package com.example.cacheapi.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cacheapi.service.GreetingService;

@RestController
public class GreetingController {

	@Autowired
	GreetingService greetingService;
	
	@GetMapping("/greet")
	public String greetUser(@RequestParam(name = "user", required = false) String user) {
		return greetingService.greet(user);
	}

}
