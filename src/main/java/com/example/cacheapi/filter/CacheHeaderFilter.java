package com.example.cacheapi.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
public class CacheHeaderFilter implements Filter {

	@Value("${cache.duration.seconds}") 
	long cacheDuration;
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		// redundant
		/*
		if( !HttpServletRequest.class.isAssignableFrom(request.getClass()))
			return;
		*/
		
		HttpServletResponse res = (HttpServletResponse) response;
		
		String cacheHeaderValue = cacheDuration > 0 ? String.format("public,max-age=%d", cacheDuration) : "private,no-cache,no-store";
		res.setHeader(HttpHeaders.CACHE_CONTROL, cacheHeaderValue);
		
		chain.doFilter(request, response);
		
	}

	public long getCacheDuration() {
		return cacheDuration;
	}

	public void setCacheDuration(long cacheDuration) {
		this.cacheDuration = cacheDuration;
	}
	
}
