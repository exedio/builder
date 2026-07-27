package com.exedio.cope.builder.other;

@SuppressWarnings({"ClassEscapesDefinedScope", "RedundantSuppression"})
@com.exedio.cope.builder.Generated
public abstract class GeneratedSubItemBuilder<B extends GeneratedSubItemBuilder<B>>
	extends com.exedio.cope.builder.test.CommonSuperItemBuilder<com.exedio.cope.builder.other.SubItem, B>
{
	@SuppressWarnings("unused")
	protected GeneratedSubItemBuilder()
	{
		super(SubItem.TYPE);
	}

	protected final com.exedio.cope.Settable<java.lang.Integer> subField = getFeature("subField");

	@com.exedio.cope.builder.Setter
	public final B subField(final int subField)
	{
		return set(this.subField,subField);
	}
}
