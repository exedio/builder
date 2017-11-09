package com.exedio.cope.builder.test;

import com.exedio.cope.builder.other.TestCompositeBuilder;

public class CompositeItemBuilder extends GeneratedCompositeItemBuilder<CompositeItemBuilder>
{
	@Override
	public CompositeItem build()
	{
		fallback(field, new TestCompositeBuilder());
		return super.build();
	}
}
