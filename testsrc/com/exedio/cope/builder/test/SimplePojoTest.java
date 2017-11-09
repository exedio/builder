package com.exedio.cope.builder.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class SimplePojoTest
{
	@Test
	public void required()
	{
		try
		{
			new SimplePojoBuilder().build();
			fail("NullPointerException expected");
		}
		catch(final NullPointerException e)
		{
			assertEquals("integerMandatory is required", e.getMessage());
		}
	}

	@Test
	public void fallback()
	{
		SimplePojoBuilder.IntegerAutoBuilder.reset();
		final SimplePojo p = new SimplePojoBuilder().integerMandatory(20).build();
		assertEquals(20, p.getIntegerMandatory());
		assertEquals(77, p.getIntegerOptional());
		assertEquals(11, p.getIntegerAuto());
	}

	@Test
	public void builder()
	{
		SimplePojoBuilder.IntegerAutoBuilder.reset();
		SimplePojo p = new SimplePojoBuilder().integerMandatory(20).build();
		assertEquals(20, p.getIntegerMandatory());
		assertEquals(77, p.getIntegerOptional());
		assertEquals(11, p.getIntegerAuto());

		p = new SimplePojoBuilder().integerMandatory(20).build();
		assertEquals(20, p.getIntegerMandatory());
		assertEquals(77, p.getIntegerOptional());
		assertEquals(12, p.getIntegerAuto());
	}

	@Test
	public void explicit()
	{
		SimplePojoBuilder.IntegerAutoBuilder.reset();
		final SimplePojo p = new SimplePojoBuilder().integerMandatory(20).integerOptional(333).integerAuto(444).build();
		assertEquals(20, p.getIntegerMandatory());
		assertEquals(333, p.getIntegerOptional());
		assertEquals(444, p.getIntegerAuto());
	}
}
