package com.example.demo;

import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Lukáš Vasek
 */
@Configuration
public class Config {

    @Bean
    public TestService testService() {
        return new TestServiceImpl();
    }

    @Bean
    public TestInterceptor testInterceptor() {
        return new TestInterceptor();
    }

    @Bean
    public TestAdvisor testAdvisor() {
        return new TestAdvisor(testInterceptor());
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator advisor =  new DefaultAdvisorAutoProxyCreator();
        advisor.setProxyTargetClass(true);
        return advisor;
    }

}
