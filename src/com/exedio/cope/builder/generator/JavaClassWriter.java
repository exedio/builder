package com.exedio.cope.builder.generator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import javax.annotation.Nonnull;

public class JavaClassWriter extends OutputStreamWriter
{
	private static final String newLine = System.lineSeparator();

	JavaClassWriter(final File file) throws FileNotFoundException
	{
		super(new FileOutputStream(file), StandardCharsets.US_ASCII.newEncoder());// TODO customizable
	}

	public void writePackage(@Nonnull final String packageName) throws IOException
	{
		writeLine("package " + packageName + ';');
		writeLine();
	}

	public void writeImport(@Nonnull final String canonicalClass) throws IOException
	{
		writeLine("import " + canonicalClass + ";");
	}

	public void writeLine() throws IOException
	{
		writeLine("");
	}

	public void writeSetterAnnotation() throws IOException
	{
		writeLine("\t@com.exedio.cope.builder.Setter");
	}

	@SuppressWarnings("deprecation")
	public void writeLine(@Nonnull final String line) throws IOException
	{
		write(line);
		write(newLine);
	}

	/**
	 * Use writeLine.
	 */
	@Deprecated
	@Override
	public void write(@Nonnull final String str) throws IOException
	{
		super.write(str);
	}
}
