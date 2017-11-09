package com.exedio.cope.builder.generator;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.net.URI;
import org.junit.Test;

public class ModificationCheckTest
{
	@Test
	public void testSpaceInPath()
	{
		final File file = new File("with space");
		final URI uri = file.toURI();
		assertEquals(file.getAbsoluteFile(), ModificationCheck.getFileContaining(uri));
	}
}