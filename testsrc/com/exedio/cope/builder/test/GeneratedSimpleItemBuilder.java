package com.exedio.cope.builder.test;

@SuppressWarnings({"ClassEscapesDefinedScope", "RedundantSuppression"})
@com.exedio.cope.builder.Generated
public abstract class GeneratedSimpleItemBuilder<B extends GeneratedSimpleItemBuilder<B>>
	extends com.exedio.cope.builder.ItemBuilder<com.exedio.cope.builder.test.SimpleItem, B>
{
	@SuppressWarnings("unused")
	protected GeneratedSimpleItemBuilder()
	{
		super(SimpleItem.TYPE);
	}

	protected final com.exedio.cope.Settable<java.lang.Integer> integerMandatory = getFeature("integerMandatory");

	@com.exedio.cope.builder.Setter
	public final B integerMandatory(final int integerMandatory)
	{
		return set(this.integerMandatory,integerMandatory);
	}

	protected final com.exedio.cope.Settable<java.lang.Long> longOptional = getFeature("longOptional");

	@com.exedio.cope.builder.Setter
	public final B longOptional(final java.lang.Long longOptional)
	{
		return set(this.longOptional,longOptional);
	}

	protected final com.exedio.cope.Settable<java.lang.String> stringOptional = getFeature("stringOptional");

	@com.exedio.cope.builder.Setter
	public final B stringOptional(final java.lang.String stringOptional)
	{
		return set(this.stringOptional,stringOptional);
	}

	protected final com.exedio.cope.Settable<com.exedio.cope.builder.other.OuterClass.TestEnum> enumField = getFeature("enumField");

	@com.exedio.cope.builder.Setter
	public final B enumField(final com.exedio.cope.builder.other.OuterClass.TestEnum enumField)
	{
		return set(this.enumField,enumField);
	}
}
