package com.exedio.cope.builder.test;

import com.exedio.cope.ConnectProperties;
import com.exedio.cope.Model;
import com.exedio.cope.junit.CopeRule;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(CopeRule.class)

public class MainTest implements CopeRule.Config
{
	@Override
	public final Model getModel()
	{
		return TestMain.model;
	}

	@Override
	public final ConnectProperties getConnectProperties()
	{
		return new ConnectProperties(ConnectProperties.getDefaultPropertyFile());
	}
}
