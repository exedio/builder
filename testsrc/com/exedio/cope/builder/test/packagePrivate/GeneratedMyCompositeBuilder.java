package com.exedio.cope.builder.test.packagePrivate;

@SuppressWarnings({"ClassEscapesDefinedScope", "RedundantSuppression"})
@com.exedio.cope.builder.Generated
public abstract class GeneratedMyCompositeBuilder<B extends GeneratedMyCompositeBuilder<B>>
	extends com.exedio.cope.builder.CompositeBuilder<com.exedio.cope.builder.test.packagePrivate.MyComposite, B>
{
	@SuppressWarnings("unused")
	protected GeneratedMyCompositeBuilder()
	{
		super(MyComposite.class);
	}

	protected final com.exedio.cope.Settable<java.lang.String> string = getFeature("string");

	@com.exedio.cope.builder.Setter
	public final B string(final java.lang.String string)
	{
		return set(this.string,string);
	}

	protected final com.exedio.cope.Settable<com.exedio.cope.builder.test.packagePrivate.MyEnum> enumF = getFeature("enumF");

	@com.exedio.cope.builder.Setter
	public final B enumF(final com.exedio.cope.builder.test.packagePrivate.MyEnum enumF)
	{
		return set(this.enumF,enumF);
	}

	protected final com.exedio.cope.Settable<com.exedio.cope.builder.test.packagePrivate.MyItem> item = getFeature("item");

	@com.exedio.cope.builder.Setter
	public final B item(final com.exedio.cope.builder.test.packagePrivate.MyItem item)
	{
		return set(this.item,item);
	}

	@com.exedio.cope.builder.Setter
	public final B item(final java.util.function.Function<com.exedio.cope.builder.test.packagePrivate.MyItemBuilder, com.exedio.cope.builder.test.packagePrivate.MyItemBuilder> itemBuilderConsumer)
	{
		return item(itemBuilderConsumer.apply( new com.exedio.cope.builder.test.packagePrivate.MyItemBuilder() ).build());
	}

	@com.exedio.cope.builder.Setter
	public final B itemNull()
	{
		return item((com.exedio.cope.builder.test.packagePrivate.MyItem) null);
	}
}
