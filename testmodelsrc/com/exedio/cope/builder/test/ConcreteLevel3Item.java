package com.exedio.cope.builder.test;

import static com.exedio.cope.instrument.Visibility.NONE;
import static com.exedio.cope.instrument.Visibility.PUBLIC;

import com.exedio.cope.IntegerField;
import com.exedio.cope.instrument.Wrapper;
import com.exedio.cope.instrument.WrapperType;

@WrapperType(constructor=NONE, genericConstructor=NONE)
public class ConcreteLevel3Item extends MixedLevel2Item
{
	@Wrapper(wrap="get", visibility=PUBLIC)
	static final IntegerField l3 = new IntegerField().toFinal();

	/**
	 * Returns the value of {@link #l3}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="get")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	public final int getL3()
	{
		return ConcreteLevel3Item.l3.getMandatory(this);
	}

	@com.exedio.cope.instrument.Generated
	private static final long serialVersionUID = 1l;

	/**
	 * The persistent type information for concreteLevel3Item.
	 */
	@com.exedio.cope.instrument.Generated // customize with @WrapperType(type=...)
	public static final com.exedio.cope.Type<ConcreteLevel3Item> TYPE = com.exedio.cope.TypesBound.newType(ConcreteLevel3Item.class);

	/**
	 * Activation constructor. Used for internal purposes only.
	 * @see com.exedio.cope.Item#Item(com.exedio.cope.ActivationParameters)
	 */
	@com.exedio.cope.instrument.Generated
	protected ConcreteLevel3Item(final com.exedio.cope.ActivationParameters ap){super(ap);}
}
