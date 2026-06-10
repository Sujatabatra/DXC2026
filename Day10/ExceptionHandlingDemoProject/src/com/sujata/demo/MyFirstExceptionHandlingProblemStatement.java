package com.sujata.demo;

import java.util.Scanner;

public class MyFirstExceptionHandlingProblemStatement {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		
		System.out.println("Enter first number : ");
		int number1=scanner.nextInt();
		System.out.println("Enter Second number : ");
		int number2=scanner.nextInt();
		
		int divide=number1/number2;
		/*
		 * we came across with the run time problem or exception at line no 15,
		 * user gets red color error messages and my program abruptly terminate on that line itself
		 */
		
		System.out.println("Result of Division : "+divide);
		
		System.out.println("Good Bye from main!");

	}

}
