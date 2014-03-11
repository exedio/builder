
package com.exedio.cope.builder.test;

public class ConcreteItemBuilder extends GeneratedConcreteItemBuilder<ConcreteItemBuilder>
{
	// TODO replace by generated code
	public final ConcreteItemBuilder abstractField(final int abstractField)
	{
		return set(AbstractItem.abstractField, abstractField);
	}

	@Override
	public ConcreteItem build()
	{
		fallback(ConcreteItem.concreteField, 888888);
		return super.build();
	}
}
