package com.exedio.cope.builder.test;

import com.exedio.cope.IntegerField;
import com.exedio.cope.pattern.Composite;

/**
 * @cope.constructor none
 */
final class TestComposite extends Composite
{
	static final IntegerField integerMandatory = new IntegerField();

	/**
	 * @cope.get package
	 * @cope.set none
	 */
	private static final IntegerField integerOptional = new IntegerField().optional();

	/**

	 **
	 * Creates a new TestComposite and sets the given fields initially.
	 * @cope.generated This feature has been generated by the cope instrumentor and will be overwritten by the build process.
	 *       It can be customized with the tag <tt>@cope.generic.constructor public|package|protected|private|none</tt> in the class comment.
	 */
	private TestComposite(final com.exedio.cope.SetValue<?>... setValues)
	{
		super(setValues);
	}/**

	 **
	 * Returns the value of {@link #integerMandatory}.
	 * @cope.generated This feature has been generated by the cope instrumentor and will be overwritten by the build process.
	 *       It can be customized with the tag <tt>@cope.get public|package|protected|private|none|non-final</tt> in the comment of the field.
	 */
	final int getIntegerMandatory()
	{
		return getMandatory(TestComposite.integerMandatory);
	}/**

	 **
	 * Sets a new value for {@link #integerMandatory}.
	 * @cope.generated This feature has been generated by the cope instrumentor and will be overwritten by the build process.
	 *       It can be customized with the tag <tt>@cope.set public|package|protected|private|none|non-final</tt> in the comment of the field.
	 */
	final void setIntegerMandatory(final int integerMandatory)
	{
		set(TestComposite.integerMandatory,integerMandatory);
	}/**

	 **
	 * Returns the value of {@link #integerOptional}.
	 * @cope.generated This feature has been generated by the cope instrumentor and will be overwritten by the build process.
	 *       It can be customized with the tag <tt>@cope.get public|package|protected|private|none|non-final</tt> in the comment of the field.
	 */
	final java.lang.Integer getIntegerOptional()
	{
		return get(TestComposite.integerOptional);
	}/**

	 **
	 * @cope.generated This feature has been generated by the cope instrumentor and will be overwritten by the build process.
	 */
	private static final long serialVersionUID = 1l;}
