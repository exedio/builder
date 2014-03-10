package com.exedio.cope.builder;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.exedio.cope.SetValue;
import com.exedio.cope.Settable;
import com.exedio.cope.pattern.EnumSetField;
import com.exedio.cope.pattern.Hash;

public abstract class CopeBuilder<O extends Object, B extends CopeBuilder< ? , ? >> implements Builder<O>
{
	protected Map<Settable<?>, SetValue<?>>	values	= new HashMap<Settable<?>, SetValue<?>>();

	protected static <T> Set<T> toSet( final T... array )
	{
		final Set<T> result = new HashSet<T>();
		for (final T t: array)
			result.add(t);
		return result;
	}

	protected <V> boolean isSet( final Settable<V> settable )
	{
		return values.containsKey(settable);
	}

	@SuppressWarnings("unchecked")
	protected <V> B fallback( final Settable<V> settable, final V value )
	{
		if(!isSet(settable))
			set(settable, value);
		return (B) this;
	}

	@SuppressWarnings("unchecked")
	protected <V> B fallback( final Settable<V> settable, final Builder<? extends V> builder )
	{
		if(!isSet(settable))
			set(settable, builder.build());
		return (B) this;
	}

	@SuppressWarnings("unchecked")
	protected <V> B set( final Settable<V> settable, final V value )
	{
		values.put(settable, settable.map(value));
		return (B) this;
	}

	@SuppressWarnings("unchecked")
	protected <V> V get( final Settable<V> settable )
	{
		return (V) values.get(settable).value;
	}

	@SuppressWarnings("unchecked")
	protected B fallback( final Hash settable, final String value )
	{
		if(!isSet(settable))
			set(settable, value);
		return (B) this;
	}

	@SuppressWarnings("unchecked")
	protected B set( final Hash settable, final String value )
	{
		values.put(settable, settable.map(value));
		return (B) this;
	}

	@SuppressWarnings("unchecked")
	protected <V> V get( final Hash settable )
	{
		return (V) values.get(settable).value;
	}

	@SuppressWarnings("unchecked")
	protected <V extends Enum<V>> B fallback( final EnumSetField<V> field, final EnumSet<V> value )
	{
		if(!isSet(field))
			set(field, value);
		return (B) this;
	}

	protected static <T> List<T> toList( final T... array )
	{
		final List<T> result = new ArrayList<T>();
		for (final T t: array)
			result.add(t);
		return result;
	}


	protected static <K, V> Map<K, V> toMap( final K key, final V value )
	{
		final Map<K, V> map = new HashMap<K, V>();
		map.put(key, value);
		return map;
	}

	protected static <K, V> Map<K, V> toMap( final K key1, final V value1, final K key2, final V value2 )
	{
		final Map<K, V> map = new HashMap<K, V>();
		map.put(key1, value1);
		map.put(key2, value2);
		return map;
	}

	public CopeBuilder()
	{
		super();
	}

	protected <K extends Enum<K>, V> EnumMap<K, V> toEnumMap( final K key, final V value )
	{
		return new EnumMap<K, V>(toMap(key, value));
	}

	@SuppressWarnings("unchecked")
	public B copy()
	{
		try
		{
			final Constructor<?> constructor = getClass().getConstructor();
			final B copy = (B) constructor.newInstance();
			copy.values = new HashMap<Settable<?>, SetValue<?>>( values );
			return copy;
		}
		catch( final InstantiationException e )
		{
			throw new RuntimeException( "Failed to copy builder: " + getClass().getName(), e );
		}
		catch( final IllegalAccessException e )
		{
			throw new RuntimeException( "Failed to copy builder: " + getClass().getName(), e );
		}
		catch( final InvocationTargetException e )
		{
			throw new RuntimeException( "Failed to copy builder: " + getClass().getName(), e );
		}
		catch( final NoSuchMethodException e )
		{
			throw new RuntimeException( "Failed to copy builder: " + getClass().getName(), e );
		}
	}
}