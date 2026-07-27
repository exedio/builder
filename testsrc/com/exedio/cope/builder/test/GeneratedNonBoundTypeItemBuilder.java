package com.exedio.cope.builder.test;

@SuppressWarnings({"ClassEscapesDefinedScope", "RedundantSuppression"})
@com.exedio.cope.builder.Generated
public abstract class GeneratedNonBoundTypeItemBuilder<B extends GeneratedNonBoundTypeItemBuilder<B>>
	extends com.exedio.cope.builder.ItemBuilder<com.exedio.cope.builder.test.NonBoundTypeItem, B>
{
	@SuppressWarnings("unused")
	protected GeneratedNonBoundTypeItemBuilder()
	{
		super(NonBoundTypeItem.TYPE);
	}

	protected final com.exedio.cope.Settable<java.lang.Boolean> schedule_enabled = getFeature("schedule-enabled");

	@com.exedio.cope.builder.Setter
	public final B schedule_enabled(final boolean schedule_enabled)
	{
		return set(this.schedule_enabled,schedule_enabled);
	}

	protected final com.exedio.cope.Settable<com.exedio.cope.pattern.Schedule.Interval> schedule_interval = getFeature("schedule-interval");

	@com.exedio.cope.builder.Setter
	public final B schedule_interval(final com.exedio.cope.pattern.Schedule.Interval schedule_interval)
	{
		return set(this.schedule_interval,schedule_interval);
	}

	protected final com.exedio.cope.Settable<com.exedio.cope.pattern.Schedule.Run> token = getFeature("token");

	@com.exedio.cope.builder.Setter
	public final B token(final com.exedio.cope.pattern.Schedule.Run token)
	{
		return set(this.token,token);
	}
}
