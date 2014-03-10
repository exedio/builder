
package com.exedio.cope.builder.test;

import com.exedio.cope.builder.MediaBuilder;
import com.exedio.cope.pattern.Price;
import java.util.EnumMap;

public class FieldsItemBuilder extends GeneratedFieldsItemBuilder<FieldsItemBuilder>
{
	@Override
	public FieldsItem build()
	{
		fallback(FieldsItem.media, new MediaBuilder().build());
		fallback(FieldsItem.hash, "fallbackHashValue");
		fallback(FieldsItem.price, Price.storeOf(7777777));
		final EnumMap<TestEnum,String> enumMap = new EnumMap<TestEnum,String>(TestEnum.class);
		enumMap.put(TestEnum.one  , "fallbackEnumMapValueOne"  );
		enumMap.put(TestEnum.two  , "fallbackEnumMapValueTwo"  );
		enumMap.put(TestEnum.three, "fallbackEnumMapValueThree");
		fallback(FieldsItem.enumMap, enumMap);
		return super.build();
	}
}
