package com.exedio.cope.builder.test.packagePrivate;

public class MyCompositeBuilder extends GeneratedMyCompositeBuilder<MyCompositeBuilder>
{
	@Override
	public MyComposite build()
	{
		fallback(MyComposite.string, "FALLBACK");
		return super.build();
	}
}
