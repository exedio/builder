package com.exedio.cope.builder.test;

import static com.exedio.cope.instrument.Visibility.NONE;

import com.exedio.cope.Item;
import com.exedio.cope.ItemField;
import com.exedio.cope.ItemField.DeletePolicy;
import com.exedio.cope.instrument.WrapperType;
import com.exedio.cope.pattern.Schedule;
import com.exedio.cope.pattern.Schedule.Run;
import com.exedio.cope.pattern.Scheduleable;
import com.exedio.cope.util.JobContext;
import java.time.ZoneId;
import java.util.Date;

@WrapperType(constructor=NONE, genericConstructor=NONE)
final class NonBoundTypeItem extends Item implements Scheduleable
{
	private static final Schedule schedule = new Schedule(ZoneId.of("Europe/Berlin"));

	private static final ItemField<Run> token = ItemField.create(Run.class, schedule::getRunType, DeletePolicy.CASCADE);

	@Override
	public void run(final Schedule schedule, final Date from, final Date until, final JobContext ctx)
	{
	}

	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="isEnabled")
	private boolean isScheduleEnabled()
	{
		return NonBoundTypeItem.schedule.isEnabled(this);
	}

	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="setEnabled")
	private void setScheduleEnabled(final boolean enabled)
	{
		NonBoundTypeItem.schedule.setEnabled(this,enabled);
	}

	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="getInterval")
	private com.exedio.cope.pattern.Schedule.Interval getScheduleInterval()
	{
		return NonBoundTypeItem.schedule.getInterval(this);
	}

	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="setInterval")
	private void setScheduleInterval(final com.exedio.cope.pattern.Schedule.Interval interval)
	{
		NonBoundTypeItem.schedule.setInterval(this,interval);
	}

	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="run")
	private static void runSchedule(final com.exedio.cope.util.JobContext ctx)
	{
		NonBoundTypeItem.schedule.run(NonBoundTypeItem.class,ctx);
	}

	/**
	 * Returns the parent field of the run type of {@link #schedule}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="RunParent")
	private static com.exedio.cope.ItemField<NonBoundTypeItem> scheduleRunParent()
	{
		return NonBoundTypeItem.schedule.getRunParent(NonBoundTypeItem.class);
	}

	/**
	 * Returns the value of {@link #token}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="get")
	private Run getToken()
	{
		return NonBoundTypeItem.token.get(this);
	}

	/**
	 * Sets a new value for {@link #token}.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @Wrapper(wrap="set")
	private void setToken(final Run token)
			throws
				com.exedio.cope.MandatoryViolationException
	{
		NonBoundTypeItem.token.set(this,token);
	}

	@javax.annotation.Generated("com.exedio.cope.instrument")
	private static final long serialVersionUID = 1l;

	/**
	 * The persistent type information for nonBoundTypeItem.
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument") // customize with @WrapperType(type=...)
	static final com.exedio.cope.Type<NonBoundTypeItem> TYPE = com.exedio.cope.TypesBound.newType(NonBoundTypeItem.class);

	/**
	 * Activation constructor. Used for internal purposes only.
	 * @see com.exedio.cope.Item#Item(com.exedio.cope.ActivationParameters)
	 */
	@javax.annotation.Generated("com.exedio.cope.instrument")
	private NonBoundTypeItem(final com.exedio.cope.ActivationParameters ap){super(ap);}
}
