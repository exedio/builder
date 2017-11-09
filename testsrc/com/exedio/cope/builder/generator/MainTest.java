package com.exedio.cope.builder.generator;

import static org.junit.Assert.assertEquals;

import com.exedio.cope.Item;
import com.exedio.cope.ItemField;
import com.exedio.cope.StringField;
import com.exedio.cope.builder.other.SubItem;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.nio.file.Files;
import org.junit.Ignore;
import org.junit.Test;

public class MainTest
{
	static class WithOneUnboundParam<X> extends Item
	{
		private static final long serialVersionUID = 1L;
	}

	static class WithOneBoundParam<X extends Number> extends Item
	{
		private static final long serialVersionUID = 1L;
	}

	static class WithOneMultiboundParam<X extends Number & Serializable> extends Item
	{
		private static final long serialVersionUID = 1L;
	}

	static class WithTwoParams<X extends Number, Y> extends Item
	{
		private static final long serialVersionUID = 1L;
	}

	@Test
	public void testToSetterParameterType()
	{
		assertEquals("java.lang.String", Main.toSetterParameterType(new StringField()));
		assertEquals("com.exedio.cope.builder.other.SubItem", Main.toSetterParameterType(ItemField.create(SubItem.class)));
		assertEquals("int", Main.toSetterParameterType(SubItem.TYPE.getFeature("subField")));
		assertEquals(
			"com.exedio.cope.builder.generator.MainTest.WithOneUnboundParam<?>",
			Main.toSetterParameterType(ItemField.create(WithOneUnboundParam.class))
		);
		assertEquals(
			"com.exedio.cope.builder.generator.MainTest.WithOneMultiboundParam<?>",
			Main.toSetterParameterType(ItemField.create(WithOneMultiboundParam.class))
		);
		assertEquals(
			"com.exedio.cope.builder.generator.MainTest.WithTwoParams<?,?>",
			Main.toSetterParameterType(ItemField.create(WithTwoParams.class))
		);
	}

	@Test
	public void testSpaceInPath()
	{
		final File file = new File("with space");
		final URI uri = file.toURI();
		assertEquals(file.getAbsoluteFile(), Main.getFileContaining(uri));
	}

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
