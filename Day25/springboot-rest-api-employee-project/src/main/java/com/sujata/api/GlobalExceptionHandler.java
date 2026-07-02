package com.sujata.api;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> handleValidation(MethodArgumentNotValidException ex){
		
		Map<String,String> errors=new HashMap<String, String>();
		
		for(FieldError error:ex.getBindingResult().getFieldErrors()) {
			errors.put(error.getField(), error.getDefaultMessage());
		}
		
		return ResponseEntity.badRequest().body(errors);
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErrorResponse> handleRunTimeException(RuntimeException ex,HttpServletRequest request){
		
		ErrorResponse response=new ErrorResponse();
		
		response.setTimestamp(LocalDateTime.now());
		response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		response.setMessage(ex.getMessage());
		response.setPath(request.getRequestURI());
		
		return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception ex){
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
	}
}
