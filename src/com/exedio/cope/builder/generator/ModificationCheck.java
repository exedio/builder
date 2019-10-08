package com.exedio.cope.builder.generator;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

final class ModificationCheck
{
	static boolean isNoUpdateRequired(final Class<?> sourceClass, final File targetFile)
	{
		final long targetLastModified = targetFile.lastModified();
		if(targetLastModified == 0)
			return false;

		final URL url = sourceClass.getResource(sourceClass.getSimpleName() + ".class");
		final URI uri;
		try
		{
			uri = url.toURI();
		}
		catch(final URISyntaxException e)
		{
			throw new RuntimeException(e);
		}
		final File sourceFile = getFileContaining(uri);
		final long sourceLastModified = sourceFile.lastModified();
		if(sourceLastModified == 0)
			throw new RuntimeException(sourceFile.getAbsolutePath());

		return sourceLastModified <= targetLastModified;
	}

	static File getFileContaining(final URI uri)
	{
		final String scheme = uri.getScheme();
		if(scheme == null)
			throw new IllegalArgumentException("scheme null in " + uri);

		switch(scheme)
		{
			case "file":
				return new File(uri);
			case "jar":
			{
				final String ssp = uri.getRawSchemeSpecificPart();
				final int exclamation = ssp.indexOf('!');
				if(exclamation < 0)
					throw new IllegalArgumentException("no exclamation in " + ssp + " from " + uri);

				final URI jar;
				try
				{
					jar = new URI(ssp.substring(0, exclamation));
				}
				catch(final URISyntaxException e)
				{
					throw new IllegalArgumentException("" + uri, e);
				}

				return getFileContaining(jar);
			}
			default:
				throw new IllegalArgumentException("scheme " + scheme + " unsupported in " + uri);
		}
	}

	private ModificationCheck()
	{
		// prevent instantiation
	}
}
