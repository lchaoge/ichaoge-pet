package com.ichaoge.pet.dao.utils;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 **	非SQL字段对应的属性注释
 ** @date:2015-3-19
 ** @author:zengyang
 **
 **/
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NotSqlProperty {

	String value() default "";
}
