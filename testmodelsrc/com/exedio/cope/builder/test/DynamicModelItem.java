package com.exedio.cope.builder.test;

import static com.exedio.cope.instrument.Visibility.NONE;

import com.exedio.cope.Item;
import com.exedio.cope.ItemField;
import com.exedio.cope.instrument.WrapperType;
import com.exedio.cope.pattern.DynamicModel;

@WrapperType(constructor=NONE, genericConstructor=NONE)
final class DynamicModelItem extends Item
{
	static final DynamicModel<SimpleItem> features = DynamicModel.create(ItemField.create(SimpleItem.class));

	/**
	 * Returns the dynamic type of this item in the model {@link #features}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="getType")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final com.exedio.cope.pattern.DynamicModel.Type<SimpleItem> getFeaturesType()
	{
		return DynamicModelItem.features.getType(this);
	}

	/**
	 * Sets the dynamic type of this item in the model {@link #features}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="setType")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final void setFeaturesType(final com.exedio.cope.pattern.DynamicModel.Type<SimpleItem> type)
	{
		DynamicModelItem.features.setType(this,type);
	}

	/**
	 * Returns the value of {@code field} for this item in the model {@link #features}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="get")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final java.lang.Object getFeatures(final com.exedio.cope.pattern.DynamicModel.Field<SimpleItem> field)
	{
		return DynamicModelItem.features.get(this,field);
	}

	/**
	 * Sets the value of {@code field} for this item in the model {@link #features}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="set")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final void setFeatures(final com.exedio.cope.pattern.DynamicModel.Field<SimpleItem> field,final java.lang.Object value)
	{
		DynamicModelItem.features.set(this,field,value);
	}

	@com.exedio.cope.instrument.Generated
	private static final long serialVersionUID = 1l;

	/**
	 * The persistent type information for dynamicModelItem.
	 */
	@com.exedio.cope.instrument.Generated // customize with @WrapperType(type=...)
	static final com.exedio.cope.Type<DynamicModelItem> TYPE = com.exedio.cope.TypesBound.newType(DynamicModelItem.class);

	/**
	 * Activation constructor. Used for internal purposes only.
	 * @see com.exedio.cope.Item#Item(com.exedio.cope.ActivationParameters)
	 */
	@com.exedio.cope.instrument.Generated
	private DynamicModelItem(final com.exedio.cope.ActivationParameters ap){super(ap);}
}
