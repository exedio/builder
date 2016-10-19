package com.exedio.cope.builder.test.packagePrivate;

public class MyItemBuilder extends GeneratedMyItemBuilder<MyItemBuilder>
{
	// TODO should be generated
	public final MyItemBuilder enumF(final MyEnum enumF)
	{
		return set("enumF", enumF);
	}

	// TODO should be generated
	public final MyItemBuilder composite(final MyComposite composite)
	{
		return set("composite", composite);
	}

	@Override
	public MyItem build()
	{
		return super.build();
	}
}
