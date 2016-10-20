package com.exedio.cope.builder.test.genericComplex;

import static org.junit.Assert.assertEquals;

import com.exedio.cope.builder.test.MainTest;
import com.exedio.cope.builder.test.genericComplex.GeneratedGenMidBuilder.GenMidBuilder;
import com.exedio.cope.builder.test.genericComplex.GeneratedGenSupBuilder.GenSupBuilder;
import com.exedio.cope.pattern.Money;
import org.junit.Test;

public class GenericComplexTest extends MainTest
{
	@Test
	public void fallback()
	{
		final GenSource i = new GenSourceBuilder().build();
		assertEquals(null, i.getSup());
		assertEquals(null, i.getMid());
		assertEquals(null, i.getSub());
		assertEquals(null, i.getMoneySup());
		assertEquals(null, i.getMoneyMid());
		assertEquals(null, i.getMoneySub());
	}
	@Test
	public void set()
	{
		final GenSup<?,?> sup = new GenSupBuilder().build();
		final GenMid<?>   mid = new GenMidBuilder().build();
		final GenSub      sub = new GenSubBuilder().build();

		final GenSource i = new GenSourceBuilder().
				sup(sup).
				mid(mid).
				sub(sub).
				moneySup(Money.valueOf(1.1, sup)).
				moneyMid(Money.valueOf(1.2, mid)).
				moneySub(Money.valueOf(1.3, sub)).
				build();
		assertEquals(sup, i.getSup());
		assertEquals(mid, i.getMid());
		assertEquals(sub, i.getSub());
		assertEquals(Money.valueOf(1.1, sup), i.getMoneySup());
		assertEquals(Money.valueOf(1.2, mid), i.getMoneyMid());
		assertEquals(Money.valueOf(1.3, sub), i.getMoneySub());
	}
	@Test
	public void redirect()
	{
		final GenSup<?,?> sup = new GenSupBuilder().build();
		final GenMid<?>   mid = new GenMidBuilder().build();
		final GenSub      sub = new GenSubBuilder().build();

		final GenSource i = new GenSourceBuilder().
				moneySup(1.1, sup).
				moneyMid(1.2, mid).
				moneySub(1.3, sub).
				build();
		assertEquals(Money.valueOf(1.1, sup), i.getMoneySup());
		assertEquals(Money.valueOf(1.2, mid), i.getMoneyMid());
		assertEquals(Money.valueOf(1.3, sub), i.getMoneySub());
	}
	@Test
	public void redirect2()
	{
		final GenSup<?,?> sup = new GenSupBuilder().build();
		final GenMid<?>   mid = new GenMidBuilder().build();
		final GenSub      sub = new GenSubBuilder().build();

		final GenSource i = new GenSourceBuilder().
				moneySup(110, sup).
				moneyMid(120, mid).
				moneySub(130, sub).
				build();
		assertEquals(Money.valueOf(1.1, sup), i.getMoneySup());
		assertEquals(Money.valueOf(1.2, mid), i.getMoneyMid());
		assertEquals(Money.valueOf(1.3, sub), i.getMoneySub());
	}
}
