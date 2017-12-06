package com.exedio.cope.builder.generator.type;

import com.exedio.cope.Feature;
import com.exedio.cope.Item;
import com.exedio.cope.Type;
import com.exedio.cope.builder.ItemBuilder;
import java.util.List;
import javax.annotation.Nonnull;

public final class ItemType extends MyType<Item>
{
	private final Type<?> type;

	public ItemType(final Type<?> type)
	{
		super(type.getJavaClass());
		this.type = type;
	}

	@Override
	public List<? extends Feature> getDeclaredFeatures()
	{
		return type.getDeclaredFeatures();
	}

	@Override
	public String getName(final Feature feature)
	{
		return feature.getName();
	}

	@Nonnull
	@Override
	public String getGenericParams()
	{
		if(!hasSubTypes())
			return super.getGenericParams();
		return "<I extends " + simpleClassName + wildCards + ", " + "B extends Generated" + simpleClassName + "Builder <?,?>>";
	}

	@Nonnull
	@Override
	public String getExtends()
	{
		final String className = hasSubTypes() ? "I" : clazz.getCanonicalName();
		final Type<?> supertype = type.getSupertype();
		if(supertype != null)
		{
			Class<?> superClass = supertype.getJavaClass();
			return superClass.getPackage().getName() + ".Common" + superClass.getSimpleName() + "Builder<" + className + ", B>";
		}

		return ItemBuilder.class.getName() + '<' + className + ", B>";
	}

	@Override
	public boolean enableCommonBuilder()
	{
		return hasSubTypes();
	}

	@Nonnull
	@Override
	public String getTypeCast()
	{
		if(hasSubTypes())
			return "(com.exedio.cope.Type<I>)";
		return "";
	}

	@Override
	public boolean enableTypePropagationConstructor()
	{
		return hasSubTypes();
	}

	private boolean hasSubTypes()
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
		return 17 * clazz.hashCode();
	}
}