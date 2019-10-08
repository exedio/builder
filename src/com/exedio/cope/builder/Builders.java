package com.exedio.cope.builder;

import com.exedio.cope.Settable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * A collection of common builders re-usable in projects.
 */
public final class Builders
{
	/**
	 * Resets any internal static values used, for example, for generating unique values.
	 * Doesn't need to be called but makes test data better understandable when called in @Before method.
	 */
	@SuppressWarnings("synthetic-access")
	public static void reset()
	{
		AutoIncrementBuilder.nextValues.clear();
	}

	/**
	 * Generates per-field unique values every time {@link Builder#build()} is called.
	 * The result value is composed from the given pattern string
	 * where a single %d token is replaced by an integer counting up from the given start value.
	 */
	public static Builder<String> autoIncrement(final Settable<String> field, final String pattern, final int start)
	{
		return new StringAutoIncrementBuilder(field, pattern, start);
	}

	/**
	 * Generates per-field unique values every time {@link Builder#build()} is called.
	 * The result value is counting up from the given start value.
	 */
	public static Builder<Integer> autoIncrement(final Settable<Integer> field, final int start)
	{
		return new IntegerAutoIncrementBuilder(field, start);
	}

	/**
	 * Generates per-field unique values every time {@link Builder#build()} is called.
	 * The result value is counting up using the internal ordinal value of the enum constants from the given start value.
	 * Using rotate = false will throw an IllegalStateException if end of the constants set is reached.
	 * Using rotate = true will not fail if end of the constants set is reached but will not provide uniqueness in this case.
	 */
	public static <E extends Enum<E>> Builder<E> autoIncrement(final Settable<E> field, final E start, final boolean rotate)
	{
		return new EnumAutoIncrementBuilder<>(field, start, rotate);
	}

	/**
	 * Returns a builder which converts Enum results to String results
	 */
	public static <E extends Enum<E>> Builder<String> enumToStringBuilder(final Builder<E> enumBuilder)
	{
		return () -> enumBuilder.build().name();
	}

	public abstract static class AutoIncrementBuilder<T> implements Builder<T>
	{
		private static final Map<Object, AtomicInteger> nextValues = new HashMap<>();

		protected final Object object;
		protected final int    start;

		protected AutoIncrementBuilder(final Object object, final int start)
		{
			this.object = Objects.requireNonNull(object, "object");
			this.start = start;
		}

		protected final int nextValue()
		{
			if(!nextValues.containsKey(object))
				nextValues.put(object, new AtomicInteger(start));
			final AtomicInteger mutable = nextValues.get(object);
			return mutable.getAndIncrement();
		}
	}

	private static class IntegerAutoIncrementBuilder extends AutoIncrementBuilder<Integer>
	{
		IntegerAutoIncrementBuilder(final Settable<Integer> field, final int start)
		{
			super(field, start);
		}

		@Override
		public Integer build()
		{
			return nextValue();
		}
	}

	private static class StringAutoIncrementBuilder extends AutoIncrementBuilder<String>
	{
		private final String pattern;

		StringAutoIncrementBuilder(final Settable<String> field, final String pattern, final int start)
		{
			super(field, start);
			this.pattern = pattern;
		}

		@Override
		public String build()
		{
			return String.format(pattern, nextValue());
		}
	}

	private static class EnumAutoIncrementBuilder<E extends Enum<E>> extends AutoIncrementBuilder<E>
	{
		private final E       startValue;
		private final boolean rotate;

		EnumAutoIncrementBuilder(final Settable<E> field, final E start, final boolean rotate)
		{
			super(field, start.ordinal());
			if(start.getClass().getEnumConstants().length == 0)
				throw new IllegalArgumentException("Cannot handle empty enum class.");
			this.startValue = start;
			this.rotate = rotate;
		}

		@Override
		@SuppressWarnings("unchecked")
		public E build()
		{
			int nextIndex = nextValue();
			final Enum<E>[] constants = startValue.getClass().getEnumConstants();
			if(nextIndex >= constants.length)
			{
				if(rotate)
					nextIndex = 0;
				else
					throw new IllegalStateException("Run out of values while incrementing " + startValue.getClass());
			}
			return (E) constants[nextIndex];
		}
	}

	private Builders()
	{
		// prevent instantiation
	}
}
