package com.sujata.demo;

public class MainComplexNumber {

	public static void main(String[] args) {
		/*
		 * when object get created all the object variables or instance variable(why object variables are called instance variables
		 *  because object is known as an instance of a class) get default initial values
		 *  all integer store 0 default initial value
		 * 	all floating point store 0.0 default initial value
		 * all boolean store false default initial value
		 * all char store /uffff (check it once ) default initial value
		 */
		ComplexNumber complexNumber=new ComplexNumber(); // object created with default initial values
		
		complexNumber.input(2, 8);
		complexNumber.display();
		
//		System.out.println(complexNumber);
		System.out.println("===================");
		
		ComplexNumber complexNumber1=new ComplexNumber();  //declaring complex number
		complexNumber1.input(4, -5); //initializing the complex number
		complexNumber1.display();
		
		System.out.println("===================");
		ComplexNumber complexNumber2=new ComplexNumber();
		complexNumber2.input(7, 0);
		complexNumber2.display();
		

	}

}
