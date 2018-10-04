package com.exedio.cope.builder.test;

import com.exedio.cope.IntegerField;
import com.exedio.cope.Item;

/**
 * @cope.constructor none
 * @cope.generic.constructor none
 */
public abstract class AbstractItem extends Item
{
	/**
	 * @cope.get public
	 */
	static final IntegerField abstractField = new IntegerField().toFinal();

	/**
	 * Returns the value of {@link #abstractField}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="get")
	public final int getAbstractField()
	{
		return AbstractItem.abstractField.getMandatory(this);
	}

	@javax.annotation.Generated("com.exedio.cope.instrument")
	private static final long serialVersionUID = 2l;

	/**
	 * The persistent type information for abstractItem.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @WrapperType(type=...)
	public static final com.exedio.cope.Type<AbstractItem> TYPE = com.exedio.cope.TypesBound.newType(AbstractItem.class);

	/**
	 * Activation constructor. Used for internal purposes only.
	 * @see com.exedio.cope.Item#Item(com.exedio.cope.ActivationParameters)
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument")
	protected AbstractItem(final com.exedio.cope.ActivationParameters ap){super(ap);}
}
