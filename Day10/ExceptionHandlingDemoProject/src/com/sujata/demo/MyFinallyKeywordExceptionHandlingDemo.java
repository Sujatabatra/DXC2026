package com.sujata.demo;

import java.util.Scanner;

public class MyFinallyKeywordExceptionHandlingDemo {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int location=0;
		try {
		System.out.println("Enter first number : ");
		int number1=scanner.nextInt();
		System.out.println("Enter Second number : ");
		int number2=scanner.nextInt();
		int divide=number1/number2;
		System.out.println("Result of Division : "+divide);
		
		int arr[];
		System.out.println("Enter total number of elements in an array : ");
		int total=scanner.nextInt();
		
		arr=new int[total];
		
		for(int i=0;i<total;i++) {
			System.out.println("Enter element at location "+(i+1)+" : ");
			arr[i]=scanner.nextInt();
		}
		
		System.out.println("Enter location in an array whoes element we want to view : ");
		location=scanner.nextInt();
		
		System.out.println("Element at "+location+" location in an array : "+arr[location]);
		}
		/*
		 * when you are writing multiple handlers, i.e catch block
		 * always write all the specific handlers first, and at the end write generic handler to avaoid unreachable code situation
		 */
		catch (ArithmeticException arithmeticException) {
			System.out.println("Undefined");
		}
		catch (NegativeArraySizeException negativeArraySizeException) {
			System.out.println("Kindly try again by entering the positive integer in the size of an array");
		}
		catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
			System.out.println(location+" location does not exist in an array");
		}
		catch (Exception exception) {
			System.out.println(exception.getClass());
			System.out.println("Something went wrong please try after sometime");
		}
		/*
		 * No matter what happens, wheather you are handling the exception or not handling,
		 * wheather your code is reachable or not reachable but finally block will going to execute
		 */
		finally {
			System.out.println("Hi I am finally Block");
		}
		System.out.println("Good Bye from main!");

	}

}
