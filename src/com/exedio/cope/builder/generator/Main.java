package com.exedio.cope.builder.generator;

import com.exedio.cope.Feature;
import com.exedio.cope.Model;
import com.exedio.cope.Type;
import com.exedio.cope.builder.generator.type.CompositeType;
import com.exedio.cope.builder.generator.type.ItemType;
import com.exedio.cope.builder.generator.type.MyType;
import com.exedio.cope.pattern.Composite;
import com.exedio.cope.pattern.CompositeField;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;

final class Main
{
	static final void main(final Params params) throws HumanReadableException, IOException
	{
		final Model model = params.getModel();

		final ArrayList<Class<?>> skippedPackagePrefix = new ArrayList<>();
		final HashMap<File, ArrayList<Class<?>>> skippedTargetDirectoryDoesNotExist = new HashMap<>();
		final AtomicInteger progress = new AtomicInteger(0);
		final HashSet<MyType> generated = new HashSet<>();
		final List<DelayedWriter> writer = new LinkedList<>();
		for(final Type<?> type : model.getTypes())
		{
			if(!type.isBound())
				continue;

			final Class<?> clazz = type.getJavaClass();
			if(!params.matchesPackagePrefixes(clazz))
			{
				skippedPackagePrefix.add(clazz);
				continue;
			}

			writer.add(writeFiles(params, new ItemType(type), skippedTargetDirectoryDoesNotExist, progress, generated));
		}

		final HashSet<Class<? extends Composite>> compositeClasses = new HashSet<>();
		for(final Type<?> type : model.getTypes())
		{
			for(final Feature feature : type.getDeclaredFeatures())
			{
				if(!(feature instanceof CompositeField<?>))
					continue;

				final CompositeField<?> field = (CompositeField<?>) feature;

				final Class<? extends Composite> clazz = field.getValueClass();
				if(!params.matchesPackagePrefixes(clazz))
				{
					skippedPackagePrefix.add(clazz);
					continue;
				}

				if(!compositeClasses.add(clazz))
					continue;

				writer.add(writeFiles(params, new CompositeType(clazz, field), skippedTargetDirectoryDoesNotExist, progress, generated));
			}
		}
		for(DelayedWriter delayedWriter : writer)
		{
			if(delayedWriter == null)
				continue;
			delayedWriter.write();
		}

		printSummary(params, model, skippedPackagePrefix, skippedTargetDirectoryDoesNotExist, progress.get());
	}

	private static void printSummary(final Params params, final Model model, final ArrayList<Class<?>> skippedPackagePrefix,
		final HashMap<File, ArrayList<Class<?>>> skippedTargetDirectoryDoesNotExist, int generatedBuilders)
	{
		switch(skippedPackagePrefix.size())
		{
			case 0: // nothing
				break;
			case 1:
				final String clasName = skippedPackagePrefix.get(0).getName();
				System.out.println("Skipping " + clasName + " because not in packagePrefix '" + params.getPackagePrefixes() + "'.");
				break;
			default:
				System.out.println("Skipping " + skippedPackagePrefix.size() + " classes because not in packagePrefix '" + params.getPackagePrefixes() + "'.");
				break;
		}
		for(final Map.Entry<File, ArrayList<Class<?>>> entry : skippedTargetDirectoryDoesNotExist.entrySet())
		{
			final ArrayList<Class<?>> classes = entry.getValue();
			if(classes.size() == 1)
				System.out.println("Skipping " + classes.get(0).getName() + " because target directory does not exist: " + entry.getKey().getAbsolutePath());
			else
				System.out.println("Skipping " + classes.size() + " classes because target directory does not exist: " + entry.getKey().getAbsolutePath());
		}
		{
			if(generatedBuilders > 0)
				System.out.println("Generated " + generatedBuilders + " builders for " + model + " in '" + params.getPackagePrefixes() + "'.");
		}
	}

	@Nullable
	private static final DelayedWriter writeFiles(
		final Params params,
		final MyType type,
		final HashMap<File, ArrayList<Class<?>>> skippedTargetDirectoryDoesNotExist,
		final AtomicInteger progress,
		final Set<MyType> generated)
		throws HumanReadableException, IOException
	{
		final Class<?> clazz = type.getJavaClass();
		final String packageName = clazz.getPackage().getName();
		final String simpleClassName = clazz.getSimpleName();

		final File dir = new File(
			params.getDestdir(),
			packageName.replace('.', '/'));

		if(!dir.exists())
		{
			if(params.getSkipMissingTargetDirectory())
			{
				ArrayList<Class<?>> classes = skippedTargetDirectoryDoesNotExist.get(dir);
				if(classes == null)
				{
					classes = new ArrayList<>();
					skippedTargetDirectoryDoesNotExist.put(dir, classes);
				}
				classes.add(clazz);
				return null;
			}
			else
			{
				if(!dir.mkdirs())
					throw new IOException("Couldn't create " + dir);
			}
		}
		if(!dir.isDirectory())
			throw new HumanReadableException("expected directory: " + dir.getAbsolutePath());

		generated.add(type);
		return () -> {
			final String wildcards = Writer.typeParameterWildCards(clazz);
			writeGenerated(type, clazz, packageName, simpleClassName, wildcards, dir, progress, generated);
			writeConcrete(type, packageName, simpleClassName, wildcards, dir);
		};
	}

	interface DelayedWriter
	{
		void write() throws IOException;
	}

	private static void writeGenerated(
		final MyType type, final Class<?> clazz,
		final String packageName, final String simpleClassName, final String wildcards,
		final File dir, final AtomicInteger progress, final Set<MyType> generated)
		throws IOException
	{
		final File file = new File(dir, "Generated" + simpleClassName + "Builder.java");

		if(ModificationCheck.isNoUpdateRequired(clazz, file))
			return;

		final CharsetEncoder encoder = StandardCharsets.US_ASCII.newEncoder(); // TODO customizable
		try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file), encoder))
		{
			Writer.writeGeneratedBuilder(type, packageName, simpleClassName, wildcards, writer, generated);
		}
		progress.incrementAndGet();
	}

	private static void writeConcrete(
		final MyType type,
		final String packageName,
		final String simpleClassName,
		final String wildcards,
		final File dir)
		throws IOException
	{

		final File file = new File(dir, (type.enableCommonBuilder() ? "Common" : "") + simpleClassName + "Builder.java");

		if(file.exists())
			return;

		final CharsetEncoder encoder = StandardCharsets.US_ASCII.newEncoder(); // TODO customizable
		try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file), encoder))
		{
			Writer.writeConcreteBuilder(type, packageName, simpleClassName, wildcards, writer);
		}
	}

	private Main()
	{
		// prevent instantiation
	}
}
