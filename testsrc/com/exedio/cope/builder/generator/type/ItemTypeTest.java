package com.exedio.cope.builder.generator.type;

import static org.junit.Assert.assertEquals;

import com.exedio.cope.builder.other.ConcreteItem;
import com.exedio.cope.builder.test.AbstractItem;
import com.exedio.cope.builder.test.MainTest;
import com.exedio.cope.builder.test.genericComplex.GenMid;
import org.junit.Test;

public class ItemTypeTest extends MainTest
{
	@Test
	public void concrete()
	{
		final ItemType type = new ItemType(ConcreteItem.TYPE);
		assertEquals(ConcreteItem.class, type.getJavaClass());
		assertEquals(type.getDeclaredFeatures().toString(), 4, type.getDeclaredFeatures().size());
		assertEquals("TYPE", type.getTypeName());
		assertEquals("", type.getWildCards());
		assertEquals(false, type.enableTypePropagationConstructor());
		assertEquals(false, type.enableCommonBuilder());
		assertEquals("", type.getTypeCast());
		assertEquals("<B extends GeneratedConcreteItemBuilder<B>>", type.getGenericParams());
		assertEquals("com.exedio.cope.builder.test.CommonAbstractItemBuilder<com.exedio.cope.builder.other.ConcreteItem, B>", type.getExtends());
	}

	@Test
	public void abstract_()
	{
		final ItemType type = new ItemType(AbstractItem.TYPE);
		assertEquals(AbstractItem.class, type.getJavaClass());
		assertEquals(type.getDeclaredFeatures().toString(), 2, type.getDeclaredFeatures().size());
		assertEquals("TYPE", type.getTypeName());
		assertEquals("", type.getWildCards());
		assertEquals(true, type.enableTypePropagationConstructor());
		assertEquals(true, type.enableCommonBuilder());
		assertEquals("(com.exedio.cope.Type<I>)", type.getTypeCast());
		assertEquals("<I extends AbstractItem, B extends GeneratedAbstractItemBuilder <I,B>>", type.getGenericParams());
		assertEquals("com.exedio.cope.builder.ItemBuilder<I, B>", type.getExtends());
	}

	@Test
	public void genMid()
	{
		final ItemType type = new ItemType(GenMid.TYPE);
		assertEquals(GenMid.class, type.getJavaClass());
		assertEquals(type.getDeclaredFeatures().toString(), 1, type.getDeclaredFeatures().size());
		assertEquals("TYPE", type.getTypeName());
		assertEquals("<?>", type.getWildCards());
		assertEquals(true, type.enableTypePropagationConstructor());
		assertEquals(true, type.enableCommonBuilder());
		assertEquals("(com.exedio.cope.Type<I>)", type.getTypeCast());
		assertEquals("<I extends GenMid<?>, B extends GeneratedGenMidBuilder <I,B>>", type.getGenericParams());
		assertEquals("com.exedio.cope.builder.test.genericComplex.CommonGenSupBuilder<I, B>", type.getExtends());
	}
}