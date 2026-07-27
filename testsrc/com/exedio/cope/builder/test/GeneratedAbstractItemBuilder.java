package com.exedio.cope.builder.test;

@SuppressWarnings({"ClassEscapesDefinedScope", "RedundantSuppression"})
@com.exedio.cope.builder.Generated
public abstract class GeneratedAbstractItemBuilder<I extends AbstractItem, B extends GeneratedAbstractItemBuilder <I,B>>
	extends com.exedio.cope.builder.ItemBuilder<I, B>
{

	protected GeneratedAbstractItemBuilder(final com.exedio.cope.Type<I> type)
	{
		super(type);
	}

	protected final com.exedio.cope.Settable<java.lang.Integer> abstractField = getFeature("abstractField");

	@com.exedio.cope.builder.Setter
	public final B abstractField(final int abstractField)
	{
		return set(this.abstractField,abstractField);
	}
}
