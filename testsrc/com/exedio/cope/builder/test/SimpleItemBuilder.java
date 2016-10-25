
package com.exedio.cope.builder.test;

import com.exedio.cope.builder.other.OuterClass.TestEnum;

public class SimpleItemBuilder extends GeneratedSimpleItemBuilder<SimpleItemBuilder>
{
	@Override
	public SimpleItem build()
	{
		fallback(integerMandatory, 777777);
		fallback(enumField, TestEnum.one);
		return super.build();
	}
}
