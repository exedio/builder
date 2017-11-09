package com.exedio.cope.builder.test.genericComplex;

import com.exedio.cope.Type;

public abstract class CommonGenMidBuilder<I extends GenMid<?>, B extends CommonGenMidBuilder<?, ?>>
	extends GeneratedGenMidBuilder<I, B>
{
	protected CommonGenMidBuilder(final Type<I> type)
	{
		super(type);
	}

	@Override
	public I build()
	{
		return super.build();
	}
}
