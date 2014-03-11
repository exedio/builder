
package com.exedio.cope.builder.other;

public class TestCompositeBuilder extends GeneratedTestCompositeBuilder<TestCompositeBuilder>
{
	@Override
	public TestComposite build()
	{
		fallback(TestComposite.integerMandatory, 777777);
		return super.build();
	}
}
