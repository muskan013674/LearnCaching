package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import javax.persistence.Cacheable;

@SpringBootApplication
@EnableCaching
public class LearnCachingApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnCachingApplication.class, args);
    }

}
