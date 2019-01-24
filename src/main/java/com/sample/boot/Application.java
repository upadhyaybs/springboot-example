package com.sample.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application {

	static Logger log =LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
		log.info("This is spring boot Application");
		SpringApplication.run(Application.class, args);
	}
}
