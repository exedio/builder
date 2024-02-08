package com.exedio.cope.builder.test;

import com.exedio.cope.Item;
import com.exedio.cope.StringField;
import com.exedio.cope.instrument.WrapperType;
import com.exedio.cope.pattern.EnumMapField;

import static com.exedio.cope.instrument.Visibility.NONE;

@WrapperType(constructor = NONE, genericConstructor = NONE)
final class PackageNameConflictItem extends Item {
    enum AEnum {
        com, net, de, java
    }

    static final EnumMapField<AEnum, String> enumField = EnumMapField.create(AEnum.class, new StringField());

	/**
	 * Returns the value mapped to {@code k} by the field map {@link #enumField}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="get")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final String getEnumField(final AEnum k)
	{
		return PackageNameConflictItem.enumField.get(this,k);
	}

	/**
	 * Associates {@code k} to a new value in the field map {@link #enumField}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="set")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final void setEnumField(final AEnum k,final String enumField)
	{
		PackageNameConflictItem.enumField.set(this,k,enumField);
	}

	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="getMap")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final java.util.Map<AEnum,String> getEnumFieldMap()
	{
		return PackageNameConflictItem.enumField.getMap(this);
	}

	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="setMap")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final void setEnumFieldMap(final java.util.Map<? extends AEnum,? extends String> enumField)
	{
		PackageNameConflictItem.enumField.setMap(this,enumField);
	}

	@com.exedio.cope.instrument.Generated
	private static final long serialVersionUID = 1l;

	/**
	 * The persistent type information for packageNameConflictItem.
	 */
	@com.exedio.cope.instrument.Generated // customize with @WrapperType(type=...)
	static final com.exedio.cope.Type<PackageNameConflictItem> TYPE = com.exedio.cope.TypesBound.newType(PackageNameConflictItem.class);

	/**
	 * Activation constructor. Used for internal purposes only.
	 * @see com.exedio.cope.Item#Item(com.exedio.cope.ActivationParameters)
	 */
	@com.exedio.cope.instrument.Generated
	private PackageNameConflictItem(final com.exedio.cope.ActivationParameters ap){super(ap);}
}
