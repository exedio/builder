package com.exedio.cope.builder;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.SOURCE;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Marks all Generated*Builder classes.
 * You may use this annotation to configure code analysis tools.
 */
@Retention(SOURCE)
@Target(TYPE)
public @interface Generated
{
}
