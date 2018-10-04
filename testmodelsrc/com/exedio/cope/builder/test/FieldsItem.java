package com.exedio.cope.builder.test;

import com.exedio.cope.EnumField;
import com.exedio.cope.IntegerField;
import com.exedio.cope.Item;
import com.exedio.cope.StringField;
import com.exedio.cope.builder.other.OuterClass.TestEnum;
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

/**
 * @cope.constructor none
 * @cope.generic.constructor none
 */
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

	enum Currency implements Money.Currency { EUR, GBP }


	/**
	 * Returns a URL the content of {@link #media} is available under.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="getURL")
	final java.lang.String getMediaURL()
	{
		return FieldsItem.media.getURL(this);
	}

	/**
	 * Returns a Locator the content of {@link #media} is available under.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="getLocator")
	final com.exedio.cope.pattern.MediaPath.Locator getMediaLocator()
	{
		return FieldsItem.media.getLocator(this);
	}

	/**
	 * Returns the content type of the media {@link #media}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="getContentType")
	final java.lang.String getMediaContentType()
	{
		return FieldsItem.media.getContentType(this);
	}

	/**
	 * Returns the last modification date of media {@link #media}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="getLastModified")
	final java.util.Date getMediaLastModified()
	{
		return FieldsItem.media.getLastModified(this);
	}

	/**
	 * Returns the body length of the media {@link #media}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="getLength")
	final long getMediaLength()
	{
		return FieldsItem.media.getLength(this);
	}

	/**
	 * Returns the body of the media {@link #media}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="getBody")
	final byte[] getMediaBody()
	{
		return FieldsItem.media.getBody(this);
	}

	/**
	 * Writes the body of media {@link #media} into the given stream.
	 * Does nothing, if the media is null.
	 * @throws java.io.IOException if accessing <tt>body</tt> throws an IOException.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="getBody")
	final void getMediaBody(final java.io.OutputStream body)
			throws
				java.io.IOException
	{
		FieldsItem.media.getBody(this,body);
	}

	/**
	 * Writes the body of media {@link #media} into the given file.
	 * Does nothing, if the media is null.
	 * @throws java.io.IOException if accessing <tt>body</tt> throws an IOException.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="getBody")
	final void getMediaBody(final java.io.File body)
			throws
				java.io.IOException
	{
		FieldsItem.media.getBody(this,body);
	}

	/**
	 * Returns whether the given value corresponds to the hash in {@link #hash}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="check")
	final boolean checkHash(final java.lang.String hash)
	{
		return FieldsItem.hash.check(this,hash);
	}

	/**
	 * Wastes (almost) as much cpu cycles, as a call to <tt>checkHash</tt> would have needed.
	 * Needed to prevent Timing Attacks.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="blind")
	static final void blindHash(final java.lang.String hash)
	{
		FieldsItem.hash.blind(hash);
	}

	/**
	 * Returns the encoded hash value for hash {@link #hash}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="getMD5")
	final java.lang.String getHashMD5()
	{
		return FieldsItem.hash.getHash(this);
	}

	/**
	 * Returns the value of {@link #price}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="get")
	final com.exedio.cope.pattern.Price getPrice()
	{
		return FieldsItem.price.get(this);
	}

	/**
	 * Returns the value of {@link #money}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="get")
	final com.exedio.cope.pattern.Money<Currency> getMoney()
	{
		return FieldsItem.money.get(this);
	}

	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="get")
	final com.exedio.cope.pattern.Range<Integer> getRange()
	{
		return FieldsItem.range.get(this);
	}

	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="set")
	final void setRange(final com.exedio.cope.pattern.Range<? extends Integer> range)
			throws
				com.exedio.cope.MandatoryViolationException
	{
		FieldsItem.range.set(this,range);
	}

	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="getFrom")
	final Integer getRangeFrom()
	{
		return FieldsItem.range.getFrom(this);
	}

	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="getTo")
	final Integer getRangeTo()
	{
		return FieldsItem.range.getTo(this);
	}

	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="setFrom")
	final void setRangeFrom(final Integer range)
			throws
				com.exedio.cope.MandatoryViolationException
	{
		FieldsItem.range.setFrom(this,range);
	}

	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="setTo")
	final void setRangeTo(final Integer range)
			throws
				com.exedio.cope.MandatoryViolationException
	{
		FieldsItem.range.setTo(this,range);
	}

	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="doesContain")
	final boolean doesRangeContain(final Integer range)
	{
		return FieldsItem.range.doesContain(this,range);
	}

	/**
	 * Returns the value mapped to <tt>k</tt> by the field map {@link #enumMap}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="get")
	final String getEnumMap(final TestEnum k)
	{
		return FieldsItem.enumMap.get(this,k);
	}

	/**
	 * Associates <tt>k</tt> to a new value in the field map {@link #enumMap}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="set")
	final void setEnumMap(final TestEnum k,final String enumMap)
	{
		FieldsItem.enumMap.set(this,k,enumMap);
	}

	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="getMap")
	final java.util.Map<TestEnum,String> getEnumMapMap()
	{
		return FieldsItem.enumMap.getMap(this);
	}

	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="setMap")
	final void setEnumMapMap(final java.util.Map<? extends TestEnum,? extends String> enumMap)
	{
		FieldsItem.enumMap.setMap(this,enumMap);
	}

	/**
	 * Returns the value of {@link #set}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="get")
	final java.util.Set<String> getSet()
	{
		return FieldsItem.set.get(this);
	}

	/**
	 * Returns a query for the value of {@link #set}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="getQuery")
	final com.exedio.cope.Query<String> getSetQuery()
	{
		return FieldsItem.set.getQuery(this);
	}

	/**
	 * Returns the items, for which field set {@link #set} contains the given element.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="getParentsOf")
	static final java.util.List<FieldsItem> getParentsOfSet(final String element)
	{
		return FieldsItem.set.getParents(FieldsItem.class,element);
	}

	/**
	 * Sets a new value for {@link #set}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="set")
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
	 * @return <tt>true</tt> if the field set changed as a result of the call.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="addTo")
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
	 * @return <tt>true</tt> if the field set changed as a result of the call.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="removeFrom")
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
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="Parent")
	static final com.exedio.cope.ItemField<FieldsItem> setParent()
	{
		return FieldsItem.set.getParent(FieldsItem.class);
	}

	/**
	 * Returns the value of {@link #list}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="get")
	final java.util.List<String> getList()
	{
		return FieldsItem.list.get(this);
	}

	/**
	 * Returns a query for the value of {@link #list}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="getQuery")
	final com.exedio.cope.Query<String> getListQuery()
	{
		return FieldsItem.list.getQuery(this);
	}

	/**
	 * Returns the items, for which field list {@link #list} contains the given element.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="getDistinctParentsOf")
	static final java.util.List<FieldsItem> getDistinctParentsOfList(final String element)
	{
		return FieldsItem.list.getDistinctParents(FieldsItem.class,element);
	}

	/**
	 * Adds a new value for {@link #list}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="addTo")
	final void addToList(final String list)
			throws
				com.exedio.cope.MandatoryViolationException,
				com.exedio.cope.StringLengthViolationException,
				java.lang.ClassCastException
	{
		FieldsItem.list.add(this,list);
	}

	/**
	 * Sets a new value for {@link #list}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="set")
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
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="Parent")
	static final com.exedio.cope.ItemField<FieldsItem> listParent()
	{
		return FieldsItem.list.getParent(FieldsItem.class);
	}

	/**
	 * Returns the value mapped to <tt>k</tt> by the field map {@link #map}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="get")
	final String getMap(final String k)
	{
		return FieldsItem.map.get(this,k);
	}

	/**
	 * Associates <tt>k</tt> to a new value in the field map {@link #map}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="set")
	final void setMap(final String k,final String map)
	{
		FieldsItem.map.set(this,k,map);
	}

	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="getMap")
	final java.util.Map<String,String> getMapMap()
	{
		return FieldsItem.map.getMap(this);
	}

	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="setMap")
	final void setMapMap(final java.util.Map<? extends String,? extends String> map)
	{
		FieldsItem.map.setMap(this,map);
	}

	/**
	 * Returns the parent field of the type of {@link #map}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="Parent")
	static final com.exedio.cope.ItemField<FieldsItem> mapParent()
	{
		return FieldsItem.map.getParent(FieldsItem.class);
	}

	@javax.annotation.Generated("com.exedio.cope.instrument")
	private static final long serialVersionUID = 1l;

	/**
	 * The persistent type information for fieldsItem.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @WrapperType(type=...)
	static final com.exedio.cope.Type<FieldsItem> TYPE = com.exedio.cope.TypesBound.newType(FieldsItem.class);

	/**
	 * Activation constructor. Used for internal purposes only.
	 * @see com.exedio.cope.Item#Item(com.exedio.cope.ActivationParameters)
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument")
	private FieldsItem(final com.exedio.cope.ActivationParameters ap){super(ap);}
}
