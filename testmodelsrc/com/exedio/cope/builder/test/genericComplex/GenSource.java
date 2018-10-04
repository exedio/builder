package com.exedio.cope.builder.test.genericComplex;

import com.exedio.cope.Item;
import com.exedio.cope.ItemField;
import com.exedio.cope.pattern.ListField;
import com.exedio.cope.pattern.MapField;
import com.exedio.cope.pattern.MoneyField;
import com.exedio.cope.pattern.SetField;

final class GenSource extends Item
{
	static final ItemField<GenSup<?,?>> sup = ItemField.create(GenSup.classWildcard.value).optional();
	static final ItemField<GenMid<?>>   mid = ItemField.create(GenMid.classWildcard.value).optional();
	static final ItemField<GenSub>      sub = ItemField.create(GenSub.class).optional();

	static final MoneyField<GenSup<?,?>> moneySup = MoneyField.exclusive(ItemField.create(GenSup.classWildcard.value)).optional();
	static final MoneyField<GenMid<?>>   moneyMid = MoneyField.exclusive(ItemField.create(GenMid.classWildcard.value)).optional();
	static final MoneyField<GenSub>      moneySub = MoneyField.exclusive(ItemField.create(GenSub.class)).optional();

	static final SetField<GenSup<?,?>> setSup = SetField.create(ItemField.create(GenSup.classWildcard.value));
	static final SetField<GenMid<?>>   setMid = SetField.create(ItemField.create(GenMid.classWildcard.value));
	static final SetField<GenSub>      setSub = SetField.create(ItemField.create(GenSub.class));

	static final ListField<GenSup<?,?>> listSup = ListField.create(ItemField.create(GenSup.classWildcard.value));
	static final ListField<GenMid<?>>   listMid = ListField.create(ItemField.create(GenMid.classWildcard.value));
	static final ListField<GenSub>      listSub = ListField.create(ItemField.create(GenSub.class));

	static final ItemField<GenSub>      subFallback = ItemField.create(GenSub.class).optional();
	static final ItemField<GenSub>      subMandatory = ItemField.create(GenSub.class);

	static final MapField<GenSup<?,?>,GenSup<?,?>> mapSup = MapField.create(ItemField.create(GenSup.classWildcard.value), ItemField.create(GenSup.classWildcard.value));
	static final MapField<GenMid<?>,  GenMid<?>>   mapMid = MapField.create(ItemField.create(GenMid.classWildcard.value), ItemField.create(GenMid.classWildcard.value));
	static final MapField<GenSub,     GenSub>      mapSub = MapField.create(ItemField.create(GenSub.class),               ItemField.create(GenSub.class));


	/**
	 * Creates a new GenSource with all the fields initially needed.
	 * @param subMandatory the initial value for field {@link #subMandatory}.
	 * @throws com.exedio.cope.MandatoryViolationException if subMandatory is null.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @WrapperType(constructor=...) and @WrapperInitial
	GenSource(
				final GenSub subMandatory)
			throws
				com.exedio.cope.MandatoryViolationException
	{
		this(new com.exedio.cope.SetValue<?>[]{
			GenSource.subMandatory.map(subMandatory),
		});
	}

	/**
	 * Creates a new GenSource and sets the given fields initially.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @WrapperType(genericConstructor=...)
	private GenSource(final com.exedio.cope.SetValue<?>... setValues)
	{
		super(setValues);
	}

	/**
	 * Returns the value of {@link #sup}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="get")
	final GenSup<?,?> getSup()
	{
		return GenSource.sup.get(this);
	}

	/**
	 * Sets a new value for {@link #sup}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="set")
	final void setSup(final GenSup<?,?> sup)
	{
		GenSource.sup.set(this,sup);
	}

	/**
	 * Returns the value of {@link #mid}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="get")
	final GenMid<?> getMid()
	{
		return GenSource.mid.get(this);
	}

	/**
	 * Sets a new value for {@link #mid}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="set")
	final void setMid(final GenMid<?> mid)
	{
		GenSource.mid.set(this,mid);
	}

	/**
	 * Returns the value of {@link #sub}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="get")
	final GenSub getSub()
	{
		return GenSource.sub.get(this);
	}

	/**
	 * Sets a new value for {@link #sub}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="set")
	final void setSub(final GenSub sub)
	{
		GenSource.sub.set(this,sub);
	}

	/**
	 * Returns the value of {@link #moneySup}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="get")
	final com.exedio.cope.pattern.Money<GenSup<?,?>> getMoneySup()
	{
		return GenSource.moneySup.get(this);
	}

	/**
	 * Sets a new value for {@link #moneySup}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="set")
	final void setMoneySup(final com.exedio.cope.pattern.Money<GenSup<?,?>> moneySup)
	{
		GenSource.moneySup.set(this,moneySup);
	}

	/**
	 * Returns the value of {@link #moneyMid}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="get")
	final com.exedio.cope.pattern.Money<GenMid<?>> getMoneyMid()
	{
		return GenSource.moneyMid.get(this);
	}

	/**
	 * Sets a new value for {@link #moneyMid}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="set")
	final void setMoneyMid(final com.exedio.cope.pattern.Money<GenMid<?>> moneyMid)
	{
		GenSource.moneyMid.set(this,moneyMid);
	}

	/**
	 * Returns the value of {@link #moneySub}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="get")
	final com.exedio.cope.pattern.Money<GenSub> getMoneySub()
	{
		return GenSource.moneySub.get(this);
	}

	/**
	 * Sets a new value for {@link #moneySub}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="set")
	final void setMoneySub(final com.exedio.cope.pattern.Money<GenSub> moneySub)
	{
		GenSource.moneySub.set(this,moneySub);
	}

	/**
	 * Returns the value of {@link #setSup}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="get")
	final java.util.Set<GenSup<?,?>> getSetSup()
	{
		return GenSource.setSup.get(this);
	}

	/**
	 * Returns a query for the value of {@link #setSup}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="getQuery")
	final com.exedio.cope.Query<GenSup<?,?>> getSetSupQuery()
	{
		return GenSource.setSup.getQuery(this);
	}

	/**
	 * Returns the items, for which field set {@link #setSup} contains the given element.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="getParentsOf")
	static final java.util.List<GenSource> getParentsOfSetSup(final GenSup<?,?> element)
	{
		return GenSource.setSup.getParents(GenSource.class,element);
	}

	/**
	 * Sets a new value for {@link #setSup}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="set")
	final void setSetSup(final java.util.Collection<? extends GenSup<?,?>> setSup)
			throws
				com.exedio.cope.MandatoryViolationException,
				java.lang.ClassCastException
	{
		GenSource.setSup.set(this,setSup);
	}

	/**
	 * Adds a new element to {@link #setSup}.
	 * @return <tt>true</tt> if the field set changed as a result of the call.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="addTo")
	final boolean addToSetSup(final GenSup<?,?> element)
			throws
				com.exedio.cope.MandatoryViolationException,
				java.lang.ClassCastException
	{
		return GenSource.setSup.add(this,element);
	}

	/**
	 * Removes an element from {@link #setSup}.
	 * @return <tt>true</tt> if the field set changed as a result of the call.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="removeFrom")
	final boolean removeFromSetSup(final GenSup<?,?> element)
			throws
				com.exedio.cope.MandatoryViolationException,
				java.lang.ClassCastException
	{
		return GenSource.setSup.remove(this,element);
	}

	/**
	 * Returns the parent field of the type of {@link #setSup}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="Parent")
	static final com.exedio.cope.ItemField<GenSource> setSupParent()
	{
		return GenSource.setSup.getParent(GenSource.class);
	}

	/**
	 * Returns the value of {@link #setMid}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="get")
	final java.util.Set<GenMid<?>> getSetMid()
	{
		return GenSource.setMid.get(this);
	}

	/**
	 * Returns a query for the value of {@link #setMid}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="getQuery")
	final com.exedio.cope.Query<GenMid<?>> getSetMidQuery()
	{
		return GenSource.setMid.getQuery(this);
	}

	/**
	 * Returns the items, for which field set {@link #setMid} contains the given element.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="getParentsOf")
	static final java.util.List<GenSource> getParentsOfSetMid(final GenMid<?> element)
	{
		return GenSource.setMid.getParents(GenSource.class,element);
	}

	/**
	 * Sets a new value for {@link #setMid}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="set")
	final void setSetMid(final java.util.Collection<? extends GenMid<?>> setMid)
			throws
				com.exedio.cope.MandatoryViolationException,
				java.lang.ClassCastException
	{
		GenSource.setMid.set(this,setMid);
	}

	/**
	 * Adds a new element to {@link #setMid}.
	 * @return <tt>true</tt> if the field set changed as a result of the call.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="addTo")
	final boolean addToSetMid(final GenMid<?> element)
			throws
				com.exedio.cope.MandatoryViolationException,
				java.lang.ClassCastException
	{
		return GenSource.setMid.add(this,element);
	}

	/**
	 * Removes an element from {@link #setMid}.
	 * @return <tt>true</tt> if the field set changed as a result of the call.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="removeFrom")
	final boolean removeFromSetMid(final GenMid<?> element)
			throws
				com.exedio.cope.MandatoryViolationException,
				java.lang.ClassCastException
	{
		return GenSource.setMid.remove(this,element);
	}

	/**
	 * Returns the parent field of the type of {@link #setMid}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="Parent")
	static final com.exedio.cope.ItemField<GenSource> setMidParent()
	{
		return GenSource.setMid.getParent(GenSource.class);
	}

	/**
	 * Returns the value of {@link #setSub}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="get")
	final java.util.Set<GenSub> getSetSub()
	{
		return GenSource.setSub.get(this);
	}

	/**
	 * Returns a query for the value of {@link #setSub}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="getQuery")
	final com.exedio.cope.Query<GenSub> getSetSubQuery()
	{
		return GenSource.setSub.getQuery(this);
	}

	/**
	 * Returns the items, for which field set {@link #setSub} contains the given element.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="getParentsOf")
	static final java.util.List<GenSource> getParentsOfSetSub(final GenSub element)
	{
		return GenSource.setSub.getParents(GenSource.class,element);
	}

	/**
	 * Sets a new value for {@link #setSub}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="set")
	final void setSetSub(final java.util.Collection<? extends GenSub> setSub)
			throws
				com.exedio.cope.MandatoryViolationException,
				java.lang.ClassCastException
	{
		GenSource.setSub.set(this,setSub);
	}

	/**
	 * Adds a new element to {@link #setSub}.
	 * @return <tt>true</tt> if the field set changed as a result of the call.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="addTo")
	final boolean addToSetSub(final GenSub element)
			throws
				com.exedio.cope.MandatoryViolationException,
				java.lang.ClassCastException
	{
		return GenSource.setSub.add(this,element);
	}

	/**
	 * Removes an element from {@link #setSub}.
	 * @return <tt>true</tt> if the field set changed as a result of the call.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="removeFrom")
	final boolean removeFromSetSub(final GenSub element)
			throws
				com.exedio.cope.MandatoryViolationException,
				java.lang.ClassCastException
	{
		return GenSource.setSub.remove(this,element);
	}

	/**
	 * Returns the parent field of the type of {@link #setSub}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="Parent")
	static final com.exedio.cope.ItemField<GenSource> setSubParent()
	{
		return GenSource.setSub.getParent(GenSource.class);
	}

	/**
	 * Returns the value of {@link #listSup}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="get")
	final java.util.List<GenSup<?,?>> getListSup()
	{
		return GenSource.listSup.get(this);
	}

	/**
	 * Returns a query for the value of {@link #listSup}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="getQuery")
	final com.exedio.cope.Query<GenSup<?,?>> getListSupQuery()
	{
		return GenSource.listSup.getQuery(this);
	}

	/**
	 * Returns the items, for which field list {@link #listSup} contains the given element.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="getDistinctParentsOf")
	static final java.util.List<GenSource> getDistinctParentsOfListSup(final GenSup<?,?> element)
	{
		return GenSource.listSup.getDistinctParents(GenSource.class,element);
	}

	/**
	 * Adds a new value for {@link #listSup}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="addTo")
	final void addToListSup(final GenSup<?,?> listSup)
			throws
				com.exedio.cope.MandatoryViolationException,
				java.lang.ClassCastException
	{
		GenSource.listSup.add(this,listSup);
	}

	/**
	 * Removes all occurrences of {@code element} from {@link #listSup}.
	 * @return {@code true} if the field set changed as a result of the call.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="removeAllFrom")
	final boolean removeAllFromListSup(final GenSup<?,?> listSup)
	{
		return GenSource.listSup.removeAll(this,listSup);
	}

	/**
	 * Sets a new value for {@link #listSup}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="set")
	final void setListSup(final java.util.Collection<? extends GenSup<?,?>> listSup)
			throws
				com.exedio.cope.MandatoryViolationException,
				java.lang.ClassCastException
	{
		GenSource.listSup.set(this,listSup);
	}

	/**
	 * Returns the parent field of the type of {@link #listSup}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="Parent")
	static final com.exedio.cope.ItemField<GenSource> listSupParent()
	{
		return GenSource.listSup.getParent(GenSource.class);
	}

	/**
	 * Returns the value of {@link #listMid}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="get")
	final java.util.List<GenMid<?>> getListMid()
	{
		return GenSource.listMid.get(this);
	}

	/**
	 * Returns a query for the value of {@link #listMid}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="getQuery")
	final com.exedio.cope.Query<GenMid<?>> getListMidQuery()
	{
		return GenSource.listMid.getQuery(this);
	}

	/**
	 * Returns the items, for which field list {@link #listMid} contains the given element.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="getDistinctParentsOf")
	static final java.util.List<GenSource> getDistinctParentsOfListMid(final GenMid<?> element)
	{
		return GenSource.listMid.getDistinctParents(GenSource.class,element);
	}

	/**
	 * Adds a new value for {@link #listMid}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="addTo")
	final void addToListMid(final GenMid<?> listMid)
			throws
				com.exedio.cope.MandatoryViolationException,
				java.lang.ClassCastException
	{
		GenSource.listMid.add(this,listMid);
	}

	/**
	 * Removes all occurrences of {@code element} from {@link #listMid}.
	 * @return {@code true} if the field set changed as a result of the call.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="removeAllFrom")
	final boolean removeAllFromListMid(final GenMid<?> listMid)
	{
		return GenSource.listMid.removeAll(this,listMid);
	}

	/**
	 * Sets a new value for {@link #listMid}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="set")
	final void setListMid(final java.util.Collection<? extends GenMid<?>> listMid)
			throws
				com.exedio.cope.MandatoryViolationException,
				java.lang.ClassCastException
	{
		GenSource.listMid.set(this,listMid);
	}

	/**
	 * Returns the parent field of the type of {@link #listMid}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="Parent")
	static final com.exedio.cope.ItemField<GenSource> listMidParent()
	{
		return GenSource.listMid.getParent(GenSource.class);
	}

	/**
	 * Returns the value of {@link #listSub}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="get")
	final java.util.List<GenSub> getListSub()
	{
		return GenSource.listSub.get(this);
	}

	/**
	 * Returns a query for the value of {@link #listSub}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="getQuery")
	final com.exedio.cope.Query<GenSub> getListSubQuery()
	{
		return GenSource.listSub.getQuery(this);
	}

	/**
	 * Returns the items, for which field list {@link #listSub} contains the given element.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="getDistinctParentsOf")
	static final java.util.List<GenSource> getDistinctParentsOfListSub(final GenSub element)
	{
		return GenSource.listSub.getDistinctParents(GenSource.class,element);
	}

	/**
	 * Adds a new value for {@link #listSub}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="addTo")
	final void addToListSub(final GenSub listSub)
			throws
				com.exedio.cope.MandatoryViolationException,
				java.lang.ClassCastException
	{
		GenSource.listSub.add(this,listSub);
	}

	/**
	 * Removes all occurrences of {@code element} from {@link #listSub}.
	 * @return {@code true} if the field set changed as a result of the call.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="removeAllFrom")
	final boolean removeAllFromListSub(final GenSub listSub)
	{
		return GenSource.listSub.removeAll(this,listSub);
	}

	/**
	 * Sets a new value for {@link #listSub}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="set")
	final void setListSub(final java.util.Collection<? extends GenSub> listSub)
			throws
				com.exedio.cope.MandatoryViolationException,
				java.lang.ClassCastException
	{
		GenSource.listSub.set(this,listSub);
	}

	/**
	 * Returns the parent field of the type of {@link #listSub}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="Parent")
	static final com.exedio.cope.ItemField<GenSource> listSubParent()
	{
		return GenSource.listSub.getParent(GenSource.class);
	}

	/**
	 * Returns the value of {@link #subFallback}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="get")
	final GenSub getSubFallback()
	{
		return GenSource.subFallback.get(this);
	}

	/**
	 * Sets a new value for {@link #subFallback}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="set")
	final void setSubFallback(final GenSub subFallback)
	{
		GenSource.subFallback.set(this,subFallback);
	}

	/**
	 * Returns the value of {@link #subMandatory}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="get")
	final GenSub getSubMandatory()
	{
		return GenSource.subMandatory.get(this);
	}

	/**
	 * Sets a new value for {@link #subMandatory}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="set")
	final void setSubMandatory(final GenSub subMandatory)
			throws
				com.exedio.cope.MandatoryViolationException
	{
		GenSource.subMandatory.set(this,subMandatory);
	}

	/**
	 * Returns the value mapped to <tt>k</tt> by the field map {@link #mapSup}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="get")
	final GenSup<?,?> getMapSup(final GenSup<?,?> k)
	{
		return GenSource.mapSup.get(this,k);
	}

	/**
	 * Associates <tt>k</tt> to a new value in the field map {@link #mapSup}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="set")
	final void setMapSup(final GenSup<?,?> k,final GenSup<?,?> mapSup)
	{
		GenSource.mapSup.set(this,k,mapSup);
	}

	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="getMap")
	final java.util.Map<GenSup<?,?>,GenSup<?,?>> getMapSupMap()
	{
		return GenSource.mapSup.getMap(this);
	}

	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="setMap")
	final void setMapSupMap(final java.util.Map<? extends GenSup<?,?>,? extends GenSup<?,?>> mapSup)
	{
		GenSource.mapSup.setMap(this,mapSup);
	}

	/**
	 * Returns the parent field of the type of {@link #mapSup}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="Parent")
	static final com.exedio.cope.ItemField<GenSource> mapSupParent()
	{
		return GenSource.mapSup.getParent(GenSource.class);
	}

	/**
	 * Returns the value mapped to <tt>k</tt> by the field map {@link #mapMid}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="get")
	final GenMid<?> getMapMid(final GenMid<?> k)
	{
		return GenSource.mapMid.get(this,k);
	}

	/**
	 * Associates <tt>k</tt> to a new value in the field map {@link #mapMid}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="set")
	final void setMapMid(final GenMid<?> k,final GenMid<?> mapMid)
	{
		GenSource.mapMid.set(this,k,mapMid);
	}

	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="getMap")
	final java.util.Map<GenMid<?>,GenMid<?>> getMapMidMap()
	{
		return GenSource.mapMid.getMap(this);
	}

	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="setMap")
	final void setMapMidMap(final java.util.Map<? extends GenMid<?>,? extends GenMid<?>> mapMid)
	{
		GenSource.mapMid.setMap(this,mapMid);
	}

	/**
	 * Returns the parent field of the type of {@link #mapMid}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="Parent")
	static final com.exedio.cope.ItemField<GenSource> mapMidParent()
	{
		return GenSource.mapMid.getParent(GenSource.class);
	}

	/**
	 * Returns the value mapped to <tt>k</tt> by the field map {@link #mapSub}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="get")
	final GenSub getMapSub(final GenSub k)
	{
		return GenSource.mapSub.get(this,k);
	}

	/**
	 * Associates <tt>k</tt> to a new value in the field map {@link #mapSub}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="set")
	final void setMapSub(final GenSub k,final GenSub mapSub)
	{
		GenSource.mapSub.set(this,k,mapSub);
	}

	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="getMap")
	final java.util.Map<GenSub,GenSub> getMapSubMap()
	{
		return GenSource.mapSub.getMap(this);
	}

	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="setMap")
	final void setMapSubMap(final java.util.Map<? extends GenSub,? extends GenSub> mapSub)
	{
		GenSource.mapSub.setMap(this,mapSub);
	}

	/**
	 * Returns the parent field of the type of {@link #mapSub}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="Parent")
	static final com.exedio.cope.ItemField<GenSource> mapSubParent()
	{
		return GenSource.mapSub.getParent(GenSource.class);
	}

	@javax.annotation.Generated("com.exedio.cope.instrument")
	private static final long serialVersionUID = 1l;

	/**
	 * The persistent type information for genSource.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @WrapperType(type=...)
	static final com.exedio.cope.Type<GenSource> TYPE = com.exedio.cope.TypesBound.newType(GenSource.class);

	/**
	 * Activation constructor. Used for internal purposes only.
	 * @see com.exedio.cope.Item#Item(com.exedio.cope.ActivationParameters)
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument")
	private GenSource(final com.exedio.cope.ActivationParameters ap){super(ap);}
}
