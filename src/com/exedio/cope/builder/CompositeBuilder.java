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



import com.exedio.cope.SetValue;
import com.exedio.cope.Settable;
import com.exedio.cope.pattern.Composite;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;

public abstract class CompositeBuilder<C extends Composite, B extends CompositeBuilder< ? , ? >> extends CopeBuilder<C, B>
{
	private final Class<C>	targetClazz;

	public CompositeBuilder( final Class<C> targetClazz )
	{
		this.targetClazz = targetClazz;
	}

	@SuppressWarnings("unchecked")
	@SuppressFBWarnings("DP_DO_INSIDE_DO_PRIVILEGED")
	protected B set(final String settableName, final Object value)
	{
		try
		{
			final java.lang.reflect.Field field = targetClazz.getDeclaredField(settableName);
			field.setAccessible(true);
			return set((Settable<Object>)field.get(null), value);
		}
		catch( final IllegalAccessException e )
		{
			throw new RuntimeException( e );
		}
		catch( final NoSuchFieldException e )
		{
			throw new RuntimeException( e );
		}
	}

	@Override
	public C build()
	{
		final List<SetValue< ? >> allValues = new LinkedList<SetValue< ? >>( values.values() );
		try
		{
			// TODO use some framework function for this
			final Constructor< ? extends C> constructor = targetClazz.getDeclaredConstructor( SetValue[].class );
			constructor.setAccessible( true );
			final SetValue< ? >[] vs = allValues.toArray( new SetValue[allValues.size()] );
			return constructor.newInstance( new Object[] { vs} );
		}
		catch( final InstantiationException e )
		{
			throw new RuntimeException( "Failed to instantiate composite: " + getClass().getName(), e );
		}
		catch( final IllegalAccessException e )
		{
			throw new RuntimeException( "Failed to instantiate composite: " + getClass().getName(), e );
		}
		catch( final InvocationTargetException e )
		{
			throw new RuntimeException( "Failed to instantiate composite: " + getClass().getName(), e );
		}
		catch( final NoSuchMethodException e )
		{
			throw new RuntimeException( "Failed to instantiate composite: " + getClass().getName(), e );
		}
	}
}
