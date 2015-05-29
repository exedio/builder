package com.exedio.cope.builder.test;

import static org.junit.Assert.assertEquals;

import com.exedio.cope.builder.other.OuterClass.TestEnum;
import org.junit.Test;

public class SimpleTest extends MainTest
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
	@Test
	public void enumExplicit()
	{
		final SimpleItem i = new SimpleItemBuilder().enumField(TestEnum.two).build();
		assertEquals(TestEnum.two, i.getEnumField());
	}
	@Test
	public void enumFallback()
	{
		final SimpleItem i = new SimpleItemBuilder().build();
		assertEquals(TestEnum.one, i.getEnumField());
	}
}
