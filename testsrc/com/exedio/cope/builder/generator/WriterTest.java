package com.exedio.cope.builder.generator;

import static org.junit.Assert.assertEquals;

import com.exedio.cope.Item;
import com.exedio.cope.ItemField;
import com.exedio.cope.StringField;
import com.exedio.cope.builder.other.SubItem;
import java.io.Serializable;
import org.junit.Test;

public class WriterTest
{
	static class WithOneUnboundParam<X> extends Item
	{
		private static final long serialVersionUID = 1L;
	}

	static class WithOneBoundParam<X extends Number> extends Item
	{
		private static final long serialVersionUID = 1L;
	}

	static class WithOneMultiboundParam<X extends Number & Serializable> extends Item
	{
		private static final long serialVersionUID = 1L;
	}

	static class WithTwoParams<X extends Number, Y> extends Item
	{
		private static final long serialVersionUID = 1L;
	}

	@Test
	public void testToSetterParameterType()
	{
		assertEquals("java.lang.String", Writer.toSetterParameterType(new StringField()));
		assertEquals("com.exedio.cope.builder.other.SubItem", Writer.toSetterParameterType(ItemField.create(SubItem.class)));
		assertEquals("int", Writer.toSetterParameterType(SubItem.TYPE.getFeature("subField")));
		assertEquals(
			"com.exedio.cope.builder.generator.WriterTest.WithOneUnboundParam<?>",
			Writer.toSetterParameterType(ItemField.create(WithOneUnboundParam.class))
		);
		assertEquals(
			"com.exedio.cope.builder.generator.WriterTest.WithOneMultiboundParam<?>",
			Writer.toSetterParameterType(ItemField.create(WithOneMultiboundParam.class))
		);
		assertEquals(
			"com.exedio.cope.builder.generator.WriterTest.WithTwoParams<?,?>",
			Writer.toSetterParameterType(ItemField.create(WithTwoParams.class))
		);
	}
}