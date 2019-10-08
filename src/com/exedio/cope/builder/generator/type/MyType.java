package com.exedio.cope.builder.generator.type;

import com.exedio.cope.Feature;
import java.io.IOException;
import java.util.List;
import javax.annotation.Nonnull;

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

	@Nonnull
	public final Class<? extends T> getJavaClass()
	{
		return clazz;
	}

	@Nonnull
	public String getPackageName()
	{
		return packageName;
	}

	public String getSimpleClassName()
	{
		return simpleClassName;
	}

	@Nonnull
	public final String getWildCards()
	{
		return wildCards;
	}

	public abstract List<? extends Feature> getDeclaredFeatures();

	public abstract String getName(Feature feature);

	@Nonnull
	public abstract String getExtends() throws IOException;

	@Nonnull
	public String getGenericParams()
	{
		return "<B extends Generated" + simpleClassName + "Builder<?>>";
	}

	@Nonnull
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