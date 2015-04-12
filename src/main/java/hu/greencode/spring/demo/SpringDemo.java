package hu.greencode.spring.demo;

import hu.greencode.spring.demo.todo.Todo;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"hu.greencode.spring.demo"})
public class SpringDemo {


    public static void main(String[] args) {
        SpringApplication.run(SpringDemo.class, args);
    }

    @Bean(name = "todos")
//    @Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
    @Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
//    @Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public Map<String, Todo> todos() {
        return new HashMap<String, Todo>();
    }
}
