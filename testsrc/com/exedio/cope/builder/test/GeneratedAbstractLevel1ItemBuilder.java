package com.exedio.cope.builder.test;

@SuppressWarnings({"ClassEscapesDefinedScope", "RedundantSuppression"})
@com.exedio.cope.builder.Generated
public abstract class GeneratedAbstractLevel1ItemBuilder<I extends AbstractLevel1Item, B extends GeneratedAbstractLevel1ItemBuilder <I,B>>
	extends com.exedio.cope.builder.ItemBuilder<I, B>
{

	protected GeneratedAbstractLevel1ItemBuilder(final com.exedio.cope.Type<I> type)
	{
		super(type);
	}

	protected final com.exedio.cope.Settable<java.lang.Integer> l1 = getFeature("l1");

	@com.exedio.cope.builder.Setter
	public final B l1(final int l1)
	{
		return set(this.l1,l1);
	}
}
