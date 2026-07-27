package com.exedio.cope.builder.test;

@SuppressWarnings({"ClassEscapesDefinedScope", "RedundantSuppression"})
@com.exedio.cope.builder.Generated
public abstract class GeneratedUnknownPatternItemBuilder<B extends GeneratedUnknownPatternItemBuilder<B>>
	extends com.exedio.cope.builder.ItemBuilder<com.exedio.cope.builder.test.UnknownPatternItem, B>
{
	@SuppressWarnings("unused")
	protected GeneratedUnknownPatternItemBuilder()
	{
		super(UnknownPatternItem.TYPE);
	}

	protected final com.exedio.cope.Settable<com.exedio.cope.builder.test.SimpleItem> parent = getFeature("parent");

	@com.exedio.cope.builder.Setter
	public final B parent(final com.exedio.cope.builder.test.SimpleItem parent)
	{
		return set(this.parent,parent);
	}

	@com.exedio.cope.builder.Setter
	public final B parent(final java.util.function.Function<com.exedio.cope.builder.test.SimpleItemBuilder, com.exedio.cope.builder.test.SimpleItemBuilder> parentBuilderConsumer)
	{
		return parent(parentBuilderConsumer.apply( new com.exedio.cope.builder.test.SimpleItemBuilder() ).build());
	}

	protected final com.exedio.cope.Settable<java.lang.Integer> order = getFeature("order");

	@com.exedio.cope.builder.Setter
	public final B order(final int order)
	{
		return set(this.order,order);
	}
}
