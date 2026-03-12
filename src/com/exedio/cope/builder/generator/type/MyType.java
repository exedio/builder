package com.exedio.cope.builder.generator.type;

import com.exedio.cope.Feature;
import java.util.List;

public abstract class MyType<T>
{
	protected final Class<? extends T> clazz;
	final           String             wildCards;
	final           String             simpleClassName;
	private final   String             packageName;

	MyType(final Class<? extends T> clazz)
	{
		this.clazz = clazz;
		this.wildCards = TypeUtil.typeParameterWildCards(clazz);
		simpleClassName = clazz.getSimpleName();
		packageName = clazz.getPackage().getName();
	}

	public final Class<? extends T> getJavaClass()
	{
		return clazz;
	}

	public String getPackageName()
	{
		return packageName;
	}

	public String getSimpleClassName()
	{
		return simpleClassName;
	}

	public final String getWildCards()
	{
		return wildCards;
	}

	public abstract List<? extends Feature> getDeclaredFeatures();

	public abstract String getName(Feature feature);

	public abstract String getExtends();

	public String getGenericParams()
	{
		return "<B extends Generated" + simpleClassName + "Builder<B>>";
	}

	public String getTypeCast()
	{
		return "";
	}

	public boolean enableCommonBuilder()
	{
		return false;
	}

	public boolean enableTypePropagationConstructor()
	{
		return false;
	}

	public abstract String getTypeName();

	@Override
	public abstract boolean equals(final Object obj);

	@Override
	public abstract int hashCode();
}