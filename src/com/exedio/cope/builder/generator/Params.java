package com.exedio.cope.builder.generator;

import com.exedio.cope.Cope;
import com.exedio.cope.Model;
import java.io.File;

final class Params
{
	private Model model = null;

	void setModel(final String model)
	{
		this.model = Cope.getModel(model);
	}

	Model getModel()
	{
		return model;
	}


	private String packagePrefix = null;

	void setPackagePrefix(final String packagePrefix)
	{
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
