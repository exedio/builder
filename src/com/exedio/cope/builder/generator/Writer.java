package com.exedio.cope.builder.generator;

import com.exedio.cope.Feature;
import com.exedio.cope.Item;
import com.exedio.cope.ItemField;
import com.exedio.cope.Pattern;
import com.exedio.cope.Settable;
import com.exedio.cope.TypesBound;
import com.exedio.cope.misc.PrimitiveUtil;
import com.exedio.cope.pattern.Composite;
import com.exedio.cope.pattern.CompositeField;
import com.exedio.cope.pattern.DynamicModel;
import com.exedio.cope.pattern.ListField;
import com.exedio.cope.pattern.MapField;
import com.exedio.cope.pattern.MoneyField;
import com.exedio.cope.pattern.PriceField;
import com.exedio.cope.pattern.RangeField;
import com.exedio.cope.pattern.SetField;
import com.exedio.cope.util.Cast;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.TypeVariable;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Writer
{
	static final void writeGeneratedBuilder(
		final MyType type,
		final String packageName,
		final String simpleClassName,
		final String wildcards,
		final OutputStreamWriter writer,
		final Set<MyType> generated)
		throws IOException
	{
		final String newLine = System.lineSeparator();

		writer.write("package ");
		writer.write(packageName);
		writer.write(';');
		writer.write(newLine);
		writer.write(newLine);

		writer.write("@javax.annotation.Generated(\"com.exedio.cope.builder\")");
		writer.write(newLine);
		writer.write("public abstract class Generated");
		writer.write(simpleClassName);
		writer.write("Builder");
		type.writeGenericParams(writer, simpleClassName, wildcards);
		writer.write(newLine);
		writer.write("\textends ");
		type.writeExtends(writer, simpleClassName);
		writer.write(newLine);

		writer.write("{");
		writer.write(newLine);

		if(type.enableCommonBuilder())
		{
			final String pack = type.getJavaClass().getPackage().getName();

			final String generics = "<" + simpleClassName + wildcards + "," + simpleClassName + "Builder>";
			writer.write("\tpublic static class " + simpleClassName + "Builder extends " + pack + ".Common" + simpleClassName + "Builder" + generics);
			writer.write(newLine);
			writer.write("\t{");
			writer.write(newLine);
			final String visibility = Modifier.isAbstract(type.getJavaClass().getModifiers()) ? "private" : "public";
			writer.write("\t\t" + visibility + " " + simpleClassName + "Builder( )");
			writer.write(newLine);
			writer.write("\t\t{");
			writer.write(newLine);
			writer.write("\t\t\tsuper( " + simpleClassName + ".TYPE );");
			writer.write(newLine);
			writer.write("\t\t}");
			writer.write(newLine);
			writer.write("\t}");
			writer.write(newLine);
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
				feature instanceof Settable<?> ||
					feature instanceof SetField<?> ||
					feature instanceof ListField<?> ||
					feature instanceof MapField<?, ?>))
				continue;

			if(feature instanceof Settable &&
				!isVisible(packageName, ((Settable<?>) feature).getInitialType()))
				continue;

			{
				final Pattern pattern = feature.getPattern();
				if((pattern != null) &&
					(pattern instanceof Settable<?> || pattern instanceof DynamicModel<?>))
					continue;
			}

			final String featureName = type.getName(feature);
			final String featureIdentifier = featureName.replace('-', '_');

			final String setterParameter = toSetterParameterType(feature);
			if(setterParameter == null)
			{
				System.out.println("Skipping setter for " + feature + ". Not implemented yet.");
				continue;
			}

			writer.write(newLine);
			writer.write(newLine);
			writer.write("\tprotected final ");

			if(feature instanceof Settable)
			{
				writer.write(Settable.class.getName());
				writer.write('<');
				writer.write(getCanonicalName(((Settable<?>) feature).getInitialType()));
				writer.write('>');
			}
			else if(feature instanceof SetField)
			{
				writer.write(SetField.class.getName());
				writer.write('<');
				writer.write(getCanonicalName(((SetField<?>) feature).getElement().getValueClass()));
				writer.write('>');
			}
			else if(feature instanceof ListField)
			{
				writer.write(ListField.class.getName());
				writer.write('<');
				writer.write(getCanonicalName(((ListField<?>) feature).getElement().getValueClass()));
				writer.write('>');
			}
			else if(feature instanceof MapField)
			{
				final MapField<?, ?> field = (MapField<?, ?>) feature;
				writer.write(MapField.class.getName());
				writer.write('<');
				writer.write(getCanonicalName(field.getKey().getValueClass()));
				writer.write(',');
				writer.write(getCanonicalName(field.getValue().getValueClass()));
				writer.write('>');
			}
			else
				throw new RuntimeException("" + feature.getClass());

			writer.write(' ');
			writer.write(featureIdentifier);
			writer.write(" = getFeature(\"");
			writer.write(featureName);
			writer.write("\");");
			writer.write(newLine);

			writer.write(newLine);
			writer.write("\tpublic final B ");
			writer.write(featureIdentifier);
			writer.write("(final ");
			writer.write(setterParameter);
			writer.write(" ");
			writer.write(featureIdentifier);
			writer.write(")");
			writer.write(newLine);
			writer.write("\t{");
			writer.write(newLine);

			writer.write("\t\treturn set(this.");
			writer.write(featureIdentifier);
			writer.write(",");
			writer.write(featureIdentifier);
			writer.write(");");
			writer.write(newLine);

			writer.write("\t}");
			writer.write(newLine);

			if(feature instanceof ListField<?>)
			{
				writer.write(newLine);
				final Class<?> elementClass = ((ListField<?>) feature).getElement().getValueClass();
				writeVarargsSuppressor(writer, elementClass);
				final String itemClass = getCanonicalName(elementClass);
				final String parameterList = "final " + itemClass + "... " + featureIdentifier;
				final String mapping = "java.util.Arrays.asList(" + featureIdentifier + ")";
				writeRedirectSetter(writer, newLine, featureIdentifier, parameterList, mapping);
			}
			else if(feature instanceof SetField<?>)
			{
				writer.write(newLine);
				final Class<?> elementClass = ((SetField<?>) feature).getElement().getValueClass();
				writeVarargsSuppressor(writer, elementClass);
				final String itemClass = getCanonicalName(elementClass);
				final String parameterList = "final " + itemClass + "... " + featureIdentifier;
				final String mapping = "new java.util.HashSet<>(java.util.Arrays.asList(" + featureIdentifier + "))";
				writeRedirectSetter(writer, newLine, featureIdentifier, parameterList, mapping);
			}
			else if(feature instanceof RangeField<?>)
			{
				final String fromClass = ((RangeField<?>) feature).getFrom().getValueClass().getCanonicalName();
				final String toClass = ((RangeField<?>) feature).getTo().getValueClass().getCanonicalName();
				final String parameterList = "final " + fromClass + " from, final " + toClass + " to";
				writeRedirectSetter(writer, newLine, featureIdentifier, parameterList, "com.exedio.cope.pattern.Range.valueOf(from, to)");
			}
			else if(feature instanceof PriceField)
			{
				writeRedirectSetter(writer, newLine, featureIdentifier,
					"final double value",
					"com.exedio.cope.pattern.Price.valueOf(value)");
				writeRedirectSetter(writer, newLine, featureIdentifier,
					"final int store",
					"com.exedio.cope.pattern.Price.storeOf(store)");
			}
			else if(feature instanceof MoneyField)
			{
				final MoneyField<?> field = (MoneyField<?>) feature;
				writeRedirectSetter(writer, newLine, featureIdentifier,
					"final double value," +
						"final " + getCanonicalName(field.getCurrencyClass()) + " currency",
					"com.exedio.cope.pattern.Money.valueOf(value,currency)");
				writeRedirectSetter(writer, newLine, featureIdentifier,
					"final int store," +
						"final " + getCanonicalName(field.getCurrencyClass()) + " currency",
					"com.exedio.cope.pattern.Money.storeOf(store,currency)");
			}
			else if(feature instanceof ItemField)
			{
				final ItemField<?> field = (ItemField<?>) feature;
				final Class<? extends Item> elementClass = field.getValueClass();
				MyType myType = new ItemType(TypesBound.forClass(elementClass));

				if(!myType.enableCommonBuilder()) //TODO generate in all children if a common builder exists
				{
					final String itemClass = myType.getJavaClass().getCanonicalName();
					final String itemClassBuilder = itemClass + "Builder";
					writeRedirectSetter(writer, newLine, featureIdentifier,
						"final java.util.function.Function<" + itemClassBuilder + ", " + itemClassBuilder + "> " + featureIdentifier + "BuilderConsumer",
						featureIdentifier + "BuilderConsumer.apply( new " + itemClassBuilder + "() ).build()");
					if(!field.isMandatory())
					{
						writeRedirectSetter(writer, newLine, featureIdentifier + "Null", featureIdentifier, "", "(" + itemClass + ") null");
					}
				}
			}
			else if(feature instanceof CompositeField)
			{
				final CompositeField<?> field = (CompositeField<?>) feature;
				final Class<? extends Composite> elementClass = field.getValueClass();
				MyType myType = new CompositeType(elementClass, field);
				if(generated.contains(myType))
				{

					final String compositeClass = myType.getJavaClass().getCanonicalName();
					final String compositeClassBuilder = compositeClass + "Builder";

					writeRedirectSetter(writer, newLine, featureIdentifier,
						"final java.util.function.Function<" + compositeClassBuilder + ", " + compositeClassBuilder + "> " + featureIdentifier
							+ "BuilderConsumer",
						featureIdentifier + "BuilderConsumer.apply( new " + compositeClassBuilder + "() ).build()");
					if(!field.isMandatory())
					{
						writeRedirectSetter(writer, newLine, featureIdentifier + "Null", featureIdentifier, "", "(" + compositeClass + ") null");
					}
				}
				else
				{
					System.out.println("Skip external composite lambda builder setter:" + field + " " + elementClass);
				}
			}
		}

		writer.write("}");
		writer.write(newLine);
	}

	private static boolean isVisible(final String packageName, final java.lang.reflect.Type valueType)
	{
		if(valueType instanceof Class<?>)
			return isVisible(packageName, (Class<?>) valueType);
		else if(valueType instanceof ParameterizedType)
			return isVisible(packageName, (ParameterizedType) valueType);
		else
			throw new RuntimeException(valueType.getTypeName() + ' ' + valueType.getClass());
	}

	private static boolean isVisible(final String packageName, final ParameterizedType valueType)
	{
		if(!isVisible(packageName, valueType.getRawType()))
			return false;

		for(final java.lang.reflect.Type argument : valueType.getActualTypeArguments())
			if(!isVisible(packageName, argument))
				return false;

		return true;
	}

	private static boolean isVisible(final String packageName, final Class<?> valueClass)
	{
		final int modifier = valueClass.getModifiers();
		if(Modifier.isPublic(modifier))
			return true;
		if(Modifier.isPrivate(modifier))
			return false;

		return packageName.equals(valueClass.getPackage().getName());
	}

	private static void writeVarargsSuppressor(
		final OutputStreamWriter writer,
		final Class<?> elementClass)
		throws IOException
	{
		if(elementClass.getTypeParameters().length > 0)
			writer.write("\t@SafeVarargs @SuppressWarnings(\"varargs\")");
	}

	private static void writeRedirectSetter(final OutputStreamWriter writer, final String newLine, final String featureIdentifier, final String parameterList,
		final String mapping)
		throws IOException
	{
		writeRedirectSetter(writer, newLine, featureIdentifier, featureIdentifier, parameterList, mapping);
	}

	private static void writeRedirectSetter(final OutputStreamWriter writer, final String newLine, final String methodName, final String featureIdentifier,
		final String parameterList, final String mapping) throws IOException
	{
		writer.write(newLine);
		writer.write("\tpublic final B ");
		writer.write(methodName);
		writer.write("(");
		writer.write(parameterList);
		writer.write(")");
		writer.write(newLine);
		writer.write("\t{");
		writer.write(newLine);

		writer.write("\t\treturn " + featureIdentifier + "(");
		writer.write(mapping);
		writer.write(");");
		writer.write(newLine);

		writer.write("\t}");
		writer.write(newLine);
	}

	static String toSetterParameterType(final Feature feature)
	{
		if(feature instanceof Settable<?>)
		{
			final Settable<?> field = (Settable<?>) feature;
			final java.lang.reflect.Type valueClass = field.getInitialType();
			final java.lang.reflect.Type primitiveClass =
				(valueClass instanceof Class && field.isMandatory())
					? PrimitiveUtil.toPrimitive((Class<?>) valueClass)
					: valueClass;
			return getCanonicalName((primitiveClass != null) ? primitiveClass : valueClass);
		}
		else if(feature instanceof SetField<?>)
		{
			final SetField<?> field = (SetField<?>) feature;
			final StringBuilder sb = new StringBuilder();
			sb.append(Set.class.getName());
			sb.append('<');
			sb.append(getCanonicalName(field.getElement().getValueClass()));
			sb.append('>');
			return sb.toString();
		}
		else if(feature instanceof ListField<?>)
		{
			final ListField<?> field = (ListField<?>) feature;
			final StringBuilder sb = new StringBuilder();
			sb.append(List.class.getName());
			sb.append('<');
			sb.append(getCanonicalName(field.getElement().getValueClass()));
			sb.append('>');
			return sb.toString();
		}
		else if(feature instanceof MapField<?, ?>)
		{
			final MapField<?, ?> field = (MapField<?, ?>) feature;
			final StringBuilder sb = new StringBuilder();
			sb.append(Map.class.getName());
			sb.append('<');
			sb.append(getCanonicalName(field.getKey().getValueClass()));
			sb.append(',');
			sb.append(getCanonicalName(field.getValue().getValueClass()));
			sb.append('>');
			return sb.toString();
		}
		return null;
	}

	private static String getCanonicalName(final java.lang.reflect.Type type)
	{
		if(type instanceof Class)
			return getCanonicalName((Class<?>) type);
		else if(type instanceof ParameterizedType)
			return getCanonicalName((ParameterizedType) type);
		else
			throw new RuntimeException("" + type);
	}

	private static String getCanonicalName(final Class<?> type)
	{
		final String rawName = type.getCanonicalName();

		final TypeVariable<?>[] typeParams = type.getTypeParameters();
		if(typeParams.length == 0)
			return rawName;

		final StringBuilder bf = new StringBuilder(rawName);
		bf.append("<?");
		for(int i = 1; i < typeParams.length; i++)
			bf.append(",?");
		bf.append('>');
		return bf.toString();
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
		if(arguments != null && arguments.length > 0)
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

	static final void writeConcreteBuilder(final MyType type, final String packageName, final String simpleClassName, final String wildcards,
		final OutputStreamWriter writer)
		throws IOException
	{
		final String newLine = System.lineSeparator();

		writer.write("package ");
		writer.write(packageName);
		writer.write(';');
		writer.write(newLine);
		writer.write(newLine);

		if(type.enableCommonBuilder())
		{
			writer.write("import com.exedio.cope.Type;");
			writer.write(newLine);
			writer.write(newLine);
		}

		writer.write("public ");
		if(type.enableCommonBuilder())
			writer.write("abstract ");
		writer.write("class ");

		if(type.enableCommonBuilder())
			writer.write("Common");
		writer.write(simpleClassName);
		writer.write("Builder");

		if(type.enableCommonBuilder())
		{

			writer.write("<I extends " + simpleClassName + wildcards + ", B extends Common" + simpleClassName + "Builder<?,?>>");
			writer.write(newLine);
			writer.write("\textends ");
			writer.write("Generated" + simpleClassName + "Builder<I,B>");
		}
		else
		{
			writer.write(" extends ");
			writer.write("Generated" + simpleClassName + "Builder<" + simpleClassName + "Builder>");
		}

		writer.write(newLine);

		writer.write("{");
		writer.write(newLine);

		if(type.enableCommonBuilder())
		{
			writer.write("\tprotected Common" + simpleClassName + "Builder(final Type<I> type)");
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
		if(type.enableCommonBuilder())
		{
			writer.write("\tpublic I build()");
		}
		else
		{
			writer.write("\tpublic " + simpleClassName + " build()");
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

	static String typeParameterWildCards(final Class<?> clazz)
	{
		final int typeParameters = clazz.getTypeParameters().length;
		if(typeParameters == 0)
			return "";

		final StringBuilder bf = new StringBuilder();
		bf.append("<?");
		for(int i = 1; i < typeParameters; i++)
			bf.append(",?");
		bf.append('>');
		return bf.toString();
	}
}
