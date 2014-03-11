package com.exedio.cope.builder.test;

import static org.junit.Assert.assertEquals;

import com.exedio.cope.builder.other.TestCompositeBuilder;
import org.junit.Test;

public class CompositeFieldTest extends MainTest
{
	@Test
	public void explicit()
	{
		final CompositeItem i = new CompositeItemBuilder().
				field(new TestCompositeBuilder().integerMandatory(88).build()). // TODO support builder instead
				build();
		assertEquals(88, i.getField().getIntegerMandatory());
	}
	@Test
	public void fallback()
	{
		final CompositeItem i = new CompositeItemBuilder().build();
		assertEquals(777777, i.getField().getIntegerMandatory());
	}
}
