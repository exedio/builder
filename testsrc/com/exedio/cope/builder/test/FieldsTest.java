package com.exedio.cope.builder.test;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.emptyMap;
import static java.util.Collections.emptySet;
import static org.junit.Assert.assertEquals;

import com.exedio.cope.builder.MediaBuilder;
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
		final EnumMap<TestEnum,String> enumMap = new EnumMap<TestEnum,String>(TestEnum.class);
		enumMap.put(TestEnum.one  , "enumMapValueOne"  );
		enumMap.put(TestEnum.two  , "enumMapValueTwo"  );
		enumMap.put(TestEnum.three, "enumMapValueThree");
		final HashMap<String, String> map = new HashMap<String, String>();
		map.put("key1", "value1");
		map.put("key2", "value2");
		final FieldsItem i = new FieldsItemBuilder().
				media(new MediaBuilder().type("major/minor").build()).
				hash("hashValue").
				price(Price.storeOf(1234)).
				range(Range.valueOf(44, 55)).
				enumMap(enumMap).
				set(new HashSet<String>(asList("setOne, setTwo"))).
				list(asList("setOne, setTwo")).
				map(map).
				build();
		assertEquals("major/minor", i.getMediaContentType());
		assertEquals(true, i.checkHash("hashValue"));
		assertEquals(Price.storeOf(1234), i.getPrice());
		assertEquals(Range.valueOf(44, 55), i.getRange());
		assertEquals("enumMapValueOne"  , i.getEnumMap(TestEnum.one));
		assertEquals("enumMapValueTwo"  , i.getEnumMap(TestEnum.two));
		assertEquals("enumMapValueThree", i.getEnumMap(TestEnum.three));
		assertEquals(new HashSet<String>(asList("setOne, setTwo")), i.getSet());
		assertEquals(asList("setOne, setTwo"), i.getList());
		assertEquals(map, i.getMapMap());
	}
	@Test
	public void fallback()
	{
		final FieldsItem i = new FieldsItemBuilder().build();
		assertEquals("image/png", i.getMediaContentType());
		assertEquals(true, i.checkHash("fallbackHashValue"));
		assertEquals(Price.storeOf(7777777), i.getPrice());
		assertEquals(Range.valueOf(7777777, 8888888), i.getRange());
		assertEquals("fallbackEnumMapValueOne"  , i.getEnumMap(TestEnum.one));
		assertEquals("fallbackEnumMapValueTwo"  , i.getEnumMap(TestEnum.two));
		assertEquals("fallbackEnumMapValueThree", i.getEnumMap(TestEnum.three));
		assertEquals(emptySet (), i.getSet());
		assertEquals(emptyList(), i.getList());
		assertEquals(emptyMap (), i.getMapMap());
	}
}