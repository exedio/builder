package com.exedio.cope.builder.other;

public class ConcreteItemBuilder extends GeneratedConcreteItemBuilder<ConcreteItemBuilder>
{
	@Override
	public ConcreteItem build()
	{
		fallback(concreteField, 888888);
		return super.build();
	}
}
