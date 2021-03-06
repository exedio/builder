package com.exedio.cope.builder.test.genericComplex;

import com.exedio.cope.Type;

public abstract class CommonGenSupBuilder<I extends GenSup<?, ?>, B extends CommonGenSupBuilder<I, B>>
	extends GeneratedGenSupBuilder<I, B>
{
	protected CommonGenSupBuilder(final Type<I> type)
	{
		super(type);
	}

	@Override
	@SuppressWarnings("EmptyMethod")
	public I build()
	{
		return super.build();
	}
}
