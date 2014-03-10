
package com.exedio.cope.builder.test;

public class SimpleItemBuilder extends GeneratedSimpleItemBuilder<SimpleItemBuilder>
{
	@Override
	public SimpleItem build()
	{
		fallback(SimpleItem.integerMandatory, 777777);
		return super.build();
	}
}
