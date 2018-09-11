package com.exedio.cope.builder.test.genericComplex;

import com.exedio.cope.instrument.WrapInterim;
import java.util.Collection;

public class GenMid<L extends Collection<String>> extends GenSup<Long, L>
{
	@WrapInterim
	static final class classWildcard
	{
		@WrapInterim
		@SuppressWarnings("unchecked")
		static final Class<GenMid<?>> value = (Class<GenMid<?>>)(Class<?>)GenMid.class;
	}

	/**
	 * Creates a new GenMid with all the fields initially needed.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @WrapperType(constructor=...) and @WrapperInitial
	public GenMid()
	{
		this(new com.exedio.cope.SetValue<?>[]{
		});
	}

	/**
	 * Creates a new GenMid and sets the given fields initially.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @WrapperType(genericConstructor=...)
	protected GenMid(final com.exedio.cope.SetValue<?>... setValues)
	{
		super(setValues);
	}

	@javax.annotation.Generated("com.exedio.cope.instrument")
	private static final long serialVersionUID = 1l;

	/**
	 * The persistent type information for genMid.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @WrapperType(type=...)
	public static final com.exedio.cope.Type<GenMid<?>> TYPE = com.exedio.cope.TypesBound.newType(GenMid.classWildcard.value);

	/**
	 * Activation constructor. Used for internal purposes only.
	 * @see com.exedio.cope.Item#Item(com.exedio.cope.ActivationParameters)
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument")
	protected GenMid(final com.exedio.cope.ActivationParameters ap){super(ap);}
}
