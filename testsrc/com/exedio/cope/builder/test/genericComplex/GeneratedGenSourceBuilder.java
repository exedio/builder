package com.exedio.cope.builder.test.genericComplex;

@SuppressWarnings({"ClassEscapesDefinedScope", "RedundantSuppression"})
@com.exedio.cope.builder.Generated
public abstract class GeneratedGenSourceBuilder<B extends GeneratedGenSourceBuilder<B>>
	extends com.exedio.cope.builder.ItemBuilder<com.exedio.cope.builder.test.genericComplex.GenSource, B>
{
	@SuppressWarnings("unused")
	protected GeneratedGenSourceBuilder()
	{
		super(GenSource.TYPE);
	}

	protected final com.exedio.cope.Settable<com.exedio.cope.builder.test.genericComplex.GenSup<?,?>> sup = getFeature("sup");

	@com.exedio.cope.builder.Setter
	public final B sup(final com.exedio.cope.builder.test.genericComplex.GenSup<?,?> sup)
	{
		return set(this.sup,sup);
	}

	protected final com.exedio.cope.Settable<com.exedio.cope.builder.test.genericComplex.GenMid<?>> mid = getFeature("mid");

	@com.exedio.cope.builder.Setter
	public final B mid(final com.exedio.cope.builder.test.genericComplex.GenMid<?> mid)
	{
		return set(this.mid,mid);
	}

	protected final com.exedio.cope.Settable<com.exedio.cope.builder.test.genericComplex.GenSub> sub = getFeature("sub");

	@com.exedio.cope.builder.Setter
	public final B sub(final com.exedio.cope.builder.test.genericComplex.GenSub sub)
	{
		return set(this.sub,sub);
	}

	@com.exedio.cope.builder.Setter
	public final B sub(final java.util.function.Function<com.exedio.cope.builder.test.genericComplex.GenSubBuilder, com.exedio.cope.builder.test.genericComplex.GenSubBuilder> subBuilderConsumer)
	{
		return sub(subBuilderConsumer.apply( new com.exedio.cope.builder.test.genericComplex.GenSubBuilder() ).build());
	}

	@com.exedio.cope.builder.Setter
	public final B subNull()
	{
		return sub((com.exedio.cope.builder.test.genericComplex.GenSub) null);
	}

	protected final com.exedio.cope.Settable<com.exedio.cope.pattern.Money<com.exedio.cope.builder.test.genericComplex.GenSup<?,?>>> moneySup = getFeature("moneySup");

	@com.exedio.cope.builder.Setter
	public final B moneySup(final com.exedio.cope.pattern.Money<com.exedio.cope.builder.test.genericComplex.GenSup<?,?>> moneySup)
	{
		return set(this.moneySup,moneySup);
	}

	@com.exedio.cope.builder.Setter
	public final B moneySup(final double value,final com.exedio.cope.builder.test.genericComplex.GenSup<?,?> currency)
	{
		return moneySup(com.exedio.cope.pattern.Money.valueOf(value,currency));
	}

	@com.exedio.cope.builder.Setter
	public final B moneySup(final int store,final com.exedio.cope.builder.test.genericComplex.GenSup<?,?> currency)
	{
		return moneySup(com.exedio.cope.pattern.Money.storeOf(store,currency));
	}

	protected final com.exedio.cope.Settable<com.exedio.cope.pattern.Money<com.exedio.cope.builder.test.genericComplex.GenMid<?>>> moneyMid = getFeature("moneyMid");

	@com.exedio.cope.builder.Setter
	public final B moneyMid(final com.exedio.cope.pattern.Money<com.exedio.cope.builder.test.genericComplex.GenMid<?>> moneyMid)
	{
		return set(this.moneyMid,moneyMid);
	}

	@com.exedio.cope.builder.Setter
	public final B moneyMid(final double value,final com.exedio.cope.builder.test.genericComplex.GenMid<?> currency)
	{
		return moneyMid(com.exedio.cope.pattern.Money.valueOf(value,currency));
	}

	@com.exedio.cope.builder.Setter
	public final B moneyMid(final int store,final com.exedio.cope.builder.test.genericComplex.GenMid<?> currency)
	{
		return moneyMid(com.exedio.cope.pattern.Money.storeOf(store,currency));
	}

	protected final com.exedio.cope.Settable<com.exedio.cope.pattern.Money<com.exedio.cope.builder.test.genericComplex.GenSub>> moneySub = getFeature("moneySub");

	@com.exedio.cope.builder.Setter
	public final B moneySub(final com.exedio.cope.pattern.Money<com.exedio.cope.builder.test.genericComplex.GenSub> moneySub)
	{
		return set(this.moneySub,moneySub);
	}

	@com.exedio.cope.builder.Setter
	public final B moneySub(final double value,final com.exedio.cope.builder.test.genericComplex.GenSub currency)
	{
		return moneySub(com.exedio.cope.pattern.Money.valueOf(value,currency));
	}

	@com.exedio.cope.builder.Setter
	public final B moneySub(final int store,final com.exedio.cope.builder.test.genericComplex.GenSub currency)
	{
		return moneySub(com.exedio.cope.pattern.Money.storeOf(store,currency));
	}

	protected final com.exedio.cope.pattern.SetField<com.exedio.cope.builder.test.genericComplex.GenSup<?,?>> setSup = getFeature("setSup");

	@com.exedio.cope.builder.Setter
	public final B setSup(final java.util.Set<com.exedio.cope.builder.test.genericComplex.GenSup<?,?>> setSup)
	{
		return set(this.setSup,setSup);
	}

	@com.exedio.cope.builder.Setter
	public final B setSup(final com.exedio.cope.builder.test.genericComplex.GenSup<?,?>... setSup)
	{
		return setSup(new java.util.LinkedHashSet<>(java.util.Arrays.asList(setSup)));
	}

	protected final com.exedio.cope.pattern.SetField<com.exedio.cope.builder.test.genericComplex.GenMid<?>> setMid = getFeature("setMid");

	@com.exedio.cope.builder.Setter
	public final B setMid(final java.util.Set<com.exedio.cope.builder.test.genericComplex.GenMid<?>> setMid)
	{
		return set(this.setMid,setMid);
	}

	@com.exedio.cope.builder.Setter
	public final B setMid(final com.exedio.cope.builder.test.genericComplex.GenMid<?>... setMid)
	{
		return setMid(new java.util.LinkedHashSet<>(java.util.Arrays.asList(setMid)));
	}

	protected final com.exedio.cope.pattern.SetField<com.exedio.cope.builder.test.genericComplex.GenSub> setSub = getFeature("setSub");

	@com.exedio.cope.builder.Setter
	public final B setSub(final java.util.Set<com.exedio.cope.builder.test.genericComplex.GenSub> setSub)
	{
		return set(this.setSub,setSub);
	}

	@com.exedio.cope.builder.Setter
	public final B setSub(final com.exedio.cope.builder.test.genericComplex.GenSub... setSub)
	{
		return setSub(new java.util.LinkedHashSet<>(java.util.Arrays.asList(setSub)));
	}

	protected final com.exedio.cope.pattern.ListField<com.exedio.cope.builder.test.genericComplex.GenSup<?,?>> listSup = getFeature("listSup");

	@com.exedio.cope.builder.Setter
	public final B listSup(final java.util.List<com.exedio.cope.builder.test.genericComplex.GenSup<?,?>> listSup)
	{
		return set(this.listSup,listSup);
	}

	@com.exedio.cope.builder.Setter
	public final B listSup(final com.exedio.cope.builder.test.genericComplex.GenSup<?,?>... listSup)
	{
		return listSup(java.util.Arrays.asList(listSup));
	}

	protected final com.exedio.cope.pattern.ListField<com.exedio.cope.builder.test.genericComplex.GenMid<?>> listMid = getFeature("listMid");

	@com.exedio.cope.builder.Setter
	public final B listMid(final java.util.List<com.exedio.cope.builder.test.genericComplex.GenMid<?>> listMid)
	{
		return set(this.listMid,listMid);
	}

	@com.exedio.cope.builder.Setter
	public final B listMid(final com.exedio.cope.builder.test.genericComplex.GenMid<?>... listMid)
	{
		return listMid(java.util.Arrays.asList(listMid));
	}

	protected final com.exedio.cope.pattern.ListField<com.exedio.cope.builder.test.genericComplex.GenSub> listSub = getFeature("listSub");

	@com.exedio.cope.builder.Setter
	public final B listSub(final java.util.List<com.exedio.cope.builder.test.genericComplex.GenSub> listSub)
	{
		return set(this.listSub,listSub);
	}

	@com.exedio.cope.builder.Setter
	public final B listSub(final com.exedio.cope.builder.test.genericComplex.GenSub... listSub)
	{
		return listSub(java.util.Arrays.asList(listSub));
	}

	protected final com.exedio.cope.Settable<com.exedio.cope.builder.test.genericComplex.GenSub> subFallback = getFeature("subFallback");

	@com.exedio.cope.builder.Setter
	public final B subFallback(final com.exedio.cope.builder.test.genericComplex.GenSub subFallback)
	{
		return set(this.subFallback,subFallback);
	}

	@com.exedio.cope.builder.Setter
	public final B subFallback(final java.util.function.Function<com.exedio.cope.builder.test.genericComplex.GenSubBuilder, com.exedio.cope.builder.test.genericComplex.GenSubBuilder> subFallbackBuilderConsumer)
	{
		return subFallback(subFallbackBuilderConsumer.apply( new com.exedio.cope.builder.test.genericComplex.GenSubBuilder() ).build());
	}

	@com.exedio.cope.builder.Setter
	public final B subFallbackNull()
	{
		return subFallback((com.exedio.cope.builder.test.genericComplex.GenSub) null);
	}

	protected final com.exedio.cope.Settable<com.exedio.cope.builder.test.genericComplex.GenSub> subMandatory = getFeature("subMandatory");

	@com.exedio.cope.builder.Setter
	public final B subMandatory(final com.exedio.cope.builder.test.genericComplex.GenSub subMandatory)
	{
		return set(this.subMandatory,subMandatory);
	}

	@com.exedio.cope.builder.Setter
	public final B subMandatory(final java.util.function.Function<com.exedio.cope.builder.test.genericComplex.GenSubBuilder, com.exedio.cope.builder.test.genericComplex.GenSubBuilder> subMandatoryBuilderConsumer)
	{
		return subMandatory(subMandatoryBuilderConsumer.apply( new com.exedio.cope.builder.test.genericComplex.GenSubBuilder() ).build());
	}

	protected final com.exedio.cope.pattern.MapField<com.exedio.cope.builder.test.genericComplex.GenSup<?,?>,com.exedio.cope.builder.test.genericComplex.GenSup<?,?>> mapSup = getFeature("mapSup");

	@com.exedio.cope.builder.Setter
	public final B mapSup(final java.util.Map<com.exedio.cope.builder.test.genericComplex.GenSup<?,?>,com.exedio.cope.builder.test.genericComplex.GenSup<?,?>> mapSup)
	{
		return set(this.mapSup,mapSup);
	}

	protected final com.exedio.cope.pattern.MapField<com.exedio.cope.builder.test.genericComplex.GenMid<?>,com.exedio.cope.builder.test.genericComplex.GenMid<?>> mapMid = getFeature("mapMid");

	@com.exedio.cope.builder.Setter
	public final B mapMid(final java.util.Map<com.exedio.cope.builder.test.genericComplex.GenMid<?>,com.exedio.cope.builder.test.genericComplex.GenMid<?>> mapMid)
	{
		return set(this.mapMid,mapMid);
	}

	protected final com.exedio.cope.pattern.MapField<com.exedio.cope.builder.test.genericComplex.GenSub,com.exedio.cope.builder.test.genericComplex.GenSub> mapSub = getFeature("mapSub");

	@com.exedio.cope.builder.Setter
	public final B mapSub(final java.util.Map<com.exedio.cope.builder.test.genericComplex.GenSub,com.exedio.cope.builder.test.genericComplex.GenSub> mapSub)
	{
		return set(this.mapSub,mapSub);
	}
}
