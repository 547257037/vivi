package com.tiantian.baba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableCaching
public class BabaApplication  extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(BabaApplication.class, args);
	}
}
