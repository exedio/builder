
package com.exedio.cope.builder.test;

public class SubItemBuilder extends GeneratedSubItemBuilder<SubItemBuilder>
{
	@Override
	public SubItem build()
	{
		fallback(SubItem.subField, 777777);
		return super.build();
	}
}
