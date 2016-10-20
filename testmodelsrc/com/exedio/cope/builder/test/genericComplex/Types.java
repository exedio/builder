package com.exedio.cope.builder.test.genericComplex;

import com.exedio.cope.TypeSet;

public final class Types
{
	public static final TypeSet types = new TypeSet(
			GenSup.TYPE,
			GenMid.TYPE,
			GenSub.TYPE);

	private Types()
	{
		// prevent instantiation
	}
}
