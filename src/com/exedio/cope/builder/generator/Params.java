package com.exedio.cope.builder.generator;

import com.exedio.cope.Model;
import com.exedio.cope.misc.ModelByString;
import java.io.File;

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


	private String packagePrefix = null;

	void setPackagePrefix(final String packagePrefix)
	{
		for(int i = 0; i<packagePrefix.length(); i++)
		{
			final char c = packagePrefix.charAt(i);
			if(!(
				('0'<=c && c<='9') ||
				('A'<=c && c<='Z') ||
				('a'<=c && c<='z') ||
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

		this.packagePrefix = packagePrefix + '.';
	}

	String getPackagePrefix()
	{
		return packagePrefix;
	}


	private File destdir;

	void setDestdir(final File destdir)
	{
		this.destdir = destdir;
	}

	File getDestdir() throws HumanReadableException
	{
		if(destdir==null)
			throw new HumanReadableException("attribute destdir is mandatory");

		return destdir;
	}
}
