package com.exedio.cope.builder.test;

import com.exedio.cope.Type;

public abstract class CommonMixedLevel2ItemBuilder<I extends MixedLevel2Item, B extends CommonMixedLevel2ItemBuilder<?, ?>>
	extends GeneratedMixedLevel2ItemBuilder<I, B>
{
	protected CommonMixedLevel2ItemBuilder(final Type<I> type)
	{
		super(type);
	}

	@Override
	public I build()
	{
		return super.build();
	}
}
