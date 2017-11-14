package com.example.demo;

import java.io.Serializable;
import java.lang.reflect.Method;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractPointcutAdvisor;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

/**
 * @author Lukáš Vasek
 */
public class TestAdvisor extends AbstractPointcutAdvisor {

    private static final TestPointcut testPointcut = new TestPointcut();

    private final TestInterceptor testInterceptor;

    public TestAdvisor(TestInterceptor testInterceptor) {
        this.testInterceptor = testInterceptor;
    }

    @Override
    public Pointcut getPointcut() {
        return testPointcut;
    }

    @Override
    public Advice getAdvice() {
        return testInterceptor;
    }

    private static class TestPointcut extends StaticMethodMatcherPointcut implements Serializable {

        private static final long serialVersionUID = 1L;

        @Override
        public boolean matches(
                Method method,
                Class<?> targetClass) {
            return method.isAnnotationPresent(TestAnnotation.class);
        }
    }
}
