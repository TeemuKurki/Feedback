package com.MasterBranch.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/feedback").setViewName("feedback");
        registry.addViewController("/addAnswer").setViewName("addAnswer"); // VASTAUS-SIVUN NIMI
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/adminSite").setViewName("adminSite");
        registry.addViewController("/login").setViewName("login");
    }

}
