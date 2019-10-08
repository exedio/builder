package com.exedio.cope.builder.test;

import com.exedio.cope.builder.MediaBuilder;
import com.exedio.cope.builder.other.OuterClass.TestEnum;
import com.exedio.cope.pattern.Money;
import com.exedio.cope.pattern.Price;
import com.exedio.cope.pattern.Range;
import java.util.EnumMap;

public class FieldsItemBuilder extends GeneratedFieldsItemBuilder<FieldsItemBuilder>
{
	@Override
	public FieldsItem build()
	{
		fallback(media, new MediaBuilder());
		fallback(hash, "fallbackHashValue");
		fallback(price, Price.storeOf(7777777));
		fallback(money, Money.storeOf(8888888, FieldsItem.Currency.EUR));
		fallback(range, Range.valueOf(7777777, 8888888));

		fallback(enumMap, TestEnum.one, "keyFallback1");
		final EnumMap<TestEnum, String> enumMap = new EnumMap<>(TestEnum.class);
		enumMap.put(TestEnum.one, "mapFallback1");//ignored
		enumMap.put(TestEnum.two, "mapFallback2");
		//enumMap.put(TestEnum.three, "mapFallback3"); skip to use default
		fallback(this.enumMap, enumMap);
		fallback(this.enumMap, TestEnum.two, "keyFallback2");//ignored

		return super.build();
	}
}
