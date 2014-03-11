package com.exedio.cope.builder.test;

import static org.junit.Assert.assertEquals;

import com.exedio.cope.builder.other.ConcreteItem;
import com.exedio.cope.builder.other.ConcreteItemBuilder;
import org.junit.Test;

public class AbstractTest extends MainTest
{
	@Test
	public void superExplicit()
	{
		final ConcreteItem i = new ConcreteItemBuilder().
				abstractField(77).
				concreteField(88).
				build();
		assertEquals(77, i.getAbstractField());
		assertEquals(88, i.getConcreteField());
	}
	@Test
	public void superFallback()
	{
		final ConcreteItem i = new ConcreteItemBuilder().build();
		assertEquals(777777, i.getAbstractField());
		assertEquals(888888, i.getConcreteField());
	}
}
