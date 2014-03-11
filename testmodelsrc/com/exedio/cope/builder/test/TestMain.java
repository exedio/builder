package com.exedio.cope.builder.test;

import com.exedio.cope.Model;

public final class TestMain
{
	public static final Model model = new Model(
			SimpleItem.TYPE,
			FieldsItem.TYPE,
			SuperItem.TYPE, SubItem.TYPE,
			AbstractItem.TYPE, ConcreteItem.TYPE,
			CompositeItem.TYPE
	);
}
