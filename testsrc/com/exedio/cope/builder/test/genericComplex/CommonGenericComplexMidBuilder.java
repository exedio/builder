package com.exedio.cope.builder.test.genericComplex;

import com.exedio.cope.Type;

public abstract class CommonGenericComplexMidBuilder<I extends GenericComplexMid<?>, B extends CommonGenericComplexMidBuilder<?,?>>
	extends GeneratedGenericComplexMidBuilder<I,B>
{
	protected CommonGenericComplexMidBuilder(final Type<I> type)
	{
		super(type);
	}

	@Override
	public I build()
	{
		return super.build();
	}
}
