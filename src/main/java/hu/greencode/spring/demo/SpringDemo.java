package hu.greencode.spring.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
public class SpringDemo {

    public static void main(String[] args) {
        SpringApplication.run(SpringDemo.class);
    }

}
