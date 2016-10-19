package com.exedio.cope.builder.test.packagePrivate;

import static org.junit.Assert.assertEquals;

import com.exedio.cope.builder.test.MainTest;
import com.exedio.cope.pattern.Money;
import com.exedio.cope.pattern.Range;
import org.junit.Test;

public class PackagePrivateTest extends MainTest
{
	@Test
	public void item()
	{
		final MyItem itemValue = new MyItemBuilder().build();
		final MyComposite compositeValue = new MyCompositeBuilder().build();

		final MyItem built = new MyItemBuilder().
				enumF(MyEnum.TWO).
				item(itemValue).
				composite(compositeValue).
				rangeEnum(Range.valueOf(MyEnum.ONE, MyEnum.TWO)).
				moneyEnum(Money.valueOf(1.3, MyEnum.ONE)).
				moneyItem(Money.valueOf(1.4, itemValue)).
				build();
		assertEquals(MyEnum.TWO, built.getEnumF());
		assertEquals(itemValue, built.getItem());
		assertEquals(compositeValue, built.getComposite());
		assertEquals(Range.valueOf(MyEnum.ONE, MyEnum.TWO), built.getRangeEnum());
		assertEquals(Money.valueOf(1.3, MyEnum.ONE), built.getMoneyEnum());
		assertEquals(Money.valueOf(1.4, itemValue), built.getMoneyItem());
	}
	@Test
	public void composite()
	{
		final MyItem itemValue = new MyItemBuilder().build();

		final MyComposite built = new MyCompositeBuilder().
				enumF(MyEnum.TWO).
				item(itemValue).
				build();
		assertEquals(MyEnum.TWO, built.getEnumF());
		assertEquals(itemValue, built.getItem());
	}
}
