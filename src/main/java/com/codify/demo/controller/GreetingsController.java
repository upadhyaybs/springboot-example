package com.codify.demo.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greetings")
public class GreetingsController {
	
	@Value("${spring.application.name}")
    private String appName;
	
	@GetMapping
	public String greeting() {
		return "Hello ! This is Spring Boot Demo App.";
	}

	@GetMapping("/hello")
    String sayHello(@RequestParam(value = "name") String name) {
        String rsp = "Hi " + name + " : responded on - " + new Date();
        return rsp;
    }
	
	@GetMapping("/index")
	public String index() {
		return String.format("Hello from %s!", appName);
	}
}
