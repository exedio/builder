package com.exedio.cope.mockframework;

import com.exedio.cope.EnumField;
import com.exedio.cope.IntegerField;
import com.exedio.cope.Pattern;
import com.exedio.cope.SetValue;
import com.exedio.cope.instrument.WrapperIgnore;
import com.exedio.cope.pattern.Block;
import com.exedio.cope.pattern.BlockActivationParameters;
import com.exedio.cope.pattern.BlockField;
import com.exedio.cope.pattern.BlockType;
import com.exedio.cope.pattern.Composite;
import com.exedio.cope.pattern.CompositeField;
import com.exedio.cope.pattern.RangeField;

@WrapperIgnore
public final class SourceFeatureClassPattern extends Pattern
{
	public enum EnumPublic { A,B }
	enum EnumPackage { A,B }


	public static final class CompositePublic extends Composite
	{
		static final IntegerField integer = new IntegerField();
		CompositePublic(final SetValue<?>... sv) { super(sv); }
		private static final long serialVersionUID = 1l;
	}
	static final class CompositePackage extends Composite
	{
		static final IntegerField integer = new IntegerField();
		CompositePackage(final SetValue<?>... sv) { super(sv); }
		private static final long serialVersionUID = 1l;
	}


	public static final class BlockPublic extends Block
	{
		static final IntegerField integer = new IntegerField().optional();
		BlockPublic(final BlockActivationParameters ap) { super(ap); }
		static final BlockType<BlockPublic> TYPE = BlockType.newType(BlockPublic.class);
		private static final long serialVersionUID = 1l;
	}
	static final class BlockPackage extends Block
	{
		static final IntegerField integer = new IntegerField().optional();
		BlockPackage(final BlockActivationParameters ap) { super(ap); }
		static final BlockType<BlockPackage> TYPE = BlockType.newType(BlockPackage.class);
		private static final long serialVersionUID = 1l;
	}


	public SourceFeatureClassPattern()
	{
		addSourceFeature(EnumField.create(EnumPublic.class).optional(), "enumPublic");
		addSourceFeature(EnumField.create(EnumPackage.class).optional(), "enumPackage");
		addSourceFeature(CompositeField.create(CompositePublic.class).optional(), "compositePublic");
		addSourceFeature(CompositeField.create(CompositePackage.class).optional(), "compositePackage");
		addSourceFeature(BlockField.create(BlockPublic.TYPE), "blockPublic");
		addSourceFeature(BlockField.create(BlockPackage.TYPE), "blockPackage");
		addSourceFeature(RangeField.create(EnumField.create(EnumPublic.class).optional()), "rangeEnumPublic");
		addSourceFeature(RangeField.create(EnumField.create(EnumPackage.class).optional()), "rangeEnumPackage");
	}


	private static final long serialVersionUID = 1l;
}
