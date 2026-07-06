package com.sujata.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.sujata.security.JwtAuthenticationEntryPoint;
import com.sujata.security.JwtAuthenticationFilter;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

	private final JwtAuthenticationFilter jwtAuthenticationFilter;

	private final AuthenticationProvider authenticationProvider;

	private final JwtAuthenticationEntryPoint authenticationEntryPoint;

	public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter,
			AuthenticationProvider authenticationProvider, JwtAuthenticationEntryPoint authenticationEntryPoint) {

		this.jwtAuthenticationFilter = jwtAuthenticationFilter;
		this.authenticationProvider = authenticationProvider;
		this.authenticationEntryPoint = authenticationEntryPoint;
	}

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http

				// Disable CSRF for REST APIs
				.csrf(csrf -> csrf.disable())

				// Stateless session
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

				// Exception Handling
				.exceptionHandling(exception -> exception.authenticationEntryPoint(authenticationEntryPoint))

				// Authentication Provider
				.authenticationProvider(authenticationProvider)

				// Authorization Rules
				.authorizeHttpRequests(auth -> auth

						// Public APIs
						.requestMatchers("/auth/**", "/error").permitAll()    //if request is coming from either /auth or /error

						// Employee APIs
						.requestMatchers("/employees/**").hasAnyRole("ADMIN", "HR", "EMPLOYEE")

						// Payroll APIs
						.requestMatchers("/payroll/**").hasAnyRole("ADMIN", "HR", "EMPLOYEE")

						// Admin APIs
						.requestMatchers("/admin/**").hasRole("ADMIN")

						// Everything else
						.anyRequest().authenticated())

				// Disable default login page
				.formLogin(Customizer.withDefaults());

		// JWT Filter
		http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}
}
