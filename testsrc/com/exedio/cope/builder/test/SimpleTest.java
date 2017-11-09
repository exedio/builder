package com.exedio.cope.builder.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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

	@Test
	public void integerGetOrBuild()
	{
		final SimpleItem i1 = new SimpleItemBuilder().integerMandatory(1).getOrBuild();
		assertEquals(1, i1.getIntegerMandatory());
		assertEquals(i1, new SimpleItemBuilder().integerMandatory(1).getOrBuild());
		final SimpleItem i2 = new SimpleItemBuilder().integerMandatory(2).getOrBuild();
		assertTrue(!i1.equals(i2));
		assertEquals(2, i2.getIntegerMandatory());
	}

	@Test
	public void enumGetOrBuild()
	{
		final SimpleItem i1 = new SimpleItemBuilder().enumField(TestEnum.one).getOrBuild();
		assertEquals(TestEnum.one, i1.getEnumField());
		assertEquals(i1, new SimpleItemBuilder().enumField(TestEnum.one).getOrBuild());
		final SimpleItem i2 = new SimpleItemBuilder().enumField(TestEnum.two).getOrBuild();
		assertTrue(!i1.equals(i2));
		assertEquals(TestEnum.two, i2.getEnumField());
	}

	@Test
	public void getOrBuildDuplicateFails()
	{
		new SimpleItemBuilder().integerMandatory(1).build();
		new SimpleItemBuilder().integerMandatory(1).build();
		try
		{
			new SimpleItemBuilder().integerMandatory(1).getOrBuild();
			fail();
		}
		catch(IllegalArgumentException e)
		{
			assertTrue(e.getMessage().startsWith("expected result of size one or less, but was "));
		}
	}
}
