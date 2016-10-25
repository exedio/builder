
package com.exedio.cope.builder.test;

import com.exedio.cope.Type;

public abstract class CommonAbstractItemBuilder<I extends AbstractItem, B extends CommonAbstractItemBuilder<?,?>>
	extends GeneratedAbstractItemBuilder<I,B>
{
	protected CommonAbstractItemBuilder(final Type<I> type)
	{
		super(type);
	}

	@Override
	public I build()
	{
		fallback(abstractField, 777777);
		return super.build();
	}
}
