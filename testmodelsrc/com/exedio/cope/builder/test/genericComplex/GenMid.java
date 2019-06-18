package com.exedio.cope.builder.test.genericComplex;

import java.util.Collection;

public class GenMid<L extends Collection<String>> extends GenSup<Long, L>
{
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
	 * Use GenMid.classWildcard.value instead of GenMid.class to avoid rawtypes warnings.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @WrapperType(wildcardClass=...)
	public static final class classWildcard { public static final java.lang.Class<GenMid<?>> value = com.exedio.cope.ItemWildcardCast.cast(GenMid.class); private classWildcard(){} }

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
