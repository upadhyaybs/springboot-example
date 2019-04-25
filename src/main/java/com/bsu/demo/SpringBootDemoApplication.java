package com.bsu.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class SpringBootDemoApplication {

	
	public static void main(String[] args) {
		log.info("This is spring boot Application");
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}
}
