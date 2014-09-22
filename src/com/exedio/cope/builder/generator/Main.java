package com.exedio.cope.builder.generator;

import com.exedio.cope.Feature;
import com.exedio.cope.Model;
import com.exedio.cope.Pattern;
import com.exedio.cope.Settable;
import com.exedio.cope.Type;
import com.exedio.cope.misc.PrimitiveUtil;
import com.exedio.cope.pattern.Composite;
import com.exedio.cope.pattern.CompositeField;
import com.exedio.cope.pattern.DynamicModel;
import com.exedio.cope.pattern.ListField;
import com.exedio.cope.pattern.MapField;
import com.exedio.cope.pattern.SetField;
import com.exedio.cope.util.Cast;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.TypeVariable;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

final class Main
{
	static final void main(final Params params) throws HumanReadableException, IOException
	{
		final Model model = params.getModel();
		final String packagePrefix = params.getPackagePrefix();

		final HashMap<File,ArrayList<Class<?>>> skipped = new HashMap<File,ArrayList<Class<?>>>();
		final AtomicInteger progress = new AtomicInteger(0);
		for(final Type<?> type : model.getTypes())
		{
			if(!type.isBound())
				continue;

			final Class<?> clazz = type.getJavaClass();
			if(!clazz.getName().startsWith(packagePrefix))
				continue;

			writeFiles(params, new ItemType( type, clazz ), skipped, progress);
		}

		final HashSet<Class<? extends Composite>> compositeClasses = new HashSet<Class<? extends Composite>>();
		for(final Type<?> type : model.getTypes())
		{
			for(final Feature feature : type.getDeclaredFeatures())
			{
				if(!(feature instanceof CompositeField<?>))
					continue;

				final CompositeField<?> field = (CompositeField<?>)feature;

				final Class<? extends Composite> clazz = field.getValueClass();
				if(!clazz.getName().startsWith(packagePrefix))
					continue;

				if(!compositeClasses.add(clazz))
					continue;

				writeFiles(params, new CompositeType( clazz, field ), skipped, progress);
			}
		}
		for(final Map.Entry<File,ArrayList<Class<?>>> entry : skipped.entrySet())
		{
			final ArrayList<Class<?>> classes = entry.getValue();
			if(classes.size()==1)
				System.out.println("Skipping " + classes.get(0).getName() + " because target directory does not exist: " + entry.getKey().getAbsolutePath());
			else
				System.out.println("Skipping " + classes.size() +   " classes because target directory does not exist: " + entry.getKey().getAbsolutePath());
		}
		{
			final int progressResult = progress.get();
			if(progressResult>0)
				System.out.println("Generated " + progressResult + " builders for " + model + " in '" + packagePrefix + "'.");
		}
	}

	private static final void writeFiles(
			final Params params,
			final MyType type,
			final HashMap<File,ArrayList<Class<?>>> skipped,
			final AtomicInteger progress)
		throws HumanReadableException, IOException
	{
		final Class<?> clazz = type.getJavaClass();
		final String packageName = clazz.getPackage().getName();
		final String simpleClassName = clazz.getSimpleName();

		final File dir = new File(
				params.getDestdir(),
				packageName.replace('.', '/'));

		if(!dir.exists())
		{
			ArrayList<Class<?>> classes = skipped.get(dir);
			if(classes==null)
			{
				classes = new ArrayList<Class<?>>();
				skipped.put(dir, classes);
			}
			classes.add(clazz);
			return;
		}
		if(!dir.isDirectory())
			throw new HumanReadableException("expected directory: " + dir.getAbsolutePath());

		writeGenerated( type, clazz, packageName, simpleClassName, dir );
		writeConcrete( type, packageName, simpleClassName, dir );
		progress.incrementAndGet();
	}

	private static void writeGenerated( final MyType type, final Class< ? > clazz, final String packageName, final String simpleClassName, final File dir )
			throws FileNotFoundException, IOException
	{
		final File file = new File(dir, "Generated" + simpleClassName + "Builder.java");

		if(isNoUpdateRequired(clazz, file))
			return;

		final CharsetEncoder encoder = Charset.forName("US-ASCII").newEncoder(); // TODO customizable
		final OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file), encoder);
		try
		{
			write(type, packageName, simpleClassName, writer);
		}
		finally
		{
			writer.close();
		}
	}

	private static void writeConcrete( final MyType type, final String packageName, final String simpleClassName, final File dir )
			throws FileNotFoundException, IOException
	{

		final File file = new File(dir, (type.enableCommonBuilder()?"Common":"") + simpleClassName + "Builder.java");

		if( file.exists())
			return;

		final CharsetEncoder encoder = Charset.forName("US-ASCII").newEncoder(); // TODO customizable
		final OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file), encoder);
		try
		{
			writeConcrete(type, packageName, simpleClassName, writer);
		}
		finally
		{
			writer.close();
		}
	}

	private static boolean isNoUpdateRequired(final Class<?> sourceClass, final File targetFile)
	{
		final long targetLastModified = targetFile.lastModified();
		if(targetLastModified==0)
			return false;

		final URL url = sourceClass.getResource(sourceClass.getSimpleName() + ".class");
		final URI uri;
		try
		{
			uri = url.toURI();
		}
		catch(final URISyntaxException e)
		{
			throw new RuntimeException(e);
		}
		final File sourceFile = new File(uri);
		final long sourceLastModified = sourceFile.lastModified();
		if(sourceLastModified==0)
			throw new RuntimeException(sourceFile.getAbsolutePath());

		return sourceLastModified<=targetLastModified;
	}

	private static final void write(
			final MyType type,
			final String packageName,
			final String simpleClassName,
			final OutputStreamWriter writer)
		throws IOException
	{
		final String newLine = System.getProperty("line.separator");

		writer.write("// Generated by ");
		writer.write(Main.class.getName());
		writer.write(newLine);
		writer.write(newLine);

		writer.write("package ");
		writer.write(packageName);
		writer.write(';');
		writer.write(newLine);
		writer.write(newLine);

		writer.write("public abstract class Generated");
		writer.write(simpleClassName);
		writer.write("Builder");
		type.writeGenericParams(writer, simpleClassName);
		writer.write(newLine);
		writer.write("\textends ");
		type.writeExtends(writer, simpleClassName);
		writer.write(newLine);

		writer.write("{");
		writer.write(newLine);

		if (type.enableCommonBuilder())
		{
			final String pack=type.getJavaClass().getPackage().getName();

			writer.write("\tpublic static class "+simpleClassName+"Builder extends "+pack+".Common"+simpleClassName+"Builder<"+simpleClassName+","+simpleClassName+"Builder>");
			writer.write( newLine );
			writer.write("\t{");
			writer.write( newLine );
			writer.write("\t\tpublic "+simpleClassName+"Builder( )");
			writer.write( newLine );
			writer.write("\t\t{");
			writer.write( newLine );
			writer.write("\t\t\tsuper( "+simpleClassName+".TYPE );");
			writer.write( newLine );
			writer.write("\t\t}");
			writer.write( newLine );
			writer.write("\t}");
			writer.write( newLine );
		}
		else
		{
			writer.write("\tprotected Generated");
			writer.write(simpleClassName);
			writer.write("Builder()");
			writer.write(newLine);

			writer.write("\t{");
			writer.write(newLine);

			writer.write("\t\tsuper(");
			type.writeTypeCast(writer);
			writer.write(simpleClassName);
			writer.write('.');
			writer.write(type.getTypeName());
			writer.write(");");
			writer.write(newLine);

			writer.write("\t}");
			writer.write(newLine);
		}

		if(type.enableTypePropagationConstructor())
		{
			writer.write(newLine);

			writer.write("\tprotected Generated");
			writer.write(simpleClassName);
			writer.write("Builder(final com.exedio.cope.Type<I> type)");
			writer.write(newLine);

			writer.write("\t{");
			writer.write(newLine);

			writer.write("\t\tsuper(type);");
			writer.write(newLine);

			writer.write("\t}");
			writer.write(newLine);
		}

		for(final Feature feature : type.getDeclaredFeatures())
		{
			if(!(
				feature instanceof Settable<?>  ||
				feature instanceof SetField<?>  ||
				feature instanceof ListField<?> ||
				feature instanceof MapField<?,?>))
				continue;

			{
				final Pattern pattern = feature.getPattern();
				if((pattern!=null) &&
					(pattern instanceof Settable<?> || pattern instanceof DynamicModel<?>) )
					continue;
			}

			writer.write(newLine);

			final String featureName = type.getName(feature);
			final String featureIdentifier = featureName.replace('-', '_');

			final String setterParameter=toSetterParameterType( feature );
			if (setterParameter==null)
			{
				System.out.println( "Skipping setter for " + feature +". Not implemented yet." );
				continue;
			}

			writer.write("\tpublic final B ");
			writer.write(featureIdentifier);
			writer.write("(final ");
			writer.write(setterParameter );
			writer.write(" ");
			writer.write(featureIdentifier);
			writer.write(")");
			writer.write(newLine);
			writer.write("\t{");
			writer.write(newLine);

			writer.write("\t\treturn set(\"");
			writer.write(featureName);
			writer.write("\", ");
			writer.write(featureIdentifier);
			writer.write(");");
			writer.write(newLine);

			writer.write("\t}");
			writer.write(newLine);
		}

		writer.write("}");
		writer.write(newLine);
	}

	static String toSetterParameterType( final Feature feature )
	{
		if(feature instanceof Settable<?>)
		{
			final Settable<?> field = (Settable<?>)feature;
			final java.lang.reflect.Type valueClass = field.getInitialType();
			final java.lang.reflect.Type primitiveClass =
					(valueClass instanceof Class && field.isMandatory())
					? PrimitiveUtil.toPrimitive((Class<?>)valueClass)
					: valueClass;
			final String canonicalName = getCanonicalName((primitiveClass!=null) ? primitiveClass : valueClass);
			if ( valueClass instanceof Class && ((Class<?>)valueClass).getTypeParameters().length>0 )
			{
				final StringBuilder typeParamsString = new StringBuilder();
				typeParamsString.append( "<" );
				final TypeVariable<?>[] typeParams = ((Class<?>)valueClass).getTypeParameters();
				for (int paramIndex = 0; paramIndex < typeParams.length; paramIndex++)
				{
					final TypeVariable<?> typeVariable = typeParams[paramIndex];
					if ( paramIndex>0 )
					{
						typeParamsString.append( "," );
					}
					typeParamsString.append( "?" );
					typeParamsString.append( " extends " );
					for (int boundsIndex = 0; boundsIndex < typeVariable.getBounds().length; boundsIndex++)
					{
						final java.lang.reflect.Type bound = typeVariable.getBounds()[boundsIndex];
						if ( boundsIndex!=0 )
						{
							typeParamsString.append( " & " );
						}
						typeParamsString.append( getCanonicalName(bound) );
					}
				}
				typeParamsString.append( ">" );
				return canonicalName + typeParamsString;
			}
			else
			{
				return canonicalName;
			}
		}
		else if(feature instanceof SetField<?>)
		{
			final SetField<?> field = (SetField<?>)feature;
			final StringBuilder sb=new StringBuilder();
			sb.append(Set.class.getName());
			sb.append('<');
			sb.append(field.getElement().getValueClass().getCanonicalName());
			sb.append('>');
			return sb.toString();
		}
		else if(feature instanceof ListField<?>)
		{
			final ListField<?> field = (ListField<?>)feature;
			final StringBuilder sb=new StringBuilder();
			sb.append(List.class.getName());
			sb.append('<');
			sb.append(field.getElement().getValueClass().getCanonicalName());
			sb.append('>');
			return sb.toString();
		}
		else if(feature instanceof MapField<?,?>)
		{
			final MapField<?,?> field = (MapField<?,?>)feature;
			final StringBuilder sb=new StringBuilder();
			sb.append(Map.class.getName());
			sb.append('<');
			sb.append(field.getKey().getValueClass().getCanonicalName());
			sb.append(',');
			sb.append(field.getValue().getValueClass().getCanonicalName());
			sb.append('>');
			return sb.toString();
		}
		return null;
	}

	private static String getCanonicalName(final java.lang.reflect.Type type)
	{
		if(type instanceof Class)
			return ((Class<?>)type).getCanonicalName();
		else if(type instanceof ParameterizedType)
			return getCanonicalName((ParameterizedType)type);
		else
			throw new RuntimeException("" + type);
	}

	private static String getCanonicalName(final ParameterizedType type)
	{
		{
			final java.lang.reflect.Type ownerType = type.getOwnerType();
			if(ownerType != null)
				throw new IllegalArgumentException(ownerType.toString());
		}

		final StringBuilder bf = new StringBuilder();

		bf.append(Cast.verboseCast(Class.class, type.getRawType()).getCanonicalName());

		final java.lang.reflect.Type[] arguments = type.getActualTypeArguments();
		if(arguments!=null && arguments.length>0)
		{
			bf.append('<');
			boolean first = true;
			for(final java.lang.reflect.Type argument : arguments)
			{
				if(first)
					first = false;
				else
					bf.append(',');

				bf.append(getCanonicalName(argument));
			}
			bf.append('>');
		}

		return bf.toString();
	}

	private static final void writeConcrete(
			final MyType type,
			final String packageName,
			final String simpleClassName,
			final OutputStreamWriter writer)
		throws IOException
	{
		final String newLine = System.getProperty("line.separator");

		writer.write("package ");
		writer.write(packageName);
		writer.write(';');
		writer.write(newLine);
		writer.write(newLine);

		if (type.enableCommonBuilder())
		{
			writer.write("import com.exedio.cope.Type;");
			writer.write(newLine);
			writer.write(newLine);
		}

		writer.write("public ");
		if (type.enableCommonBuilder()) writer.write("abstract ");
		writer.write("class ");

		if (type.enableCommonBuilder()) writer.write("Common");
		writer.write(simpleClassName);
		writer.write("Builder");

		if (type.enableCommonBuilder())
		{

			writer.write("<I extends "+simpleClassName+", B extends Common"+simpleClassName+"Builder<?,?>>");
			writer.write(newLine);
			writer.write("\textends ");
			writer.write("Generated"+simpleClassName+"Builder<I,B>");
		}
		else
		{
			writer.write(" extends ");
			writer.write("Generated"+simpleClassName+"Builder<"+simpleClassName+"Builder>");
		}


		writer.write(newLine);

		writer.write("{");
		writer.write(newLine);

		if (type.enableCommonBuilder())
		{
			writer.write("\tprotected Common"+simpleClassName+"Builder(final Type<I> type)");
			writer.write(newLine);
			writer.write("\t{");
			writer.write(newLine);
			writer.write("\t\tsuper(type);");
			writer.write(newLine);
			writer.write("\t}");
			writer.write(newLine);
			writer.write(newLine);
		}

		writer.write("\t@Override");
		writer.write(newLine);
		if (type.enableCommonBuilder())
		{
			writer.write("\tpublic I build()");
		}
		else
		{
			writer.write("\tpublic "+simpleClassName+" build()");
		}

		writer.write(newLine);
		writer.write("\t{");
		writer.write(newLine);
		writer.write("\t\treturn super.build();");
		writer.write(newLine);
		writer.write("\t}");

		writer.write(newLine);
		writer.write("}");
		writer.write(newLine);
	}


	private Main()
	{
		// prevent instantiation
	}
}
