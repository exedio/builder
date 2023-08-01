package com.exedio.cope.builder.generator.type;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.exedio.cope.builder.other.TestComposite;
import com.exedio.cope.builder.test.CompositeItem;
import com.exedio.cope.builder.test.MainTest;
import org.junit.jupiter.api.Test;

public class CompositeTypeTest extends MainTest
{
	@Test
	public void concrete()
	{
		final CompositeType type = new CompositeType(CompositeItem.field);
		assertEquals(TestComposite.class, type.getJavaClass());
		assertEquals(2, type.getDeclaredFeatures().size(), type.getDeclaredFeatures().toString());
		assertEquals("class", type.getTypeName());
		assertEquals("", type.getWildCards());
		assertEquals(false, type.enableTypePropagationConstructor());
		assertEquals(false, type.enableCommonBuilder());
		assertEquals("", type.getTypeCast());
		assertEquals("<B extends GeneratedTestCompositeBuilder<B>>", type.getGenericParams());
		assertEquals("com.exedio.cope.builder.CompositeBuilder<com.exedio.cope.builder.other.TestComposite, B>", type.getExtends());
	}
}