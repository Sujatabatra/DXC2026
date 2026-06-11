package com.sujata.exception;


//Checked Exception : Compiler force me to handle exception
public class AgeCheckedException extends Exception {

	public AgeCheckedException(String message) {
		super(message);
	}
}
