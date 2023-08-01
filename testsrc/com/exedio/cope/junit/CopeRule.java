/*
 * Copyright (C) 2004-2015  exedio GmbH (www.exedio.com)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a
 * copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

package com.exedio.cope.junit;

import static java.util.Objects.requireNonNull;

import com.exedio.cope.ConnectProperties;
import com.exedio.cope.Model;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Optional;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public final class CopeRule implements
		BeforeAllCallback, AfterAllCallback,
		BeforeEachCallback, AfterEachCallback
{
	public interface Config
	{
		Model getModel();

		ConnectProperties getConnectProperties();
	}

	private Model model;

	@Override
	public void beforeAll(final ExtensionContext context)
	{
		final Optional<Class<?>> clazz = context.getTestClass();
		if (clazz.isEmpty())
			throw new IllegalArgumentException("does not have a test class");
		if (!(Config.class.isAssignableFrom(clazz.get())))
			throw new IllegalArgumentException("test class must implement " + Config.class + ", but was " + clazz.get());
	}

	@Override
	public void afterAll(final ExtensionContext context)
	{
		ModelConnector.disconnect();
	}


	@Override
	public void beforeEach(final ExtensionContext context)
	{
		final Config config = (Config) context.getTestInstance().orElseThrow();
		model = requireNonNull(config.getModel(), "model");
		if (!model.isConnected())
			ModelConnector.connectAndCreate(model, config.getConnectProperties());
		else
			model.deleteSchemaForTest(); // typically faster than checkEmptySchema

		if (!context.getTags().contains(NO_TRANSACTION))
			model.startTransaction(context.getUniqueId());
	}

	@Test
	@Tag(NO_TRANSACTION)
	@Target({ElementType.METHOD, ElementType.TYPE})
	@Retention(RetentionPolicy.RUNTIME)
	public @interface NoTransaction
	{
	}

	private static final String NO_TRANSACTION = "notransaction";

	@Override
	public void afterEach(final ExtensionContext context)
	{
		// NOTE:
		// do rollback even if @NoTransaction is absent
		// because test could have started a transaction
		model.rollbackIfNotCommitted();

		if (model.isConnected())
		{
			model.getConnectProperties().mediaFingerprintOffset().reset();
			model.setDatabaseListener(null);
		}
		model.removeAllChangeListeners();
	}


	private CopeRule()
	{
		// just make private
	}
}
