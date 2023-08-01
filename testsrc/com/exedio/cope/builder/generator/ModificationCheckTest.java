package com.exedio.cope.builder.generator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.net.URI;
import org.junit.jupiter.api.Test;

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