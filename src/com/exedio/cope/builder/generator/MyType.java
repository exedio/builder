package com.exedio.cope.builder.generator;

import com.exedio.cope.Feature;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Collection;

abstract class MyType
{
	abstract Class<?> getJavaClass();

	abstract Collection<? extends Feature> getDeclaredFeatures();

	abstract String getName(Feature feature);

	abstract void writeExtends(OutputStreamWriter writer, String simpleClassName) throws IOException;

	/**
	 * @param wildcards needed by subclasses
	 */
	void writeGenericParams(
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
	void writeTypeCast(final OutputStreamWriter writer) throws IOException
	{
		// do nothing
	}

	boolean enableCommonBuilder()
	{
		return false;
	}

	boolean enableTypePropagationConstructor()
	{
		return false;
	}

	abstract String getTypeName();
}