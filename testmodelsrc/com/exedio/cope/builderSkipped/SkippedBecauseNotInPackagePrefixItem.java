package com.exedio.cope.builderSkipped;

import com.exedio.cope.IntegerField;
import com.exedio.cope.Item;

public final class SkippedBecauseNotInPackagePrefixItem extends Item
{
	static final IntegerField field = new IntegerField().toFinal();


	/**
	 * Creates a new SkippedBecauseNotInPackagePrefixItem with all the fields initially needed.
	 * @param field the initial value for field {@link #field}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @WrapperType(constructor=...) and @WrapperInitial
	SkippedBecauseNotInPackagePrefixItem(
				final int field)
	{
		this(new com.exedio.cope.SetValue<?>[]{
			SkippedBecauseNotInPackagePrefixItem.field.map(field),
		});
	}

	/**
	 * Creates a new SkippedBecauseNotInPackagePrefixItem and sets the given fields initially.
	 */
	@com.exedio.cope.instrument.Generated // customize with @WrapperType(genericConstructor=...)
	private SkippedBecauseNotInPackagePrefixItem(final com.exedio.cope.SetValue<?>... setValues){super(setValues);}

	/**
	 * Returns the value of {@link #field}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="get")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final int getField()
	{
		return SkippedBecauseNotInPackagePrefixItem.field.getMandatory(this);
	}

	@com.exedio.cope.instrument.Generated
	private static final long serialVersionUID = 1l;

	/**
	 * The persistent type information for skippedBecauseNotInPackagePrefixItem.
	 */
	@com.exedio.cope.instrument.Generated // customize with @WrapperType(type=...)
	public static final com.exedio.cope.Type<SkippedBecauseNotInPackagePrefixItem> TYPE = com.exedio.cope.TypesBound.newType(SkippedBecauseNotInPackagePrefixItem.class);

	/**
	 * Activation constructor. Used for internal purposes only.
	 * @see com.exedio.cope.Item#Item(com.exedio.cope.ActivationParameters)
	 */
	@com.exedio.cope.instrument.Generated
	private SkippedBecauseNotInPackagePrefixItem(final com.exedio.cope.ActivationParameters ap){super(ap);}
}
