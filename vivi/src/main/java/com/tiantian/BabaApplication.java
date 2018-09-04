package com.tiantian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class BabaApplication   {

	public static void main(String[] args) {
		SpringApplication.run(BabaApplication.class, args);
	}
}