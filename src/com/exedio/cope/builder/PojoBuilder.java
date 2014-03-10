package com.exedio.cope.builder;

public abstract class PojoBuilder<R> implements Builder<R>
{
	protected <E> E fallback(final E value, final Builder<? extends E> builder)
	{
		if(value != null) return value;
		return builder.build();
	}

	protected <E> E fallback(final E value, final E def)
	{
		if(value != null) return value;
		return def;
	}

	protected <E> E required( final String field, final E o )
	{
		if( o == null ) throw new NullPointerException( field + " is required" );
		return o;
	}
}
