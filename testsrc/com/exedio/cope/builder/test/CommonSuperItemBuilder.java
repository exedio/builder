package com.exedio.cope.builder.test;

import com.exedio.cope.Type;

public abstract class CommonSuperItemBuilder<I extends SuperItem, B extends CommonSuperItemBuilder<?, ?>>
	extends GeneratedSuperItemBuilder<I, B>
{
	protected CommonSuperItemBuilder(final Type<I> type)
	{
		super(type);
	}

	@Override
	public I build()
	{
		fallback(superField, 888888);
		return super.build();
	}
}
