
package com.exedio.cope.builder.test;

import com.exedio.cope.builder.other.OuterClass.TestEnum;

public class SimpleItemBuilder extends GeneratedSimpleItemBuilder<SimpleItemBuilder>
{
	@Override
	public SimpleItem build()
	{
		fallback(SimpleItem.integerMandatory, 777777);
		fallback(SimpleItem.enumField, TestEnum.one);
		return super.build();
	}
}
