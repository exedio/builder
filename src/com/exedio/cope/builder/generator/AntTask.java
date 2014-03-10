package com.exedio.cope.builder.generator;

import java.io.File;
import java.io.IOException;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;

public final class AntTask extends Task
{
	private final Params params = new Params();

	public void setModel(final String value)
	{
		params.setModel(value);
	}

	public void setPackagePrefix(final String value)
	{
		params.setPackagePrefix(value);
	}

	public void setDestdir(final File value)
	{
		params.setDestdir(value);
	}

	@Override
	public void execute() throws BuildException
	{
		try
		{
			Main.main(params);
		}
		catch(final HumanReadableException e)
		{
			throw new BuildException(e.getMessage());
		}
		catch(final IOException e)
		{
			throw new BuildException(e);
		}
	}
}
