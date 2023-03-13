package com.ouyu.config;

import com.ouyu.controller.interceptor.SpringMvcInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author a1315
 * 功能：配置SpringMVC拦截器路径
 */
@Configuration
public class SpringMvcSupport extends WebMvcConfigurationSupport {
    private SpringMvcInterceptor springMvcInterceptor;
    @Autowired
    public SpringMvcSupport(SpringMvcInterceptor springMvcInterceptor) {
        this.springMvcInterceptor = springMvcInterceptor;
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(springMvcInterceptor).addPathPatterns("/**").excludePathPatterns("/api/user/**");
    }
}
