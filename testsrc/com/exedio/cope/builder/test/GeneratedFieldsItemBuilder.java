package com.exedio.cope.builder.test;

@SuppressWarnings({"ClassEscapesDefinedScope", "RedundantSuppression"})
@com.exedio.cope.builder.Generated
public abstract class GeneratedFieldsItemBuilder<B extends GeneratedFieldsItemBuilder<B>>
	extends com.exedio.cope.builder.ItemBuilder<com.exedio.cope.builder.test.FieldsItem, B>
{
	@SuppressWarnings("unused")
	protected GeneratedFieldsItemBuilder()
	{
		super(FieldsItem.TYPE);
	}

	protected final com.exedio.cope.Settable<com.exedio.cope.pattern.Media.Value> media = getFeature("media");

	@com.exedio.cope.builder.Setter
	public final B media(final com.exedio.cope.pattern.Media.Value media)
	{
		return set(this.media,media);
	}

	protected final com.exedio.cope.Settable<java.lang.String> hash = getFeature("hash");

	@com.exedio.cope.builder.Setter
	public final B hash(final java.lang.String hash)
	{
		return set(this.hash,hash);
	}

	protected final com.exedio.cope.Settable<com.exedio.cope.pattern.Price> price = getFeature("price");

	@com.exedio.cope.builder.Setter
	public final B price(final com.exedio.cope.pattern.Price price)
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

	protected final com.exedio.cope.Settable<com.exedio.cope.pattern.Money<com.exedio.cope.builder.test.FieldsItem.Currency>> money = getFeature("money");

	@com.exedio.cope.builder.Setter
	public final B money(final com.exedio.cope.pattern.Money<com.exedio.cope.builder.test.FieldsItem.Currency> money)
	{
		return set(this.money,money);
	}

	@com.exedio.cope.builder.Setter
	public final B money(final double value,final com.exedio.cope.builder.test.FieldsItem.Currency currency)
	{
		return money(com.exedio.cope.pattern.Money.valueOf(value,currency));
	}

	@com.exedio.cope.builder.Setter
	public final B money(final int store,final com.exedio.cope.builder.test.FieldsItem.Currency currency)
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

	protected final com.exedio.cope.pattern.SetField<java.lang.String> set = getFeature("set");

	@com.exedio.cope.builder.Setter
	public final B set(final java.util.Set<java.lang.String> set)
	{
		return set(this.set,set);
	}

	@com.exedio.cope.builder.Setter
	public final B set(final java.lang.String... set)
	{
		return set(new java.util.LinkedHashSet<>(java.util.Arrays.asList(set)));
	}

	protected final com.exedio.cope.pattern.ListField<java.lang.String> list = getFeature("list");

	@com.exedio.cope.builder.Setter
	public final B list(final java.util.List<java.lang.String> list)
	{
		return set(this.list,list);
	}

	@com.exedio.cope.builder.Setter
	public final B list(final java.lang.String... list)
	{
		return list(java.util.Arrays.asList(list));
	}

	protected final com.exedio.cope.pattern.MapField<java.lang.String,java.lang.String> map = getFeature("map");

	@com.exedio.cope.builder.Setter
	public final B map(final java.util.Map<java.lang.String,java.lang.String> map)
	{
		return set(this.map,map);
	}

	protected final com.exedio.cope.Settable<com.exedio.cope.builder.skipped.SkippedBecauseTargetDirectoryDoesNotExistsItem> skippedMissing = getFeature("skippedMissing");

	@com.exedio.cope.builder.Setter
	public final B skippedMissing(final com.exedio.cope.builder.skipped.SkippedBecauseTargetDirectoryDoesNotExistsItem skippedMissing)
	{
		return set(this.skippedMissing,skippedMissing);
	}

	protected final com.exedio.cope.Settable<com.exedio.cope.builderSkipped.SkippedBecauseNotInPackagePrefixItem> skippedExcluded = getFeature("skippedExcluded");

	@com.exedio.cope.builder.Setter
	public final B skippedExcluded(final com.exedio.cope.builderSkipped.SkippedBecauseNotInPackagePrefixItem skippedExcluded)
	{
		return set(this.skippedExcluded,skippedExcluded);
	}
}
