package com.company.employeeattendance.config;

import com.company.employeeattendance.interceptors.GeneralRequestInterceptor;
import com.company.employeeattendance.interceptors.HomeRedirectInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfigurer implements WebMvcConfigurer {

    @Autowired
    private GeneralRequestInterceptor generalRequestInterceptor;

    @Autowired
    private HomeRedirectInterceptor homeRedirectInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(generalRequestInterceptor)
                .addPathPatterns("/*", "/**");
        registry.addInterceptor(homeRedirectInterceptor).addPathPatterns("/login", "/signup");
    }
}