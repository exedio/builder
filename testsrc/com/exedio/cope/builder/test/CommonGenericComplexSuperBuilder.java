package com.exedio.cope.builder.test;

import com.exedio.cope.Type;

public abstract class CommonGenericComplexSuperBuilder<I extends GenericComplexSuper<?,?>, B extends CommonGenericComplexSuperBuilder<?,?>>
	extends GeneratedGenericComplexSuperBuilder<I,B>
{
	protected CommonGenericComplexSuperBuilder(final Type<I> type)
	{
		super(type);
	}

	@Override
	public I build()
	{
		return super.build();
	}
}
