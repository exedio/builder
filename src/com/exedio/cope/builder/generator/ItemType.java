package com.exedio.cope.builder.generator;

import com.exedio.cope.Feature;
import com.exedio.cope.Type;
import com.exedio.cope.builder.ItemBuilder;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Collection;

final class ItemType extends MyType
{
	private final Type< ? >		type;
	private final Class< ? >	clazz;

	ItemType( final Type< ? > type, final Class< ? > clazz )
	{
		this.type = type;
		this.clazz = clazz;
	}

	@Override
	Class<?> getJavaClass()
	{
		return clazz;
	}

	@Override
	Collection<? extends Feature> getDeclaredFeatures()
	{
		return type.getDeclaredFeatures();
	}

	@Override
	String getName(final Feature feature)
	{
		return feature.getName();
	}

	@Override
	void writeGenericParams(final OutputStreamWriter writer, final String simpleClassName) throws IOException
	{
		if(type.getSubtypes().isEmpty())
		{
			super.writeGenericParams(writer, simpleClassName);
		}
		else
		{
			writer.write("<I extends ");
			writer.write(simpleClassName);
			writer.write(", ");
			writer.write("B extends Generated");
			writer.write(simpleClassName);
			writer.write("Builder<?,?>>");
		}
	}

	@Override
	void writeExtends(final OutputStreamWriter writer, final String simpleClassname) throws IOException
	{
		final Type<?> supertype = type.getSupertype();
		if(supertype!=null)
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
	boolean enableCommonBuilder()
	{
		return !type.getSubtypes().isEmpty();
	}

	@Override
	void writeTypeCast(final OutputStreamWriter writer) throws IOException
	{
		if(!type.getSubtypes().isEmpty())
			writer.write("(com.exedio.cope.Type<I>)");
	}

	@Override
	boolean enableTypePropagationConstructor()
	{
		return !type.getSubtypes().isEmpty();
	}

	@Override
	String getTypeName()
	{
		return "TYPE";
	}
}