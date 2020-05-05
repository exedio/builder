package com.exedio.cope.builder.test;

import static com.exedio.cope.instrument.Visibility.NONE;

import com.exedio.cope.Item;
import com.exedio.cope.ItemField;
import com.exedio.cope.ItemField.DeletePolicy;
import com.exedio.cope.instrument.WrapInterim;
import com.exedio.cope.instrument.WrapperType;
import com.exedio.cope.pattern.Schedule;
import com.exedio.cope.pattern.Schedule.Run;
import com.exedio.cope.util.JobContext;
import java.time.ZoneId;
import java.util.Date;

@WrapperType(constructor=NONE, genericConstructor=NONE)
final class NonBoundTypeItem extends Item
{
	private static final Schedule schedule = Schedule.create(ZoneId.of("Europe/Berlin"), NonBoundTypeItem::run);

	private static final ItemField<Run> token = ItemField.create(Run.class, schedule::getRunType, DeletePolicy.CASCADE);

	@WrapInterim(methodBody=false)
	@SuppressWarnings("EmptyMethod") // OK: just a dummy
	private void run(final Date from, final Date until, final JobContext ctx)
	{
	}

	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="isEnabled")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	private boolean isScheduleEnabled()
	{
		return NonBoundTypeItem.schedule.isEnabled(this);
	}

	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="setEnabled")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	private void setScheduleEnabled(final boolean enabled)
	{
		NonBoundTypeItem.schedule.setEnabled(this,enabled);
	}

	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="getInterval")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	private com.exedio.cope.pattern.Schedule.Interval getScheduleInterval()
	{
		return NonBoundTypeItem.schedule.getInterval(this);
	}

	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="setInterval")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	private void setScheduleInterval(final com.exedio.cope.pattern.Schedule.Interval interval)
	{
		NonBoundTypeItem.schedule.setInterval(this,interval);
	}

	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="run")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	private static void runSchedule(final com.exedio.cope.util.JobContext ctx)
	{
		NonBoundTypeItem.schedule.run(NonBoundTypeItem.class,ctx);
	}

	/**
	 * Returns the parent field of the run type of {@link #schedule}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="RunParent")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	private static com.exedio.cope.ItemField<NonBoundTypeItem> scheduleRunParent()
	{
		return NonBoundTypeItem.schedule.getRunParent(NonBoundTypeItem.class);
	}

	/**
	 * Returns the value of {@link #token}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="get")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	private Run getToken()
	{
		return NonBoundTypeItem.token.get(this);
	}

	/**
	 * Sets a new value for {@link #token}.
	 */
	@com.exedio.cope.instrument.Generated // customize with @Wrapper(wrap="set")
	@java.lang.SuppressWarnings({"FinalMethodInFinalClass","RedundantSuppression","TypeParameterExtendsFinalClass","UnnecessarilyQualifiedStaticUsage"})
	private void setToken(final Run token)
			throws
				com.exedio.cope.MandatoryViolationException
	{
		NonBoundTypeItem.token.set(this,token);
	}

	@com.exedio.cope.instrument.Generated
	private static final long serialVersionUID = 1l;

	/**
	 * The persistent type information for nonBoundTypeItem.
	 */
	@com.exedio.cope.instrument.Generated // customize with @WrapperType(type=...)
	static final com.exedio.cope.Type<NonBoundTypeItem> TYPE = com.exedio.cope.TypesBound.newType(NonBoundTypeItem.class);

	/**
	 * Activation constructor. Used for internal purposes only.
	 * @see com.exedio.cope.Item#Item(com.exedio.cope.ActivationParameters)
	 */
	@com.exedio.cope.instrument.Generated
	private NonBoundTypeItem(final com.exedio.cope.ActivationParameters ap){super(ap);}
}
