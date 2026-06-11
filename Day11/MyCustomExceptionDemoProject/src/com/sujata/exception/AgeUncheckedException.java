package com.sujata.exception;

//Compiler does not force to check exception
public class AgeUncheckedException extends RuntimeException {

	public AgeUncheckedException(String message) {
		super(message);
	}
	
}
