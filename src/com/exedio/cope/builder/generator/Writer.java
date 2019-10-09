package com.exedio.cope.builder.generator;

import com.exedio.cope.Feature;
import com.exedio.cope.Item;
import com.exedio.cope.ItemField;
import com.exedio.cope.Pattern;
import com.exedio.cope.Settable;
import com.exedio.cope.Type;
import com.exedio.cope.TypesBound;
import com.exedio.cope.builder.generator.type.CompositeType;
import com.exedio.cope.builder.generator.type.ItemType;
import com.exedio.cope.builder.generator.type.MyType;
import com.exedio.cope.builder.generator.type.TypeUtil;
import com.exedio.cope.pattern.CompositeField;
import com.exedio.cope.pattern.DynamicModel;
import com.exedio.cope.pattern.EnumMapField;
import com.exedio.cope.pattern.ListField;
import com.exedio.cope.pattern.MapField;
import com.exedio.cope.pattern.MoneyField;
import com.exedio.cope.pattern.PriceField;
import com.exedio.cope.pattern.RangeField;
import com.exedio.cope.pattern.SetField;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.Locale;
import java.util.Set;

public final class Writer
{
	static void writeGeneratedBuilder(final MyType<?> type, final JavaClassWriter writer, final Set<MyType<?>> generated) throws IOException
	{
		final String simpleClassName = type.getSimpleClassName();

		writer.writePackage(type.getPackageName());

		writer.writeLine("@com.exedio.cope.builder.Generated");
		writer.writeLine("public abstract class Generated" + simpleClassName + "Builder" + type.getGenericParams());
		writer.writeLine("\textends " + type.getExtends());

		writer.writeLine("{");

		if(!Modifier.isAbstract(type.getJavaClass().getModifiers()))
		{
			if(type.enableCommonBuilder())
			{
				final String generics = "<" + simpleClassName + type.getWildCards() + "," + simpleClassName + "Builder>";
				writer.writeLine(
					"\tpublic static class " + simpleClassName + "Builder extends " + type.getPackageName() + ".Common" + simpleClassName + "Builder" + generics);
				writer.writeLine("\t{");
				writer.writeLine("\t\tpublic " + simpleClassName + "Builder( )");
				writer.writeLine("\t\t{");
				writer.writeLine("\t\t\tsuper( " + simpleClassName + ".TYPE );");
				writer.writeLine("\t\t}");
				writer.writeLine("\t}");
			}
			else
			{
				writer.writeLine("\tprotected Generated" + simpleClassName + "Builder()");
				writer.writeLine("\t{");
				writer.writeLine("\t\tsuper(" + type.getTypeCast() + simpleClassName + '.' + type.getTypeName() + ");");
				writer.writeLine("\t}");
			}
		}

		if(type.enableTypePropagationConstructor())
		{
			writer.writeLine();
			writer.writeLine("\tprotected Generated" + simpleClassName + "Builder(final com.exedio.cope.Type<I> type)");
			writer.writeLine("\t{");
			writer.writeLine("\t\tsuper(type);");
			writer.writeLine("\t}");
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
				!TypeUtil.isVisible(type.getPackageName(), ((Settable<?>) feature).getInitialType()))
				continue;

			{
				final Pattern pattern = feature.getPattern();
				if((pattern instanceof Settable<?> || pattern instanceof DynamicModel<?>))
					continue;
			}

			final String featureName = type.getName(feature);
			final String featureIdentifier = featureName.replace('-', '_');

			final String valueType = TypeUtil.valueType(feature);
			if(valueType == null)
			{
				System.out.println("Skipping setter for " + feature + ". Not implemented yet.");
				continue;
			}

			final boolean writeGenericSetter = !(feature instanceof EnumMapField); //set enum map by keys and skip common value setter, see below
			if(writeGenericSetter)
			{
				writer.writeLine();
				writer.writeLine("\tprotected final " + TypeUtil.fieldType(feature) + ' ' + featureIdentifier + " = getFeature(\"" + featureName + "\");");
				writer.writeLine();
				writer.writeSetterAnnotation();
				writer.writeLine("\tpublic final B " + featureIdentifier + "(final " + valueType + " " + featureIdentifier + ")");
				writer.writeLine("\t{");
				writer.writeLine("\t\treturn set(this." + featureIdentifier + "," + featureIdentifier + ");");
				writer.writeLine("\t}");
			}

			if(feature instanceof ListField<?>)
			{
				final Class<?> elementClass = ((ListField<?>) feature).getElement().getValueClass();
				final boolean safeVarargs = elementClass.getTypeParameters().length != 0;
				final String itemClass = TypeUtil.getCanonicalName(elementClass);
				final String parameterList = "final " + itemClass + "... " + featureIdentifier;
				final String mapping = "java.util.Arrays.asList(" + featureIdentifier + ")";
				writeRedirectSetter(writer, featureIdentifier, featureIdentifier, parameterList, mapping, safeVarargs);
			}
			else if(feature instanceof SetField<?>)
			{
				final Class<?> elementClass = ((SetField<?>) feature).getElement().getValueClass();
				final boolean safeVarargs = elementClass.getTypeParameters().length != 0;
				final String itemClass = TypeUtil.getCanonicalName(elementClass);
				final String parameterList = "final " + itemClass + "... " + featureIdentifier;
				final String mapping = "new java.util.LinkedHashSet<>(java.util.Arrays.asList(" + featureIdentifier + "))";
				writeRedirectSetter(writer, featureIdentifier, featureIdentifier, parameterList, mapping, safeVarargs);
			}
			else if(feature instanceof RangeField<?>)
			{
				final String fromClass = ((RangeField<?>) feature).getFrom().getValueClass().getCanonicalName();
				final String toClass = ((RangeField<?>) feature).getTo().getValueClass().getCanonicalName();
				final String parameterList = "final " + fromClass + " from, final " + toClass + " to";
				writeRedirectSetter(writer, featureIdentifier, parameterList, "com.exedio.cope.pattern.Range.valueOf(from, to)");
			}
			else if(feature instanceof PriceField)
			{
				writeRedirectSetter(writer, featureIdentifier,
					"final double value",
					"com.exedio.cope.pattern.Price.valueOf(value)");
				writeRedirectSetter(writer, featureIdentifier,
					"final int store",
					"com.exedio.cope.pattern.Price.storeOf(store)");
			}
			else if(feature instanceof MoneyField)
			{
				final MoneyField<?> field = (MoneyField<?>) feature;
				final String currencyClass = TypeUtil.getCanonicalName(field.getCurrencyClass());
				writeRedirectSetter(writer, featureIdentifier, "final double value," + "final " + currencyClass + " currency",
					"com.exedio.cope.pattern.Money.valueOf(value,currency)");
				writeRedirectSetter(writer, featureIdentifier, "final int store," + "final " + currencyClass + " currency",
					"com.exedio.cope.pattern.Money.storeOf(store,currency)");
			}
			else if(feature instanceof ItemField)
			{
				final ItemField<?> field = (ItemField<?>) feature;
				final Class<? extends Item> elementClass = field.getValueClass();
				Type<?> elementType = null;
				try
				{
					elementType = TypesBound.forClass(elementClass);
				}
				catch(final IllegalArgumentException ignored)
				{
					// ok
				}
				if(elementType!=null)
				{
					final ItemType myType = new ItemType(elementType);

					if(!myType.enableCommonBuilder()) //TODO generate in all children if a common builder exists
					{
						final String itemClass = myType.getJavaClass().getCanonicalName();
						final String itemClassBuilder = itemClass + "Builder";
						writeRedirectSetter(writer, featureIdentifier,
							"final java.util.function.Function<" + itemClassBuilder + ", " + itemClassBuilder + "> " + featureIdentifier + "BuilderConsumer",
							featureIdentifier + "BuilderConsumer.apply( new " + itemClassBuilder + "() ).build()");
						if(!field.isMandatory())
						{
							writeRedirectSetter(writer, featureIdentifier + "Null", featureIdentifier, "", "(" + itemClass + ") null", false);
						}
					}
				}
			}
			else if(feature instanceof CompositeField)
			{
				final CompositeField<?> field = (CompositeField<?>) feature;
				final CompositeType myType = new CompositeType(field);
				if(generated.contains(myType))
				{
					final String compositeClass = myType.getJavaClass().getCanonicalName();
					final String compositeClassBuilder = compositeClass + "Builder";

					writeRedirectSetter(writer, featureIdentifier,
						"final java.util.function.Function<" + compositeClassBuilder + ", " + compositeClassBuilder + "> " + featureIdentifier
							+ "BuilderConsumer",
						featureIdentifier + "BuilderConsumer.apply( new " + compositeClassBuilder + "() ).build()");
					if(!field.isMandatory())
					{
						writeRedirectSetter(writer, featureIdentifier + "Null", featureIdentifier, "", "(" + compositeClass + ") null", false);
					}
				}
				else
				{
					System.out.println("Skip external composite lambda builder setter:" + field + " " + myType.getJavaClass());
				}
			}
			else if(feature instanceof EnumMapField)
			{
				final EnumMapField<?, ?> enumMapField = (EnumMapField<?, ?>) feature;
				final Class<? extends Enum<?>> keyClass = enumMapField.getKeyClass();
				final String enumKeyType = TypeUtil.getCanonicalName(enumMapField.getKeyClass());
				final String enumValueType = TypeUtil.getCanonicalName(enumMapField.getValueClass());

				writer.writeLine();
				writer.writeLine("\tprotected final " + TypeUtil.fieldType(feature) + ' ' + featureIdentifier + " = getFeature(\"" + featureName + "\");");
				writer.writeLine();
				writer.writeSetterAnnotation();
				writer.writeLine("\t@SuppressWarnings(\"unchecked\")");
				writer.writeLine("\tpublic final B " + featureIdentifier + "(final " + valueType + " " + featureIdentifier + ")");
				writer.writeLine("\t{");
				writer.writeLine("\t\t" + featureIdentifier + ".forEach(this::" + featureIdentifier + ");");
				writer.writeLine("\t\treturn (B) this;");
				writer.writeLine("\t}");

				writer.writeLine();
				writer.writeSetterAnnotation();
				writer.writeLine("\tpublic final B " + featureIdentifier + "(final " + enumKeyType + " key, final " + enumValueType + " value)");
				writer.writeLine("\t{");
				writer.writeLine("\t\treturn set(this." + featureIdentifier + ".getField(key), value);");
				writer.writeLine("\t}");

				for(final Object e : keyClass.getEnumConstants())
				{
					final String key = ((Enum<?>) e).name();
					final String methodPart = key.substring(0, 1).toUpperCase(Locale.ENGLISH) + key.substring(1);
					final String variable = key.toLowerCase(Locale.ENGLISH); //TODO improve?
					writer.writeLine();
					writer.writeSetterAnnotation();
					writer.writeLine("\tpublic final B " + featureIdentifier + methodPart + "(final " + enumValueType + " " + variable + ")");
					writer.writeLine("\t{");
					writer.writeLine("\t\treturn " + featureIdentifier + "(" + enumKeyType + "." + key + "," + variable + ");");
					writer.writeLine("\t}");
				}
			}
		}

		writer.writeLine("}");
	}

	private static void writeRedirectSetter(final JavaClassWriter writer, final String featureIdentifier, final String parameterList, final String mapping
	) throws IOException
	{
		writeRedirectSetter(writer, featureIdentifier, featureIdentifier, parameterList, mapping, false);
	}

	private static void writeRedirectSetter(final JavaClassWriter writer, final String methodName, final String featureIdentifier,
		final String parameterList, final String mapping, final boolean safeVarargs) throws IOException
	{
		writer.writeLine();
		writer.writeSetterAnnotation();
		if(safeVarargs)
			writer.writeLine("\t@SafeVarargs @SuppressWarnings(\"varargs\")");
		writer.writeLine("\tpublic final B " + methodName + "(" + parameterList + ")");
		writer.writeLine("\t{");
		writer.writeLine("\t\treturn " + featureIdentifier + "(" + mapping + ");");
		writer.writeLine("\t}");
	}

	static void writeConcreteBuilder(final MyType<?> type, final JavaClassWriter writer) throws IOException
	{
		final String simpleClassName = type.getSimpleClassName();
		writer.writePackage(type.getPackageName());

		final boolean common = type.enableCommonBuilder();
		if(common)
		{
			writer.writeImport("com.exedio.cope.Type");
			writer.writeLine();
		}

		if(common)
		{
			writer.writeLine("public abstract class Common" + simpleClassName + "Builder"
				+ "<I extends " + simpleClassName + type.getWildCards() + ", B extends Common" + simpleClassName + "Builder<?,?>>");
			writer.writeLine("\textends Generated" + simpleClassName + "Builder<I,B>");
		}
		else
		{
			writer.writeLine("public class " + simpleClassName + "Builder extends Generated" + simpleClassName + "Builder<" + simpleClassName + "Builder>");
		}

		writer.writeLine("{");
		if(common)
		{
			writer.writeLine("\tprotected Common" + simpleClassName + "Builder(final Type<I> type)");
			writer.writeLine("\t{");
			writer.writeLine("\t\tsuper(type);");
			writer.writeLine("\t}");
			writer.writeLine();
		}

		writer.writeLine("\t@Override");
		if(common)
		{
			writer.writeLine("\tpublic I build()");
		}
		else
		{
			writer.writeLine("\tpublic " + simpleClassName + " build()");
		}

		writer.writeLine("\t{");
		writer.writeLine("\t\treturn super.build();");
		writer.writeLine("\t}");

		writer.writeLine("}");
	}

	private Writer()
	{
		// prevent instantiation
	}
}
