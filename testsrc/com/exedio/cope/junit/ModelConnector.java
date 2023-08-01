/*
 * Copyright (C) 2004-2015  exedio GmbH (www.exedio.com)
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package com.exedio.cope.junit;

import com.exedio.cope.ConnectProperties;
import com.exedio.cope.Model;
import com.exedio.dsmf.Node;

final class ModelConnector implements Runnable
{
	private static Model connectedSchema = null;
	private static boolean registeredDropSchemaHook = false;
	private static final Object lock = new Object();

	private ModelConnector()
	{
		// prevent instantiation
	}

	static void connectAndCreate(final Model model, final ConnectProperties properties)
	{
		synchronized (lock)
		{
			if (connectedSchema != model)
			{
				disconnectIfNeeded();
				model.connect(properties);
				if (model.getVerifiedSchema().getCumulativeColor() == Node.Color.ERROR)
				{
					model.tearDownSchema();
					model.createSchema();
				}
				else
				{
					model.deleteSchemaForTest();
				}
				connectedSchema = model;
			}
			else
				model.getConnectProperties().ensureEquality(properties);
		}
	}

	static void disconnect()
	{
		synchronized (lock)
		{
			if (!registeredDropSchemaHook)
			{
				Runtime.getRuntime().addShutdownHook(new Thread(new ModelConnector()));
				registeredDropSchemaHook = true;
			}
		}
	}

	private static void disconnectIfNeeded()
	{
		synchronized (lock)
		{
			if (connectedSchema != null)
			{
				connectedSchema.disconnect();
				connectedSchema = null;
			}
		}
	}

	@Override
	public void run()
	{
		disconnectIfNeeded();
	}
}
