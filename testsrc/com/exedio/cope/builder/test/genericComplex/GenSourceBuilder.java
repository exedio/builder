package com.exedio.cope.builder.test.genericComplex;

class GenSourceBuilder extends GeneratedGenSourceBuilder<GenSourceBuilder>
{
	@Override
	public GenSource build()
	{
		fallback(subFallback, new GenSubBuilder());
		fallback(subMandatory, new GenSubBuilder());
		return super.build();
	}
}
