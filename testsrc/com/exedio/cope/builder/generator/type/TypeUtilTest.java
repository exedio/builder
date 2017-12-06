package com.exedio.cope.builder.generator.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.exedio.cope.IntegerField;
import com.exedio.cope.Item;
import com.exedio.cope.ItemField;
import com.exedio.cope.StringField;
import com.exedio.cope.builder.other.SubItem;
import com.exedio.cope.builder.test.MainTest;
import com.exedio.cope.misc.ReflectionTypes;
import com.exedio.cope.pattern.ListField;
import com.exedio.cope.pattern.MapField;
import com.exedio.cope.pattern.SetField;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import org.junit.Test;

public class TypeUtilTest extends MainTest
{
	@Test
	public void typeParameterWildCards()
	{
		assertEquals("", TypeUtil.typeParameterWildCards(Object.class));
		assertEquals("<?>", TypeUtil.typeParameterWildCards(Consumer.class));
		assertEquals("<?,?>", TypeUtil.typeParameterWildCards(Function.class));
		assertEquals("<?,?,?>", TypeUtil.typeParameterWildCards(BiFunction.class));
	}

	@Test
	public void getCanonicalName()
	{
		assertEquals("java.lang.Object", TypeUtil.getCanonicalName(Object.class));
		assertEquals("java.util.function.BiFunction<?,?,?>", TypeUtil.getCanonicalName(BiFunction.class));
		final ParameterizedType type = ReflectionTypes.parameterized(BiFunction.class, Object.class, Function.class, Consumer.class);
		assertEquals("java.util.function.BiFunction<java.lang.Object,java.util.function.Function<?,?>,java.util.function.Consumer<?>>",
			TypeUtil.getCanonicalName(type));
	}

	@SuppressWarnings("unused")
	private static class WithOneUnboundParam<X> extends Item
	{
		private static final long serialVersionUID = 1L;
	}

	@SuppressWarnings("unused")
	private static class WithOneMultiboundParam<X extends Number & Serializable> extends Item
	{
		private static final long serialVersionUID = 1L;
	}

	@SuppressWarnings("unused")
	private static class WithTwoParams<X extends Number, Y> extends Item
	{
		private static final long serialVersionUID = 1L;
	}

	@Test
	public void toSetterParameterType()
	{
		assertEquals("java.lang.String", TypeUtil.toSetterParameterType(new StringField()));
		assertEquals("com.exedio.cope.builder.other.SubItem", TypeUtil.toSetterParameterType(ItemField.create(SubItem.class)));
		assertEquals("int", TypeUtil.toSetterParameterType(SubItem.TYPE.getFeature("subField")));
		String pack = "com.exedio.cope.builder.generator.type.TypeUtilTest";
		assertEquals(pack + ".WithOneUnboundParam<?>", TypeUtil.toSetterParameterType(ItemField.create(WithOneUnboundParam.class)));
		assertEquals(pack + ".WithOneMultiboundParam<?>", TypeUtil.toSetterParameterType(ItemField.create(WithOneMultiboundParam.class)));
		assertEquals(pack + ".WithTwoParams<?,?>", TypeUtil.toSetterParameterType(ItemField.create(WithTwoParams.class)));

		assertEquals("java.util.Set<java.lang.String>", TypeUtil.toSetterParameterType(SetField.create(new StringField())));
		assertEquals("java.util.List<java.lang.String>", TypeUtil.toSetterParameterType(ListField.create(new StringField())));
		assertEquals("java.util.Map<java.lang.String,java.lang.Integer>",
			TypeUtil.toSetterParameterType(MapField.create(new StringField(), new IntegerField())));
	}

	@SuppressWarnings("unused")
	private static class PrivateClass<A, B>
	{

	}

	@Test
	public void isVisible() throws ClassNotFoundException
	{
		assertTrue(TypeUtil.isVisible("any", Object.class));

		final Class<?> packageProtected = Class.forName("com.exedio.cope.builder.test.genericComplex.GenSub");
		assertFalse(TypeUtil.isVisible("other", packageProtected));
		assertTrue(TypeUtil.isVisible("com.exedio.cope.builder.test.genericComplex", packageProtected));

		assertFalse(TypeUtil.isVisible("any", PrivateClass.class));

		assertTrue(TypeUtil.isVisible("any", ReflectionTypes.parameterized(Function.class, Object.class, Function.class)));
		assertFalse(TypeUtil.isVisible("any", ReflectionTypes.parameterized(Function.class, PrivateClass.class, Function.class)));
		assertFalse(TypeUtil.isVisible("any", ReflectionTypes.parameterized(Function.class, packageProtected, Function.class)));
		assertTrue(
			TypeUtil.isVisible("com.exedio.cope.builder.test.genericComplex", ReflectionTypes.parameterized(Function.class, packageProtected, Function.class)));
	}
}