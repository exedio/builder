package com.exedio.cope.builder.generator.type;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.exedio.cope.EnumField;
import com.exedio.cope.IntegerField;
import com.exedio.cope.Item;
import com.exedio.cope.ItemField;
import com.exedio.cope.LongField;
import com.exedio.cope.Sequence;
import com.exedio.cope.StringField;
import com.exedio.cope.builder.generator.type.DummyMapFeature.CustomMap;
import com.exedio.cope.builder.generator.type.DummyMapFeature.CustomMapK;
import com.exedio.cope.builder.generator.type.DummyMapFeature.CustomMapKV;
import com.exedio.cope.builder.generator.type.DummyMapFeature.CustomMapKVZ;
import com.exedio.cope.builder.generator.type.DummyMapFeature.CustomMapV;
import com.exedio.cope.builder.generator.type.DummyMapFeature.CustomMapX;
import com.exedio.cope.builder.generator.type.DummyMapFeature.CustomMapXY;
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

	@Test
	public void getCanonicalName_annotation()
	{
		final String typeUse = "org.jspecify.annotations.Nullable";
		assertEquals("java.lang.@org.jspecify.annotations.Nullable Object", TypeUtil.getCanonicalName(Object.class, typeUse));
		assertEquals("java.util.function.@org.jspecify.annotations.Nullable BiFunction<?,?,?>", TypeUtil.getCanonicalName(BiFunction.class, typeUse));
		final ParameterizedType type = ReflectionTypes.parameterized(BiFunction.class, Object.class, Function.class, Consumer.class);
		assertEquals("java.util.function.@org.jspecify.annotations.Nullable BiFunction<java.lang.Object,java.util.function.Function<?,?>,java.util.function.Consumer<?>>",
			TypeUtil.getCanonicalName(type, typeUse)); //TODO add custom type system if nested annotations are needed
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

	@SuppressWarnings("ConstantValue")
	@Test
	public void valueType()
	{
		final String nullableAnnotation = null;
		assertEquals("java.lang.String", TypeUtil.valueType(new StringField(), nullableAnnotation));
		assertEquals("com.exedio.cope.builder.other.SubItem", TypeUtil.valueType(ItemField.create(SubItem.class), nullableAnnotation));
		assertEquals("int", TypeUtil.valueType(new IntegerField(), nullableAnnotation));
		final String pack = "com.exedio.cope.builder.generator.type.TypeUtilTest";
		assertEquals(pack + ".WithOneUnboundParam<?>", TypeUtil.valueType(ItemField.create(WithOneUnboundParam.class), nullableAnnotation));
		assertEquals(pack + ".WithOneMultiboundParam<?>", TypeUtil.valueType(ItemField.create(WithOneMultiboundParam.class), nullableAnnotation));
		assertEquals(pack + ".WithTwoParams<?,?>", TypeUtil.valueType(ItemField.create(WithTwoParams.class), nullableAnnotation));

		assertEquals("java.util.Set<java.lang.String>", TypeUtil.valueType(SetField.create(new StringField()), nullableAnnotation));
		assertEquals("java.util.List<java.lang.String>", TypeUtil.valueType(ListField.create(new StringField()), nullableAnnotation));
		assertEquals("java.util.Map<java.lang.String,java.lang.Integer>",
			TypeUtil.valueType(MapField.create(new StringField(), new IntegerField()), nullableAnnotation));
	}

	@Test
	public void valueType_withAnnotation()
	{
		final String nullableAnnotation = "org.jspecify.annotations.Nullable";
		assertEquals("java.lang.String", TypeUtil.valueType(new StringField(), nullableAnnotation));
		assertEquals("com.exedio.cope.builder.other.SubItem", TypeUtil.valueType(ItemField.create(SubItem.class), nullableAnnotation));
		assertEquals("int", TypeUtil.valueType(new IntegerField(), nullableAnnotation));
		final String pack = "com.exedio.cope.builder.generator.type.TypeUtilTest";
		assertEquals(pack + ".WithOneUnboundParam<?>", TypeUtil.valueType(ItemField.create(WithOneUnboundParam.class), nullableAnnotation));
		assertEquals(pack + ".WithOneMultiboundParam<?>", TypeUtil.valueType(ItemField.create(WithOneMultiboundParam.class), nullableAnnotation));
		assertEquals(pack + ".WithTwoParams<?,?>", TypeUtil.valueType(ItemField.create(WithTwoParams.class), nullableAnnotation));

		assertEquals("java.util.Set<java.lang.String>", TypeUtil.valueType(SetField.create(new StringField()), nullableAnnotation));
		assertEquals("java.util.List<java.lang.String>", TypeUtil.valueType(ListField.create(new StringField()), nullableAnnotation));
		assertEquals("java.util.Map<java.lang.String,java.lang.Integer>",
			TypeUtil.valueType(MapField.create(new StringField(), new IntegerField()), nullableAnnotation));
	}

	@Test
	public void valueType_withAnnotation_optional()
	{
		final String nullableAnnotation = "org.jspecify.annotations.Nullable";
		assertEquals("java.lang.@org.jspecify.annotations.Nullable String", TypeUtil.valueType(new StringField().optional(), nullableAnnotation));
		assertEquals("com.exedio.cope.builder.other.@org.jspecify.annotations.Nullable SubItem", TypeUtil.valueType(ItemField.create(SubItem.class).optional(), nullableAnnotation));
		assertEquals("java.lang.@org.jspecify.annotations.Nullable Integer", TypeUtil.valueType(new IntegerField().optional(), nullableAnnotation));
		final String pack = "com.exedio.cope.builder.generator.type.TypeUtilTest";
		assertEquals(pack + ".@org.jspecify.annotations.Nullable WithOneUnboundParam<?>", TypeUtil.valueType(ItemField.create(WithOneUnboundParam.class).optional(), nullableAnnotation));
		assertEquals(pack + ".@org.jspecify.annotations.Nullable WithOneMultiboundParam<?>", TypeUtil.valueType(ItemField.create(WithOneMultiboundParam.class).optional(), nullableAnnotation));
		assertEquals(pack + ".@org.jspecify.annotations.Nullable WithTwoParams<?,?>", TypeUtil.valueType(ItemField.create(WithTwoParams.class).optional(), nullableAnnotation));

		//always mandatory
		assertEquals("java.util.Set<java.lang.String>", TypeUtil.valueType(SetField.create(new StringField()), nullableAnnotation));
		assertEquals("java.util.List<java.lang.@org.jspecify.annotations.Nullable String>", TypeUtil.valueType(ListField.create(new StringField().optional()), nullableAnnotation));
		//always mandatory
		assertEquals("java.util.Map<java.lang.String,java.lang.Integer>",
			TypeUtil.valueType(MapField.create(new StringField(), new IntegerField()), nullableAnnotation));
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

	@SuppressWarnings("ConstantValue")
	@Test
	public void fieldType()
	{
		final String nullableAnnotation = null;
		assertAll(
			() -> assertEquals("com.exedio.cope.Settable<java.lang.String>",
				TypeUtil.fieldType(new StringField(), nullableAnnotation)),
			() -> assertEquals("com.exedio.cope.pattern.SetField<java.lang.String>",
				TypeUtil.fieldType(SetField.create(new StringField()), nullableAnnotation)),
			() -> assertEquals("com.exedio.cope.pattern.ListField<java.lang.String>",
				TypeUtil.fieldType(ListField.create(new StringField()), nullableAnnotation)),
			() -> assertEquals("com.exedio.cope.pattern.MapField<java.lang.String,java.lang.Long>",
				TypeUtil.fieldType(MapField.create(new StringField(), new LongField()), nullableAnnotation)),
			() -> assertEquals("com.exedio.cope.pattern.EnumMapField<com.exedio.cope.builder.other.OuterClass.TestEnum,java.lang.String>",
				TypeUtil.fieldType(EnumMapField.create(TestEnum.class, new StringField()), nullableAnnotation)),
			() -> assertEquals("Unhandled feature type: com.exedio.cope.Sequence",
				assertThrows(UnsupportedOperationException.class, () -> TypeUtil.fieldType(new Sequence(0), nullableAnnotation)).getMessage()),

			() -> assertEquals("com.exedio.cope.builder.generator.type.DummyMapFeature.CustomMapK<java.lang.String>",
				TypeUtil.fieldType(new CustomMapK<>(String.class), nullableAnnotation)),
			() -> assertEquals("com.exedio.cope.builder.generator.type.DummyMapFeature.CustomMapV<java.lang.Long>",
				TypeUtil.fieldType(new CustomMapV<>(Long.class), nullableAnnotation)),
			() -> assertEquals("com.exedio.cope.builder.generator.type.DummyMapFeature.CustomMapKV<java.lang.String,java.lang.Long>",
				TypeUtil.fieldType(new CustomMapKV<>(String.class, Long.class), nullableAnnotation)),
			() -> assertEquals("com.exedio.cope.builder.generator.type.DummyMapFeature.CustomMapXY<java.lang.String,java.lang.Long>",
				TypeUtil.fieldType(new CustomMapXY<>(String.class, Long.class), nullableAnnotation)),
			() -> assertEquals("com.exedio.cope.builder.generator.type.DummyMapFeature.CustomMap", TypeUtil.fieldType(new CustomMap(), nullableAnnotation)),
			() -> assertEquals("Unhandled feature type: com.exedio.cope.builder.generator.type.DummyMapFeature.CustomMapX<X>", assertThrows(UnsupportedOperationException.class,
				() -> TypeUtil.fieldType(new CustomMapX<>(String.class), nullableAnnotation)).getMessage()),
			() -> assertEquals("Unhandled feature type: com.exedio.cope.builder.generator.type.DummyMapFeature.CustomMapKVZ<K,V,Z>", assertThrows(UnsupportedOperationException.class,
				() -> TypeUtil.fieldType(new CustomMapKVZ<>(String.class, Long.class), nullableAnnotation)).getMessage())
		);
	}

	@Test
	public void fieldType_withAnnotation()
	{
		final String nullableAnnotation = "org.jspecify.annotations.Nullable";
		assertAll(
			() -> assertEquals("com.exedio.cope.Settable<java.lang.String>",
				TypeUtil.fieldType(new StringField(), nullableAnnotation)),
			() -> assertEquals("com.exedio.cope.pattern.SetField<java.lang.String>",
				TypeUtil.fieldType(SetField.create(new StringField()), nullableAnnotation)),
			() -> assertEquals("com.exedio.cope.pattern.ListField<java.lang.String>",
				TypeUtil.fieldType(ListField.create(new StringField()), nullableAnnotation)),
			() -> assertEquals("com.exedio.cope.pattern.MapField<java.lang.String,java.lang.Long>",
				TypeUtil.fieldType(MapField.create(new StringField(), new LongField()), nullableAnnotation)),
			() -> assertEquals("com.exedio.cope.pattern.EnumMapField<com.exedio.cope.builder.other.OuterClass.TestEnum,java.lang.String>",
				TypeUtil.fieldType(EnumMapField.create(TestEnum.class, new StringField()), nullableAnnotation)),
			() -> assertEquals("Unhandled feature type: com.exedio.cope.Sequence",
				assertThrows(UnsupportedOperationException.class, () -> TypeUtil.fieldType(new Sequence(0), nullableAnnotation)).getMessage()),

			() -> assertEquals("com.exedio.cope.builder.generator.type.DummyMapFeature.CustomMapK<java.lang.String>",
				TypeUtil.fieldType(new CustomMapK<>(String.class), nullableAnnotation)),
			() -> assertEquals("com.exedio.cope.builder.generator.type.DummyMapFeature.CustomMapV<java.lang.Long>",
				TypeUtil.fieldType(new CustomMapV<>(Long.class), nullableAnnotation)),
			() -> assertEquals("com.exedio.cope.builder.generator.type.DummyMapFeature.CustomMapKV<java.lang.String,java.lang.Long>",
				TypeUtil.fieldType(new CustomMapKV<>(String.class, Long.class), nullableAnnotation)),
			() -> assertEquals("com.exedio.cope.builder.generator.type.DummyMapFeature.CustomMapXY<java.lang.String,java.lang.Long>",
				TypeUtil.fieldType(new CustomMapXY<>(String.class, Long.class), nullableAnnotation)),
			() -> assertEquals("com.exedio.cope.builder.generator.type.DummyMapFeature.CustomMap", TypeUtil.fieldType(new CustomMap(), nullableAnnotation)),
			() -> assertEquals("Unhandled feature type: com.exedio.cope.builder.generator.type.DummyMapFeature.CustomMapX<X>", assertThrows(UnsupportedOperationException.class,
				() -> TypeUtil.fieldType(new CustomMapX<>(String.class), nullableAnnotation)).getMessage()),
			() -> assertEquals("Unhandled feature type: com.exedio.cope.builder.generator.type.DummyMapFeature.CustomMapKVZ<K,V,Z>", assertThrows(UnsupportedOperationException.class,
				() -> TypeUtil.fieldType(new CustomMapKVZ<>(String.class, Long.class), nullableAnnotation)).getMessage())
		);
	}

	@Test
	public void fieldType_withAnnotation_optional()
	{
		final String nullableAnnotation = "org.jspecify.annotations.Nullable";
		assertAll(
			() -> assertEquals("com.exedio.cope.Settable<java.lang.@org.jspecify.annotations.Nullable String>",
				TypeUtil.fieldType(new StringField().optional(), nullableAnnotation)),
			//always mandatory
			() -> assertEquals("com.exedio.cope.pattern.SetField<java.lang.String>",
				TypeUtil.fieldType(SetField.create(new StringField()), nullableAnnotation)),
			() -> assertEquals("com.exedio.cope.pattern.ListField<java.lang.@org.jspecify.annotations.Nullable String>",
				TypeUtil.fieldType(ListField.create(new StringField().optional()), nullableAnnotation)),
			//always mandatory
			() -> assertEquals("com.exedio.cope.pattern.MapField<java.lang.String,java.lang.Long>",
				TypeUtil.fieldType(MapField.create(new StringField(), new LongField()), nullableAnnotation)),
			() -> assertEquals("com.exedio.cope.pattern.EnumMapField<com.exedio.cope.builder.other.OuterClass.TestEnum,java.lang.@org.jspecify.annotations.Nullable String>",
				TypeUtil.fieldType(EnumMapField.create(TestEnum.class, new StringField().optional()), nullableAnnotation)),
			() -> assertEquals("Unhandled feature type: com.exedio.cope.Sequence",
				assertThrows(UnsupportedOperationException.class, () -> TypeUtil.fieldType(new Sequence(0), nullableAnnotation)).getMessage()),

			() -> assertEquals("com.exedio.cope.builder.generator.type.DummyMapFeature.CustomMapK<java.lang.String>",
				TypeUtil.fieldType(new CustomMapK<>(String.class), nullableAnnotation)),
			() -> assertEquals("com.exedio.cope.builder.generator.type.DummyMapFeature.CustomMapV<java.lang.Long>",
				TypeUtil.fieldType(new CustomMapV<>(Long.class), nullableAnnotation)),
			() -> assertEquals("com.exedio.cope.builder.generator.type.DummyMapFeature.CustomMapKV<java.lang.String,java.lang.Long>",
				TypeUtil.fieldType(new CustomMapKV<>(String.class, Long.class), nullableAnnotation)),
			() -> assertEquals("com.exedio.cope.builder.generator.type.DummyMapFeature.CustomMapXY<java.lang.String,java.lang.Long>",
				TypeUtil.fieldType(new CustomMapXY<>(String.class, Long.class), nullableAnnotation)),
			() -> assertEquals("com.exedio.cope.builder.generator.type.DummyMapFeature.CustomMap", TypeUtil.fieldType(new CustomMap(), nullableAnnotation)),
			() -> assertEquals("Unhandled feature type: com.exedio.cope.builder.generator.type.DummyMapFeature.CustomMapX<X>", assertThrows(UnsupportedOperationException.class,
				() -> TypeUtil.fieldType(new CustomMapX<>(String.class), nullableAnnotation)).getMessage()),
			() -> assertEquals("Unhandled feature type: com.exedio.cope.builder.generator.type.DummyMapFeature.CustomMapKVZ<K,V,Z>", assertThrows(UnsupportedOperationException.class,
				() -> TypeUtil.fieldType(new CustomMapKVZ<>(String.class, Long.class), nullableAnnotation)).getMessage())
		);
	}

	@Test
	public void isEnumMapFieldLike()
	{
		// no enum
		assertFalse(TypeUtil.isEnumMapFieldLike(new StringField()), "StringField");
		assertFalse(TypeUtil.isEnumMapFieldLike(MapField.create(new StringField(), new LongField())), "MapField without Enum");
		assertFalse(TypeUtil.isEnumMapFieldLike(new CustomMapXY<>(String.class, Long.class)), "CustomMap without Enum");

		// no getField()
		assertFalse(TypeUtil.isEnumMapFieldLike(MapField.create(EnumField.create(TestEnum.class), new LongField())), "MapField with Enum");

		// ok
		assertTrue(TypeUtil.isEnumMapFieldLike(EnumMapField.create(TestEnum.class, new LongField())), "EnumMapField");
		assertTrue(TypeUtil.isEnumMapFieldLike(new CustomMapXY<>(TestEnum.class, Long.class)), "CustomMap with Enum");
	}
}