package com.exedio.cope.builder.test;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

	@Test
	public void getOrBuild()
	{
		assertEquals(asList(), CompositeItem.TYPE.search());
		final CompositeItem i0 = new CompositeItemBuilder().field(new TestCompositeBuilder().integerMandatory(0).build()).getOrBuild();
		assertEquals(asList(i0), CompositeItem.TYPE.search());
		final CompositeItem i1 = new CompositeItemBuilder().field(new TestCompositeBuilder().integerMandatory(1).build()).getOrBuild();
		assertTrue(i0 != i1);
		assertEquals(asList(i0, i1), CompositeItem.TYPE.search());
	}

	@Test
	public void lambda()
	{
		final CompositeItem i = new CompositeItemBuilder().field(c -> c.integerMandatory(33)).build();
		assertEquals(33, i.getField().getIntegerMandatory());
	}

	@Test
	public void lambda2()
	{
		final CompositeItem i = new CompositeItemBuilder().
			field(c -> c.integerMandatory(33).integerOptional(44)).
			build();
		assertEquals(33, i.getField().getIntegerMandatory());
		assertEquals(Integer.valueOf(44), i.getField().getIntegerOptional());
	}

	@Test
	public void lambda3()
	{
		final CompositeItem i = new CompositeItemBuilder().
			field(c -> c.integerMandatory(33).integerMandatory(55)).
			build();
		assertEquals(55, i.getField().getIntegerMandatory());
	}

	@Test
	public void lambda4()
	{
		final CompositeItem i = new CompositeItemBuilder().
			field(c -> c.integerMandatory(33)).
			field(c -> c.integerMandatory(55)).
			build();
		assertEquals(55, i.getField().getIntegerMandatory());
	}

	@Test
	public void lambda5()
	{
		final CompositeItem i = new CompositeItemBuilder().
			field(c -> c.integerMandatory(33)).
			field(c -> c.integerOptional(55)).
			build();
		assertEquals(777777, i.getField().getIntegerMandatory());
		assertEquals(Integer.valueOf(55), i.getField().getIntegerOptional());
	}
}
