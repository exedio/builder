package com.exedio.cope.builder.test;

import com.exedio.cope.Type;

public abstract class CommonAbstractLevel1ItemBuilder<I extends AbstractLevel1Item, B extends CommonAbstractLevel1ItemBuilder<?,?>>
	extends GeneratedAbstractLevel1ItemBuilder<I,B>
{
	protected CommonAbstractLevel1ItemBuilder(final Type<I> type)
	{
		super(type);
	}

	@Override
	public I build()
	{
		return super.build();
	}
}
