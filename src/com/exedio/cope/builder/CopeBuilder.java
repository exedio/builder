package com.exedio.cope.builder;

import com.exedio.cope.Feature;
import com.exedio.cope.SetValue;
import com.exedio.cope.Settable;
import com.exedio.cope.pattern.EnumMapField;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class CopeBuilder<O, B extends CopeBuilder<?, ?>> implements Builder<O>
{
	protected Map<Settable<?>, SetValue<?>> values = new HashMap<>();

	protected final <V> boolean isSet(final Settable<V> settable)
	{
		return values.containsKey(settable);
	}

	//Handle enum map key-vise
	protected final <K extends Enum<K>> boolean isSet(final EnumMapField<K, ?> enumMapField)
	{
		return Arrays.stream(enumMapField.getKeyClass().getEnumConstants()).anyMatch(key -> values.containsKey(enumMapField.getField(key)));
	}

	protected final <K extends Enum<K>> boolean isSet(final EnumMapField<K, ?> enumMapField, final K key)
	{
		return values.containsKey(enumMapField.getField(key));
	}

	@SuppressWarnings("unchecked")
	protected final <V> B fallback(final Settable<V> settable, final V value)
	{
		if(!isSet(settable))
			set(settable, value);
		return (B) this;
	}

	//Handle enum map key-vise
	protected <K extends Enum<K>, V> void fallback(final EnumMapField<K, V> enumMapField, final EnumMap<K, V> map)
	{
		map.forEach((k, v) -> fallback(enumMapField, k, v));
	}

	protected <K extends Enum<K>, V> void fallback(final EnumMapField<K, V> enumMapField, final K key, final V value)
	{
		fallback(enumMapField.getField(key), value);
	}

	protected final <V> void fallback(final Settable<V> settable, final Builder<? extends V> builder)
	{
		if(!isSet(settable))
			set(settable, builder.build());
	}

	protected <K extends Enum<K>, V> void fallback(final EnumMapField<K, V> enumMapField, final K key, final Builder<V> builder)
	{
		if(!isSet(enumMapField.getField(key)))
			fallback(enumMapField.getField(key), builder.build());
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

	//Handle enum map key-vise
	protected final <K extends Enum<K>, V> V get(final EnumMapField<K, V> enumMapField, final K key)
	{
		return get(enumMapField.getField(key));
	}

	protected final <K extends Enum<K>, V> EnumMap<K, V> get(final EnumMapField<K, V> enumMapField)
	{
		final EnumMap<K, V> enumMap = new EnumMap<>(enumMapField.getKeyClass());
		for(final K key : enumMapField.getKeyClass().getEnumConstants())
		{
			enumMap.put(key, get(enumMapField, key));
		}
		return enumMap;
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

	@SuppressWarnings("varargs")
	@SafeVarargs
	protected static <T> Set<T> toSet(final T... array)
	{
		return new HashSet<>(Arrays.asList(array));
	}

	protected static <K extends Enum<K>, V> EnumMap<K, V> toEnumMap(final K key, final V value)
	{
		return new EnumMap<>(toMap(key, value));
	}

	protected CopeBuilder()
	{
		super();
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
		catch(final ReflectiveOperationException e)
		{
			throw new RuntimeException("Failed to copy builder: " + getClass().getName(), e);
		}
	}
}