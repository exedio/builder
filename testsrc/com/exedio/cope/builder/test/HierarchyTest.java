package com.exedio.cope.builder.test;

import static org.junit.Assert.assertEquals;

import com.exedio.cope.builder.other.SubItem;
import com.exedio.cope.builder.other.SubItemBuilder;
import com.exedio.cope.builder.test.GeneratedSuperItemBuilder.SuperItemBuilder;
import org.junit.Test;

public class HierarchyTest extends MainTest
{
	@Test
	public void superExplicit()
	{
		final SuperItem i = new SuperItemBuilder().superField(88).build();
		assertEquals(88, i.getSuperField());
	}

	@Test
	public void superFallback()
	{
		final SuperItem i = new SuperItemBuilder().build();
		assertEquals(888888, i.getSuperField());
	}

	@Test
	public void subExplicit()
	{
		final SubItem i = new SubItemBuilder().superField(88).subField(77).build();
		assertEquals(88, i.getSuperField());
		assertEquals(77, i.getSubField());
	}

	@Test
	public void subFallback()
	{
		final SubItem i = new SubItemBuilder().build();
		assertEquals(888888, i.getSuperField());
		assertEquals(777777, i.getSubField());
	}
}
