package com.example.pc.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfigurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        registry.addInterceptor(commonInterceptor())
                .addPathPatterns("/admin/**");
    }

    @Bean
    public HandlerInterceptor commonInterceptor(){
        return new Interceptor();
    }
}
