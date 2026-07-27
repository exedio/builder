package com.exedio.cope.builder.test;

@SuppressWarnings({"ClassEscapesDefinedScope", "RedundantSuppression"})
@com.exedio.cope.builder.Generated
public abstract class GeneratedSourcePatternItemBuilder<B extends GeneratedSourcePatternItemBuilder<B>>
	extends com.exedio.cope.builder.ItemBuilder<com.exedio.cope.builder.test.SourcePatternItem, B>
{
	@SuppressWarnings("unused")
	protected GeneratedSourcePatternItemBuilder()
	{
		super(SourcePatternItem.TYPE);
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
}
