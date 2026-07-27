package com.exedio.cope.builder.test;

@SuppressWarnings({"ClassEscapesDefinedScope", "RedundantSuppression"})
@com.exedio.cope.builder.Generated
public abstract class GeneratedConcreteLevel3ItemBuilder<B extends GeneratedConcreteLevel3ItemBuilder<B>>
	extends com.exedio.cope.builder.test.CommonMixedLevel2ItemBuilder<com.exedio.cope.builder.test.ConcreteLevel3Item, B>
{
	@SuppressWarnings("unused")
	protected GeneratedConcreteLevel3ItemBuilder()
	{
		super(ConcreteLevel3Item.TYPE);
	}

	protected final com.exedio.cope.Settable<java.lang.Integer> l3 = getFeature("l3");

	@com.exedio.cope.builder.Setter
	public final B l3(final int l3)
	{
		return set(this.l3,l3);
	}
}
