package com.exedio.cope.builder.generator;

import com.exedio.cope.Model;
import com.exedio.cope.misc.ModelByString;
import java.io.File;
import java.util.ArrayList;
import java.util.StringTokenizer;

final class Params
{
	private Model model = null;

	void setModel(final String model)
	{
		this.model = ModelByString.get(model);
	}

	Model getModel()
	{
		return model;
	}

	private final ArrayList<String> packagePrefixesMatch   = new ArrayList<>();
	private final StringBuilder     packagePrefixesDisplay = new StringBuilder();

	void addPackagePrefixes(final String packagePrefixes)
	{
		for(final StringTokenizer t =
			new StringTokenizer(packagePrefixes, ",");
			t.hasMoreTokens(); )
			addPackagePrefix(t.nextToken());
	}

	private void addPackagePrefix(final String packagePrefix)
	{
		for(int i = 0; i < packagePrefix.length(); i++)
		{
			final char c = packagePrefix.charAt(i);
			if(!(
				('0' <= c && c <= '9') ||
					('A' <= c && c <= 'Z') ||
					('a' <= c && c <= 'z') ||
					c == '.'))
				throw new IllegalArgumentException(
					"packagePrefix \"" + packagePrefix + "\" contains " +
						"illegal character \"" + c + "\" at position " + i + '.');
		}
		if(packagePrefix.startsWith("."))
			throw new IllegalArgumentException(
				"packagePrefix \"" + packagePrefix + "\" must not start with dot.");
		if(packagePrefix.endsWith("."))
			throw new IllegalArgumentException(
				"packagePrefix \"" + packagePrefix + "\" must not end with dot.");

		this.packagePrefixesMatch.add(packagePrefix + '.');
		if(this.packagePrefixesDisplay.length() > 0)
			this.packagePrefixesDisplay.append(',');
		this.packagePrefixesDisplay.append(packagePrefix);
	}

	boolean matchesPackagePrefixes(final Class<?> clazz)
	{
		final String clazzName = clazz.getName();

		for(final String packagePrefixMatch : packagePrefixesMatch)
			if(clazzName.startsWith(packagePrefixMatch))
				return true;

		return false;
	}

	String getPackagePrefixes()
	{
		return packagePrefixesDisplay.toString();
	}

	private File destdir;

	void setDestdir(final File destdir)
	{
		this.destdir = destdir;
	}

	File getDestdir() throws HumanReadableException
	{
		if(destdir == null)
			throw new HumanReadableException("attribute destdir is mandatory");

		return destdir;
	}

	private boolean skipMissingTargetDirectory = true;

	boolean getSkipMissingTargetDirectory()
	{
		return skipMissingTargetDirectory;
	}

	public void setSkipMissingTargetDirectory(final boolean skipMissingTargetDirectory)
	{
		this.skipMissingTargetDirectory = skipMissingTargetDirectory;
	}
}
