package com.exedio.cope.builder.test;

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
			pattern_enumPublic(null).
			pattern_compositePublic(null).
			pattern_blockPublic_integer(null).
			build();
	}
}
