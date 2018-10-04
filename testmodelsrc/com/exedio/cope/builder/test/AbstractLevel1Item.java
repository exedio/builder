package com.exedio.cope.builder.test;

import com.exedio.cope.IntegerField;
import com.exedio.cope.Item;

/**
 * @cope.constructor none
 * @cope.generic.constructor none
 */
public abstract class AbstractLevel1Item extends Item
{
	/**
	 * @cope.get public
	 */
	static final IntegerField l1 = new IntegerField().toFinal();

	/**
	 * Returns the value of {@link #l1}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="get")
	public final int getL1()
	{
		return AbstractLevel1Item.l1.getMandatory(this);
	}

	@javax.annotation.Generated("com.exedio.cope.instrument")
	private static final long serialVersionUID = 2l;

	/**
	 * The persistent type information for abstractLevel1Item.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @WrapperType(type=...)
	public static final com.exedio.cope.Type<AbstractLevel1Item> TYPE = com.exedio.cope.TypesBound.newType(AbstractLevel1Item.class);

	/**
	 * Activation constructor. Used for internal purposes only.
	 * @see com.exedio.cope.Item#Item(com.exedio.cope.ActivationParameters)
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument")
	protected AbstractLevel1Item(final com.exedio.cope.ActivationParameters ap){super(ap);}
}
