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
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @WrapperType(constructor=...) and @WrapperInitial
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
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @WrapperType(genericConstructor=...)
	private SecondPackageItem(final com.exedio.cope.SetValue<?>... setValues)
	{
		super(setValues);
	}

	/**
	 * Returns the value of {@link #field}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="get")
	final int getField()
	{
		return SecondPackageItem.field.getMandatory(this);
	}

	@javax.annotation.Generated("com.exedio.cope.instrument")
	private static final long serialVersionUID = 1l;

	/**
	 * The persistent type information for secondPackageItem.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @WrapperType(type=...)
	public static final com.exedio.cope.Type<SecondPackageItem> TYPE = com.exedio.cope.TypesBound.newType(SecondPackageItem.class);

	/**
	 * Activation constructor. Used for internal purposes only.
	 * @see com.exedio.cope.Item#Item(com.exedio.cope.ActivationParameters)
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument")
	private SecondPackageItem(final com.exedio.cope.ActivationParameters ap){super(ap);}
}
