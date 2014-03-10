package com.exedio.cope.builder.test;

import static org.junit.Assert.assertEquals;

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
		// TODO
	}
	@Test
	public void subFallback()
	{
		// TODO
	}
}
