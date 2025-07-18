package com.exedio.cope.builder.test.genericComplex;

import java.util.List;

final class GenSub extends GenMid<List<String>>
{
	/**
	 * Creates a new GenSub with all the fields initially needed.
	 */
	@com.exedio.cope.instrument.Generated // customize with @WrapperType(constructor=...) and @WrapperInitial
	GenSub()
	{
		this(com.exedio.cope.SetValue.EMPTY_ARRAY);
	}

	/**
	 * Creates a new GenSub and sets the given fields initially.
	 */
	@com.exedio.cope.instrument.Generated // customize with @WrapperType(genericConstructor=...)
	private GenSub(final com.exedio.cope.SetValue<?>... setValues){super(setValues);}

	@com.exedio.cope.instrument.Generated
	private static final long serialVersionUID = 1l;

	/**
	 * The persistent type information for genSub.
	 */
	@com.exedio.cope.instrument.Generated // customize with @WrapperType(type=...)
	static final com.exedio.cope.Type<GenSub> TYPE = com.exedio.cope.TypesBound.newType(GenSub.class,GenSub::new);

	/**
	 * Activation constructor. Used for internal purposes only.
	 * @see com.exedio.cope.Item#Item(com.exedio.cope.ActivationParameters)
	 */
	@com.exedio.cope.instrument.Generated
	private GenSub(final com.exedio.cope.ActivationParameters ap){super(ap);}
}
