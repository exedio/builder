package com.exedio.cope.builder.test;

import static com.exedio.cope.instrument.Visibility.NONE;
import static com.exedio.cope.instrument.Visibility.PUBLIC;

import com.exedio.cope.IntegerField;
import com.exedio.cope.instrument.Wrapper;
import com.exedio.cope.instrument.WrapperType;

@WrapperType(constructor=NONE, genericConstructor=NONE)
public class MixedLevel2Item extends AbstractLevel1Item
{
	@Wrapper(wrap="get", visibility=PUBLIC)
	static final IntegerField l2 = new IntegerField().toFinal();

	/**
	 * Returns the value of {@link #l2}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="get")
	public final int getL2()
	{
		return MixedLevel2Item.l2.getMandatory(this);
	}

	@javax.annotation.Generated("com.exedio.cope.instrument")
	private static final long serialVersionUID = 1l;

	/**
	 * The persistent type information for mixedLevel2Item.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @WrapperType(type=...)
	public static final com.exedio.cope.Type<MixedLevel2Item> TYPE = com.exedio.cope.TypesBound.newType(MixedLevel2Item.class);

	/**
	 * Activation constructor. Used for internal purposes only.
	 * @see com.exedio.cope.Item#Item(com.exedio.cope.ActivationParameters)
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument")
	protected MixedLevel2Item(final com.exedio.cope.ActivationParameters ap){super(ap);}
}
