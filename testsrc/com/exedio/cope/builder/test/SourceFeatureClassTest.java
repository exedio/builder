package com.exedio.cope.builder.test;

import com.exedio.cope.mockframework.SourceFeatureClassPattern;
import com.exedio.cope.pattern.Range;
import org.junit.jupiter.api.Test;

public class SourceFeatureClassTest extends MainTest
{
	/**
	 * This tests checks, that methods used do exist.
	 */
	@Test
	@SuppressWarnings("RedundantCast")
	public void methodsExist()
	{
		new SourceFeatureClassItemBuilder().
			pattern_enumPublic((SourceFeatureClassPattern.EnumPublic) null).
			pattern_compositePublic((SourceFeatureClassPattern.CompositePublic) null).
			pattern_blockPublic_integer((Integer) null).
			pattern_rangeEnumPublic((Range<SourceFeatureClassPattern.EnumPublic>) null).
			pattern_rangeEnumPublic((SourceFeatureClassPattern.EnumPublic) null, (SourceFeatureClassPattern.EnumPublic) null).
			build();
	}
}
