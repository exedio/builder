package com.exedio.cope.builder.test.packagePrivate;

@SuppressWarnings({"ClassEscapesDefinedScope", "RedundantSuppression"})
@com.exedio.cope.builder.Generated
public abstract class GeneratedMyItemBuilder<B extends GeneratedMyItemBuilder<B>>
	extends com.exedio.cope.builder.ItemBuilder<com.exedio.cope.builder.test.packagePrivate.MyItem, B>
{
	@SuppressWarnings("unused")
	protected GeneratedMyItemBuilder()
	{
		super(MyItem.TYPE);
	}

	protected final com.exedio.cope.Settable<com.exedio.cope.builder.test.packagePrivate.@org.jspecify.annotations.Nullable MyEnum> enumF = getFeature("enumF");

	@com.exedio.cope.builder.Setter
	public final B enumF(final com.exedio.cope.builder.test.packagePrivate.@org.jspecify.annotations.Nullable MyEnum enumF)
	{
		return set(this.enumF,enumF);
	}

	protected final com.exedio.cope.Settable<com.exedio.cope.builder.test.packagePrivate.@org.jspecify.annotations.Nullable MyItem> item = getFeature("item");

	@com.exedio.cope.builder.Setter
	public final B item(final com.exedio.cope.builder.test.packagePrivate.@org.jspecify.annotations.Nullable MyItem item)
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

	protected final com.exedio.cope.Settable<com.exedio.cope.builder.test.packagePrivate.@org.jspecify.annotations.Nullable MyComposite> composite = getFeature("composite");

	@com.exedio.cope.builder.Setter
	public final B composite(final com.exedio.cope.builder.test.packagePrivate.@org.jspecify.annotations.Nullable MyComposite composite)
	{
		return set(this.composite,composite);
	}

	@com.exedio.cope.builder.Setter
	public final B composite(final java.util.function.Function<com.exedio.cope.builder.test.packagePrivate.MyCompositeBuilder, com.exedio.cope.builder.test.packagePrivate.MyCompositeBuilder> compositeBuilderConsumer)
	{
		return composite(compositeBuilderConsumer.apply( new com.exedio.cope.builder.test.packagePrivate.MyCompositeBuilder() ).build());
	}

	@com.exedio.cope.builder.Setter
	public final B compositeNull()
	{
		return composite((com.exedio.cope.builder.test.packagePrivate.MyComposite) null);
	}

	protected final com.exedio.cope.Settable<com.exedio.cope.pattern.Range<com.exedio.cope.builder.test.packagePrivate.MyEnum>> rangeEnum = getFeature("rangeEnum");

	@com.exedio.cope.builder.Setter
	public final B rangeEnum(final com.exedio.cope.pattern.Range<com.exedio.cope.builder.test.packagePrivate.MyEnum> rangeEnum)
	{
		return set(this.rangeEnum,rangeEnum);
	}

	@com.exedio.cope.builder.Setter
	public final B rangeEnum(final com.exedio.cope.builder.test.packagePrivate.MyEnum from, final com.exedio.cope.builder.test.packagePrivate.MyEnum to)
	{
		return rangeEnum(com.exedio.cope.pattern.Range.valueOf(from, to));
	}

	protected final com.exedio.cope.Settable<com.exedio.cope.pattern.@org.jspecify.annotations.Nullable Money<com.exedio.cope.builder.test.packagePrivate.MyEnum>> moneyEnum = getFeature("moneyEnum");

	@com.exedio.cope.builder.Setter
	public final B moneyEnum(final com.exedio.cope.pattern.@org.jspecify.annotations.Nullable Money<com.exedio.cope.builder.test.packagePrivate.MyEnum> moneyEnum)
	{
		return set(this.moneyEnum,moneyEnum);
	}

	@com.exedio.cope.builder.Setter
	public final B moneyEnum(final double value,final com.exedio.cope.builder.test.packagePrivate.MyEnum currency)
	{
		return moneyEnum(com.exedio.cope.pattern.Money.valueOf(value,currency));
	}

	@com.exedio.cope.builder.Setter
	public final B moneyEnum(final int store,final com.exedio.cope.builder.test.packagePrivate.MyEnum currency)
	{
		return moneyEnum(com.exedio.cope.pattern.Money.storeOf(store,currency));
	}

	protected final com.exedio.cope.Settable<com.exedio.cope.pattern.@org.jspecify.annotations.Nullable Money<com.exedio.cope.builder.test.packagePrivate.MyItem>> moneyItem = getFeature("moneyItem");

	@com.exedio.cope.builder.Setter
	public final B moneyItem(final com.exedio.cope.pattern.@org.jspecify.annotations.Nullable Money<com.exedio.cope.builder.test.packagePrivate.MyItem> moneyItem)
	{
		return set(this.moneyItem,moneyItem);
	}

	@com.exedio.cope.builder.Setter
	public final B moneyItem(final double value,final com.exedio.cope.builder.test.packagePrivate.MyItem currency)
	{
		return moneyItem(com.exedio.cope.pattern.Money.valueOf(value,currency));
	}

	@com.exedio.cope.builder.Setter
	public final B moneyItem(final int store,final com.exedio.cope.builder.test.packagePrivate.MyItem currency)
	{
		return moneyItem(com.exedio.cope.pattern.Money.storeOf(store,currency));
	}
}
