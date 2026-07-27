package com.exedio.cope.builder.test;

@SuppressWarnings({"ClassEscapesDefinedScope", "RedundantSuppression"})
@com.exedio.cope.builder.Generated
public abstract class GeneratedOptionalFieldsItemBuilder<B extends GeneratedOptionalFieldsItemBuilder<B>>
	extends com.exedio.cope.builder.ItemBuilder<com.exedio.cope.builder.test.OptionalFieldsItem, B>
{
	@SuppressWarnings("unused")
	protected GeneratedOptionalFieldsItemBuilder()
	{
		super(OptionalFieldsItem.TYPE);
	}

	protected final com.exedio.cope.Settable<com.exedio.cope.pattern.Media.Value> media = getFeature("media");

	@com.exedio.cope.builder.Setter
	public final B media(final com.exedio.cope.pattern.Media.@org.jspecify.annotations.Nullable Value media)
	{
		return set(this.media,media);
	}

	protected final com.exedio.cope.Settable<java.lang.String> hash = getFeature("hash");

	@com.exedio.cope.builder.Setter
	public final B hash(final java.lang.@org.jspecify.annotations.Nullable String hash)
	{
		return set(this.hash,hash);
	}

	protected final com.exedio.cope.Settable<com.exedio.cope.pattern.Price> price = getFeature("price");

	@com.exedio.cope.builder.Setter
	public final B price(final com.exedio.cope.pattern.@org.jspecify.annotations.Nullable Price price)
	{
		return set(this.price,price);
	}

	@com.exedio.cope.builder.Setter
	public final B price(final double value)
	{
		return price(com.exedio.cope.pattern.Price.valueOf(value));
	}

	@com.exedio.cope.builder.Setter
	public final B price(final int store)
	{
		return price(com.exedio.cope.pattern.Price.storeOf(store));
	}

	protected final com.exedio.cope.Settable<com.exedio.cope.pattern.Money<com.exedio.cope.builder.test.OptionalFieldsItem.Currency>> money = getFeature("money");

	@com.exedio.cope.builder.Setter
	public final B money(final com.exedio.cope.pattern.@org.jspecify.annotations.Nullable Money<com.exedio.cope.builder.test.OptionalFieldsItem.Currency> money)
	{
		return set(this.money,money);
	}

	@com.exedio.cope.builder.Setter
	public final B money(final double value,final com.exedio.cope.builder.test.OptionalFieldsItem.Currency currency)
	{
		return money(com.exedio.cope.pattern.Money.valueOf(value,currency));
	}

	@com.exedio.cope.builder.Setter
	public final B money(final int store,final com.exedio.cope.builder.test.OptionalFieldsItem.Currency currency)
	{
		return money(com.exedio.cope.pattern.Money.storeOf(store,currency));
	}

	protected final com.exedio.cope.Settable<com.exedio.cope.pattern.Range<java.lang.Integer>> range = getFeature("range");

	@com.exedio.cope.builder.Setter
	public final B range(final com.exedio.cope.pattern.Range<java.lang.Integer> range)
	{
		return set(this.range,range);
	}

	@com.exedio.cope.builder.Setter
	public final B range(final java.lang.Integer from, final java.lang.Integer to)
	{
		return range(com.exedio.cope.pattern.Range.valueOf(from, to));
	}

	protected final com.exedio.cope.pattern.EnumMapField<com.exedio.cope.builder.other.OuterClass.TestEnum,java.lang.String> enumMap = getFeature("enumMap");

	@com.exedio.cope.builder.Setter
	public final B enumMap(final java.util.Map<com.exedio.cope.builder.other.OuterClass.TestEnum,java.lang.String> enumMap)
	{
		enumMap.forEach(this::enumMap);
		return self();
	}

	@com.exedio.cope.builder.Setter
	public final B enumMap(final com.exedio.cope.builder.other.OuterClass.TestEnum key, final java.lang.String value)
	{
		return set(this.enumMap.getField(key), value);
	}

	@com.exedio.cope.builder.Setter
	public final B enumMapOne(final java.lang.String one)
	{
		return enumMap(com.exedio.cope.builder.other.OuterClass.TestEnum.one,one);
	}

	@com.exedio.cope.builder.Setter
	public final B enumMapTwo(final java.lang.String two)
	{
		return enumMap(com.exedio.cope.builder.other.OuterClass.TestEnum.two,two);
	}

	@com.exedio.cope.builder.Setter
	public final B enumMapThree(final java.lang.String three)
	{
		return enumMap(com.exedio.cope.builder.other.OuterClass.TestEnum.three,three);
	}

	protected final com.exedio.cope.pattern.ListField<java.lang.String> list = getFeature("list");

	@com.exedio.cope.builder.Setter
	public final B list(final java.util.List<java.lang.@org.jspecify.annotations.Nullable String> list)
	{
		return set(this.list,list);
	}

	@com.exedio.cope.builder.Setter
	public final B list(final java.lang.String... list)
	{
		return list(java.util.Arrays.asList(list));
	}

	protected final com.exedio.cope.Settable<com.exedio.cope.builder.test.SimpleItem> item = getFeature("item");

	@com.exedio.cope.builder.Setter
	public final B item(final com.exedio.cope.builder.test.@org.jspecify.annotations.Nullable SimpleItem item)
	{
		return set(this.item,item);
	}

	@com.exedio.cope.builder.Setter
	public final B item(final java.util.function.Function<com.exedio.cope.builder.test.SimpleItemBuilder, com.exedio.cope.builder.test.SimpleItemBuilder> itemBuilderConsumer)
	{
		return item(itemBuilderConsumer.apply( new com.exedio.cope.builder.test.SimpleItemBuilder() ).build());
	}

	@com.exedio.cope.builder.Setter
	public final B itemNull()
	{
		return item((com.exedio.cope.builder.test.SimpleItem) null);
	}
}
