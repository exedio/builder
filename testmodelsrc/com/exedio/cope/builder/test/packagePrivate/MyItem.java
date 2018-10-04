package com.exedio.cope.builder.test.packagePrivate;

import static com.exedio.cope.instrument.Visibility.NONE;

import com.exedio.cope.EnumField;
import com.exedio.cope.Item;
import com.exedio.cope.ItemField;
import com.exedio.cope.instrument.WrapperType;
import com.exedio.cope.pattern.CompositeField;
import com.exedio.cope.pattern.Money;
import com.exedio.cope.pattern.MoneyField;
import com.exedio.cope.pattern.RangeField;

@WrapperType(constructor=NONE, genericConstructor=NONE)
final class MyItem extends Item implements Money.Currency
{
	static final EnumField<MyEnum> enumF = EnumField.create(MyEnum.class).optional();
	static final ItemField<MyItem> item = ItemField.create(MyItem.class).optional();
	static final CompositeField<MyComposite> composite = CompositeField.create(MyComposite.class).optional();

	static final RangeField<MyEnum> rangeEnum = RangeField.create(EnumField.create(MyEnum.class).optional());
	//static final RangeField<MyItem> rangeItem = RangeField.create(ItemField.create(MyItem.class).optional()); TODO not yet supported by cope

	static final MoneyField<MyEnum> moneyEnum = MoneyField.exclusive(EnumField.create(MyEnum.class)).optional();
	static final MoneyField<MyItem> moneyItem = MoneyField.exclusive(ItemField.create(MyItem.class)).optional();


	/**
	 * Returns the value of {@link #enumF}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="get")
	final MyEnum getEnumF()
	{
		return MyItem.enumF.get(this);
	}

	/**
	 * Sets a new value for {@link #enumF}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="set")
	final void setEnumF(final MyEnum enumF)
	{
		MyItem.enumF.set(this,enumF);
	}

	/**
	 * Returns the value of {@link #item}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="get")
	final MyItem getItem()
	{
		return MyItem.item.get(this);
	}

	/**
	 * Sets a new value for {@link #item}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="set")
	final void setItem(final MyItem item)
	{
		MyItem.item.set(this,item);
	}

	/**
	 * Returns the value of {@link #composite}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="get")
	final MyComposite getComposite()
	{
		return MyItem.composite.get(this);
	}

	/**
	 * Sets a new value for {@link #composite}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="set")
	final void setComposite(final MyComposite composite)
	{
		MyItem.composite.set(this,composite);
	}

	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="get")
	final com.exedio.cope.pattern.Range<MyEnum> getRangeEnum()
	{
		return MyItem.rangeEnum.get(this);
	}

	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="set")
	final void setRangeEnum(final com.exedio.cope.pattern.Range<? extends MyEnum> rangeEnum)
	{
		MyItem.rangeEnum.set(this,rangeEnum);
	}

	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="getFrom")
	final MyEnum getRangeEnumFrom()
	{
		return MyItem.rangeEnum.getFrom(this);
	}

	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="getTo")
	final MyEnum getRangeEnumTo()
	{
		return MyItem.rangeEnum.getTo(this);
	}

	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="setFrom")
	final void setRangeEnumFrom(final MyEnum rangeEnum)
	{
		MyItem.rangeEnum.setFrom(this,rangeEnum);
	}

	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="setTo")
	final void setRangeEnumTo(final MyEnum rangeEnum)
	{
		MyItem.rangeEnum.setTo(this,rangeEnum);
	}

	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="doesContain")
	final boolean doesRangeEnumContain(final MyEnum rangeEnum)
	{
		return MyItem.rangeEnum.doesContain(this,rangeEnum);
	}

	/**
	 * Returns the value of {@link #moneyEnum}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="get")
	final com.exedio.cope.pattern.Money<MyEnum> getMoneyEnum()
	{
		return MyItem.moneyEnum.get(this);
	}

	/**
	 * Sets a new value for {@link #moneyEnum}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="set")
	final void setMoneyEnum(final com.exedio.cope.pattern.Money<MyEnum> moneyEnum)
	{
		MyItem.moneyEnum.set(this,moneyEnum);
	}

	/**
	 * Returns the value of {@link #moneyItem}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="get")
	final com.exedio.cope.pattern.Money<MyItem> getMoneyItem()
	{
		return MyItem.moneyItem.get(this);
	}

	/**
	 * Sets a new value for {@link #moneyItem}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="set")
	final void setMoneyItem(final com.exedio.cope.pattern.Money<MyItem> moneyItem)
	{
		MyItem.moneyItem.set(this,moneyItem);
	}

	@javax.annotation.Generated("com.exedio.cope.instrument")
	private static final long serialVersionUID = 1l;

	/**
	 * The persistent type information for myItem.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @WrapperType(type=...)
	static final com.exedio.cope.Type<MyItem> TYPE = com.exedio.cope.TypesBound.newType(MyItem.class);

	/**
	 * Activation constructor. Used for internal purposes only.
	 * @see com.exedio.cope.Item#Item(com.exedio.cope.ActivationParameters)
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument")
	private MyItem(final com.exedio.cope.ActivationParameters ap){super(ap);}
}
