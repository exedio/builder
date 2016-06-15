package com.exedio.cope.builder.test;

import com.exedio.cope.Model;
import com.exedio.cope.builder.other.ConcreteItem;
import com.exedio.cope.builder.other.SubItem;
import com.exedio.cope.builder.skipped.SkippedBecauseTargetDirectoryDoesNotExistsItem;

public final class TestMain
{
	public static final Model model = new Model(
			SimpleItem.TYPE,
			FieldsItem.TYPE,
			SuperItem.TYPE, SubItem.TYPE,
			AbstractItem.TYPE, ConcreteItem.TYPE,
			CompositeItem.TYPE,
			SourcePatternItem.TYPE,
			SourceFeatureClassItem.TYPE,
			UnknownPatternItem.TYPE,
			DynamicModelItem.TYPE,
			SkippedBecauseTargetDirectoryDoesNotExistsItem.TYPE,
			GenericComplexSuper.TYPE, GenericComplexMid.TYPE, GenericComplexSub.TYPE,
			AbstractLevel1Item.TYPE, MixedLevel2Item.TYPE, ConcreteLevel3Item.TYPE
	);

	static
	{
		model.enableSerialization(TestMain.class, "model");
	}
}
