package com.restaurant.Configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.concurrent.TimeUnit;


@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addCorsMappings ( CorsRegistry registry ) {
        registry.addMapping("/**").allowedHeaders("*").allowedMethods("*");
    }

    @Override
    public void addResourceHandlers ( ResourceHandlerRegistry registry ) {
        registry.addResourceHandler ("/images/**").addResourceLocations ("/WEB-INF/images/")
                .setCacheControl (CacheControl.maxAge (2, TimeUnit.HOURS).cachePublic ());
    }



}
