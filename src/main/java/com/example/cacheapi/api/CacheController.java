package com.example.cacheapi.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cacheapi.filter.CacheHeaderFilter;

@RestController
public class CacheController {

	@Autowired
	CacheHeaderFilter cacheManager;
	
	@GetMapping("/cache")
	public String getCacheDuration() {
		return Long.toString(cacheManager.getCacheDuration());
	}

	@PostMapping("/cache")
	public void getCacheDuration(@RequestParam("duration") Long duration ) {
		cacheManager.setCacheDuration(duration);
	}

}
