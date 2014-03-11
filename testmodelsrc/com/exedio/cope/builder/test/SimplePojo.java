package com.exedio.cope.builder.test;

public class SimplePojo
{
	private final int	integerMandatory;
	private int			integerOptional;
	private int			integerAuto;

	public SimplePojo( final int integerMandatory )
	{
		this.integerMandatory = integerMandatory;
	}

	public int getIntegerMandatory()
	{
		return integerMandatory;
	}

	public int getIntegerOptional()
	{
		return integerOptional;
	}

	public void setIntegerOptional( final int integerOptional )
	{
		this.integerOptional = integerOptional;
	}

	public int getIntegerAuto()
	{
		return integerAuto;
	}

	public void setIntegerAuto( final int integerAuto )
	{
		this.integerAuto = integerAuto;
	}
}
