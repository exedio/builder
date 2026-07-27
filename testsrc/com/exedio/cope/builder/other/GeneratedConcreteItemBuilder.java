package com.exedio.cope.builder.other;

@SuppressWarnings({"ClassEscapesDefinedScope", "RedundantSuppression"})
@com.exedio.cope.builder.Generated
public abstract class GeneratedConcreteItemBuilder<B extends GeneratedConcreteItemBuilder<B>>
	extends com.exedio.cope.builder.test.CommonAbstractItemBuilder<com.exedio.cope.builder.other.ConcreteItem, B>
{
	@SuppressWarnings("unused")
	protected GeneratedConcreteItemBuilder()
	{
		super(ConcreteItem.TYPE);
	}

	protected final com.exedio.cope.Settable<java.lang.Integer> concreteField = getFeature("concreteField");

	@com.exedio.cope.builder.Setter
	public final B concreteField(final int concreteField)
	{
		return set(this.concreteField,concreteField);
	}

	protected final com.exedio.cope.Settable<com.exedio.cope.Type<? extends com.exedio.cope.builder.test.AbstractItem>> typeField = getFeature("typeField");

	@com.exedio.cope.builder.Setter
	public final B typeField(final com.exedio.cope.@org.jspecify.annotations.Nullable Type<? extends com.exedio.cope.builder.test.AbstractItem> typeField)
	{
		return set(this.typeField,typeField);
	}
}
