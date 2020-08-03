package com.example.cacheapi.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.cacheapi.service.GreetingService;

@SpringBootTest
class GreetingControllerTest {

	@Autowired
	GreetingController controller;
	
	@MockBean
	GreetingService service;
	
	@Test
	void testGreetUser() {
		when(service.greet(Mockito.eq("Test"))).thenReturn("Hello Test");
		assertEquals("Hello Test", controller.greetUser("Test"));
	}

	@Test
	void testGreetUser_UserMissing() {
		when(service.greet(Mockito.anyString())).thenReturn("Hello");
		assertEquals("Hello", controller.greetUser(""));
	}
	
	
}
