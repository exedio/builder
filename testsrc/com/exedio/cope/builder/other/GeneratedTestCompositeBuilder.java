package com.exedio.cope.builder.other;

@SuppressWarnings({"ClassEscapesDefinedScope", "RedundantSuppression"})
@com.exedio.cope.builder.Generated
public abstract class GeneratedTestCompositeBuilder<B extends GeneratedTestCompositeBuilder<B>>
	extends com.exedio.cope.builder.CompositeBuilder<com.exedio.cope.builder.other.TestComposite, B>
{
	@SuppressWarnings("unused")
	protected GeneratedTestCompositeBuilder()
	{
		super(TestComposite.class);
	}

	protected final com.exedio.cope.Settable<java.lang.Integer> integerMandatory = getFeature("integerMandatory");

	@com.exedio.cope.builder.Setter
	public final B integerMandatory(final int integerMandatory)
	{
		return set(this.integerMandatory,integerMandatory);
	}

	protected final com.exedio.cope.Settable<java.lang.Integer> integerOptional = getFeature("integerOptional");

	@com.exedio.cope.builder.Setter
	public final B integerOptional(final java.lang.Integer integerOptional)
	{
		return set(this.integerOptional,integerOptional);
	}
}
