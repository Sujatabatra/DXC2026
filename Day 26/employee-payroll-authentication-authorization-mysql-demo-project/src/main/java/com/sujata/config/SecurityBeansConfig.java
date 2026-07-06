package com.sujata.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;

import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.sujata.security.CustomUserDetailsService;

@Configuration
public class SecurityBeansConfig {

	private final CustomUserDetailsService userDetailsService;

	public SecurityBeansConfig(CustomUserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	/*
	 * To encrypt passwords before storing and verify them during login.
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/*
	 * Purpose :This is where real authentication logic happens.
	 * 
	 * It: 
	 * Loads user 
	 * Checks password 
	 * Validates credentials 
	 * Returns authentication result
	 */
	@Bean
	public AuthenticationProvider authenticationProvider() {
		//DaoAuthenticationProvider : takle username and password from DB
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userDetailsService);
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
	}

	/*
	 * What it does internally? 
	 * 1. Receives authentication request 
	 * 2. Finds suitable AuthenticationProvider 
	 * 3. Delegates authentication 
	 * 4. Returns: 
	 * 4.1 success→authenticated object 
	 * 4.2 failure → exception
	 */
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}
}