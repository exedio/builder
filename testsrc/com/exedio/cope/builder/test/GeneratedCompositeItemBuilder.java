package com.exedio.cope.builder.test;

@SuppressWarnings({"ClassEscapesDefinedScope", "RedundantSuppression"})
@com.exedio.cope.builder.Generated
public abstract class GeneratedCompositeItemBuilder<B extends GeneratedCompositeItemBuilder<B>>
	extends com.exedio.cope.builder.ItemBuilder<com.exedio.cope.builder.test.CompositeItem, B>
{
	@SuppressWarnings("unused")
	protected GeneratedCompositeItemBuilder()
	{
		super(CompositeItem.TYPE);
	}

	protected final com.exedio.cope.Settable<com.exedio.cope.builder.other.TestComposite> field = getFeature("field");

	@com.exedio.cope.builder.Setter
	public final B field(final com.exedio.cope.builder.other.TestComposite field)
	{
		return set(this.field,field);
	}

	@com.exedio.cope.builder.Setter
	public final B field(final java.util.function.Function<com.exedio.cope.builder.other.TestCompositeBuilder, com.exedio.cope.builder.other.TestCompositeBuilder> fieldBuilderConsumer)
	{
		return field(fieldBuilderConsumer.apply( new com.exedio.cope.builder.other.TestCompositeBuilder() ).build());
	}
}
