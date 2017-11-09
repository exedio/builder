package com.exedio.cope.builder.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import com.exedio.cope.builder.Builder;
import com.exedio.cope.builder.Builders;
import com.exedio.cope.builder.other.OuterClass.TestEnum;
import org.junit.Before;
import org.junit.Test;

public class AutoIncrementTest extends MainTest
{
	@Before
	public void resetBuilder()
	{
		Builders.reset();
	}

	@Test
	public void integer()
	{
		final Builder<Integer> b = Builders.autoIncrement(SimpleItem.integerMandatory, 7);
		assertEquals(Integer.valueOf(7), b.build());
		assertEquals(Integer.valueOf(8), b.build());
		assertEquals(Integer.valueOf(9), b.build());
		assertEquals(Integer.valueOf(10), b.build());
	}

	@Test
	public void string()
	{
		final Builder<String> b = Builders.autoIncrement(SimpleItem.stringOptional, "foo-%d", 29);
		assertEquals("foo-29", b.build());
		assertEquals("foo-30", b.build());
		assertEquals("foo-31", b.build());
		assertEquals("foo-32", b.build());
	}

	@Test
	public void enumRotate()
	{
		final Builder<TestEnum> b = Builders.autoIncrement(SimpleItem.enumField, TestEnum.one, true);
		assertEquals(TestEnum.one, b.build());
		assertEquals(TestEnum.two, b.build());
		assertEquals(TestEnum.three, b.build());
		assertEquals(TestEnum.one, b.build());
	}

	@Test
	public void enumNoRotate()
	{
		final Builder<TestEnum> b = Builders.autoIncrement(SimpleItem.enumField, TestEnum.one, false);
		assertEquals(TestEnum.one, b.build());
		assertEquals(TestEnum.two, b.build());
		assertEquals(TestEnum.three, b.build());
		try
		{
			assertEquals(TestEnum.one, b.build());
			fail("Exception expected");
		}
		catch(final IllegalStateException e)
		{
			assertEquals("Run out of values while incrementing " + TestEnum.class, e.getMessage());
		}
	}

	@Test
	public void shared()
	{
		Builder<Integer> b = Builders.autoIncrement(SimpleItem.integerMandatory, 15);
		assertEquals(Integer.valueOf(15), b.build());
		assertEquals(Integer.valueOf(16), b.build());
		b = Builders.autoIncrement(SimpleItem.integerMandatory, 99);
		assertEquals(Integer.valueOf(17), b.build());
		assertEquals(Integer.valueOf(18), b.build());
	}

	@Test
	public void enumToString()
	{
		final Builder<String> b = Builders.enumToStringBuilder(Builders.autoIncrement(SimpleItem.enumField, TestEnum.one, false));
		assertEquals("one", b.build());
		assertEquals("two", b.build());
	}
}
