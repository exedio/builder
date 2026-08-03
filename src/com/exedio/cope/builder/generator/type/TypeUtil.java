package com.exedio.cope.builder.generator.type;

import com.exedio.cope.Feature;
import com.exedio.cope.Settable;
import com.exedio.cope.misc.PrimitiveUtil;
import com.exedio.cope.pattern.EnumMapField;
import com.exedio.cope.pattern.ListField;
import com.exedio.cope.pattern.MapField;
import com.exedio.cope.pattern.MapFieldInterface;
import com.exedio.cope.pattern.Range;
import com.exedio.cope.pattern.RangeField;
import com.exedio.cope.pattern.SetField;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import org.jspecify.annotations.Nullable;

public final class TypeUtil
{
	static String typeParameterWildCards(final Class<?> clazz)
	{
		final int typeParameters = clazz.getTypeParameters().length;
		if(typeParameters == 0)
			return "";

		return "<?" + ",?".repeat(typeParameters - 1) + '>';
	}

	public static String getCanonicalName(final Type type)
	{
		return getCanonicalName(type, null);
	}

	public static String getCanonicalName(final Type type, final @Nullable String typeUseAnnotation)
	{
		if(type instanceof Class)
			return getCanonicalName((Class<?>) type, typeUseAnnotation);
		else if(type instanceof ParameterizedType)
			return getCanonicalName((ParameterizedType) type, typeUseAnnotation);
		else if(type instanceof WildcardType)
			return getCanonicalName((WildcardType) type, typeUseAnnotation);
		else
			throw new RuntimeException("Unhandled type " + type + " -- " + type.getClass());
	}

	private static String canonicalNameWithTypeUseAnnotation(final Class<?> clazz, final @Nullable String typeUseAnnotation)
	{
		final String name = clazz.getCanonicalName();
		if(clazz.isPrimitive())
			return name;
		final int splitAt = name.lastIndexOf(".") + 1;
		final String infix = typeUseAnnotation == null ? "" : "@" + typeUseAnnotation + " ";
		return name.substring(0, splitAt) + infix + name.substring(splitAt);
	}

	private static String getCanonicalName(final Class<?> clazz, final @Nullable String typeUseAnnotation)
	{
		return canonicalNameWithTypeUseAnnotation(clazz, typeUseAnnotation) + typeParameterWildCards(clazz);
	}

	private static String getCanonicalName(final WildcardType type, final @Nullable String typeUseAnnotation)
	{
		final Type[] upper = type.getUpperBounds();
		if(upper.length==1)
		{
			if(type.getLowerBounds().length!=0)
				throw new RuntimeException(Arrays.toString(type.getLowerBounds()));

			if(Object.class.equals(upper[0]))
				return "?";

			return "? extends " + getCanonicalName(upper[0]);
		}

		final Type[] lower = type.getLowerBounds();
		if(lower.length==1)
		{
			if(upper.length!=0)
				throw new RuntimeException(Arrays.toString(upper));
			return "? super " + getCanonicalName(lower[0]);
		}

		throw new RuntimeException(Arrays.asList(upper).toString() + Arrays.asList(lower));
	}

	private static String getCanonicalName(final ParameterizedType type, final @Nullable String typeUseAnnotation)
	{
		final Type ownerType = type.getOwnerType();
		if(ownerType != null)
			throw new IllegalArgumentException("ParameterizedType without owner:" + ownerType);

		final String name = canonicalNameWithTypeUseAnnotation((Class<?>) type.getRawType(), typeUseAnnotation);
		if(type.getActualTypeArguments().length == 0) // TODO possible? add a test case
			return name;
		return name + "<" + Arrays.stream(type.getActualTypeArguments())
			.map(TypeUtil::getCanonicalName).collect(Collectors.joining(","))
			+ ">";
	}

	private static @Nullable String findNullableAnnotation(final Settable<?> field, final @Nullable String nullableAnnotation)
	{
		return field.isMandatory() ? null : nullableAnnotation;
	}

	public static @Nullable String valueType(final Feature feature, final @Nullable String nullableAnnotation)
	{
		if(feature instanceof final RangeField<?> field)
		{
			//TODO two different nullabilities
			return Range.class.getName() + '<' +
				getCanonicalName(field.getFrom().getValueClass(), findNullableAnnotation(field.getFrom(), nullableAnnotation))
				+ '>';
		}
		else if(feature instanceof final Settable<?> field)
		{
			final Type valueClass = field.getInitialType();
			final Type primitiveClass = (valueClass instanceof Class && field.isMandatory())
				? PrimitiveUtil.toPrimitive((Class<?>) valueClass)
				: null;
			if(primitiveClass != null)
				return getCanonicalName(primitiveClass, null);
			return getCanonicalName(Objects.requireNonNull(valueClass), findNullableAnnotation(field, nullableAnnotation));
		}
		else if(feature instanceof final SetField<?> field)
		{
			return Set.class.getName() + '<' + getCanonicalName(field.getElement().getValueClass(), null /*always mandatory*/) + '>';
		}
		else if(feature instanceof final ListField<?> field)
		{
			return List.class.getName() + '<' + getCanonicalName(field.getElement().getValueClass(), findNullableAnnotation(field.getElement(), nullableAnnotation)) + '>';
		}
		else if(feature instanceof final MapField<?, ?> field)
		{
			return Map.class.getName() + '<' +
				getCanonicalName(field.getKey().getValueClass(), null /*always mandatory*/) + ',' +
				getCanonicalName(field.getValue().getValueClass(), findNullableAnnotation(field.getValue(), nullableAnnotation))
				+ '>';
		}
		return null;
	}

	public static String fieldType(final Feature feature, final @Nullable String nullableAnnotation)
	{
		if(feature instanceof final MapFieldInterface<?, ?> field)
		{
			final String featureClassName = field.getClass().getCanonicalName();
			final TypeVariable<?>[] typeParams = field.getClass().getTypeParameters();
			final String keyNullable = null; /*always mandatory*/
			final String valueNullable;
			if(field instanceof final EnumMapField<?, ?> enumMapField)
			{
				valueNullable = enumMapField.getValueTemplate().isMandatory() ? null : nullableAnnotation;
			}
			else
			{
				valueNullable = null; //MapField value is always mandatory; TODO handle other cases as needed
			}

			if(typeParams.length == 2)
			{
				//noinspection ConstantValue
				return featureClassName + '<' + getCanonicalName(field.getKeyClass(), keyNullable) + ',' +
					getCanonicalName(field.getValueClass(), valueNullable) + '>';
			}
			else if(typeParams.length == 0)
			{
				return featureClassName;
			}
			else if(typeParams.length == 1)
			{
				//just a more than optimistic hack to guess the mapping
				if("K".equals(typeParams[0].getName()))
				{
					//noinspection ConstantValue
					return featureClassName + '<' + getCanonicalName(field.getKeyClass(), keyNullable) + '>';
				}
				else if("V".equals(typeParams[0].getName()))
				{
					return featureClassName + '<' + getCanonicalName(field.getValueClass(), valueNullable) + '>';
				}
				else
				{
					throw new UnsupportedOperationException(
						"Unhandled feature type: " + featureClassName + "<" + typeParams[0] + ">");
				}
			}
			else
			{
				throw new UnsupportedOperationException("Unhandled feature type: " + featureClassName +
					"<" + Arrays.stream(typeParams).map(Type::getTypeName).collect(Collectors.joining(",")) + ">");
			}
		}
		else if(feature instanceof final RangeField<?> field)
		{
			//TODO two different nullabilities
			return RangeField.class.getName() + '<' +
				getCanonicalName(field.getFrom().getValueClass(), findNullableAnnotation(field.getFrom(), nullableAnnotation))
				+ '>';
		}
		else if(feature instanceof final Settable<?> settable)
		{
			return Settable.class.getName() + '<' +
				getCanonicalName(settable.getInitialType(), findNullableAnnotation(settable, nullableAnnotation)) + '>';
		}
		else if(feature instanceof final SetField<?> field)
		{
			return SetField.class.getName() + '<' + getCanonicalName(field.getElement().getValueClass(), null /*always mandatory*/) + '>';
		}
		else if(feature instanceof final ListField<?> field)
		{
			return ListField.class.getName() + '<' + getCanonicalName(field.getElement().getValueClass(),
				findNullableAnnotation(field.getElement(), nullableAnnotation)) + '>';
		}
		throw new UnsupportedOperationException("Unhandled feature type: " + feature.getClass().getCanonicalName());
	}

	public static boolean isVisible(final String packageName, final Type type)
	{
		if(type instanceof Class<?>)
			return isVisible(packageName, (Class<?>) type);
		else if(type instanceof ParameterizedType)
			return isVisible(packageName, (ParameterizedType) type);
		else if(type instanceof WildcardType)
			return isVisible(packageName, (WildcardType) type);
		else
			throw new RuntimeException(type.getTypeName() + ' ' + type.getClass());
	}

	private static boolean isVisible(final String packageName, final ParameterizedType type)
	{
		if(!isVisible(packageName, type.getRawType()))
			return false;

		for(final Type argument : type.getActualTypeArguments())
			if(!isVisible(packageName, argument))
				return false;

		return true;
	}

	private static boolean isVisible(final String packageName, final Class<?> clazz)
	{
		final int modifier = clazz.getModifiers();
		if(Modifier.isPublic(modifier))
			return true;
		if(Modifier.isPrivate(modifier))
			return false;

		return packageName.equals(clazz.getPackage().getName());
	}

	private static boolean isVisible(final String packageName, final WildcardType type)
	{
		for(final Type argument : type.getUpperBounds())
			if(!isVisible(packageName, argument))
				return false;

		for(final Type argument : type.getLowerBounds())
			if(!isVisible(packageName, argument))
				return false;

		return true;
	}

	public static boolean isEnumMapFieldLike(final Feature feature)
	{
		if(!(feature instanceof final MapFieldInterface<?, ?> mapField))
			return false;
		final Class<?> key = mapField.getKeyClass();
		if(!key.isEnum())
			return false;

		final boolean found = Arrays.stream(feature.getClass().getMethods())
			.anyMatch(m -> "getField".equals(m.getName()) // TODO via interface
				&& m.getParameterCount() == 1
				&& (m.getParameterTypes()[0] == key || m.getParameterTypes()[0] == Enum.class || m.getParameterTypes()[0] == Object.class));
		if(found)
			return true;

		System.out.println("Feature " + feature + " is missing a getField(K|Enum|Object key) method to generate key specific setter");
		return false;
	}

	private TypeUtil()
	{
		// prevent instantiation
	}
}
