package com.exedio.cope.builder.other;

import static com.exedio.cope.instrument.Visibility.NONE;
import static com.exedio.cope.instrument.Visibility.PUBLIC;

import com.exedio.cope.IntegerField;
import com.exedio.cope.instrument.Wrapper;
import com.exedio.cope.instrument.WrapperType;
import com.exedio.cope.pattern.Composite;

@WrapperType(constructor=NONE)
public final class TestComposite extends Composite
{
	@Wrapper(wrap="get", visibility=PUBLIC)
	static final IntegerField integerMandatory = new IntegerField();

	@Wrapper(wrap="get", visibility=PUBLIC)
	@Wrapper(wrap="set", visibility=NONE)
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
