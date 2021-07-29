package com.pyh.hellospringboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
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

//    这个方法名只有写成“localeResolver”才会被容器发现并使用,或者在Bean注解中写明 name属性为localeResolver
//    为啥要这样呢？看WebMvcAutoConfiguration的localeResolver方法，此方法有个注解
//    @ConditionalOnMissingBean(
//            name = {"localeResolver"}
//        )
//    也就是说容器中没有名为localeResolver的Bean时，springboot会自动配置一个默认的localeResolver给你用，
//    那这个localeResolver就不是按照你的想法去操作了
    @Bean(name = "localeResolver")
    public LocaleResolver localeResolver()
    {
        return new MyLocaleResolver();
    }
}
