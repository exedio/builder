
package com.exedio.cope.builder.test;

import com.exedio.cope.Type;

public class SuperItemBuilder<I extends SuperItem, B extends SuperItemBuilder<?,?>>
	extends GeneratedSuperItemBuilder<I,B>
{
	public SuperItemBuilder()
	{
		super();
	}

	protected SuperItemBuilder(final Type<I> type)
	{
		super(type);
	}

	@Override
	public I build()
	{
		fallback(SuperItem.superField, 888888);
		return super.build();
	}
}
