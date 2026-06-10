package com.sujata.demo;

import java.lang.reflect.Executable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MyThrowsKeywordExceptionHandlingDemo {

	/*
	 * throws is like a promise to compiler that the function which will be calling me will handle the exception specified with throws
	 */
	public static void division(int number1, int number2)throws ArithmeticException {
		
			int divide = number1 / number2;
			System.out.println("Result of Division : " + divide);
		
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int location = 0;
		try {
			
			System.out.println("Enter first number : ");
			int number1 = scanner.nextInt();
			System.out.println("Enter Second number : ");
			int number2 = scanner.nextInt();
			
			division(number1, number2);
		
		} 
		catch(ArithmeticException  arithmeticException) {
			System.out.println("Undefined");
		}
		catch (InputMismatchException exception) {
			System.out.println("Kindly enter integer value");
		}

		System.out.println("Good Bye from main!");

	}

}
