package com.codify.demo;


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

import com.codify.demo.controller.GreetingsController

import spock.lang.Narrative;
import spock.lang.Specification;
import spock.lang.Title

@ActiveProfiles("test")
@Title("Application Specification")
@Narrative("Specification which beans are expected")
@SpringBootTest
public class LoadContextTests extends Specification {

	@Autowired(required = false)
	private GreetingsController webController


	def "when context is loaded then all expected beans are created"() {
		expect: "the WebController is created"
		webController
	}
	
}
