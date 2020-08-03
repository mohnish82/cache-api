package com.example.cacheapi.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserGreetingService implements GreetingService {

	@Override
	public String greet(String user) {
		return String.format("Hello %s", StringUtils.isEmpty(user) ? "" : user).trim();
	}

}
