package com.exedio.cope.builder.generator.type;

import com.exedio.cope.Feature;
import com.exedio.cope.Settable;
import com.exedio.cope.misc.PrimitiveUtil;
import com.exedio.cope.pattern.EnumMapField;
import com.exedio.cope.pattern.ListField;
import com.exedio.cope.pattern.MapField;
import com.exedio.cope.pattern.SetField;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public final class TypeUtil
{
	@Nonnull
	static String typeParameterWildCards(@Nonnull final Class<?> clazz)
	{
		final int typeParameters = clazz.getTypeParameters().length;
		if(typeParameters == 0)
			return "";

		return "<?" + ",?".repeat(typeParameters - 1) + '>';
	}

	@Nonnull
	public static String getCanonicalName(@Nonnull final Type type)
	{
		if(type instanceof Class)
			return getCanonicalName((Class<?>) type);
		else if(type instanceof ParameterizedType)
			return getCanonicalName((ParameterizedType) type);
		else if(type instanceof WildcardType)
			return getCanonicalName((WildcardType) type);
		else
			throw new RuntimeException("Unhandled type " + type + " -- " + type.getClass());
	}

	@Nonnull
	private static String getCanonicalName(@Nonnull final Class<?> clazz)
	{
		return clazz.getCanonicalName() + typeParameterWildCards(clazz);
	}

	@Nonnull
	private static String getCanonicalName(@Nonnull final WildcardType type)
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

	@Nonnull
	private static String getCanonicalName(@Nonnull final ParameterizedType type)
	{
		final Type ownerType = type.getOwnerType();
		if(ownerType != null)
			throw new IllegalArgumentException("ParameterizedType without owner:" + ownerType);

		final String name = ((Class<?>)type.getRawType()).getCanonicalName();
		if(type.getActualTypeArguments().length == 0) // TODO possible? add a test case
			return name;
		return name + "<" + Arrays.stream(type.getActualTypeArguments()).map(TypeUtil::getCanonicalName).collect(Collectors.joining(",")) + ">";
	}

	@Nullable
	public static String valueType(@Nonnull final Feature feature)
	{
		if(feature instanceof final Settable<?> field)
		{
			final Type valueClass = field.getInitialType();
			final Type primitiveClass = (valueClass instanceof Class && field.isMandatory())
				? PrimitiveUtil.toPrimitive((Class<?>) valueClass)
				: valueClass;
			return getCanonicalName((primitiveClass != null) ? primitiveClass : Objects.requireNonNull(valueClass));
		}
		else if(feature instanceof final SetField<?> field)
		{
			return Set.class.getName() + '<' + getCanonicalName(field.getElement().getValueClass()) + '>';
		}
		else if(feature instanceof final ListField<?> field)
		{
			return List.class.getName() + '<' + getCanonicalName(field.getElement().getValueClass()) + '>';
		}
		else if(feature instanceof final MapField<?, ?> field)
		{
			return Map.class.getName() + '<' + getCanonicalName(field.getKey().getValueClass()) + ',' + getCanonicalName(field.getValue().getValueClass())
				+ '>';
		}
		return null;
	}

	@Nonnull
	public static String fieldType(@Nonnull final Feature feature)
	{
		if(feature instanceof Settable)
		{
			if(feature instanceof final EnumMapField<?, ?> field)
			{
				return EnumMapField.class.getCanonicalName() + '<' + getCanonicalName(field.getKeyClass()) + ',' +
					getCanonicalName(field.getValueClass()) + '>';
			}
			return Settable.class.getName() + '<' + getCanonicalName(((Settable<?>) feature).getInitialType()) + '>';
		}
		else if(feature instanceof SetField)
		{
			return SetField.class.getName() + '<' + getCanonicalName(((SetField<?>) feature).getElement().getValueClass()) + '>';
		}
		else if(feature instanceof ListField)
		{
			return ListField.class.getName() + '<' + getCanonicalName(((ListField<?>) feature).getElement().getValueClass()) + '>';
		}
		else if(feature instanceof final MapField<?, ?> field)
		{
			return MapField.class.getName() + '<' + getCanonicalName(field.getKey().getValueClass()) + ',' +
				getCanonicalName(field.getValue().getValueClass()) + '>';
		}
		throw new UnsupportedOperationException("Unhandled feature type: " + feature.getClass());
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

	private TypeUtil()
	{
		// prevent instantiation
	}
}
