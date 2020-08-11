package com.exedio.cope.builder.test;

import static com.exedio.cope.instrument.Visibility.NONE;

import com.exedio.cope.EnumField;
import com.exedio.cope.IntegerField;
import com.exedio.cope.Item;
import com.exedio.cope.ItemField;
import com.exedio.cope.StringField;
import com.exedio.cope.builder.other.OuterClass.TestEnum;
import com.exedio.cope.builder.skipped.SkippedBecauseTargetDirectoryDoesNotExistsItem;
import com.exedio.cope.builderSkipped.SkippedBecauseNotInPackagePrefixItem;
import com.exedio.cope.instrument.WrapperType;
import com.exedio.cope.pattern.EnumMapField;
import com.exedio.cope.pattern.Hash;
import com.exedio.cope.pattern.ListField;
import com.exedio.cope.pattern.MapField;
import com.exedio.cope.pattern.Media;
import com.exedio.cope.pattern.MessageDigestAlgorithm;
import com.exedio.cope.pattern.Money;
import com.exedio.cope.pattern.MoneyField;
import com.exedio.cope.pattern.PriceField;
import com.exedio.cope.pattern.RangeField;
import com.exedio.cope.pattern.SetField;

@WrapperType(constructor=NONE, genericConstructor=NONE)
final class FieldsItem extends Item
{
	static final Media media = new Media().toFinal();
	static final Hash hash = new Hash(new MessageDigestAlgorithm("MD5", 0, 1)).toFinal();
	static final PriceField price = new PriceField().toFinal();
	static final MoneyField<Currency> money = MoneyField.exclusive(EnumField.create(Currency.class)).toFinal();
	static final RangeField<Integer> range = RangeField.create(new IntegerField());
	static final EnumMapField<TestEnum,String> enumMap = EnumMapField.create(TestEnum.class, new StringField().toFinal())
		.defaultTo(TestEnum.three,"default3");
	static final SetField<String> set = SetField.create(new StringField());
	static final ListField<String> list = ListField.create(new StringField());
	static final MapField<String,String> map = MapField.create(new StringField().toFinal(), new StringField().toFinal());
	static final ItemField<SkippedBecauseTargetDirectoryDoesNotExistsItem> skippedMissing=
		ItemField.create(SkippedBecauseTargetDirectoryDoesNotExistsItem.class).optional();
	static final ItemField<SkippedBecauseNotInPackagePrefixItem> skippedExcluded=
		ItemField.create(SkippedBecauseNotInPackagePrefixItem.class).optional();

	enum Currency implements Money.Currency { EUR, GBP }


	/**
	 * Returns a URL the content of {@link #media} is available under.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="getURL")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final java.lang.String getMediaURL()
	{
		return FieldsItem.media.getURL(this);
	}

	/**
	 * Returns a Locator the content of {@link #media} is available under.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="getLocator")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final com.exedio.cope.pattern.MediaPath.Locator getMediaLocator()
	{
		return FieldsItem.media.getLocator(this);
	}

	/**
	 * Returns the content type of the media {@link #media}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="getContentType")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final java.lang.String getMediaContentType()
	{
		return FieldsItem.media.getContentType(this);
	}

	/**
	 * Returns the last modification date of media {@link #media}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="getLastModified")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final java.util.Date getMediaLastModified()
	{
		return FieldsItem.media.getLastModified(this);
	}

	/**
	 * Returns the body length of the media {@link #media}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="getLength")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final long getMediaLength()
	{
		return FieldsItem.media.getLength(this);
	}

	/**
	 * Returns the body of the media {@link #media}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="getBody")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final byte[] getMediaBody()
	{
		return FieldsItem.media.getBody(this);
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
		FieldsItem.media.getBody(this,body);
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
		FieldsItem.media.getBody(this,body);
	}

	/**
	 * Writes the body of media {@link #media} into the given file.
	 * Does nothing, if the media is null.
	 * @throws java.io.IOException if accessing {@code body} throws an IOException.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="getBody")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final void getMediaBody(final java.io.File body)
			throws
				java.io.IOException
	{
		FieldsItem.media.getBody(this,body);
	}

	/**
	 * Returns whether the given value corresponds to the hash in {@link #hash}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="check")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final boolean checkHash(final java.lang.String hash)
	{
		return FieldsItem.hash.check(this,hash);
	}

	/**
	 * Wastes (almost) as much cpu cycles, as a call to {@code checkHash} would have needed.
	 * Needed to prevent Timing Attacks.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="blind")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	static final void blindHash(final java.lang.String hash)
	{
		FieldsItem.hash.blind(hash);
	}

	/**
	 * Returns the encoded hash value for hash {@link #hash}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="getMD5")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final java.lang.String getHashMD5()
	{
		return FieldsItem.hash.getHash(this);
	}

	/**
	 * Returns the value of {@link #price}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="get")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final com.exedio.cope.pattern.Price getPrice()
	{
		return FieldsItem.price.get(this);
	}

	/**
	 * Returns the value of {@link #money}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="get")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final com.exedio.cope.pattern.Money<Currency> getMoney()
	{
		return FieldsItem.money.get(this);
	}

	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="get")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final com.exedio.cope.pattern.Range<Integer> getRange()
	{
		return FieldsItem.range.get(this);
	}

	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="set")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final void setRange(final com.exedio.cope.pattern.Range<? extends Integer> range)
			throws
				com.exedio.cope.MandatoryViolationException
	{
		FieldsItem.range.set(this,range);
	}

	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="getFrom")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final Integer getRangeFrom()
	{
		return FieldsItem.range.getFrom(this);
	}

	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="getTo")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final Integer getRangeTo()
	{
		return FieldsItem.range.getTo(this);
	}

	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="setFrom")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final void setRangeFrom(final Integer range)
			throws
				com.exedio.cope.MandatoryViolationException
	{
		FieldsItem.range.setFrom(this,range);
	}

	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="setTo")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final void setRangeTo(final Integer range)
			throws
				com.exedio.cope.MandatoryViolationException
	{
		FieldsItem.range.setTo(this,range);
	}

	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="doesContain")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final boolean doesRangeContain(final Integer range)
	{
		return FieldsItem.range.doesContain(this,range);
	}

	/**
	 * Returns the value mapped to {@code k} by the field map {@link #enumMap}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="get")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final String getEnumMap(final TestEnum k)
	{
		return FieldsItem.enumMap.get(this,k);
	}

	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="getMap")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final java.util.Map<TestEnum,String> getEnumMapMap()
	{
		return FieldsItem.enumMap.getMap(this);
	}

	/**
	 * Returns the value of {@link #set}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="get")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final java.util.Set<String> getSet()
	{
		return FieldsItem.set.get(this);
	}

	/**
	 * Returns a query for the value of {@link #set}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="getQuery")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final com.exedio.cope.Query<String> getSetQuery()
	{
		return FieldsItem.set.getQuery(this);
	}

	/**
	 * Returns the items, for which field set {@link #set} contains the given element.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="getParentsOf")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	static final java.util.List<FieldsItem> getParentsOfSet(final String element)
	{
		return FieldsItem.set.getParents(FieldsItem.class,element);
	}

	/**
	 * Sets a new value for {@link #set}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="set")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final void setSet(final java.util.Collection<? extends String> set)
			throws
				com.exedio.cope.MandatoryViolationException,
				com.exedio.cope.StringLengthViolationException,
				java.lang.ClassCastException
	{
		FieldsItem.set.set(this,set);
	}

	/**
	 * Adds a new element to {@link #set}.
	 * @return {@code true} if the field set changed as a result of the call.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="addTo")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final boolean addToSet(final String element)
			throws
				com.exedio.cope.MandatoryViolationException,
				com.exedio.cope.StringLengthViolationException,
				java.lang.ClassCastException
	{
		return FieldsItem.set.add(this,element);
	}

	/**
	 * Removes an element from {@link #set}.
	 * @return {@code true} if the field set changed as a result of the call.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="removeFrom")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final boolean removeFromSet(final String element)
			throws
				com.exedio.cope.MandatoryViolationException,
				com.exedio.cope.StringLengthViolationException,
				java.lang.ClassCastException
	{
		return FieldsItem.set.remove(this,element);
	}

	/**
	 * Returns the parent field of the type of {@link #set}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="Parent")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	static final com.exedio.cope.ItemField<FieldsItem> setParent()
	{
		return FieldsItem.set.getParent(FieldsItem.class);
	}

	/**
	 * Returns the value of {@link #list}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="get")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final java.util.List<String> getList()
	{
		return FieldsItem.list.get(this);
	}

	/**
	 * Returns a query for the value of {@link #list}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="getQuery")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final com.exedio.cope.Query<String> getListQuery()
	{
		return FieldsItem.list.getQuery(this);
	}

	/**
	 * Returns the items, for which field list {@link #list} contains the given element.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="getDistinctParentsOf")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	static final java.util.List<FieldsItem> getDistinctParentsOfList(final String element)
	{
		return FieldsItem.list.getDistinctParents(FieldsItem.class,element);
	}

	/**
	 * Adds a new value for {@link #list}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="addTo")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final void addToList(final String list)
			throws
				com.exedio.cope.MandatoryViolationException,
				com.exedio.cope.StringLengthViolationException,
				java.lang.ClassCastException
	{
		FieldsItem.list.add(this,list);
	}

	/**
	 * Removes all occurrences of {@code element} from {@link #list}.
	 * @return {@code true} if the field set changed as a result of the call.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="removeAllFrom")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final boolean removeAllFromList(final String list)
	{
		return FieldsItem.list.removeAll(this,list);
	}

	/**
	 * Sets a new value for {@link #list}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="set")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final void setList(final java.util.Collection<? extends String> list)
			throws
				com.exedio.cope.MandatoryViolationException,
				com.exedio.cope.StringLengthViolationException,
				java.lang.ClassCastException
	{
		FieldsItem.list.set(this,list);
	}

	/**
	 * Returns the parent field of the type of {@link #list}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="Parent")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	static final com.exedio.cope.ItemField<FieldsItem> listParent()
	{
		return FieldsItem.list.getParent(FieldsItem.class);
	}

	/**
	 * Returns the value mapped to {@code k} by the field map {@link #map}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="get")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final String getMap(final String k)
	{
		return FieldsItem.map.get(this,k);
	}

	/**
	 * Associates {@code k} to a new value in the field map {@link #map}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="set")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final void setMap(final String k,final String map)
	{
		FieldsItem.map.set(this,k,map);
	}

	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="getMap")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final java.util.Map<String,String> getMapMap()
	{
		return FieldsItem.map.getMap(this);
	}

	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="setMap")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final void setMapMap(final java.util.Map<? extends String,? extends String> map)
	{
		FieldsItem.map.setMap(this,map);
	}

	/**
	 * Returns the parent field of the type of {@link #map}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="Parent")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	static final com.exedio.cope.ItemField<FieldsItem> mapParent()
	{
		return FieldsItem.map.getParent(FieldsItem.class);
	}

	/**
	 * Returns the value of {@link #skippedMissing}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="get")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final SkippedBecauseTargetDirectoryDoesNotExistsItem getSkippedMissing()
	{
		return FieldsItem.skippedMissing.get(this);
	}

	/**
	 * Sets a new value for {@link #skippedMissing}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="set")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final void setSkippedMissing(final SkippedBecauseTargetDirectoryDoesNotExistsItem skippedMissing)
	{
		FieldsItem.skippedMissing.set(this,skippedMissing);
	}

	/**
	 * Returns the value of {@link #skippedExcluded}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="get")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final SkippedBecauseNotInPackagePrefixItem getSkippedExcluded()
	{
		return FieldsItem.skippedExcluded.get(this);
	}

	/**
	 * Sets a new value for {@link #skippedExcluded}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="set")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final void setSkippedExcluded(final SkippedBecauseNotInPackagePrefixItem skippedExcluded)
	{
		FieldsItem.skippedExcluded.set(this,skippedExcluded);
	}

	@com.exedio.cope.instrument.Generated
	private static final long serialVersionUID = 1l;

	/**
	 * The persistent type information for fieldsItem.
	 */
	@com.exedio.cope.instrument.Generated // customize with @WrapperType(type=...)
	static final com.exedio.cope.Type<FieldsItem> TYPE = com.exedio.cope.TypesBound.newType(FieldsItem.class);

	/**
	 * Activation constructor. Used for internal purposes only.
	 * @see com.exedio.cope.Item#Item(com.exedio.cope.ActivationParameters)
	 */
	@com.exedio.cope.instrument.Generated
	private FieldsItem(final com.exedio.cope.ActivationParameters ap){super(ap);}
}
