package com.exedio.cope.builder.test.genericComplex;

import com.exedio.cope.Item;
import com.exedio.cope.pattern.Money;
import java.util.Collection;

class GenSup<N extends Number, L extends Collection<String>> extends Item implements Money.Currency
{
	static final class classWildcard
	{
		@SuppressWarnings("unchecked")
		static final Class<GenSup<?,?>> value = (Class<GenSup<?,?>>)(Class<?>)GenSup.class;
	}

	/**
	 * Creates a new GenSup with all the fields initially needed.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @WrapperType(constructor=...) and @WrapperInitial
	GenSup()
	{
		this(new com.exedio.cope.SetValue<?>[]{
		});
	}

	/**
	 * Creates a new GenSup and sets the given fields initially.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @WrapperType(genericConstructor=...)
	protected GenSup(final com.exedio.cope.SetValue<?>... setValues)
	{
		super(setValues);
	}

	@javax.annotation.Generated("com.exedio.cope.instrument")
	private static final long serialVersionUID = 1l;

	/**
	 * The persistent type information for genSup.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @WrapperType(type=...)
	static final com.exedio.cope.Type<GenSup<?,?>> TYPE = com.exedio.cope.TypesBound.newType(GenSup.classWildcard.value);

	/**
	 * Activation constructor. Used for internal purposes only.
	 * @see com.exedio.cope.Item#Item(com.exedio.cope.ActivationParameters)
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument")
	protected GenSup(final com.exedio.cope.ActivationParameters ap){super(ap);}
}
