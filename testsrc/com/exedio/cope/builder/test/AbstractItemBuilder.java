
package com.exedio.cope.builder.test;

import com.exedio.cope.Type;

public abstract class AbstractItemBuilder<I extends AbstractItem, B extends AbstractItemBuilder<?,?>>
	extends GeneratedAbstractItemBuilder<I,B>
{
	protected AbstractItemBuilder(final Type<I> type)
	{
		super(type);
	}

	@Override
	public I build()
	{
		fallback(AbstractItem.abstractField, 777777);
		return super.build();
	}
}
