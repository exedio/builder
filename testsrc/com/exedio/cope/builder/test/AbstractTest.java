package com.exedio.cope.builder.test;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.exedio.cope.builder.other.ConcreteItem;
import com.exedio.cope.builder.other.ConcreteItemBuilder;
import com.exedio.cope.builder.test.GeneratedMixedLevel2ItemBuilder.MixedLevel2ItemBuilder;
import java.lang.reflect.Modifier;
import org.junit.jupiter.api.Test;

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

	@Test
	public void commonAbstract() throws NoSuchMethodException
	{
		assertTrue(Modifier.isPublic(MixedLevel2ItemBuilder.class.getDeclaredConstructor().getModifiers()));
		assertEquals(asList(), asList(GeneratedAbstractLevel1ItemBuilder.class.getDeclaredClasses()));
	}

	@Test
	public void typeFieldExplicit()
	{
		final ConcreteItem i = new ConcreteItemBuilder().
			typeField(AbstractItem.TYPE).
			build();
		assertEquals(AbstractItem.TYPE, i.getTypeField());
	}

	@Test
	public void typeFieldFallback()
	{
		final ConcreteItem i = new ConcreteItemBuilder().
			build();
		assertEquals(null, i.getTypeField());
	}
}
