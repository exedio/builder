package com.exedio.cope.builder.test.packagePrivate;

class MyCompositeBuilder extends GeneratedMyCompositeBuilder<MyCompositeBuilder>
{
	@Override
	public MyComposite build()
	{
		fallback(string, "FALLBACK");
		return super.build();
	}
}
