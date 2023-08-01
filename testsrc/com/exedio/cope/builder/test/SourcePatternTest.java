package com.exedio.cope.builder.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.exedio.cope.pattern.Schedule.Interval;
import org.junit.jupiter.api.Test;

public class SourcePatternTest extends MainTest
{
	@Test
	public void explicit()
	{
		final SourcePatternItem i = new SourcePatternItemBuilder().
			schedule_enabled(false).
			schedule_interval(Interval.MONTHLY).
			build();
		assertEquals(false, i.isScheduleEnabled());
		assertEquals(Interval.MONTHLY, i.getScheduleInterval());
	}

	@Test
	public void copeDefault()
	{
		// this works not by builder fallback but by defaults in cope
		final SourcePatternItem i = new SourcePatternItemBuilder().build();
		assertEquals(true, i.isScheduleEnabled());
		assertEquals(Interval.DAILY, i.getScheduleInterval());
	}
}
