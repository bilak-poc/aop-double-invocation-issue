package com.example.demo;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author Lukáš Vasek
 */
public class TestInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("calling interceptor");
        Object invoked = methodInvocation.proceed();
        System.out.println("interceptor called");
        // return new String("test");
        return invoked;
    }
}
