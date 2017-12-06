package com.exedio.cope.builder.generator.type;

import com.exedio.cope.Feature;
import java.io.IOException;
import java.util.List;
import javax.annotation.Nonnull;

public abstract class MyType<T>
{
	protected final Class<? extends T> clazz;
	protected final String             wildCards;
	protected final String             simpleClassName;

	MyType(final Class<? extends T> clazz)
	{
		this.clazz = clazz;
		this.wildCards = typeParameterWildCards(clazz);
		simpleClassName = clazz.getSimpleName();
	}

	static String typeParameterWildCards(final Class<?> clazz)
	{
		final int typeParameters = clazz.getTypeParameters().length;
		if(typeParameters == 0)
			return "";

		final StringBuilder bf = new StringBuilder();
		bf.append("<?");
		for(int i = 1; i < typeParameters; i++)
			bf.append(",?");
		bf.append('>');
		return bf.toString();
	}

	@Nonnull
	public final Class<? extends T> getJavaClass()
	{
		return clazz;
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

	public abstract boolean equals(final Object obj);

	@Override
	public abstract int hashCode();
}