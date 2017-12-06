package com.exedio.cope.builder.generator.type;

import com.exedio.cope.Feature;
import com.exedio.cope.FunctionField;
import com.exedio.cope.builder.CompositeBuilder;
import com.exedio.cope.pattern.Composite;
import com.exedio.cope.pattern.CompositeField;
import java.util.List;
import javax.annotation.Nonnull;

public final class CompositeType extends MyType<Composite>
{
	private final CompositeField<?> field;

	public CompositeType(final CompositeField<?> field)
	{
		super(field.getValueClass());
		this.field = field;
	}

	@Override
	public List<? extends Feature> getDeclaredFeatures()
	{
		return field.getTemplates();
	}

	@Override
	public String getName(final Feature feature)
	{
		if(feature instanceof FunctionField)
			return Composite.getTemplateName((FunctionField<?>) feature);
		else
			throw new RuntimeException("Not implemented");
	}

	@Nonnull
	@Override
	public String getExtends()
	{
		return CompositeBuilder.class.getName() + '<' + clazz.getCanonicalName() + ", B>";
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
		return 23 * clazz.hashCode();
	}
}