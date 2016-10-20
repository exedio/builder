package com.exedio.cope.builder.test;

import com.exedio.cope.mockframework.SourceFeatureClassPattern;
import org.junit.Test;

public class SourceFeatureClassTest extends MainTest
{
	/**
	 * This tests checks, that methods used do exist.
	 */
	@Test
	public void methodsExist()
	{
		new SourceFeatureClassItemBuilder().
			pattern_enumPublic((SourceFeatureClassPattern.EnumPublic)null).
			pattern_compositePublic((SourceFeatureClassPattern.CompositePublic)null).
			pattern_blockPublic_integer((Integer)null).
			build();
	}
}
