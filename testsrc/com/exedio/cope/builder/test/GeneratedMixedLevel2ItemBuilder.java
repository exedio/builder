package com.exedio.cope.builder.test;

@SuppressWarnings({"ClassEscapesDefinedScope", "RedundantSuppression"})
@com.exedio.cope.builder.Generated
public abstract class GeneratedMixedLevel2ItemBuilder<I extends MixedLevel2Item, B extends GeneratedMixedLevel2ItemBuilder <I,B>>
	extends com.exedio.cope.builder.test.CommonAbstractLevel1ItemBuilder<I, B>
{
	@com.exedio.cope.builder.Generated
	public static class MixedLevel2ItemBuilder extends com.exedio.cope.builder.test.CommonMixedLevel2ItemBuilder<MixedLevel2Item,MixedLevel2ItemBuilder>
	{
		public MixedLevel2ItemBuilder( )
		{
			super( MixedLevel2Item.TYPE );
		}
	}

	protected GeneratedMixedLevel2ItemBuilder(final com.exedio.cope.Type<I> type)
	{
		super(type);
	}

	protected final com.exedio.cope.Settable<java.lang.Integer> l2 = getFeature("l2");

	@com.exedio.cope.builder.Setter
	public final B l2(final int l2)
	{
		return set(this.l2,l2);
	}
}
