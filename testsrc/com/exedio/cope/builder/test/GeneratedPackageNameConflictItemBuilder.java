package com.exedio.cope.builder.test;

@SuppressWarnings({"ClassEscapesDefinedScope", "RedundantSuppression"})
@com.exedio.cope.builder.Generated
public abstract class GeneratedPackageNameConflictItemBuilder<B extends GeneratedPackageNameConflictItemBuilder<B>>
	extends com.exedio.cope.builder.ItemBuilder<com.exedio.cope.builder.test.PackageNameConflictItem, B>
{
	@SuppressWarnings("unused")
	protected GeneratedPackageNameConflictItemBuilder()
	{
		super(PackageNameConflictItem.TYPE);
	}

	protected final com.exedio.cope.pattern.EnumMapField<com.exedio.cope.builder.test.PackageNameConflictItem.AEnum,java.lang.String> enumField = getFeature("enumField");

	@com.exedio.cope.builder.Setter
	public final B enumField(final java.util.Map<com.exedio.cope.builder.test.PackageNameConflictItem.AEnum,java.lang.String> enumField)
	{
		enumField.forEach(this::enumField);
		return self();
	}

	@com.exedio.cope.builder.Setter
	public final B enumField(final com.exedio.cope.builder.test.PackageNameConflictItem.AEnum key, final java.lang.String value)
	{
		return set(this.enumField.getField(key), value);
	}

	@com.exedio.cope.builder.Setter
	public final B enumFieldCom(final java.lang.String _com)
	{
		return enumField(com.exedio.cope.builder.test.PackageNameConflictItem.AEnum.com,_com);
	}

	@com.exedio.cope.builder.Setter
	public final B enumFieldNet(final java.lang.String net)
	{
		return enumField(com.exedio.cope.builder.test.PackageNameConflictItem.AEnum.net,net);
	}

	@com.exedio.cope.builder.Setter
	public final B enumFieldDe(final java.lang.String de)
	{
		return enumField(com.exedio.cope.builder.test.PackageNameConflictItem.AEnum.de,de);
	}

	@com.exedio.cope.builder.Setter
	public final B enumFieldJava(final java.lang.String java)
	{
		return enumField(com.exedio.cope.builder.test.PackageNameConflictItem.AEnum.java,java);
	}
}
