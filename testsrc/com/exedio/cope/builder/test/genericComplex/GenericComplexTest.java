package com.exedio.cope.builder.test.genericComplex;

import static org.junit.Assert.assertEquals;

import com.exedio.cope.builder.test.MainTest;
import com.exedio.cope.builder.test.genericComplex.GeneratedGenMidBuilder.GenMidBuilder;
import com.exedio.cope.builder.test.genericComplex.GeneratedGenSupBuilder.GenSupBuilder;
import org.junit.Test;

public class GenericComplexTest extends MainTest
{
	@Test
	public void fallback()
	{
		final GenSource i = new GenSourceBuilder().build();
		assertEquals(null, i.getSup());
		assertEquals(null, i.getMid());
		assertEquals(null, i.getSub());
	}
	@Test
	public void set()
	{
		final GenSup<?,?> sup = new GenSupBuilder().build();
		final GenMid<?>   mid = new GenMidBuilder().build();
		final GenSub      sub = new GenSubBuilder().build();

		final GenSource i = new GenSourceBuilder().
				sup(sup).
				mid(mid).
				sub(sub).
				build();
		assertEquals(sup, i.getSup());
		assertEquals(mid, i.getMid());
		assertEquals(sub, i.getSub());
	}
}
