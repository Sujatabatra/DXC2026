package com.sujata.demo;

import java.util.Scanner;

public class MyTryCatchExceptionHandlingDemo {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		/*
		 * enclosed line number 13 to 18 in try block as we are expecting exception might can come on these lines,
		 * if exception comes then to handle that exception we are writing handler of ArithmeticException with the help of catch block
		 */
		try {
		System.out.println("Enter first number : ");
		int number1=scanner.nextInt();
		System.out.println("Enter Second number : ");
		int number2=scanner.nextInt();
		int divide=number1/number2;
		System.out.println("Result of Division : "+divide);
		
		}
		catch (ArithmeticException arithmeticException) {
			System.out.println("Undefined");
		}
		System.out.println("Good Bye from main!");

	}

}
