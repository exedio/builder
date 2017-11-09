package com.exedio.cope.builder.test.genericComplex;

import com.exedio.cope.Type;

public abstract class CommonGenSupBuilder<I extends GenSup<?, ?>, B extends CommonGenSupBuilder<?, ?>>
	extends GeneratedGenSupBuilder<I, B>
{
	protected CommonGenSupBuilder(final Type<I> type)
	{
		super(type);
	}

	@Override
	public I build()
	{
		return super.build();
	}
}
