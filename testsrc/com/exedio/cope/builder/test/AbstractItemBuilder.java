
package com.exedio.cope.builder.test;

public abstract class AbstractItemBuilder extends GeneratedAbstractItemBuilder<AbstractItemBuilder>
{
	@Override
	public AbstractItem build()
	{
		fallback(AbstractItem.abstractField, 777777);
		return super.build();
	}
}
