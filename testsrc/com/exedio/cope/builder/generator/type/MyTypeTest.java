package com.exedio.cope.builder.generator.type;

import static org.junit.Assert.assertEquals;

import com.exedio.cope.builder.test.MainTest;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import org.junit.Test;

public class MyTypeTest extends MainTest
{
	@Test
	public void typeParameterWildCards()
	{
		assertEquals("", MyType.typeParameterWildCards(Object.class));
		assertEquals("<?>", MyType.typeParameterWildCards(Consumer.class));
		assertEquals("<?,?>", MyType.typeParameterWildCards(Function.class));
		assertEquals("<?,?,?>", MyType.typeParameterWildCards(BiFunction.class));
	}
}