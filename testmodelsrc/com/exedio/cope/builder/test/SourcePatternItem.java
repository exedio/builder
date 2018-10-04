package com.exedio.cope.builder.test;

import com.exedio.cope.Item;
import com.exedio.cope.pattern.Schedule;
import com.exedio.cope.pattern.Scheduleable;
import com.exedio.cope.util.JobContext;
import java.time.ZoneId;
import java.util.Date;

/**
 * @cope.constructor none
 * @cope.generic.constructor none
 */
final class SourcePatternItem extends Item implements Scheduleable
{
	static final Schedule schedule = new Schedule(ZoneId.systemDefault());

	@Override
	public void run(final Schedule schedule, final Date from, final Date until, final JobContext ctx)
	{
		throw new RuntimeException();
	}

	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="isEnabled")
	final boolean isScheduleEnabled()
	{
		return SourcePatternItem.schedule.isEnabled(this);
	}

	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="setEnabled")
	final void setScheduleEnabled(final boolean enabled)
	{
		SourcePatternItem.schedule.setEnabled(this,enabled);
	}

	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="getInterval")
	final com.exedio.cope.pattern.Schedule.Interval getScheduleInterval()
	{
		return SourcePatternItem.schedule.getInterval(this);
	}

	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="setInterval")
	final void setScheduleInterval(final com.exedio.cope.pattern.Schedule.Interval interval)
	{
		SourcePatternItem.schedule.setInterval(this,interval);
	}

	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="run")
	static final void runSchedule(final com.exedio.cope.util.JobContext ctx)
	{
		SourcePatternItem.schedule.run(SourcePatternItem.class,ctx);
	}

	/**
	 * Returns the parent field of the run type of {@link #schedule}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="RunParent")
	static final com.exedio.cope.ItemField<SourcePatternItem> scheduleRunParent()
	{
		return SourcePatternItem.schedule.getRunParent(SourcePatternItem.class);
	}

	@javax.annotation.Generated("com.exedio.cope.instrument")
	private static final long serialVersionUID = 1l;

	/**
	 * The persistent type information for sourcePatternItem.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @WrapperType(type=...)
	static final com.exedio.cope.Type<SourcePatternItem> TYPE = com.exedio.cope.TypesBound.newType(SourcePatternItem.class);

	/**
	 * Activation constructor. Used for internal purposes only.
	 * @see com.exedio.cope.Item#Item(com.exedio.cope.ActivationParameters)
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument")
	private SourcePatternItem(final com.exedio.cope.ActivationParameters ap){super(ap);}
}
