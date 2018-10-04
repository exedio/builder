package com.exedio.cope.builder.other;

import com.exedio.cope.IntegerField;
import com.exedio.cope.builder.test.SuperItem;

/**
 * @cope.constructor none
 * @cope.generic.constructor none
 */
public final class SubItem extends SuperItem
{
	/**
	 * @cope.get public
	 */
	static final IntegerField subField = new IntegerField().toFinal();

	/**
	 * Returns the value of {@link #subField}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="get")
	public final int getSubField()
	{
		return SubItem.subField.getMandatory(this);
	}

	@javax.annotation.Generated("com.exedio.cope.instrument")
	private static final long serialVersionUID = 1l;

	/**
	 * The persistent type information for subItem.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @WrapperType(type=...)
	public static final com.exedio.cope.Type<SubItem> TYPE = com.exedio.cope.TypesBound.newType(SubItem.class);

	/**
	 * Activation constructor. Used for internal purposes only.
	 * @see com.exedio.cope.Item#Item(com.exedio.cope.ActivationParameters)
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument")
	private SubItem(final com.exedio.cope.ActivationParameters ap){super(ap);}
}
