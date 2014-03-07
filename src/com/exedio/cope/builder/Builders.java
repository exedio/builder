package com.exedio.cope.builder;
/*
 * Copyright (C) 2004-2012  exedio GmbH (www.exedio.com)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a
 * copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */



import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import com.exedio.cope.FunctionField;

/**
 * A collection of common builders re-usable in projects.
 */
public class Builders
{
	/**
	 * Resets any internal static values used, for example, for generating unique values.
	 * Doesn't need to be called but makes test data better understandable when called in @Before method.
	 */
	public static void reset()
	{
		AutoIncrementBuilder.nextValues.clear();
	}

	/**
	 * Generates per-field unique values every time {@link Builder#build()} is called.
	 * The result value is composed from the given pattern string
	 * where a single %d token is replaced by an integer counting up from the given start value.
	 */
	public static Builder<String> autoIncrement(final FunctionField<String> field, final String pattern, final int start)
	{
		return new StringAutoIncrementBuilder(field, pattern, start);
	}

	/**
	 * Generates per-field unique values every time {@link Builder#build()} is called.
	 * The result value is counting up from the given start value.
	 */
	public static Builder<Integer> autoIncrement(final FunctionField<Integer> field, final int start)
	{
		return new IntegerAutoIncrementBuilder(field, start);
	}


	/**
	 * Generates per-field unique values every time {@link Builder#build()} is called.
	 * The result value is counting up using the internal ordinal value of the enum constants from the given start value.
	 * Using rotate = false will throw an IllegalStateException if end of the constants set is reached.
	 * Using rotate = true will not fail if end of the constants set is reached but will not provide uniqueness in this case.
	 */
	public static <E extends Enum<E>> Builder<E> autoIncrement(final FunctionField<E> field, final E start, final boolean rotate)
	{
		return new EnumAutoIncrementBuilder<E>(field, start, rotate);
	}

	/**
	 * Returns a builder which converts Enum results to String results
	 */
	public static <E extends Enum<E>> Builder<String> enumToStringBuilder(final Builder<E> enumBuilder)
	{
		return new Builder<String>()
		{
			@Override
			public String build()
			{
				return enumBuilder.build().name();
			}
		};
	}

	abstract private static class AutoIncrementBuilder<T> implements Builder<T>
	{
		private static Map<FunctionField<?>, AtomicInteger> nextValues = new HashMap<FunctionField<?>, AtomicInteger>();

		final FunctionField<T> field;
		final int start;

		AutoIncrementBuilder(final FunctionField<T> field, final int start)
		{
			this.field = field;
			this.start = start;
		}

		int nextValue(final FunctionField<T> field, final int firstValue)
		{
			if(!nextValues.containsKey(field))
				nextValues.put(field, new AtomicInteger(firstValue));
			final AtomicInteger mutable = nextValues.get(field);
			return mutable.incrementAndGet();
		}
	}

	private static class IntegerAutoIncrementBuilder extends AutoIncrementBuilder<Integer>
	{
		private IntegerAutoIncrementBuilder(final FunctionField<Integer> field, final int start)
		{
			super(field, start);
		}

		@Override
		public Integer build()
		{
			return nextValue(this.field, start);
		}
	}

	private static class StringAutoIncrementBuilder extends AutoIncrementBuilder<String>
	{
		private final String pattern;

		private StringAutoIncrementBuilder(final FunctionField<String> field, final String pattern, final int start)
		{
			super(field, start);
			this.pattern = pattern;
		}

		@Override
		public String build()
		{
			return String.format(pattern, nextValue(field, start));
		}
	}

	private static class EnumAutoIncrementBuilder<E extends Enum<E>> extends AutoIncrementBuilder<E>
	{
		private E startValue;
		private boolean rotate;

		private EnumAutoIncrementBuilder(final FunctionField<E> field, final E start)
		{
			this(field, start, false);
		}

		private EnumAutoIncrementBuilder(final FunctionField<E> field, final E start, final boolean rotate)
		{
			super(field, start.ordinal());
			if (start.getClass().getEnumConstants().length == 0)
				throw new IllegalArgumentException("Cannot handle empty enum class.");
			this.startValue = start;
			this.rotate = rotate;
		}

		@Override
	   @SuppressWarnings("unchecked")
		public E build()
		{
			int nextIndex = nextValue(this.field, start);
			final Enum<E>[] constants = startValue.getClass().getEnumConstants();
		   if (nextIndex >= constants.length)
		   {
		   	if (rotate)
		   		nextIndex = 0;
		   	else
		   		throw new IllegalStateException("Run out of values while incrementing "+startValue.getClass());
		   }
			return (E) constants[nextIndex];
		}
	}

	private Builders()
	{
		// prevent instantiation
	}
}
