package hu.greencode.spring.demo;

import hu.greencode.spring.demo.todo.Todo;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.context.annotation.*;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Configuration
@EnableAutoConfiguration(exclude = SecurityAutoConfiguration.class)
@ComponentScan
public class SpringDemo {


    public static void main(String[] args) {
        SpringApplication.run(SpringDemo.class, args);
    }

    @Bean(name = "todos")
    @Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
//    @Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
//    @Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public Map<String, Todo> todos() {
        return new HashMap<String, Todo>();
    }

      @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(new Locale("HU", "hu"));
        return slr;

    }

}
