package com.exedio.cope.builder.test.genericComplex;

import java.util.Collection;

public class GenMid<L extends Collection<String>> extends GenSup<Long, L>
{
	/**
	 * Creates a new GenMid with all the fields initially needed.
	 */
	@com.exedio.cope.instrument.Generated // customize with @WrapperType(constructor=...) and @WrapperInitial
	public GenMid()
	{
		this(new com.exedio.cope.SetValue<?>[]{
		});
	}

	/**
	 * Creates a new GenMid and sets the given fields initially.
	 */
	@com.exedio.cope.instrument.Generated // customize with @WrapperType(genericConstructor=...)
	protected GenMid(final com.exedio.cope.SetValue<?>... setValues){super(setValues);}

	@com.exedio.cope.instrument.Generated
	private static final long serialVersionUID = 1l;

	/**
	 * Use GenMid.classWildcard.value instead of GenMid.class to avoid rawtypes warnings.
	 */
	@com.exedio.cope.instrument.Generated // customize with @WrapperType(wildcardClass=...)
	public static final class classWildcard { public static final java.lang.Class<GenMid<?>> value = com.exedio.cope.ItemWildcardCast.cast(GenMid.class); private classWildcard(){} }

	/**
	 * The persistent type information for genMid.
	 */
	@com.exedio.cope.instrument.Generated // customize with @WrapperType(type=...)
	public static final com.exedio.cope.Type<GenMid<?>> TYPE = com.exedio.cope.TypesBound.newType(classWildcard.value);

	/**
	 * Activation constructor. Used for internal purposes only.
	 * @see com.exedio.cope.Item#Item(com.exedio.cope.ActivationParameters)
	 */
	@com.exedio.cope.instrument.Generated
	protected GenMid(final com.exedio.cope.ActivationParameters ap){super(ap);}
}
