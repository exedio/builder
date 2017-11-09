package com.exedio.cope.builder.test;

import static com.exedio.cope.builder.test.FieldsItem.Currency.EUR;
import static com.exedio.cope.builder.test.FieldsItem.Currency.GBP;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.emptyMap;
import static java.util.Collections.emptySet;
import static org.junit.Assert.assertEquals;

import com.exedio.cope.builder.MediaBuilder;
import com.exedio.cope.builder.other.OuterClass.TestEnum;
import com.exedio.cope.pattern.Money;
import com.exedio.cope.pattern.Price;
import com.exedio.cope.pattern.Range;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import org.junit.Test;

public class FieldsTest extends MainTest
{
	@Test
	public void explicit()
	{
		final EnumMap<TestEnum, String> enumMap = new EnumMap<>(TestEnum.class);
		enumMap.put(TestEnum.one, "enumMapValueOne");
		enumMap.put(TestEnum.two, "enumMapValueTwo");
		enumMap.put(TestEnum.three, "enumMapValueThree");
		final HashMap<String, String> map = new HashMap<>();
		map.put("key1", "value1");
		map.put("key2", "value2");
		final FieldsItem i = new FieldsItemBuilder().
			media(new MediaBuilder().type("major/minor").build()).
			hash("hashValue").
			price(Price.storeOf(1234)).
			money(Money.storeOf(4567, GBP)).
			range(Range.valueOf(44, 55)).
			enumMap(enumMap).
			set(new HashSet<>(asList("setOne", "setTwo"))).
			list(asList("setOne", "setTwo")).
			map(map).
			build();
		assertEquals("major/minor", i.getMediaContentType());
		assertEquals(true, i.checkHash("hashValue"));
		assertEquals(Price.storeOf(1234), i.getPrice());
		assertEquals(Money.storeOf(4567, GBP), i.getMoney());
		assertEquals(Range.valueOf(44, 55), i.getRange());
		assertEquals("enumMapValueOne", i.getEnumMap(TestEnum.one));
		assertEquals("enumMapValueTwo", i.getEnumMap(TestEnum.two));
		assertEquals("enumMapValueThree", i.getEnumMap(TestEnum.three));
		assertEquals(new HashSet<>(asList("setOne", "setTwo")), i.getSet());
		assertEquals(asList("setOne", "setTwo"), i.getList());
		assertEquals(map, i.getMapMap());
	}

	@Test
	public void fallback()
	{
		final FieldsItem i = new FieldsItemBuilder().build();
		assertEquals("image/png", i.getMediaContentType());
		assertEquals(true, i.checkHash("fallbackHashValue"));
		assertEquals(Price.storeOf(7777777), i.getPrice());
		assertEquals(Money.storeOf(8888888, EUR), i.getMoney());
		assertEquals(Range.valueOf(7777777, 8888888), i.getRange());
		assertEquals("fallbackEnumMapValueOne", i.getEnumMap(TestEnum.one));
		assertEquals("fallbackEnumMapValueTwo", i.getEnumMap(TestEnum.two));
		assertEquals("fallbackEnumMapValueThree", i.getEnumMap(TestEnum.three));
		assertEquals(emptySet(), i.getSet());
		assertEquals(emptyList(), i.getList());
		assertEquals(emptyMap(), i.getMapMap());
	}

	@Test
	public void listSetPriceRangeShortcuts()
	{
		final FieldsItem i = new FieldsItemBuilder().
			price(1234).
			money(4567, GBP).
			range(44, 55).
			set("setOne", "setTwo").
			list("setOne", "setTwo").
			build();
		assertEquals(Price.storeOf(1234), i.getPrice());
		assertEquals(Money.storeOf(4567, GBP), i.getMoney());
		assertEquals(Range.valueOf(44, 55), i.getRange());
		assertEquals(new HashSet<>(asList("setOne", "setTwo")), i.getSet());
		assertEquals(asList("setOne", "setTwo"), i.getList());

		//fallbacks
		assertEquals("image/png", i.getMediaContentType());
		assertEquals(true, i.checkHash("fallbackHashValue"));
		assertEquals("fallbackEnumMapValueOne", i.getEnumMap(TestEnum.one));
		assertEquals("fallbackEnumMapValueTwo", i.getEnumMap(TestEnum.two));
		assertEquals("fallbackEnumMapValueThree", i.getEnumMap(TestEnum.three));
	}

	@Test
	public void doubleShortcuts()
	{
		final FieldsItem i = new FieldsItemBuilder().
			price(12.34).
			money(45.67, GBP).
			build();
		assertEquals(Price.storeOf(1234), i.getPrice());
		assertEquals(Money.storeOf(4567, GBP), i.getMoney());
	}
}
