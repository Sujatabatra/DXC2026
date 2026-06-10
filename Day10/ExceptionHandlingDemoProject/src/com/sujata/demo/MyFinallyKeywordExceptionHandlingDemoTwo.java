package com.sujata.demo;

import java.lang.reflect.Executable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MyFinallyKeywordExceptionHandlingDemoTwo {

	public static void division(int number1, int number2) {
		try {
			int divide = number1 / number2;
			System.out.println("Result of Division : " + divide);
			return;  //if i am not getting an exception this return statement make line no 18 unreachable
		} catch (ArrayIndexOutOfBoundsException exception) {
			System.out.println(exception.getMessage());
		} finally {
			System.out.println("Hi i am finally block!");
		}
		System.out.println("Good Bye from division method!");
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
