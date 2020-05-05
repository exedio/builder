package com.exedio.cope.builder.test;

import static com.exedio.cope.instrument.Visibility.NONE;
import static com.exedio.cope.instrument.Visibility.PUBLIC;

import com.exedio.cope.IntegerField;
import com.exedio.cope.Item;
import com.exedio.cope.instrument.Wrapper;
import com.exedio.cope.instrument.WrapperType;

@WrapperType(constructor=NONE, genericConstructor=NONE)
public abstract class AbstractLevel1Item extends Item
{
	@Wrapper(wrap="get", visibility=PUBLIC)
	static final IntegerField l1 = new IntegerField().toFinal();

	/**
	 * Returns the value of {@link #l1}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="get")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	public final int getL1()
	{
		return AbstractLevel1Item.l1.getMandatory(this);
	}

	@com.exedio.cope.instrument.Generated
	private static final long serialVersionUID = 2l;

	/**
	 * The persistent type information for abstractLevel1Item.
	 */
	@com.exedio.cope.instrument.Generated // customize with @WrapperType(type=...)
	public static final com.exedio.cope.Type<AbstractLevel1Item> TYPE = com.exedio.cope.TypesBound.newType(AbstractLevel1Item.class);

	/**
	 * Activation constructor. Used for internal purposes only.
	 * @see com.exedio.cope.Item#Item(com.exedio.cope.ActivationParameters)
	 */
	@com.exedio.cope.instrument.Generated
	protected AbstractLevel1Item(final com.exedio.cope.ActivationParameters ap){super(ap);}
}
