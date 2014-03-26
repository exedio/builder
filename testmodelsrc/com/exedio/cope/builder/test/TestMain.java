package com.exedio.cope.builder.test;

import com.exedio.cope.Model;
import com.exedio.cope.builder.other.ConcreteItem;
import com.exedio.cope.builder.other.SubItem;

public final class TestMain
{
	public static final Model model = new Model(
			SimpleItem.TYPE,
			FieldsItem.TYPE,
			SuperItem.TYPE, SubItem.TYPE,
			AbstractItem.TYPE, ConcreteItem.TYPE,
			CompositeItem.TYPE,
			SourcePatternItem.TYPE,
			UnknownPatternItem.TYPE,
			DynamicModelItem.TYPE,
			AbstractLevel1Item.TYPE, MixedLevel2Item.TYPE, ConcreteLevel3Item.TYPE
	);
}
