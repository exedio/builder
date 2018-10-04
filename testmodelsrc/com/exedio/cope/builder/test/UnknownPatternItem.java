package com.exedio.cope.builder.test;

import com.exedio.cope.IntegerField;
import com.exedio.cope.Item;
import com.exedio.cope.ItemField;
import com.exedio.cope.pattern.PartOf;

/**
 * @cope.constructor none
 * @cope.generic.constructor none
 */
final class UnknownPatternItem extends Item
{
	static final ItemField<SimpleItem> parent = ItemField.create(SimpleItem.class).toFinal();
	static final IntegerField order = new IntegerField().toFinal();
	static final PartOf<SimpleItem> unknowns = PartOf.create(parent, order);

	/**
	 * Returns the value of {@link #parent}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="get")
	final SimpleItem getParent()
	{
		return UnknownPatternItem.parent.get(this);
	}

	/**
	 * Returns the value of {@link #order}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="get")
	final int getOrder()
	{
		return UnknownPatternItem.order.getMandatory(this);
	}

	/**
	 * Returns the container this item is part of by {@link #unknowns}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="getContainer")
	final SimpleItem getUnknownsContainer()
	{
		return UnknownPatternItem.unknowns.getContainer(this);
	}

	/**
	 * Returns the parts of the given container.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="getParts")
	static final java.util.List<UnknownPatternItem> getUnknownsParts(final SimpleItem container)
	{
		return UnknownPatternItem.unknowns.getParts(UnknownPatternItem.class,container);
	}

	/**
	 * Returns the parts of the given container matching the given condition.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="getParts")
	static final java.util.List<UnknownPatternItem> getUnknownsParts(final SimpleItem container,final com.exedio.cope.Condition condition)
	{
		return UnknownPatternItem.unknowns.getParts(UnknownPatternItem.class,container,condition);
	}

	@javax.annotation.Generated("com.exedio.cope.instrument")
	private static final long serialVersionUID = 1l;

	/**
	 * The persistent type information for unknownPatternItem.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @WrapperType(type=...)
	static final com.exedio.cope.Type<UnknownPatternItem> TYPE = com.exedio.cope.TypesBound.newType(UnknownPatternItem.class);

	/**
	 * Activation constructor. Used for internal purposes only.
	 * @see com.exedio.cope.Item#Item(com.exedio.cope.ActivationParameters)
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument")
	private UnknownPatternItem(final com.exedio.cope.ActivationParameters ap){super(ap);}
}
