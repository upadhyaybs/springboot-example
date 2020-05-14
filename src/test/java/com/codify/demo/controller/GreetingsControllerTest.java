package com.codify.demo.controller;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class GreetingsControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void shouldReturnDefaultMessage() throws Exception {
		this.mockMvc.perform(get("/greetings")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Hello ! This is Spring Boot Demo App.")));
	}
	
	@Test
	public void getMessageTest() throws Exception {
		this.mockMvc.perform(get("/greetings/hello?name=TestUser"))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Hi TestUser")));
	}
}
