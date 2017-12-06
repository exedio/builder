package com.exedio.cope.builder.generator.type;

import com.exedio.cope.Feature;
import com.exedio.cope.Settable;
import com.exedio.cope.misc.PrimitiveUtil;
import com.exedio.cope.pattern.ListField;
import com.exedio.cope.pattern.MapField;
import com.exedio.cope.pattern.SetField;
import com.exedio.cope.util.Cast;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class TypeUtil
{
	@Nonnull
	static String typeParameterWildCards(@Nonnull final Class<?> clazz)
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

	@Nonnull
	public static String getCanonicalName(@Nonnull final Type type)
	{
		if(type instanceof Class)
			return getCanonicalName((Class<?>) type);
		else if(type instanceof ParameterizedType)
			return getCanonicalName((ParameterizedType) type);
		else
			throw new RuntimeException("Unhandled type " + type + " -- " + type.getClass());
	}

	@Nonnull
	private static String getCanonicalName(@Nonnull final Class<?> clazz)
	{
		return clazz.getCanonicalName() + typeParameterWildCards(clazz);
	}

	@Nonnull
	private static String getCanonicalName(@Nonnull final ParameterizedType type)
	{
		final Type ownerType = type.getOwnerType();
		if(ownerType != null)
			throw new IllegalArgumentException("ParameterizedType without owner:" + ownerType.toString());

		String name = (Cast.verboseCast(Class.class, type.getRawType()).getCanonicalName());
		if(type.getActualTypeArguments().length == 0) // TODO possible? add a test case
			return name;
		return name + "<" + Arrays.stream(type.getActualTypeArguments()).map(TypeUtil::getCanonicalName).collect(Collectors.joining(",")) + ">";
	}

	@Nullable
	public static String toSetterParameterType(@Nonnull final Feature feature)
	{
		if(feature instanceof Settable<?>)
		{
			final Settable<?> field = (Settable<?>) feature;
			final Type valueClass = field.getInitialType();
			final Type primitiveClass = (valueClass instanceof Class && field.isMandatory())
				? PrimitiveUtil.toPrimitive((Class<?>) valueClass)
				: valueClass;
			return getCanonicalName((primitiveClass != null) ? primitiveClass : valueClass);
		}
		else if(feature instanceof SetField<?>)
		{
			final SetField<?> field = (SetField<?>) feature;
			return Set.class.getName() + '<' + getCanonicalName(field.getElement().getValueClass()) + '>';
		}
		else if(feature instanceof ListField<?>)
		{
			final ListField<?> field = (ListField<?>) feature;
			return List.class.getName() + '<' + getCanonicalName(field.getElement().getValueClass()) + '>';
		}
		else if(feature instanceof MapField<?, ?>)
		{
			final MapField<?, ?> field = (MapField<?, ?>) feature;
			return Map.class.getName() + '<' + getCanonicalName(field.getKey().getValueClass()) + ',' + getCanonicalName(field.getValue().getValueClass())
				+ '>';
		}
		return null;
	}
}
