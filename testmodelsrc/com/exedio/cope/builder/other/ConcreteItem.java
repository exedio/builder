package com.exedio.cope.builder.other;

import com.exedio.cope.IntegerField;
import com.exedio.cope.builder.test.AbstractItem;

/**
 * @cope.constructor none
 * @cope.generic.constructor none
 */
public final class ConcreteItem extends AbstractItem
{
	/**
	 * @cope.get public
	 */
	private static final IntegerField concreteField = new IntegerField().toFinal();

	/**
	 * Returns the value of {@link #concreteField}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="get")
	public final int getConcreteField()
	{
		return ConcreteItem.concreteField.getMandatory(this);
	}

	@javax.annotation.Generated("com.exedio.cope.instrument")
	private static final long serialVersionUID = 1l;

	/**
	 * The persistent type information for concreteItem.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @WrapperType(type=...)
	public static final com.exedio.cope.Type<ConcreteItem> TYPE = com.exedio.cope.TypesBound.newType(ConcreteItem.class);

	/**
	 * Activation constructor. Used for internal purposes only.
	 * @see com.exedio.cope.Item#Item(com.exedio.cope.ActivationParameters)
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument")
	private ConcreteItem(final com.exedio.cope.ActivationParameters ap){super(ap);}
}
