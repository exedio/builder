package com.exedio.cope.builder.generator.type;

import com.exedio.cope.Feature;
import com.exedio.cope.FunctionField;
import com.exedio.cope.builder.CompositeBuilder;
import com.exedio.cope.pattern.Composite;
import com.exedio.cope.pattern.CompositeField;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Collection;

public final class CompositeType extends MyType
{
	private final Class<? extends Composite> clazz;
	private final CompositeField<?>          field;

	public CompositeType(final Class<? extends Composite> clazz, final CompositeField<?> field)
	{
		this.clazz = clazz;
		this.field = field;
	}

	@Override
	public Class<?> getJavaClass()
	{
		return clazz;
	}

	@Override
	public Collection<? extends Feature> getDeclaredFeatures()
	{
		return field.getTemplates();
	}

	@Override
	public String getName(final Feature feature)
	{
		return Composite.getTemplateName((FunctionField<?>) feature);
	}

	@Override
	public void writeExtends(final OutputStreamWriter writer, final String simpleClassName) throws IOException
	{
		writer.write(CompositeBuilder.class.getName());
		writer.write('<');
		writer.write(clazz.getCanonicalName());
		writer.write(", B>");
	}

	@Override
	public String getTypeName()
	{
		return "class";
	}

	@Override
	public boolean equals(final Object obj)
	{
		return obj instanceof CompositeType && clazz.equals(((CompositeType) obj).clazz); // TODO maybe different fields?
	}

	@Override
	public int hashCode()
	{
		return clazz.hashCode();
	}
}