package com.exedio.cope.builder.test.packagePrivate;

public class MyCompositeBuilder extends GeneratedMyCompositeBuilder<MyCompositeBuilder>
{
	// TODO should be generated
	public final MyCompositeBuilder enumF(final MyEnum enumF)
	{
		return set("enumF", enumF);
	}

	@Override
	public MyComposite build()
	{
		fallback(MyComposite.string, "FALLBACK");
		return super.build();
	}
}
