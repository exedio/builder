package com.exedio.cope.builder;

import com.exedio.cope.Feature;
import com.exedio.cope.SetValue;
import com.exedio.cope.pattern.Composite;
import com.exedio.cope.pattern.CompositeType;

@SuppressWarnings("AbstractClassWithoutAbstractMethods")
public abstract class CompositeBuilder<C extends Composite, B extends CompositeBuilder<C, B>> extends CopeBuilder<C, B>
{
	private final CompositeType<C> type;

	protected CompositeBuilder(final Class<C> targetClazz)
	{
		this.type = CompositeType.forClass(targetClazz);
	}

	@Override
	protected final <F extends Feature> F getFeature(final String featureName)
	{
		@SuppressWarnings("unchecked")
		final F result = (F) type.getFeature(featureName);
		return result;
	}

	/**
	 * @deprecated Use fields filled by {@link #getFeature(String)} instead.
	 */
	@Deprecated
	protected final B set(final String featureName, final Object value)
	{
		return set(getFeature(featureName), value);
	}

	@Override
	public C build()
	{
		return type.newValue(values.values().toArray(new SetValue<?>[0]));
	}
}
