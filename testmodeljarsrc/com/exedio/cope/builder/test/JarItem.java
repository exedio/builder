package com.exedio.cope.builder.test;

import com.exedio.cope.IntegerField;
import com.exedio.cope.Item;

public final class JarItem extends Item
{
	static final IntegerField field = new IntegerField().toFinal();


	/**
	 * Creates a new JarItem with all the fields initially needed.
	 * @param field the initial value for field {@link #field}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @WrapperType(constructor=...) and @WrapperInitial
	JarItem(
				final int field)
	{
		this(new com.exedio.cope.SetValue<?>[]{
			com.exedio.cope.SetValue.map(JarItem.field,field),
		});
	}

	/**
	 * Creates a new JarItem and sets the given fields initially.
	 */
	@com.exedio.cope.instrument.Generated // customize with @WrapperType(genericConstructor=...)
	private JarItem(final com.exedio.cope.SetValue<?>... setValues){super(setValues);}

	/**
	 * Returns the value of {@link #field}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="get")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final int getField()
	{
		return JarItem.field.getMandatory(this);
	}

	@com.exedio.cope.instrument.Generated
	private static final long serialVersionUID = 1l;

	/**
	 * The persistent type information for jarItem.
	 */
	@com.exedio.cope.instrument.Generated // customize with @WrapperType(type=...)
	public static final com.exedio.cope.Type<JarItem> TYPE = com.exedio.cope.TypesBound.newType(JarItem.class);

	/**
	 * Activation constructor. Used for internal purposes only.
	 * @see com.exedio.cope.Item#Item(com.exedio.cope.ActivationParameters)
	 */
	@com.exedio.cope.instrument.Generated
	private JarItem(final com.exedio.cope.ActivationParameters ap){super(ap);}
}
