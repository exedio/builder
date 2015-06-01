package com.exedio.cope.builder;

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
	private final Class<C> targetClazz;

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
			// TODO use some framework function for this
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
		final List<SetValue< ? >> allValues = new LinkedList<>( values.values() );
		try
		{
			// TODO use some framework function for this
			final Constructor< ? extends C> constructor = targetClazz.getDeclaredConstructor( SetValue[].class );
			constructor.setAccessible( true );
			final SetValue<?>[] vs = allValues.toArray( new SetValue<?>[allValues.size()] );
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
