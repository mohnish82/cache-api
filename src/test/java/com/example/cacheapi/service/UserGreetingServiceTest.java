package com.example.cacheapi.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserGreetingServiceTest {

	UserGreetingService service = new UserGreetingService();
	
	@Test
	void testGreet_NullUser() {
		assertEquals("Hello", service.greet(null));
	}

	@Test
	void testGreet_EmptyUser() {
		assertEquals("Hello", service.greet(""));
		assertEquals("Hello", service.greet(" "));
	}
	
	@Test
	void testGreet() {
		assertEquals("Hello Test", service.greet("Test"));
	}
	
}
