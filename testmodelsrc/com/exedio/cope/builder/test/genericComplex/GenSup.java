package com.exedio.cope.builder.test.genericComplex;

import com.exedio.cope.Item;
import com.exedio.cope.pattern.Money;
import java.util.Collection;

class GenSup<N extends Number, L extends Collection<String>> extends Item implements Money.Currency
{
	/**
	 * Creates a new GenSup with all the fields initially needed.
	 */
	@com.exedio.cope.instrument.Generated // customize with @WrapperType(constructor=...) and @WrapperInitial
	GenSup()
	{
		this(new com.exedio.cope.SetValue<?>[]{
		});
	}

	/**
	 * Creates a new GenSup and sets the given fields initially.
	 */
	@com.exedio.cope.instrument.Generated // customize with @WrapperType(genericConstructor=...)
	protected GenSup(final com.exedio.cope.SetValue<?>... setValues){super(setValues);}

	@com.exedio.cope.instrument.Generated
	private static final long serialVersionUID = 1l;

	/**
	 * Use GenSup.classWildcard.value instead of GenSup.class to avoid rawtypes warnings.
	 */
	@com.exedio.cope.instrument.Generated // customize with @WrapperType(wildcardClass=...)
	static final class classWildcard { public static final java.lang.Class<GenSup<?,?>> value = com.exedio.cope.ItemWildcardCast.cast(GenSup.class); private classWildcard(){} }

	/**
	 * The persistent type information for genSup.
	 */
	@com.exedio.cope.instrument.Generated // customize with @WrapperType(type=...)
	static final com.exedio.cope.Type<GenSup<?,?>> TYPE = com.exedio.cope.TypesBound.newType(classWildcard.value);

	/**
	 * Activation constructor. Used for internal purposes only.
	 * @see com.exedio.cope.Item#Item(com.exedio.cope.ActivationParameters)
	 */
	@com.exedio.cope.instrument.Generated
	protected GenSup(final com.exedio.cope.ActivationParameters ap){super(ap);}
}
