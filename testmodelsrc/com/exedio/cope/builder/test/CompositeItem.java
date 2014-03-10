package com.exedio.cope.builder.test;

import com.exedio.cope.Item;
import com.exedio.cope.pattern.CompositeField;

/**
 * @cope.constructor none
 * @cope.generic.constructor none
 */
final class CompositeItem extends Item
{
	static final CompositeField<TestComposite> field = CompositeField.create(TestComposite.class);

	/**

	 **
	 * Returns the value of {@link #field}.
	 * @cope.generated This feature has been generated by the cope instrumentor and will be overwritten by the build process.
	 *       It can be customized with the tag <tt>@cope.get public|package|protected|private|none|non-final</tt> in the comment of the field.
	 */
	final TestComposite getField()
	{
		return CompositeItem.field.get(this);
	}/**

	 **
	 * Sets a new value for {@link #field}.
	 * @cope.generated This feature has been generated by the cope instrumentor and will be overwritten by the build process.
	 *       It can be customized with the tag <tt>@cope.set public|package|protected|private|none|non-final</tt> in the comment of the field.
	 */
	final void setField(final TestComposite field)
			throws
				com.exedio.cope.MandatoryViolationException
	{
		CompositeItem.field.set(this,field);
	}/**

	 **
	 * @cope.generated This feature has been generated by the cope instrumentor and will be overwritten by the build process.
	 */
	private static final long serialVersionUID = 1l;/**

	 **
	 * The persistent type information for compositeItem.
	 * @cope.generated This feature has been generated by the cope instrumentor and will be overwritten by the build process.
	 *       It can be customized with the tag <tt>@cope.type public|package|protected|private|none</tt> in the class comment.
	 */
	static final com.exedio.cope.Type<CompositeItem> TYPE = com.exedio.cope.TypesBound.newType(CompositeItem.class);/**

	 **
	 * Activation constructor. Used for internal purposes only.
	 * @see com.exedio.cope.Item#Item(com.exedio.cope.ActivationParameters)
	 * @cope.generated This feature has been generated by the cope instrumentor and will be overwritten by the build process.
	 */
	@SuppressWarnings("unused") private CompositeItem(final com.exedio.cope.ActivationParameters ap){super(ap);
}}
