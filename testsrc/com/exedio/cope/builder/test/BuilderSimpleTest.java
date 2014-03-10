package com.exedio.cope.builder.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BuilderSimpleTest extends MainTest
{
	@Test
	public void simple()
	{
		final SimpleItem i = new SimpleItemBuilder().integer(88).build();
		assertEquals(88, i.getInteger());
	}
}
