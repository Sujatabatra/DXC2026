package com.sujata.oop;

public class OopFactorialDemoMainClass {

	public static void main(String[] args) {
		/*
		 * if we want to make use of a class,
		 * we need to create an object
		 * 
		 * Syntax for object : ClassName objectName=new ClassName();
		 */
		
		OopFactorialDemo oopFactorialDemo=new OopFactorialDemo();
		
		oopFactorialDemo.setNumber(4);
		System.out.println("Factorial : "+oopFactorialDemo.getFactorial());

	}

}
