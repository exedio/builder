package com.exedio.cope.builder;

import com.exedio.cope.Condition;
import com.exedio.cope.Feature;
import com.exedio.cope.FunctionField;
import com.exedio.cope.Item;
import com.exedio.cope.Query;
import com.exedio.cope.SetValue;
import com.exedio.cope.Settable;
import com.exedio.cope.Type;
import com.exedio.cope.pattern.ListField;
import com.exedio.cope.pattern.MapField;
import com.exedio.cope.pattern.SetField;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * A generic base class for builders.
 *
 * @param <I> the resulting item class
 * @param <B> the actual sub-class of this base class
 */
@SuppressWarnings("AbstractClassWithoutAbstractMethods")
public abstract class ItemBuilder<I extends Item, B extends ItemBuilder<I, B>> extends CopeBuilder<I, B>
{

	private final Type<I> type;
	protected Map<ListField<?>, List<?>>     listValues = new HashMap<>();
	protected Map<SetField<?>, Set<?>>       setValues  = new HashMap<>();
	protected Map<MapField<?, ?>, Map<?, ?>> mapValues  = new HashMap<>();

	/**
	 * @param type the type of the item you want to build
	 */
	protected ItemBuilder(final Type<I> type)
	{
		this.type = type;
	}

	protected final <V> boolean isSet(final ListField<V> field)
	{
		return listValues.containsKey(field);
	}

	protected final <K, V> boolean isSet(final MapField<K, V> field)
	{
		return mapValues.containsKey(field);
	}

	protected final <V> boolean isSet(final SetField<V> field)
	{
		return setValues.containsKey(field);
	}

	protected final <V> B fallback(final SetField<V> field, final Set<V> value)
	{
		if(!isSet(field))
			set(field, value);
		return self();
	}

	protected final <V> B set(final SetField<V> field, final Set<V> value)
	{
		setValues.put(field, value);
		return self();
	}

	@SuppressWarnings("unchecked")
	protected final <V> Set<V> get(final SetField<V> field)
	{
		if(!setValues.containsKey(field))
			return null;
		return (Set<V>) setValues.get(field);
	}

	protected final <V> B fallback(final ListField<V> field, final List<V> value)
	{
		if(!isSet(field))
			set(field, value);
		return self();
	}

	protected final <V> B set(final ListField<V> field, final List<V> value)
	{
		listValues.put(field, value);
		return self();
	}

	@SuppressWarnings("unchecked")
	protected final <V> List<V> get(final ListField<V> field)
	{
		if(!listValues.containsKey(field))
			return null;
		return (List<V>) listValues.get(field);
	}

	protected final <K, V> B fallback(final MapField<K, V> field, final Map<K, V> value)
	{
		if(!isSet(field))
			set(field, value);
		return self();
	}

	protected final <K, V> B set(final MapField<K, V> field, final Map<K, V> value)
	{
		mapValues.put(field, value);
		return self();
	}

	@SuppressWarnings("unchecked")
	protected final <K, V> Map<K, V> get(final MapField<K, V> field)
	{
		if(!mapValues.containsKey(field))
			return null;
		return (Map<K, V>) mapValues.get(field);
	}

	@Override
	protected final <F extends Feature> F getFeature(final String featureName)
	{
		final Feature feature = type.getFeature(featureName);
		if(feature == null)
			throw new NullPointerException(featureName);
		@SuppressWarnings("unchecked")
		final F result = (F) feature;
		return result;
	}

	/**
	 * @deprecated Use fields filled by {@link #getFeature(String)} instead.
	 */
	@Deprecated
	@SuppressWarnings("unchecked")
	protected final B set(final String featureName, final Object value)
	{
		final Feature feature = getFeature(featureName);
		if(feature instanceof Settable<?>)
			return set((Settable<Object>) feature, value);
		else if(feature instanceof SetField<?>)
			return set((SetField<Object>) feature, (Set<Object>) value); // TODO kaputt
		else if(feature instanceof ListField<?>)
			return set((ListField<Object>) feature, (List<Object>) value); // TODO kaputt
		else if(feature instanceof MapField<?, ?>)
			return set((MapField<Object, Object>) feature, (Map<Object, Object>) value); // TODO kaputt
		else
			throw new IllegalArgumentException(featureName);
	}

	/**
	 * Build the resulting item.
	 *
	 * @return the created item
	 */
	@Override
	public I build()
	{
		final I result = type.newItem(new ArrayList<>(values.values()));
		for(final Map.Entry<ListField<?>, List<?>> entry : listValues.entrySet())
			setListValue(result, entry.getKey(), entry.getValue());
		for(final Map.Entry<SetField<?>, Set<?>> entry : setValues.entrySet())
			setSetValue(result, entry.getKey(), entry.getValue());
		for(final Map.Entry<MapField<?, ?>, Map<?, ?>> entry : mapValues.entrySet())
			setMapValue(result, entry.getKey(), entry.getValue());
		return result;
	}

	private final class DefaultItemBuilder implements Builder<I>
	{
		private final ItemBuilder<I, B> builder;

		DefaultItemBuilder(final ItemBuilder<I, B> builder)
		{
			this.builder = builder;
		}

		@SuppressWarnings({"rawtypes", "unchecked"})
		@Override
		public I build()
		{
			@SuppressWarnings("synthetic-access")
			final Query<I> query = builder.type.newQuery();
			for(final Map.Entry<Settable<?>, SetValue<?>> key : builder.values.entrySet())
			{
				@SuppressWarnings("RawTypeCanBeGeneric")
				final Settable field = key.getKey();
				for(final SetValue setValue : field.execute(key.getValue().value, null))
				{
					if(setValue.settable instanceof FunctionField)
						query.narrow(equalCondition((FunctionField<?>) setValue.settable, setValue));
				}
			}
			I value = query.searchSingleton();
			if(value == null || !value.existsCopeItem())
			{
				value = builder.copy().build();
			}
			return value;
		}

		@SuppressWarnings("unchecked")
		private static <T> Condition equalCondition(final FunctionField<?> key, final SetValue<?> value)
		{
			//noinspection RedundantCast
			return ((FunctionField<T>) key).equal(((SetValue<T>) value).value);
		}
	}

	protected final Builder<I> toDefault()
	{
		return new DefaultItemBuilder(this);
	}

	public final I getOrBuild()
	{
		return toDefault().build();
	}

	@Override
	@SuppressWarnings("unchecked")
	public B copy()
	{
		try
		{
			final Constructor<?> constructor = getClass().getDeclaredConstructor();
			constructor.setAccessible(true);
			final B copy = (B) constructor.newInstance();
			copy.values = new HashMap<>(values);
			copy.listValues = new HashMap<>(listValues);
			copy.setValues = new HashMap<>(setValues);
			copy.mapValues = new HashMap<>(mapValues);
			return copy;
		}
		catch(final ReflectiveOperationException e)
		{
			throw new RuntimeException("Failed to copy builder: " + getClass().getName(), e);
		}
	}

	@SuppressWarnings("unchecked")
	private <V> void setListValue(final I result, final ListField<?> listField, final List<?> list)
	{
		((ListField<V>) listField).set(result, (List<V>) list);
	}

	@SuppressWarnings("unchecked")
	private <V> void setSetValue(final I result, final SetField<?> setField, final Set<?> list)
	{
		((SetField<V>) setField).set(result, (Set<V>) list);
	}

	@SuppressWarnings("unchecked")
	private <K, V> void setMapValue(final I result, final MapField<?, ?> mapField, final Map<?, ?> map)
	{
		((MapField<K, V>) mapField).setMap(result, (Map<K, V>) map);
	}
}
