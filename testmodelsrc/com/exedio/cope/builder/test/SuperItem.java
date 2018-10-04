package com.exedio.cope.builder.test;

import com.exedio.cope.IntegerField;
import com.exedio.cope.Item;

/**
 * @cope.constructor none
 * @cope.generic.constructor none
 */
public class SuperItem extends Item
{
	/**
	 * @cope.get public
	 */
	static final IntegerField superField = new IntegerField().toFinal();

	/**
	 * Returns the value of {@link #superField}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="get")
	public final int getSuperField()
	{
		return SuperItem.superField.getMandatory(this);
	}

	@javax.annotation.Generated("com.exedio.cope.instrument")
	private static final long serialVersionUID = 1l;

	/**
	 * The persistent type information for superItem.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @WrapperType(type=...)
	public static final com.exedio.cope.Type<SuperItem> TYPE = com.exedio.cope.TypesBound.newType(SuperItem.class);

	/**
	 * Activation constructor. Used for internal purposes only.
	 * @see com.exedio.cope.Item#Item(com.exedio.cope.ActivationParameters)
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument")
	protected SuperItem(final com.exedio.cope.ActivationParameters ap){super(ap);}
}
