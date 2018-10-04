package com.exedio.cope.builder.test.packagePrivate;

import com.exedio.cope.EnumField;
import com.exedio.cope.ItemField;
import com.exedio.cope.StringField;
import com.exedio.cope.pattern.Composite;

/**
 * @cope.constructor none
 */
final class MyComposite extends Composite
{
	static final StringField string = new StringField();
	static final EnumField<MyEnum> enumF = EnumField.create(MyEnum.class).optional();
	static final ItemField<MyItem> item = ItemField.create(MyItem.class).optional();


	/**
	 * Creates a new MyComposite and sets the given fields initially.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @WrapperType(genericConstructor=...)
	private MyComposite(final com.exedio.cope.SetValue<?>... setValues)
	{
		super(setValues);
	}

	/**
	 * Returns the value of {@link #string}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="get")
	final java.lang.String getString()
	{
		return get(MyComposite.string);
	}

	/**
	 * Sets a new value for {@link #string}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="set")
	final void setString(final java.lang.String string)
			throws
				com.exedio.cope.MandatoryViolationException,
				com.exedio.cope.StringLengthViolationException
	{
		set(MyComposite.string,string);
	}

	/**
	 * Returns the value of {@link #enumF}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="get")
	final MyEnum getEnumF()
	{
		return get(MyComposite.enumF);
	}

	/**
	 * Sets a new value for {@link #enumF}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="set")
	final void setEnumF(final MyEnum enumF)
	{
		set(MyComposite.enumF,enumF);
	}

	/**
	 * Returns the value of {@link #item}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="get")
	final MyItem getItem()
	{
		return get(MyComposite.item);
	}

	/**
	 * Sets a new value for {@link #item}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="set")
	final void setItem(final MyItem item)
	{
		set(MyComposite.item,item);
	}

	@javax.annotation.Generated("com.exedio.cope.instrument")
	private static final long serialVersionUID = 1l;
}
