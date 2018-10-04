package com.exedio.cope.builder.other;

import com.exedio.cope.IntegerField;
import com.exedio.cope.pattern.Composite;

/**
 * @cope.constructor none
 */
public final class TestComposite extends Composite
{
	/**
	 * @cope.get public
	 */
	static final IntegerField integerMandatory = new IntegerField();

	/**
	 * @cope.get public
	 * @cope.set none
	 */
	private static final IntegerField integerOptional = new IntegerField().optional();

	/**
	 * Creates a new TestComposite and sets the given fields initially.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @WrapperType(genericConstructor=...)
	private TestComposite(final com.exedio.cope.SetValue<?>... setValues)
	{
		super(setValues);
	}

	/**
	 * Returns the value of {@link #integerMandatory}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="get")
	public final int getIntegerMandatory()
	{
		return getMandatory(TestComposite.integerMandatory);
	}

	/**
	 * Sets a new value for {@link #integerMandatory}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="set")
	final void setIntegerMandatory(final int integerMandatory)
	{
		set(TestComposite.integerMandatory,integerMandatory);
	}

	/**
	 * Returns the value of {@link #integerOptional}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="get")
	public final java.lang.Integer getIntegerOptional()
	{
		return get(TestComposite.integerOptional);
	}

	@javax.annotation.Generated("com.exedio.cope.instrument")
	private static final long serialVersionUID = 1l;
}
