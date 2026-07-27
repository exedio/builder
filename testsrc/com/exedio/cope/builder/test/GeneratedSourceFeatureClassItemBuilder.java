package com.exedio.cope.builder.test;

@SuppressWarnings({"ClassEscapesDefinedScope", "RedundantSuppression"})
@com.exedio.cope.builder.Generated
public abstract class GeneratedSourceFeatureClassItemBuilder<B extends GeneratedSourceFeatureClassItemBuilder<B>>
	extends com.exedio.cope.builder.ItemBuilder<com.exedio.cope.builder.test.SourceFeatureClassItem, B>
{
	@SuppressWarnings("unused")
	protected GeneratedSourceFeatureClassItemBuilder()
	{
		super(SourceFeatureClassItem.TYPE);
	}

	protected final com.exedio.cope.Settable<com.exedio.cope.mockframework.SourceFeatureClassPattern.EnumPublic> pattern_enumPublic = getFeature("pattern-enumPublic");

	@com.exedio.cope.builder.Setter
	public final B pattern_enumPublic(final com.exedio.cope.mockframework.SourceFeatureClassPattern.@org.jspecify.annotations.Nullable EnumPublic pattern_enumPublic)
	{
		return set(this.pattern_enumPublic,pattern_enumPublic);
	}

	protected final com.exedio.cope.Settable<com.exedio.cope.mockframework.SourceFeatureClassPattern.CompositePublic> pattern_compositePublic = getFeature("pattern-compositePublic");

	@com.exedio.cope.builder.Setter
	public final B pattern_compositePublic(final com.exedio.cope.mockframework.SourceFeatureClassPattern.@org.jspecify.annotations.Nullable CompositePublic pattern_compositePublic)
	{
		return set(this.pattern_compositePublic,pattern_compositePublic);
	}

	protected final com.exedio.cope.Settable<java.lang.Integer> pattern_blockPublic_integer = getFeature("pattern-blockPublic-integer");

	@com.exedio.cope.builder.Setter
	public final B pattern_blockPublic_integer(final java.lang.@org.jspecify.annotations.Nullable Integer pattern_blockPublic_integer)
	{
		return set(this.pattern_blockPublic_integer,pattern_blockPublic_integer);
	}

	protected final com.exedio.cope.Settable<java.lang.Integer> pattern_blockPackage_integer = getFeature("pattern-blockPackage-integer");

	@com.exedio.cope.builder.Setter
	public final B pattern_blockPackage_integer(final java.lang.@org.jspecify.annotations.Nullable Integer pattern_blockPackage_integer)
	{
		return set(this.pattern_blockPackage_integer,pattern_blockPackage_integer);
	}

	protected final com.exedio.cope.Settable<com.exedio.cope.pattern.Range<com.exedio.cope.mockframework.SourceFeatureClassPattern.EnumPublic>> pattern_rangeEnumPublic = getFeature("pattern-rangeEnumPublic");

	@com.exedio.cope.builder.Setter
	public final B pattern_rangeEnumPublic(final com.exedio.cope.pattern.Range<com.exedio.cope.mockframework.SourceFeatureClassPattern.EnumPublic> pattern_rangeEnumPublic)
	{
		return set(this.pattern_rangeEnumPublic,pattern_rangeEnumPublic);
	}

	@com.exedio.cope.builder.Setter
	public final B pattern_rangeEnumPublic(final com.exedio.cope.mockframework.SourceFeatureClassPattern.EnumPublic from, final com.exedio.cope.mockframework.SourceFeatureClassPattern.EnumPublic to)
	{
		return pattern_rangeEnumPublic(com.exedio.cope.pattern.Range.valueOf(from, to));
	}
}
