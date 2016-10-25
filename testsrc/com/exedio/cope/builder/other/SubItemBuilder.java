
package com.exedio.cope.builder.other;

public class SubItemBuilder extends GeneratedSubItemBuilder<SubItemBuilder>
{
	@Override
	public SubItem build()
	{
		fallback(subField, 777777);
		return super.build();
	}
}
