package com.exedio.cope.builder.test;

import static com.exedio.cope.instrument.Visibility.NONE;

import com.exedio.cope.IntegerField;
import com.exedio.cope.Item;
import com.exedio.cope.ItemField;
import com.exedio.cope.instrument.WrapperType;
import com.exedio.cope.pattern.PartOf;

@WrapperType(constructor=NONE, genericConstructor=NONE)
final class UnknownPatternItem extends Item
{
	static final ItemField<SimpleItem> parent = ItemField.create(SimpleItem.class).toFinal();
	static final IntegerField order = new IntegerField().toFinal();
	static final PartOf<SimpleItem> unknowns = PartOf.create(parent, order);

	/**
	 * Returns the value of {@link #parent}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="get")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final SimpleItem getParent()
	{
		return UnknownPatternItem.parent.get(this);
	}

	/**
	 * Returns the value of {@link #order}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="get")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final int getOrder()
	{
		return UnknownPatternItem.order.getMandatory(this);
	}

	/**
	 * Returns the container this item is part of by {@link #unknowns}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="getContainer")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final SimpleItem getUnknownsContainer()
	{
		return UnknownPatternItem.unknowns.getContainer(this);
	}

	/**
	 * Returns the parts of the given container.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="getParts")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	static final java.util.List<UnknownPatternItem> getUnknownsParts(final SimpleItem container)
	{
		return UnknownPatternItem.unknowns.getParts(UnknownPatternItem.class,container);
	}

	/**
	 * Returns the parts of the given container matching the given condition.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="getParts")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	static final java.util.List<UnknownPatternItem> getUnknownsParts(final SimpleItem container,final com.exedio.cope.Condition condition)
	{
		return UnknownPatternItem.unknowns.getParts(UnknownPatternItem.class,container,condition);
	}

	@com.exedio.cope.instrument.Generated
	private static final long serialVersionUID = 1l;

	/**
	 * The persistent type information for unknownPatternItem.
	 */
	@com.exedio.cope.instrument.Generated // customize with @WrapperType(type=...)
	static final com.exedio.cope.Type<UnknownPatternItem> TYPE = com.exedio.cope.TypesBound.newType(UnknownPatternItem.class);

	/**
	 * Activation constructor. Used for internal purposes only.
	 * @see com.exedio.cope.Item#Item(com.exedio.cope.ActivationParameters)
	 */
	@com.exedio.cope.instrument.Generated
	private UnknownPatternItem(final com.exedio.cope.ActivationParameters ap){super(ap);}
}
