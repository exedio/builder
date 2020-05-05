package com.exedio.cope.builder.test;

import static com.exedio.cope.instrument.Visibility.NONE;

import com.exedio.cope.Item;
import com.exedio.cope.instrument.WrapInterim;
import com.exedio.cope.instrument.WrapperType;
import com.exedio.cope.pattern.Schedule;
import com.exedio.cope.util.JobContext;
import java.time.ZoneId;
import java.util.Date;

@WrapperType(constructor=NONE, genericConstructor=NONE)
final class SourcePatternItem extends Item
{
	static final Schedule schedule = Schedule.create(ZoneId.systemDefault(), SourcePatternItem::run);

	@WrapInterim(methodBody=false)
	@SuppressWarnings("MethodMayBeStatic") // OK: just a dummy
	private void run(final Date from, final Date until, final JobContext ctx)
	{
		throw new RuntimeException();
	}

	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="isEnabled")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final boolean isScheduleEnabled()
	{
		return SourcePatternItem.schedule.isEnabled(this);
	}

	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="setEnabled")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final void setScheduleEnabled(final boolean enabled)
	{
		SourcePatternItem.schedule.setEnabled(this,enabled);
	}

	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="getInterval")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final com.exedio.cope.pattern.Schedule.Interval getScheduleInterval()
	{
		return SourcePatternItem.schedule.getInterval(this);
	}

	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="setInterval")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	final void setScheduleInterval(final com.exedio.cope.pattern.Schedule.Interval interval)
	{
		SourcePatternItem.schedule.setInterval(this,interval);
	}

	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="run")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	static final void runSchedule(final com.exedio.cope.util.JobContext ctx)
	{
		SourcePatternItem.schedule.run(SourcePatternItem.class,ctx);
	}

	/**
	 * Returns the parent field of the run type of {@link #schedule}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="RunParent")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	static final com.exedio.cope.ItemField<SourcePatternItem> scheduleRunParent()
	{
		return SourcePatternItem.schedule.getRunParent(SourcePatternItem.class);
	}

	@com.exedio.cope.instrument.Generated
	private static final long serialVersionUID = 1l;

	/**
	 * The persistent type information for sourcePatternItem.
	 */
	@com.exedio.cope.instrument.Generated // customize with @WrapperType(type=...)
	static final com.exedio.cope.Type<SourcePatternItem> TYPE = com.exedio.cope.TypesBound.newType(SourcePatternItem.class);

	/**
	 * Activation constructor. Used for internal purposes only.
	 * @see com.exedio.cope.Item#Item(com.exedio.cope.ActivationParameters)
	 */
	@com.exedio.cope.instrument.Generated
	private SourcePatternItem(final com.exedio.cope.ActivationParameters ap){super(ap);}
}
