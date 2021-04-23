package org.my.example.controller;

import io.micronaut.aop.Around;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;


@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, METHOD})
@Around
public @interface ErrorHidden {
}
