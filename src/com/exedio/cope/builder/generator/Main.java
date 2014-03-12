package com.exedio.cope.builder.generator;

import com.exedio.cope.Feature;
import com.exedio.cope.FunctionField;
import com.exedio.cope.Model;
import com.exedio.cope.Pattern;
import com.exedio.cope.Settable;
import com.exedio.cope.Type;
import com.exedio.cope.builder.CompositeBuilder;
import com.exedio.cope.builder.ItemBuilder;
import com.exedio.cope.misc.PrimitiveUtil;
import com.exedio.cope.pattern.Composite;
import com.exedio.cope.pattern.CompositeField;
import com.exedio.cope.pattern.DynamicModel;
import com.exedio.cope.pattern.EnumMapField;
import com.exedio.cope.pattern.Hash;
import com.exedio.cope.pattern.ListField;
import com.exedio.cope.pattern.MapField;
import com.exedio.cope.pattern.Media;
import com.exedio.cope.pattern.Price;
import com.exedio.cope.pattern.PriceField;
import com.exedio.cope.pattern.Range;
import com.exedio.cope.pattern.RangeField;
import com.exedio.cope.pattern.SetField;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
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

			writeFile(params, new MyType(){
				@Override
				Class<?> getJavaClass()
				{
					return clazz;
				}
				@Override
				Collection<? extends Feature> getDeclaredFeatures()
				{
					return type.getDeclaredFeatures();
				}
				@Override
				String getName(final Feature feature)
				{
					return feature.getName();
				}
				@Override
				void writeGenericParams(final OutputStreamWriter writer, final String simpleClassName) throws IOException
				{
					if(type.getSubtypes().isEmpty())
					{
						super.writeGenericParams(writer, simpleClassName);
					}
					else
					{
						writer.write("<I extends ");
						writer.write(simpleClassName);
						writer.write(", ");
						writer.write("B extends Generated");
						writer.write(simpleClassName);
						writer.write("Builder<?,?>>");
					}
				}
				@Override
				void writeExtends(final OutputStreamWriter writer, final String simpleClassname) throws IOException
				{
					final Type<?> supertype = type.getSupertype();
					if(supertype!=null)
					{
						writer.write(supertype.getJavaClass().getPackage().getName());
						writer.write(".Common");
						writer.write(supertype.getJavaClass().getSimpleName());
						writer.write("Builder<");
						writer.write(simpleClassname);
						writer.write(", B>");
						return;
					}

					writer.write(ItemBuilder.class.getName());
					writer.write('<');
					if(type.getSubtypes().isEmpty())
					{
						writer.write(clazz.getCanonicalName());
					}
					else
					{
						writer.write('I');
					}
					writer.write(", B>");
				}
				@Override
				public boolean enableCommonBuilder()
				{
					return !type.getSubtypes().isEmpty();
				}
				@Override
				void writeTypeCast(final OutputStreamWriter writer) throws IOException
				{
					if(!type.getSubtypes().isEmpty())
						writer.write("(com.exedio.cope.Type<I>)");
				}
				@Override
				boolean enableTypePropagationConstructor()
				{
					return !type.getSubtypes().isEmpty();
				}
				@Override
				String getTypeName()
				{
					return "TYPE";
				}
			}, skipped, progress);
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

				writeFile(params, new MyType(){
					@Override
					Class<?> getJavaClass()
					{
						return clazz;
					}
					@Override
					Collection<? extends Feature> getDeclaredFeatures()
					{
						return field.getTemplates();
					}
					@Override
					String getName(final Feature feature)
					{
						return Composite.getTemplateName((FunctionField<?>)feature);
					}
					@Override
					void writeExtends(final OutputStreamWriter writer, final String simpleClassName) throws IOException
					{
						writer.write(CompositeBuilder.class.getName());
						writer.write('<');
						writer.write(clazz.getCanonicalName());
						writer.write(", B>");
					}
					@Override
					String getTypeName()
					{
						return "class";
					}
				}, skipped, progress);
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

	private static final void writeFile(
			final Params params,
			final MyType type,
			final HashMap<File,ArrayList<Class<?>>> skipped,
			final AtomicInteger progress)
		throws HumanReadableException, IOException
	{
		final Class<?> clazz = type.getJavaClass();
		final String clazzName = clazz.getName();
		final int pos = clazzName.lastIndexOf('.');
		final String packageName = clazzName.substring(0, pos);
		final String simpleClassName = clazzName.substring(pos+1);

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

		final File file = new File(dir, "Generated" + simpleClassName + "Builder.java");

		if(done(clazz, file))
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
		progress.incrementAndGet();
	}

	private static boolean done(final Class<?> sourceClass, final File targetFile)
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
			writer.write("\t\tprotected "+simpleClassName+"Builder( )");
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

			writer.write("\tpublic final B ");
			writer.write(featureIdentifier);
			writer.write("(final ");

			if(feature instanceof FunctionField<?>)
			{
				final FunctionField<?> field = (FunctionField<?>)feature;
				final Class<?> valueClass = field.getValueClass();
				final Class<?> primitiveClass =
						field.isMandatory()
						? PrimitiveUtil.toPrimitive(valueClass)
						: valueClass;
				writer.write(((primitiveClass!=null) ? primitiveClass : valueClass).getCanonicalName());
			}
			else if(feature instanceof Media)
			{
				writer.write(Media.Value.class.getCanonicalName());
			}
			else if(feature instanceof Hash)
			{
				writer.write(String.class.getName());
			}
			else if(feature instanceof PriceField)
			{
				writer.write(Price.class.getName());
			}
			else if(feature instanceof RangeField)
			{
				writer.write(Range.class.getName());
				writer.write('<');
				writer.write(((RangeField<?>)feature).getFrom().getValueClass().getCanonicalName());
				writer.write('>');
			}
			else if(feature instanceof CompositeField)
			{
				final CompositeField<?> field = (CompositeField<?>)feature;
				writer.write(field.getValueClass().getCanonicalName());
			}
			else if(feature instanceof EnumMapField)
			{
				final EnumMapField<?,?> field = (EnumMapField<?,?>)feature;
				writer.write(EnumMap.class.getName());
				writer.write('<');
				writer.write(field.getKeyClass().getCanonicalName());
				writer.write(',');
				writer.write(getValueClass(field).getCanonicalName());
				writer.write('>');
			}
			else if(feature instanceof SetField<?>)
			{
				final SetField<?> field = (SetField<?>)feature;
				writer.write(Set.class.getName());
				writer.write('<');
				writer.write(field.getElement().getValueClass().getCanonicalName());
				writer.write('>');
			}
			else if(feature instanceof ListField<?>)
			{
				final ListField<?> field = (ListField<?>)feature;
				writer.write(List.class.getName());
				writer.write('<');
				writer.write(field.getElement().getValueClass().getCanonicalName());
				writer.write('>');
			}
			else if(feature instanceof MapField<?,?>)
			{
				final MapField<?,?> field = (MapField<?,?>)feature;
				writer.write(Map.class.getName());
				writer.write('<');
				writer.write(field.getKey().getValueClass().getCanonicalName());
				writer.write(',');
				writer.write(field.getValue().getValueClass().getCanonicalName());
				writer.write('>');
			}
			else
				throw new RuntimeException("" + feature);

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

	// TODO should be part of the framework
	private static <K extends Enum<K>,V> Class<V> getValueClass(final EnumMapField<K,V> field)
	{
		return field.getField(field.getKeyClass().getEnumConstants()[0]).getValueClass();
	}

	static abstract class MyType
	{
		abstract Class<?> getJavaClass();



		abstract Collection<? extends Feature> getDeclaredFeatures();
		abstract String getName(Feature feature);
		abstract void writeExtends(OutputStreamWriter writer, String simpleClassName) throws IOException;

		void writeGenericParams(final OutputStreamWriter writer, final String simpleClassName) throws IOException
		{
			writer.write("<B extends Generated");
			writer.write(simpleClassName);
			writer.write("Builder<?>>");
		}

		@SuppressWarnings("unused")
		void writeTypeCast(final OutputStreamWriter writer) throws IOException
		{
			// do nothing
		}

		public boolean enableCommonBuilder()
		{
			return false;
		}

		boolean enableTypePropagationConstructor()
		{
			return false;
		}

		abstract String getTypeName();
	}

	private Main()
	{
		// prevent instantiation
	}
}
