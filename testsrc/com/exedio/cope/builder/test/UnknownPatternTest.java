package com.exedio.cope.builder.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UnknownPatternTest extends MainTest
{
	@Test
	public void test()
	{
		final SimpleItem parent = new SimpleItemBuilder().build();
		final UnknownPatternItem i = new UnknownPatternItemBuilder().
				parent(parent).
				order(5).
				build();
		assertEquals(parent, i.getParent());
		assertEquals(5, i.getOrder());
	}
}
