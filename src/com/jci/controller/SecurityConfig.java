//package com.jci.controller;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
//import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
//import org.springframework.security.web.header.writers.XXssProtectionHeaderWriter;
//
//
//	
//
//
//	
//	 
//	@Configuration
//	@EnableWebSecurity
//	public class SecurityConfig {
//
//	    @Bean
//	    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//	    	 CsrfTokenRequestAttributeHandler requestHandler = new CsrfTokenRequestAttributeHandler();
//	    	  
//	    	    requestHandler.setCsrfRequestAttributeName(null);
//	    	    
//	    	httpSecurity.headers(headers -> 
//	         headers.xssProtection(
//	            xss -> xss.headerValue(XXssProtectionHeaderWriter.HeaderValue.ENABLED_MODE_BLOCK) //xss disabled
//	         ).contentSecurityPolicy(
//	            cps -> cps.policyDirectives("script-src 'self' .....")
//	        )).csrf(c -> c.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//	                .csrfTokenRequestHandler(requestHandler)); //csrf disable
//	    	
//	      return httpSecurity.build();
//	    }
//	}

