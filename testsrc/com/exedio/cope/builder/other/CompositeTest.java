package com.exedio.cope.builder.other;

import static org.junit.Assert.assertEquals;

import com.exedio.cope.builder.test.MainTest;
import org.junit.Test;

public class CompositeTest extends MainTest
{
	@Test
	public void mandatoryExplicit()
	{
		final TestComposite i = new TestCompositeBuilder().integerMandatory(88).build();
		assertEquals(88, i.getIntegerMandatory());
	}
	@Test
	public void mandatoryFallback()
	{
		final TestComposite i = new TestCompositeBuilder().build();
		assertEquals(777777, i.getIntegerMandatory());
	}
	@Test
	public void optionalExplicit()
	{
		final TestComposite i = new TestCompositeBuilder().integerOptional(88).build();
		assertEquals(Integer.valueOf(88), i.getIntegerOptional());
	}
	@Test
	public void optionalFallback()
	{
		final TestComposite i = new TestCompositeBuilder().build();
		assertEquals(null, i.getIntegerOptional());
	}
}
