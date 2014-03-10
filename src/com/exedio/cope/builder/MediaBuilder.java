package com.exedio.cope.builder;

import com.exedio.cope.pattern.Media;
import com.exedio.cope.pattern.Media.Value;
import com.exedio.cope.pattern.MediaType;

public class MediaBuilder extends PojoBuilder<Value>
{
	public static final Builder<Value> DEFAULT = new MediaBuilder();
	public static final String CSS = "text/css";
	public static final String XSL = "application/xslt+xml";

	private String type = MediaType.PNG;

	@Override
	public Value build()
	{
		return Media.toValue(new byte[] { 0, 0, 0}, type);
	}

	public MediaBuilder type(final String type)
	{
		this.type = type;
		return this;
	}
}
