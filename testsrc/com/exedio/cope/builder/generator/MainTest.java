package com.exedio.cope.builder.generator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import org.junit.Ignore;
import org.junit.Test;

public class MainTest
{
	@Ignore("for debugging")
	@Test
	public void testMain() throws HumanReadableException, IOException
	{
		final Params params = new Params();
		params.setModel("com.exedio.cope.builder.test.TestMain#model");
		params.addPackagePrefixes("com.exedio.cope.builder,com.exedio.cope.builderSecond");
		params.setSkipMissingTargetDirectory(false);
		final File maintest = Files.createTempDirectory("maintest").toFile();
		System.out.println(maintest);
		params.setDestdir(maintest);
		Main.main(params);
	}
}
