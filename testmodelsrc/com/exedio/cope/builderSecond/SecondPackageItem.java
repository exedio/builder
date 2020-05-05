package com.exedio.cope.builderSecond;

import com.exedio.cope.IntegerField;
import com.exedio.cope.Item;

public final class SecondPackageItem extends Item
{
	static final IntegerField field = new IntegerField().toFinal();


	/**
	 * Creates a new SecondPackageItem with all the fields initially needed.
	 * @param field the initial value for field {@link #field}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @WrapperType(constructor=...) and @WrapperInitial
	SecondPackageItem(
				final int field)
	{
		this(new com.exedio.cope.SetValue<?>[]{
			SecondPackageItem.field.map(field),
		});
	}

	/**
	 * Creates a new SecondPackageItem and sets the given fields initially.
	 */
	@com.exedio.cope.instrument.Generated // customize with @WrapperType(genericConstructor=...)
	private SecondPackageItem(final com.exedio.cope.SetValue<?>... setValues){super(setValues);}

	/**
	 * Returns the value of {@link #field}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="get")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final int getField()
	{
		return SecondPackageItem.field.getMandatory(this);
	}

	@com.exedio.cope.instrument.Generated
	private static final long serialVersionUID = 1l;

	/**
	 * The persistent type information for secondPackageItem.
	 */
	@com.exedio.cope.instrument.Generated // customize with @WrapperType(type=...)
	public static final com.exedio.cope.Type<SecondPackageItem> TYPE = com.exedio.cope.TypesBound.newType(SecondPackageItem.class);

	/**
	 * Activation constructor. Used for internal purposes only.
	 * @see com.exedio.cope.Item#Item(com.exedio.cope.ActivationParameters)
	 */
	@com.exedio.cope.instrument.Generated
	private SecondPackageItem(final com.exedio.cope.ActivationParameters ap){super(ap);}
}
