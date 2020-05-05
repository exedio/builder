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
	@com.exedio.cope.instrument.Generated // customize with @WrapperType(genericConstructor=...)
	private TestComposite(final com.exedio.cope.SetValue<?>... setValues){super(setValues);}

	/**
	 * Returns the value of {@link #integerMandatory}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="get")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	public final int getIntegerMandatory()
	{
		return getMandatory(TestComposite.integerMandatory);
	}

	/**
	 * Sets a new value for {@link #integerMandatory}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="set")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final void setIntegerMandatory(final int integerMandatory)
	{
		set(TestComposite.integerMandatory,integerMandatory);
	}

	/**
	 * Returns the value of {@link #integerOptional}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="get")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	public final java.lang.Integer getIntegerOptional()
	{
		return get(TestComposite.integerOptional);
	}

	@com.exedio.cope.instrument.Generated
	private static final long serialVersionUID = 1l;
}
