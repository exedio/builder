package com.exedio.cope.builder.other;

import static com.exedio.cope.instrument.Visibility.NONE;
import static com.exedio.cope.instrument.Visibility.PUBLIC;

import com.exedio.cope.IntegerField;
import com.exedio.cope.builder.test.AbstractItem;
import com.exedio.cope.instrument.Wrapper;
import com.exedio.cope.instrument.WrapperType;
import com.exedio.cope.reflect.TypeField;

@WrapperType(constructor=NONE, genericConstructor=NONE)
public final class ConcreteItem extends AbstractItem
{
	@Wrapper(wrap="get", visibility=PUBLIC)
	private static final IntegerField concreteField = new IntegerField().toFinal();

	@Wrapper(wrap="get", visibility=PUBLIC)
	private static final TypeField<AbstractItem> typeField = TypeField.create(AbstractItem.class).optional();

	/**
	 * Returns the value of {@link #concreteField}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="get")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	public final int getConcreteField()
	{
		return ConcreteItem.concreteField.getMandatory(this);
	}

	/**
	 * Returns the value of {@link #typeField}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="get")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	public final com.exedio.cope.Type<? extends AbstractItem> getTypeField()
	{
		return ConcreteItem.typeField.get(this);
	}

	/**
	 * Sets a new value for {@link #typeField}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="set")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	private void setTypeField(final com.exedio.cope.Type<? extends AbstractItem> typeField)
			throws
				com.exedio.cope.StringLengthViolationException
	{
		ConcreteItem.typeField.set(this,typeField);
	}

	@com.exedio.cope.instrument.Generated
	private static final long serialVersionUID = 1l;

	/**
	 * The persistent type information for concreteItem.
	 */
	@com.exedio.cope.instrument.Generated // customize with @WrapperType(type=...)
	public static final com.exedio.cope.Type<ConcreteItem> TYPE = com.exedio.cope.TypesBound.newType(ConcreteItem.class);

	/**
	 * Activation constructor. Used for internal purposes only.
	 * @see com.exedio.cope.Item#Item(com.exedio.cope.ActivationParameters)
	 */
	@com.exedio.cope.instrument.Generated
	private ConcreteItem(final com.exedio.cope.ActivationParameters ap){super(ap);}
}
