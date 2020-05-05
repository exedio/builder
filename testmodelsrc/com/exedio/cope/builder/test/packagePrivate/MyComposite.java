package com.exedio.cope.builder.test.packagePrivate;

import static com.exedio.cope.instrument.Visibility.NONE;

import com.exedio.cope.EnumField;
import com.exedio.cope.ItemField;
import com.exedio.cope.StringField;
import com.exedio.cope.instrument.WrapperType;
import com.exedio.cope.pattern.Composite;

@WrapperType(constructor=NONE)
final class MyComposite extends Composite
{
	static final StringField string = new StringField();
	static final EnumField<MyEnum> enumF = EnumField.create(MyEnum.class).optional();
	static final ItemField<MyItem> item = ItemField.create(MyItem.class).optional();


	/**
	 * Creates a new MyComposite and sets the given fields initially.
	 */
	@com.exedio.cope.instrument.Generated // customize with @WrapperType(genericConstructor=...)
	private MyComposite(final com.exedio.cope.SetValue<?>... setValues){super(setValues);}

	/**
	 * Returns the value of {@link #string}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="get")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final java.lang.String getString()
	{
		return get(MyComposite.string);
	}

	/**
	 * Sets a new value for {@link #string}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="set")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
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
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="get")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final MyEnum getEnumF()
	{
		return get(MyComposite.enumF);
	}

	/**
	 * Sets a new value for {@link #enumF}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="set")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final void setEnumF(final MyEnum enumF)
	{
		set(MyComposite.enumF,enumF);
	}

	/**
	 * Returns the value of {@link #item}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="get")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final MyItem getItem()
	{
		return get(MyComposite.item);
	}

	/**
	 * Sets a new value for {@link #item}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="set")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final void setItem(final MyItem item)
	{
		set(MyComposite.item,item);
	}

	@com.exedio.cope.instrument.Generated
	private static final long serialVersionUID = 1l;
}
