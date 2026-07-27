package com.exedio.cope.builder.test;

@SuppressWarnings({"ClassEscapesDefinedScope", "RedundantSuppression"})
@com.exedio.cope.builder.Generated
public abstract class GeneratedJarItemBuilder<B extends GeneratedJarItemBuilder<B>>
	extends com.exedio.cope.builder.ItemBuilder<com.exedio.cope.builder.test.JarItem, B>
{
	@SuppressWarnings("unused")
	protected GeneratedJarItemBuilder()
	{
		super(JarItem.TYPE);
	}

	protected final com.exedio.cope.Settable<java.lang.Integer> field = getFeature("field");

	@com.exedio.cope.builder.Setter
	public final B field(final int field)
	{
		return set(this.field,field);
	}
}
