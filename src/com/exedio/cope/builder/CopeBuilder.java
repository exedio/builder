package com.exedio.cope.builder;

import com.exedio.cope.Feature;
import com.exedio.cope.SetValue;
import com.exedio.cope.Settable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class CopeBuilder<O extends Object, B extends CopeBuilder<?, ?>> implements Builder<O>
{
	protected Map<Settable<?>, SetValue<?>> values = new HashMap<>();

	@SafeVarargs
	protected static <T> Set<T> toSet(final T... array)
	{
		final Set<T> result = new HashSet<>();
		for(final T t : array)
			result.add(t);
		return result;
	}

	protected final <V> boolean isSet(final Settable<V> settable)
	{
		return values.containsKey(settable);
	}

	@SuppressWarnings("unchecked")
	protected final <V> B fallback(final Settable<V> settable, final V value)
	{
		if(!isSet(settable))
			set(settable, value);
		return (B) this;
	}

	@SuppressWarnings("unchecked")
	protected final <V> B fallback(final Settable<V> settable, final Builder<? extends V> builder)
	{
		if(!isSet(settable))
			set(settable, builder.build());
		return (B) this;
	}

	@SuppressWarnings("unchecked")
	protected final <V> B set(final Settable<V> settable, final V value)
	{
		values.put(settable, settable.map(value));
		return (B) this;
	}

	@SuppressWarnings("unchecked")
	protected final <V> V get(final Settable<V> settable)
	{
		if(!values.containsKey(settable))
			return null;
		return (V) values.get(settable).value;
	}

	@SafeVarargs
	protected static <T> List<T> toList(final T... array)
	{
		final List<T> result = new ArrayList<>();
		for(final T t : array)
			result.add(t);
		return result;
	}

	protected static <K, V> Map<K, V> toMap(final K key, final V value)
	{
		final Map<K, V> map = new HashMap<>();
		map.put(key, value);
		return map;
	}

	protected static <K, V> Map<K, V> toMap(final K key1, final V value1, final K key2, final V value2)
	{
		final Map<K, V> map = new HashMap<>();
		map.put(key1, value1);
		map.put(key2, value2);
		return map;
	}

	public CopeBuilder()
	{
		super();
	}

	protected static <K extends Enum<K>, V> EnumMap<K, V> toEnumMap(final K key, final V value)
	{
		return new EnumMap<>(toMap(key, value));
	}

	protected abstract <F extends Feature> F getFeature(String featureName);

	@SuppressWarnings("unchecked")
	public B copy()
	{
		try
		{
			final Constructor<?> constructor = getClass().getConstructor();
			final B copy = (B) constructor.newInstance();
			copy.values = new HashMap<>(values);
			return copy;
		}
		catch(final InstantiationException e)
		{
			throw new RuntimeException("Failed to copy builder: " + getClass().getName(), e);
		}
		catch(final IllegalAccessException e)
		{
			throw new RuntimeException("Failed to copy builder: " + getClass().getName(), e);
		}
		catch(final InvocationTargetException e)
		{
			throw new RuntimeException("Failed to copy builder: " + getClass().getName(), e);
		}
		catch(final NoSuchMethodException e)
		{
			throw new RuntimeException("Failed to copy builder: " + getClass().getName(), e);
		}
	}
}