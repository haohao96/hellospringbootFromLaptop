package com.pyh.hellospringboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//MVC的配置类   关于mvc的配置都可以写在这里，但要实现WebMvcConfigurer
@Configuration
public class MvcConfig implements WebMvcConfigurer {
//    为url设置跳转页面，这样就不用写controller了
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");

        registry.addViewController("/login").setViewName("login");
    }
}
