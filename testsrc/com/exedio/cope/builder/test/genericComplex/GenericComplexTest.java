package com.exedio.cope.builder.test.genericComplex;

import static java.util.Collections.emptyList;
import static java.util.Collections.emptyMap;
import static java.util.Collections.emptySet;
import static java.util.Collections.singleton;
import static java.util.Collections.singletonList;
import static java.util.Collections.singletonMap;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import com.exedio.cope.builder.test.MainTest;
import com.exedio.cope.builder.test.genericComplex.GeneratedGenMidBuilder.GenMidBuilder;
import com.exedio.cope.builder.test.genericComplex.GeneratedGenSupBuilder.GenSupBuilder;
import com.exedio.cope.pattern.Money;
import java.util.function.Function;
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
		assertNotNull(i.getSubFallback());
		assertEquals(null, i.getMoneySup());
		assertEquals(null, i.getMoneyMid());
		assertEquals(null, i.getMoneySub());
		assertEquals(emptySet(), i.getSetSup());
		assertEquals(emptySet(), i.getSetMid());
		assertEquals(emptySet(), i.getSetSub());
		assertEquals(emptyList(), i.getListSup());
		assertEquals(emptyList(), i.getListMid());
		assertEquals(emptyList(), i.getListSub());
		assertEquals(emptyMap(), i.getMapSupMap());
		assertEquals(emptyMap(), i.getMapMidMap());
		assertEquals(emptyMap(), i.getMapSubMap());
	}

	@Test
	public void set()
	{
		final GenSup<?, ?> sup = new GenSupBuilder().build();
		final GenMid<?> mid = new GenMidBuilder().build();
		final GenSub sub = new GenSubBuilder().build();

		final GenSource i = new GenSourceBuilder().
			sup(sup).
			mid(mid).
			sub(sub).
			moneySup(Money.valueOf(1.1, sup)).
			moneyMid(Money.valueOf(1.2, mid)).
			moneySub(Money.valueOf(1.3, sub)).
			setSup(singleton(sup)).
			setMid(singleton(mid)).
			setSub(singleton(sub)).
			listSup(singletonList(sup)).
			listMid(singletonList(mid)).
			listSub(singletonList(sub)).
			mapSup(singletonMap(sup, sup)).
			mapMid(singletonMap(mid, mid)).
			mapSub(singletonMap(sub, sub)).
			build();
		assertEquals(sup, i.getSup());
		assertEquals(mid, i.getMid());
		assertEquals(sub, i.getSub());
		assertEquals(Money.valueOf(1.1, sup), i.getMoneySup());
		assertEquals(Money.valueOf(1.2, mid), i.getMoneyMid());
		assertEquals(Money.valueOf(1.3, sub), i.getMoneySub());
		assertEquals(singleton(sup), i.getSetSup());
		assertEquals(singleton(mid), i.getSetMid());
		assertEquals(singleton(sub), i.getSetSub());
		assertEquals(singletonList(sup), i.getListSup());
		assertEquals(singletonList(mid), i.getListMid());
		assertEquals(singletonList(sub), i.getListSub());
		assertEquals(singletonMap(sup, sup), i.getMapSupMap());
		assertEquals(singletonMap(mid, mid), i.getMapMidMap());
		assertEquals(singletonMap(sub, sub), i.getMapSubMap());
	}

	@Test
	public void setNull() throws NoSuchMethodException
	{
		assertNull(new GenSourceBuilder().subFallbackNull().build().getSubFallback());
		assertNotNull(new GenSourceBuilder().build().getSubFallback());

		assertNotNull(GenSourceBuilder.class.getMethod("subMandatory", GenSub.class));
		try
		{
			GenSourceBuilder.class.getMethod("subMandatoryNull");
			fail("Null-Setter generated for mandatory");
		}
		catch(final NoSuchMethodException e)
		{
			assertEquals("com.exedio.cope.builder.test.genericComplex.GenSourceBuilder.subMandatoryNull()", e.getMessage());
		}
	}

	@Test
	public void setLambda() throws NoSuchMethodException
	{
		assertNotNull(new GenSourceBuilder().sub(s -> s).build().getSubFallback());
		assertNotNull(GenSourceBuilder.class.getMethod("sub", Function.class));
		try
		{
			GenSourceBuilder.class.getMethod("midNull");
			fail("Lambda-Setter generated for inherited");
		}
		catch(final NoSuchMethodException e)
		{
			assertEquals("com.exedio.cope.builder.test.genericComplex.GenSourceBuilder.midNull()", e.getMessage());
		}

		try
		{
			GenSourceBuilder.class.getMethod("mid", Function.class);
			fail("Null-Setter generated for inherited");
		}
		catch(final NoSuchMethodException e)
		{
			assertEquals("com.exedio.cope.builder.test.genericComplex.GenSourceBuilder.mid(java.util.function.Function)", e.getMessage());
		}
	}

	@Test
	public void redirect()
	{
		final GenSup<?, ?> sup = new GenSupBuilder().build();
		final GenMid<?> mid = new GenMidBuilder().build();
		final GenSub sub = new GenSubBuilder().build();

		final GenSource i = new GenSourceBuilder().
			moneySup(1.1, sup).
			moneyMid(1.2, mid).
			moneySub(1.3, sub).
			setSup(sup).
			setMid(mid).
			setSub(sub).
			listSup(sup).
			listMid(mid).
			listSub(sub).
			build();
		assertEquals(Money.valueOf(1.1, sup), i.getMoneySup());
		assertEquals(Money.valueOf(1.2, mid), i.getMoneyMid());
		assertEquals(Money.valueOf(1.3, sub), i.getMoneySub());
		assertEquals(singleton(sup), i.getSetSup());
		assertEquals(singleton(mid), i.getSetMid());
		assertEquals(singleton(sub), i.getSetSub());
		assertEquals(singletonList(sup), i.getListSup());
		assertEquals(singletonList(mid), i.getListMid());
		assertEquals(singletonList(sub), i.getListSub());
	}

	@Test
	public void redirect2()
	{
		final GenSup<?, ?> sup = new GenSupBuilder().build();
		final GenMid<?> mid = new GenMidBuilder().build();
		final GenSub sub = new GenSubBuilder().build();

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
