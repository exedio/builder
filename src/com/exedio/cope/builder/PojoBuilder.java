package com.exedio.cope.builder;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public abstract class PojoBuilder<R> implements Builder<R>
{
	@Nonnull
	protected <E> E fallback(@Nullable final E value, @Nonnull final Builder<? extends E> builder)
	{
		if(value != null)
			return value;
		return builder.build();
	}

	@Nonnull
	protected <E> E fallback(@Nullable final E value, @Nonnull final E def)
	{
		if(value != null)
			return value;
		return def;
	}

	@Nonnull
	protected <E> E required(@Nonnull final String field, @Nullable final E value)
	{
		if(value == null)
			throw new NullPointerException(field + " is required");
		return value;
	}
}
