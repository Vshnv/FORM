package io.github.vshnv.form.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * PrimaryKey marks fields that are denoted to be used as primary keys for the object when serializing the object
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PrimaryKey {
}
