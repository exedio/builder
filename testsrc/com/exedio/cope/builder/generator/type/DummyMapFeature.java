package com.exedio.cope.builder.generator.type;

import com.exedio.cope.Feature;
import com.exedio.cope.Item;
import com.exedio.cope.pattern.MapFieldInterface;
import java.util.Map;

class DummyMapFeature<K, V> extends Feature implements MapFieldInterface<K, V>
{
	private static final long serialVersionUID = 1L;

	private final Class<K> key;
	private final Class<V> value;

	protected DummyMapFeature(final Class<K> key, final Class<V> value)
	{
		this.key = key;
		this.value = value;
	}

	@Override
	public Class<K> getKeyClass()
	{
		return key;
	}

	@Override
	public Class<V> getValueClass()
	{
		return value;
	}

	@Override
	public V get(final Item item, final K key)
	{
		return null;
	}

	@Override
	public void set(final Item item, final K key, final V value)
	{
	}

	@Override
	public Map<K, V> getMap(final Item item)
	{
		return Map.of();
	}

	@Override
	public void setMap(final Item item, final Map<? extends K, ? extends V> map)
	{
	}

	static class CustomMapK<K> extends DummyMapFeature<K, Long>
	{
		private static final long serialVersionUID = 1L;

		CustomMapK(final Class<K> key)
		{
			super(key, Long.class);
		}
	}

	static class CustomMapV<V> extends DummyMapFeature<String, V>
	{
		private static final long serialVersionUID = 1L;

		CustomMapV(final Class<V> value)
		{
			super(String.class, value);
		}
	}

	static class CustomMapKV<K, V> extends DummyMapFeature<K, V>
	{
		private static final long serialVersionUID = 1L;

		CustomMapKV(final Class<K> key, final Class<V> value)
		{
			super(key, value);
		}
	}

	static class CustomMapXY<X, Y> extends DummyMapFeature<X, Y>
	{
		private static final long serialVersionUID = 1L;

		CustomMapXY(final Class<X> key, final Class<Y> value)
		{
			super(key, value);
		}
	}

	static class CustomMap extends DummyMapFeature<String, Long>
	{
		private static final long serialVersionUID = 1L;

		CustomMap()
		{
			super(String.class, Long.class);
		}
	}

	static class CustomMapX<X> extends DummyMapFeature<X, Long>
	{
		private static final long serialVersionUID = 1L;

		CustomMapX(final Class<X> key)
		{
			super(key, Long.class);
		}
	}

	static class CustomMapKVZ<K, V, Z> extends DummyMapFeature<K, V>
	{
		private static final long serialVersionUID = 1L;

		CustomMapKVZ(final Class<K> key, final Class<V> value)
		{
			super(key, value);
		}
	}
}
