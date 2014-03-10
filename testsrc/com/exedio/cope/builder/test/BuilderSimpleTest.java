package com.exedio.cope.builder.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BuilderSimpleTest extends MainTest
{
	@Test
	public void mandatoryExplicit()
	{
		final SimpleItem i = new SimpleItemBuilder().integerMandatory(88).build();
		assertEquals(88, i.getIntegerMandatory());
	}
	@Test
	public void mandatoryFallback()
	{
		final SimpleItem i = new SimpleItemBuilder().build();
		assertEquals(777777, i.getIntegerMandatory());
	}
	@Test
	public void optionalExplicit()
	{
		final SimpleItem i = new SimpleItemBuilder().integerOptional(88).build();
		assertEquals(Integer.valueOf(88), i.getIntegerOptional());
	}
	@Test
	public void optionalFallback()
	{
		final SimpleItem i = new SimpleItemBuilder().build();
		assertEquals(null, i.getIntegerOptional());
	}
}
