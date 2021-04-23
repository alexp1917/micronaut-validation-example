package org.my.example.controller;

import io.micronaut.aop.InterceptorBean;
import io.micronaut.aop.MethodInterceptor;
import io.micronaut.aop.MethodInvocationContext;

import javax.inject.Singleton;
import java.net.http.HttpResponse;


@Singleton
@InterceptorBean(ErrorHidden.class)
public class ErrorHider implements MethodInterceptor<HttpResponse<?>, Object> {
    @Override
    public Object intercept(MethodInvocationContext<HttpResponse<?>, Object> context) {
        // set breakpoint here
        System.out.println("hello");
        return context.proceed();
    }
}
