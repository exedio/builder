package com.exedio.cope.builder.test;

import static org.junit.Assert.assertEquals;

import com.exedio.cope.builder.other.ConcreteItem;
import com.exedio.cope.builder.other.ConcreteItemBuilder;
import com.exedio.cope.builder.test.GeneratedAbstractLevel1ItemBuilder.AbstractLevel1ItemBuilder;
import com.exedio.cope.builder.test.GeneratedMixedLevel2ItemBuilder.MixedLevel2ItemBuilder;
import java.lang.reflect.Modifier;
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
	@Test
	public void commonAbstract() throws NoSuchMethodException
	{
		Modifier.isPublic(MixedLevel2ItemBuilder.class.getDeclaredConstructor().getModifiers());
		Modifier.isPrivate(AbstractLevel1ItemBuilder.class.getDeclaredConstructor().getModifiers());
	}
}
