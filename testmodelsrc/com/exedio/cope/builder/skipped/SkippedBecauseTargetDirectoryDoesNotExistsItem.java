package com.exedio.cope.builder.skipped;

import com.exedio.cope.IntegerField;
import com.exedio.cope.Item;

public final class SkippedBecauseTargetDirectoryDoesNotExistsItem extends Item
{
	static final IntegerField field = new IntegerField().toFinal();


	/**
	 * Creates a new SkippedBecauseTargetDirectoryDoesNotExistsItem with all the fields initially needed.
	 * @param field the initial value for field {@link #field}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @WrapperType(constructor=...) and @WrapperInitial
	SkippedBecauseTargetDirectoryDoesNotExistsItem(
				final int field)
	{
		this(new com.exedio.cope.SetValue<?>[]{
			SkippedBecauseTargetDirectoryDoesNotExistsItem.field.map(field),
		});
	}

	/**
	 * Creates a new SkippedBecauseTargetDirectoryDoesNotExistsItem and sets the given fields initially.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @WrapperType(genericConstructor=...)
	private SkippedBecauseTargetDirectoryDoesNotExistsItem(final com.exedio.cope.SetValue<?>... setValues)
	{
		super(setValues);
	}

	/**
	 * Returns the value of {@link #field}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="get")
	final int getField()
	{
		return SkippedBecauseTargetDirectoryDoesNotExistsItem.field.getMandatory(this);
	}

	@javax.annotation.Generated("com.exedio.cope.instrument")
	private static final long serialVersionUID = 1l;

	/**
	 * The persistent type information for skippedBecauseTargetDirectoryDoesNotExistsItem.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @WrapperType(type=...)
	public static final com.exedio.cope.Type<SkippedBecauseTargetDirectoryDoesNotExistsItem> TYPE = com.exedio.cope.TypesBound.newType(SkippedBecauseTargetDirectoryDoesNotExistsItem.class);

	/**
	 * Activation constructor. Used for internal purposes only.
	 * @see com.exedio.cope.Item#Item(com.exedio.cope.ActivationParameters)
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument")
	private SkippedBecauseTargetDirectoryDoesNotExistsItem(final com.exedio.cope.ActivationParameters ap){super(ap);}
}
