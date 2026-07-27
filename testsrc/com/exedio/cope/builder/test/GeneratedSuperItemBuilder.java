package com.exedio.cope.builder.test;

@SuppressWarnings({"ClassEscapesDefinedScope", "RedundantSuppression"})
@com.exedio.cope.builder.Generated
public abstract class GeneratedSuperItemBuilder<I extends SuperItem, B extends GeneratedSuperItemBuilder <I,B>>
	extends com.exedio.cope.builder.ItemBuilder<I, B>
{
	@com.exedio.cope.builder.Generated
	public static class SuperItemBuilder extends com.exedio.cope.builder.test.CommonSuperItemBuilder<SuperItem,SuperItemBuilder>
	{
		public SuperItemBuilder( )
		{
			super( SuperItem.TYPE );
		}
	}

	protected GeneratedSuperItemBuilder(final com.exedio.cope.Type<I> type)
	{
		super(type);
	}

	protected final com.exedio.cope.Settable<java.lang.Integer> superField = getFeature("superField");

	@com.exedio.cope.builder.Setter
	public final B superField(final int superField)
	{
		return set(this.superField,superField);
	}
}
