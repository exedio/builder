package com.exedio.cope.builder.generator.type;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.exedio.cope.IntegerField;
import com.exedio.cope.Item;
import com.exedio.cope.ItemField;
import com.exedio.cope.LongField;
import com.exedio.cope.Sequence;
import com.exedio.cope.StringField;
import com.exedio.cope.builder.other.OuterClass.TestEnum;
import com.exedio.cope.builder.other.SubItem;
import com.exedio.cope.builder.test.MainTest;
import com.exedio.cope.misc.ReflectionTypes;
import com.exedio.cope.pattern.EnumMapField;
import com.exedio.cope.pattern.ListField;
import com.exedio.cope.pattern.MapField;
import com.exedio.cope.pattern.SetField;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import org.junit.jupiter.api.Test;

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
	public void valueType()
	{
		assertEquals("java.lang.String", TypeUtil.valueType(new StringField()));
		assertEquals("com.exedio.cope.builder.other.SubItem", TypeUtil.valueType(ItemField.create(SubItem.class)));
		assertEquals("int", TypeUtil.valueType(SubItem.TYPE.getFeature("subField")));
		final String pack = "com.exedio.cope.builder.generator.type.TypeUtilTest";
		assertEquals(pack + ".WithOneUnboundParam<?>", TypeUtil.valueType(ItemField.create(WithOneUnboundParam.class)));
		assertEquals(pack + ".WithOneMultiboundParam<?>", TypeUtil.valueType(ItemField.create(WithOneMultiboundParam.class)));
		assertEquals(pack + ".WithTwoParams<?,?>", TypeUtil.valueType(ItemField.create(WithTwoParams.class)));

		assertEquals("java.util.Set<java.lang.String>", TypeUtil.valueType(SetField.create(new StringField())));
		assertEquals("java.util.List<java.lang.String>", TypeUtil.valueType(ListField.create(new StringField())));
		assertEquals("java.util.Map<java.lang.String,java.lang.Integer>",
			TypeUtil.valueType(MapField.create(new StringField(), new IntegerField())));
	}

	@SuppressWarnings({"unused", "EmptyClass"})
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

	@Test
	public void fieldType()
	{
		assertAll(
			() -> assertEquals("com.exedio.cope.Settable<java.lang.String>",
				TypeUtil.fieldType(new StringField())),
			() -> assertEquals("com.exedio.cope.pattern.SetField<java.lang.String>",
				TypeUtil.fieldType(SetField.create(new StringField()))),
			() -> assertEquals("com.exedio.cope.pattern.ListField<java.lang.String>",
				TypeUtil.fieldType(ListField.create(new StringField()))),
			() -> assertEquals("com.exedio.cope.pattern.MapField<java.lang.String,java.lang.Long>",
				TypeUtil.fieldType(MapField.create(new StringField(), new LongField()))),
			() -> assertEquals("com.exedio.cope.pattern.EnumMapField<com.exedio.cope.builder.other.OuterClass.TestEnum,java.lang.String>",
				TypeUtil.fieldType(EnumMapField.create(TestEnum.class, new StringField()))),
			() -> assertEquals("Unhandled feature type: class com.exedio.cope.Sequence",
				assertThrows(UnsupportedOperationException.class, () -> TypeUtil.fieldType(new Sequence(0))).getMessage())
		);
	}
}