package com.exedio.cope.builder.generator.type;

import com.exedio.cope.Feature;
import com.exedio.cope.Type;
import com.exedio.cope.builder.ItemBuilder;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Collection;

public final class ItemType extends MyType
{
	private final Type<?>  type;
	private final Class<?> clazz;

	public ItemType(final Type<?> type)
	{
		this.type = type;
		this.clazz = type.getJavaClass();
	}

	@Override
	public Class<?> getJavaClass()
	{
		return clazz;
	}

	@Override
	public Collection<? extends Feature> getDeclaredFeatures()
	{
		return type.getDeclaredFeatures();
	}

	@Override
	public String getName(final Feature feature)
	{
		return feature.getName();
	}

	@Override
	public void writeGenericParams(
		final OutputStreamWriter writer,
		final String simpleClassName,
		final String wildcards)
		throws IOException
	{
		if(type.getSubtypes().isEmpty())
		{
			super.writeGenericParams(writer, simpleClassName, wildcards);
		}
		else
		{
			writer.write("<I extends ");
			writer.write(simpleClassName);
			writer.write(wildcards);
			writer.write(", ");
			writer.write("B extends Generated");
			writer.write(simpleClassName);
			writer.write("Builder<?,?>>");
		}
	}

	@Override
	public void writeExtends(final OutputStreamWriter writer, final String simpleClassname) throws IOException
	{
		final Type<?> supertype = type.getSupertype();
		if(supertype != null)
		{
			writer.write(supertype.getJavaClass().getPackage().getName());
			writer.write(".Common");
			writer.write(supertype.getJavaClass().getSimpleName());
			if(type.getSubtypes().isEmpty())
			{
				writer.write("Builder<");
				writer.write(simpleClassname);
				writer.write(", B>");
			}
			else
			{
				writer.write("Builder<I, B>");
			}
			return;
		}

		writer.write(ItemBuilder.class.getName());
		writer.write('<');
		if(type.getSubtypes().isEmpty())
		{
			writer.write(clazz.getCanonicalName());
		}
		else
		{
			writer.write('I');
		}
		writer.write(", B>");
	}

	@Override
	public boolean enableCommonBuilder()
	{
		return !type.getSubtypes().isEmpty();
	}

	@Override
	public void writeTypeCast(final OutputStreamWriter writer) throws IOException
	{
		if(!type.getSubtypes().isEmpty())
			writer.write("(com.exedio.cope.Type<I>)");
	}

	@Override
	public boolean enableTypePropagationConstructor()
	{
		return !type.getSubtypes().isEmpty();
	}

	@Override
	public String getTypeName()
	{
		return "TYPE";
	}

	@Override
	public boolean equals(final Object obj)
	{
		return obj instanceof ItemType && clazz.equals(((ItemType) obj).clazz);
	}

	@Override
	public int hashCode()
	{
		return clazz.hashCode();
	}
}