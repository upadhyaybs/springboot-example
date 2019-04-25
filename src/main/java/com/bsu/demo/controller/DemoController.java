package com.bsu.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DemoController {
	
	@GetMapping(value = "/message")
	  public String sayHello(){
	    return "Hello !! This is Spring Boot Demo App";
	  }

}
