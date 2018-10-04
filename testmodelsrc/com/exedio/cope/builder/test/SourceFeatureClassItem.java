package com.exedio.cope.builder.test;

import com.exedio.cope.Item;
import com.exedio.cope.mockframework.SourceFeatureClassPattern;

final class SourceFeatureClassItem extends Item
{
	static final SourceFeatureClassPattern pattern = new SourceFeatureClassPattern();


	/**
	 * Creates a new SourceFeatureClassItem with all the fields initially needed.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @WrapperType(constructor=...) and @WrapperInitial
	SourceFeatureClassItem()
	{
		this(new com.exedio.cope.SetValue<?>[]{
		});
	}

	/**
	 * Creates a new SourceFeatureClassItem and sets the given fields initially.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @WrapperType(genericConstructor=...)
	private SourceFeatureClassItem(final com.exedio.cope.SetValue<?>... setValues)
	{
		super(setValues);
	}

	@javax.annotation.Generated("com.exedio.cope.instrument")
	private static final long serialVersionUID = 1l;

	/**
	 * The persistent type information for sourceFeatureClassItem.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @WrapperType(type=...)
	static final com.exedio.cope.Type<SourceFeatureClassItem> TYPE = com.exedio.cope.TypesBound.newType(SourceFeatureClassItem.class);

	/**
	 * Activation constructor. Used for internal purposes only.
	 * @see com.exedio.cope.Item#Item(com.exedio.cope.ActivationParameters)
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument")
	private SourceFeatureClassItem(final com.exedio.cope.ActivationParameters ap){super(ap);}
}
