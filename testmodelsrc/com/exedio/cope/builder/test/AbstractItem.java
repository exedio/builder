package com.exedio.cope.builder.test;

import static com.exedio.cope.instrument.Visibility.NONE;
import static com.exedio.cope.instrument.Visibility.PUBLIC;

import com.exedio.cope.IntegerField;
import com.exedio.cope.Item;
import com.exedio.cope.instrument.Wrapper;
import com.exedio.cope.instrument.WrapperType;

@WrapperType(constructor=NONE, genericConstructor=NONE)
public abstract class AbstractItem extends Item
{
	@Wrapper(wrap="get", visibility=PUBLIC)
	static final IntegerField abstractField = new IntegerField().toFinal();

	/**
	 * Returns the value of {@link #abstractField}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="get")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	public final int getAbstractField()
	{
		return AbstractItem.abstractField.getMandatory(this);
	}

	@com.exedio.cope.instrument.Generated
	private static final long serialVersionUID = 2l;

	/**
	 * The persistent type information for abstractItem.
	 */
	@com.exedio.cope.instrument.Generated // customize with @WrapperType(type=...)
	public static final com.exedio.cope.Type<AbstractItem> TYPE = com.exedio.cope.TypesBound.newType(AbstractItem.class);

	/**
	 * Activation constructor. Used for internal purposes only.
	 * @see com.exedio.cope.Item#Item(com.exedio.cope.ActivationParameters)
	 */
	@com.exedio.cope.instrument.Generated
	protected AbstractItem(final com.exedio.cope.ActivationParameters ap){super(ap);}
}
