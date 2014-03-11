package com.exedio.cope.builder.test;

import com.exedio.cope.builder.Builder;
import com.exedio.cope.builder.PojoBuilder;

public class SimplePojoBuilder extends PojoBuilder<SimplePojo>
{

	static class IntegerAutoBuilder implements  Builder<Integer>
	{
		static int	i	= 11;

		@Override
		public Integer build()
		{
			return i++;
		}

		public static void reset()
		{
			i = 11;
		}
	}

	private Integer			integerMandatory;
	private Integer			integerOptional;
	private Integer			integerAuto;

	@Override
	public SimplePojo build()
	{
		final SimplePojo p = new SimplePojo( required( "integerMandatory", integerMandatory ) );
		p.setIntegerOptional( fallback( integerOptional, 77 ) );
		p.setIntegerAuto( fallback( integerAuto, new IntegerAutoBuilder() ) );
		return p;
	}

	public SimplePojoBuilder integerMandatory( final Integer integerMandatory )
	{
		this.integerMandatory = integerMandatory;
		return this;
	}

	public SimplePojoBuilder integerOptional( final Integer integerOptional )
	{
		this.integerOptional = integerOptional;
		return this;
	}

	public SimplePojoBuilder integerAuto( final Integer integerAuto )
	{
		this.integerAuto = integerAuto;
		return this;
	}

}
