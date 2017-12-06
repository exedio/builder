package com.exedio.cope.builder.generator.type;

import com.exedio.cope.Feature;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Collection;

public abstract class MyType
{
	public abstract Class<?> getJavaClass();

	public abstract Collection<? extends Feature> getDeclaredFeatures();

	public abstract String getName(Feature feature);

	public abstract void writeExtends(OutputStreamWriter writer, String simpleClassName) throws IOException;

	/**
	 * @param wildcards needed by subclasses
	 */
	public void writeGenericParams(
		final OutputStreamWriter writer,
		final String simpleClassName,
		final String wildcards)
		throws IOException
	{
		writer.write("<B extends Generated");
		writer.write(simpleClassName);
		writer.write("Builder<?>>");
	}

	@SuppressWarnings("unused")
	public void writeTypeCast(final OutputStreamWriter writer) throws IOException
	{
		// do nothing
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

	public abstract int hashCode();
}