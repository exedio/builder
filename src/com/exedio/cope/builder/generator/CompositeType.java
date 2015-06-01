package com.exedio.cope.builder.generator;

import com.exedio.cope.Feature;
import com.exedio.cope.FunctionField;
import com.exedio.cope.builder.CompositeBuilder;
import com.exedio.cope.pattern.Composite;
import com.exedio.cope.pattern.CompositeField;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Collection;

final class CompositeType extends MyType
{
	private final Class< ? extends Composite>	clazz;
	private final CompositeField< ? >			field;

	CompositeType( final Class<? extends Composite> clazz, final CompositeField<?> field )
	{
		this.clazz = clazz;
		this.field = field;
	}

	@Override
	Class<?> getJavaClass()
	{
		return clazz;
	}

	@Override
	Collection<? extends Feature> getDeclaredFeatures()
	{
		return field.getTemplates();
	}

	@Override
	String getName(final Feature feature)
	{
		return Composite.getTemplateName((FunctionField<?>)feature);
	}

	@Override
	void writeExtends(final OutputStreamWriter writer, final String simpleClassName) throws IOException
	{
		writer.write(CompositeBuilder.class.getName());
		writer.write('<');
		writer.write(clazz.getCanonicalName());
		writer.write(", B>");
	}

	@Override
	String getTypeName()
	{
		return "class";
	}
}