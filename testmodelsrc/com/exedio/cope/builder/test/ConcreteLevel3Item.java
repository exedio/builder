package com.exedio.cope.builder.test;

import com.exedio.cope.IntegerField;

/**
 * @cope.constructor none
 * @cope.generic.constructor none
 */
public class ConcreteLevel3Item extends MixedLevel2Item
{
	/**
	 * @cope.get public
	 */
	static final IntegerField l3 = new IntegerField().toFinal();

	/**
	 * Returns the value of {@link #l3}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="get")
	public final int getL3()
	{
		return ConcreteLevel3Item.l3.getMandatory(this);
	}

	@javax.annotation.Generated("com.exedio.cope.instrument")
	private static final long serialVersionUID = 1l;

	/**
	 * The persistent type information for concreteLevel3Item.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @WrapperType(type=...)
	public static final com.exedio.cope.Type<ConcreteLevel3Item> TYPE = com.exedio.cope.TypesBound.newType(ConcreteLevel3Item.class);

	/**
	 * Activation constructor. Used for internal purposes only.
	 * @see com.exedio.cope.Item#Item(com.exedio.cope.ActivationParameters)
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument")
	protected ConcreteLevel3Item(final com.exedio.cope.ActivationParameters ap){super(ap);}
}
