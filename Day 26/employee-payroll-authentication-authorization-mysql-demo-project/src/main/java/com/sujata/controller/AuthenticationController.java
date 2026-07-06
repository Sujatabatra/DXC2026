package com.sujata.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sujata.dto.LoginRequest;
import com.sujata.dto.LoginResponse;
import com.sujata.service.AuthenticationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

	private final AuthenticationService authenticationService;

	public AuthenticationController(AuthenticationService authenticationService) {

		this.authenticationService = authenticationService;
	}

	@PostMapping("/login")
	public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) {

		LoginResponse response = authenticationService.login(request);

		return new ResponseEntity<>(response, HttpStatus.OK);

	}

}