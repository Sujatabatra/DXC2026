package com.sujata.demo;

public class MainComplexNumber {

	public static void main(String[] args) {

		/*
		 * ClassName referenceVariable name= new Constructor();
		 */
		ComplexNumber complexNumber = new ComplexNumber(4, 8);

//		complexNumber.input(2, 8);
		complexNumber.display();

//		ComplexNumber complexNumber1 = new ComplexNumber();
//		complexNumber1.display();

		System.out.println();
		ComplexNumber complexNumber2 = new ComplexNumber(6);
		complexNumber2.display();
		
		System.out.print("Sum of two complex Numbers : ");
		ComplexNumber sum=complexNumber2.addTwoNumbers(complexNumber);
		sum.display();
	}

}
