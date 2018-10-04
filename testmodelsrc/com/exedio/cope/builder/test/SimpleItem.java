package com.exedio.cope.builder.test;

import static com.exedio.cope.instrument.Visibility.NONE;
import static com.exedio.cope.instrument.Visibility.PACKAGE;

import com.exedio.cope.EnumField;
import com.exedio.cope.IntegerField;
import com.exedio.cope.Item;
import com.exedio.cope.StringField;
import com.exedio.cope.builder.other.OuterClass.TestEnum;
import com.exedio.cope.instrument.Wrapper;
import com.exedio.cope.instrument.WrapperType;

@WrapperType(constructor=NONE, genericConstructor=NONE)
final class SimpleItem extends Item
{
	static final IntegerField integerMandatory = new IntegerField().toFinal();

	@Wrapper(wrap="get", visibility=PACKAGE)
	private static final IntegerField integerOptional = new IntegerField().toFinal().optional();

	static final StringField stringOptional = new StringField().toFinal().optional();
	static final EnumField<TestEnum> enumField = EnumField.create(TestEnum.class);

	/**
	 * Returns the value of {@link #integerMandatory}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="get")
	final int getIntegerMandatory()
	{
		return SimpleItem.integerMandatory.getMandatory(this);
	}

	/**
	 * Returns the value of {@link #integerOptional}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="get")
	final java.lang.Integer getIntegerOptional()
	{
		return SimpleItem.integerOptional.get(this);
	}

	/**
	 * Returns the value of {@link #stringOptional}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="get")
	final java.lang.String getStringOptional()
	{
		return SimpleItem.stringOptional.get(this);
	}

	/**
	 * Returns the value of {@link #enumField}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="get")
	final TestEnum getEnumField()
	{
		return SimpleItem.enumField.get(this);
	}

	/**
	 * Sets a new value for {@link #enumField}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="set")
	final void setEnumField(final TestEnum enumField)
			throws
				com.exedio.cope.MandatoryViolationException
	{
		SimpleItem.enumField.set(this,enumField);
	}

	@javax.annotation.Generated("com.exedio.cope.instrument")
	private static final long serialVersionUID = 1l;

	/**
	 * The persistent type information for simpleItem.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @WrapperType(type=...)
	static final com.exedio.cope.Type<SimpleItem> TYPE = com.exedio.cope.TypesBound.newType(SimpleItem.class);

	/**
	 * Activation constructor. Used for internal purposes only.
	 * @see com.exedio.cope.Item#Item(com.exedio.cope.ActivationParameters)
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument")
	private SimpleItem(final com.exedio.cope.ActivationParameters ap){super(ap);}
}
