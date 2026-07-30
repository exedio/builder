package com.exedio.cope.builder.test;

import static com.exedio.cope.instrument.Visibility.NONE;

import com.exedio.cope.EnumField;
import com.exedio.cope.IntegerField;
import com.exedio.cope.Item;
import com.exedio.cope.ItemField;
import com.exedio.cope.StringField;
import com.exedio.cope.builder.other.OuterClass.TestEnum;
import com.exedio.cope.instrument.WrapperType;
import com.exedio.cope.pattern.EnumMapField;
import com.exedio.cope.pattern.Hash;
import com.exedio.cope.pattern.ListField;
import com.exedio.cope.pattern.Media;
import com.exedio.cope.pattern.MessageDigestHashAlgorithm;
import com.exedio.cope.pattern.Money;
import com.exedio.cope.pattern.MoneyField;
import com.exedio.cope.pattern.PriceField;
import com.exedio.cope.pattern.RangeField;

// Copy of FieldsItems with all-optional fields
@WrapperType(constructor=NONE, genericConstructor=NONE)
final class OptionalFieldsItem extends Item
{
	static final Media media = new Media().toFinal().optional();
	static final Hash hash = new Hash(MessageDigestHashAlgorithm.create("MD5", 0, null, 1)).toFinal().optional();
	static final PriceField price = new PriceField().toFinal().optional();
	static final MoneyField<Currency> money = MoneyField.exclusive(EnumField.create(Currency.class)).toFinal().optional();
	static final RangeField<Integer> range = RangeField.create(new IntegerField()).optionalFrom().optionalTo();
	static final EnumMapField<TestEnum,String> enumMap = EnumMapField.create(TestEnum.class, new StringField().toFinal().optional())
		.defaultTo(TestEnum.three,"default3");
	// SetField is always mandatory
	static final ListField<String> list = ListField.create(new StringField().optional());
	// MapField is always mandatory
	static final ItemField<SimpleItem> item = ItemField.create(SimpleItem.class).optional();

	enum Currency implements Money.Currency { EUR, GBP }


	/**
	 * Returns a URL the content of {@link #media} is available under.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="getURL")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final java.lang.String getMediaURL()
	{
		return OptionalFieldsItem.media.getURL(this);
	}

	/**
	 * Returns a Locator the content of {@link #media} is available under.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="getLocator")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final com.exedio.cope.pattern.MediaPath.Locator getMediaLocator()
	{
		return OptionalFieldsItem.media.getLocator(this);
	}

	/**
	 * Returns the content type of the media {@link #media}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="getContentType")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final java.lang.String getMediaContentType()
	{
		return OptionalFieldsItem.media.getContentType(this);
	}

	/**
	 * Returns whether media {@link #media} is null.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="isNull")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final boolean isMediaNull()
	{
		return OptionalFieldsItem.media.isNull(this);
	}

	/**
	 * Returns the last modification date of media {@link #media}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="getLastModified")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final java.util.Date getMediaLastModified()
	{
		return OptionalFieldsItem.media.getLastModified(this);
	}

	/**
	 * Returns the body length of the media {@link #media}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="getLength")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final long getMediaLength()
	{
		return OptionalFieldsItem.media.getLength(this);
	}

	/**
	 * Returns the body of the media {@link #media}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="getBody")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final byte[] getMediaBody()
	{
		return OptionalFieldsItem.media.getBody(this);
	}

	/**
	 * Writes the body of media {@link #media} into the given stream.
	 * Does nothing, if the media is null.
	 * @throws java.io.IOException if accessing {@code body} throws an IOException.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="getBody")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final void getMediaBody(final java.io.OutputStream body)
			throws
				java.io.IOException
	{
		OptionalFieldsItem.media.getBody(this,body);
	}

	/**
	 * Writes the body of media {@link #media} into the given file.
	 * Does nothing, if the media is null.
	 * @throws java.io.IOException if accessing {@code body} throws an IOException.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="getBody")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final void getMediaBody(final java.nio.file.Path body)
			throws
				java.io.IOException
	{
		OptionalFieldsItem.media.getBody(this,body);
	}

	/**
	 * Returns whether the given value corresponds to the hash in {@link #hash}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="check")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final boolean checkHash(final java.lang.String hash)
	{
		return OptionalFieldsItem.hash.check(this,hash);
	}

	/**
	 * Wastes (almost) as much cpu cycles, as a call to {@code checkHash} would have needed.
	 * Needed to prevent Timing Attacks.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="blind")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	static final void blindHash(final java.lang.String hash)
	{
		OptionalFieldsItem.hash.blind(hash);
	}

	/**
	 * Returns the encoded hash value for hash {@link #hash}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="getMD5")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final java.lang.String getHashMD5()
	{
		return OptionalFieldsItem.hash.getHash(this);
	}

	/**
	 * Returns the value of {@link #price}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="get")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final com.exedio.cope.pattern.Price getPrice()
	{
		return OptionalFieldsItem.price.get(this);
	}

	/**
	 * Returns the value of {@link #money}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="get")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final com.exedio.cope.pattern.Money<Currency> getMoney()
	{
		return OptionalFieldsItem.money.get(this);
	}

	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="get")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final com.exedio.cope.pattern.Range<Integer> getRange()
	{
		return OptionalFieldsItem.range.get(this);
	}

	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="set")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final void setRange(final com.exedio.cope.pattern.Range<? extends Integer> range)
			throws
				com.exedio.cope.MandatoryViolationException
	{
		OptionalFieldsItem.range.set(this,range);
	}

	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="getFrom")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final Integer getRangeFrom()
	{
		return OptionalFieldsItem.range.getFrom(this);
	}

	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="getTo")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final Integer getRangeTo()
	{
		return OptionalFieldsItem.range.getTo(this);
	}

	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="setFrom")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final void setRangeFrom(final Integer range)
	{
		OptionalFieldsItem.range.setFrom(this,range);
	}

	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="setTo")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final void setRangeTo(final Integer range)
	{
		OptionalFieldsItem.range.setTo(this,range);
	}

	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="doesContain")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final boolean doesRangeContain(final Integer range)
	{
		return OptionalFieldsItem.range.doesContain(this,range);
	}

	/**
	 * Returns the value mapped to {@code k} by the field map {@link #enumMap}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="get")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final String getEnumMap(final TestEnum k)
	{
		return OptionalFieldsItem.enumMap.get(this,k);
	}

	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="getMap")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final java.util.Map<TestEnum,String> getEnumMapMap()
	{
		return OptionalFieldsItem.enumMap.getMap(this);
	}

	/**
	 * Returns the value of {@link #list}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="get")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final java.util.List<String> getList()
	{
		return OptionalFieldsItem.list.get(this);
	}

	/**
	 * Returns a query for the value of {@link #list}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="getQuery")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final com.exedio.cope.Query<String> getListQuery()
	{
		return OptionalFieldsItem.list.getQuery(this);
	}

	/**
	 * Returns the items, for which field list {@link #list} contains the given element.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="getDistinctParentsOf")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	static final java.util.List<OptionalFieldsItem> getDistinctParentsOfList(final String element)
	{
		return OptionalFieldsItem.list.getDistinctParents(OptionalFieldsItem.class,element);
	}

	/**
	 * Adds a new value for {@link #list}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="addTo")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final void addToList(final String list)
			throws
				com.exedio.cope.StringLengthViolationException,
				java.lang.ClassCastException
	{
		OptionalFieldsItem.list.add(this,list);
	}

	/**
	 * Removes all occurrences of {@code element} from {@link #list}.
	 * @return {@code true} if the field set changed as a result of the call.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="removeAllFrom")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final boolean removeAllFromList(final String list)
	{
		return OptionalFieldsItem.list.removeAll(this,list);
	}

	/**
	 * Sets a new value for {@link #list}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="set")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final void setList(final java.util.Collection<? extends String> list)
			throws
				com.exedio.cope.StringLengthViolationException,
				java.lang.ClassCastException
	{
		OptionalFieldsItem.list.set(this,list);
	}

	/**
	 * Returns the parent field of the type of {@link #list}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="Parent")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	static final com.exedio.cope.ItemField<OptionalFieldsItem> listParent()
	{
		return OptionalFieldsItem.list.getParent(OptionalFieldsItem.class);
	}

	/**
	 * Returns the value of {@link #item}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="get")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final SimpleItem getItem()
	{
		return OptionalFieldsItem.item.get(this);
	}

	/**
	 * Sets a new value for {@link #item}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="set")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final void setItem(final SimpleItem item)
	{
		OptionalFieldsItem.item.set(this,item);
	}

	@com.exedio.cope.instrument.Generated
	@java.io.Serial
	private static final long serialVersionUID = 1L;

	/**
	 * The persistent type information for optionalFieldsItem.
	 */
	@com.exedio.cope.instrument.Generated // customize with @WrapperType(type=...)
	static final com.exedio.cope.Type<OptionalFieldsItem> TYPE = com.exedio.cope.TypesBound.newType(OptionalFieldsItem.class,OptionalFieldsItem::new);

	/**
	 * Activation constructor. Used for internal purposes only.
	 * @see com.exedio.cope.Item#Item(com.exedio.cope.ActivationParameters)
	 */
	@com.exedio.cope.instrument.Generated
	private OptionalFieldsItem(final com.exedio.cope.ActivationParameters ap){super(ap);}
}
