package com.exedio.cope.builderSecond;

@SuppressWarnings({"ClassEscapesDefinedScope", "RedundantSuppression"})
@com.exedio.cope.builder.Generated
public abstract class GeneratedSecondPackageItemBuilder<B extends GeneratedSecondPackageItemBuilder<B>>
	extends com.exedio.cope.builder.ItemBuilder<com.exedio.cope.builderSecond.SecondPackageItem, B>
{
	@SuppressWarnings("unused")
	protected GeneratedSecondPackageItemBuilder()
	{
		super(SecondPackageItem.TYPE);
	}

	protected final com.exedio.cope.Settable<java.lang.Integer> field = getFeature("field");

	@com.exedio.cope.builder.Setter
	public final B field(final int field)
	{
		return set(this.field,field);
	}
}
