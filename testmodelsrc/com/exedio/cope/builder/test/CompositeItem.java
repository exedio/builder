package com.exedio.cope.builder.test;

import static com.exedio.cope.instrument.Visibility.NONE;

import com.exedio.cope.Item;
import com.exedio.cope.builder.other.TestComposite;
import com.exedio.cope.instrument.WrapperType;
import com.exedio.cope.pattern.CompositeField;

@WrapperType(constructor=NONE, genericConstructor=NONE)
public final class CompositeItem extends Item
{
	public static final CompositeField<TestComposite> field = CompositeField.create(TestComposite.class);

	/**
	 * Returns the value of {@link #field}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="get")
	public final TestComposite getField()
	{
		return CompositeItem.field.get(this);
	}

	/**
	 * Sets a new value for {@link #field}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="set")
	public final void setField(final TestComposite field)
			throws
				com.exedio.cope.MandatoryViolationException
	{
		CompositeItem.field.set(this,field);
	}

	@javax.annotation.Generated("com.exedio.cope.instrument")
	private static final long serialVersionUID = 1l;

	/**
	 * The persistent type information for compositeItem.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @WrapperType(type=...)
	public static final com.exedio.cope.Type<CompositeItem> TYPE = com.exedio.cope.TypesBound.newType(CompositeItem.class);

	/**
	 * Activation constructor. Used for internal purposes only.
	 * @see com.exedio.cope.Item#Item(com.exedio.cope.ActivationParameters)
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument")
	private CompositeItem(final com.exedio.cope.ActivationParameters ap){super(ap);}
}
