
package com.exedio.cope.builder.test;

public class SuperItemBuilder extends GeneratedSuperItemBuilder<SuperItemBuilder>
{
	@Override
	public SuperItem build()
	{
		fallback(SuperItem.superField, 888888);
		return super.build();
	}
}
