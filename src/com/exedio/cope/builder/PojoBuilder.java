package com.exedio.cope.builder;

import org.jspecify.annotations.Nullable;

public abstract class PojoBuilder<R> implements Builder<R>
{
	protected <E> E fallback(final @Nullable E value, final Builder<? extends E> builder)
	{
		if(value != null)
			return value;
		return builder.build();
	}

	protected <E> E fallback(final @Nullable E value, final E def)
	{
		if(value != null)
			return value;
		return def;
	}

	protected <E> E required(final String field, final @Nullable E value)
	{
		if(value == null)
			throw new NullPointerException(field + " is required");
		return value;
	}
}
