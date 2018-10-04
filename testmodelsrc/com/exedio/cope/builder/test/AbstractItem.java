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

	 **
	 * Returns the value of {@link #abstractField}.
	 * @cope.generated This feature has been generated by the cope instrumentor and will be overwritten by the build process.
	 *       It can be customized with the tag <tt>@cope.get public|package|protected|private|none|non-final</tt> in the comment of the field.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument")
	public final int getAbstractField()
	{
		return AbstractItem.abstractField.getMandatory(this);
	}/**

	 **
	 * @cope.generated This feature has been generated by the cope instrumentor and will be overwritten by the build process.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument")
	private static final long serialVersionUID = 2l;/**

	 **
	 * The persistent type information for abstractItem.
	 * @cope.generated This feature has been generated by the cope instrumentor and will be overwritten by the build process.
	 *       It can be customized with the tag <tt>@cope.type public|package|protected|private|none</tt> in the class comment.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument")
	public static final com.exedio.cope.Type<AbstractItem> TYPE = com.exedio.cope.TypesBound.newType(AbstractItem.class);/**

	 **
	 * Activation constructor. Used for internal purposes only.
	 * @see com.exedio.cope.Item#Item(com.exedio.cope.ActivationParameters)
	 * @cope.generated This feature has been generated by the cope instrumentor and will be overwritten by the build process.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument")
	protected AbstractItem(final com.exedio.cope.ActivationParameters ap){super(ap);
}}
