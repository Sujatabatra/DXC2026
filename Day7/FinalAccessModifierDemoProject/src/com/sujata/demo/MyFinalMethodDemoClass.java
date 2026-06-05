package com.sujata.demo;

/*
 * if the method is final, we won't be able to override it
 */

class Factorial{
	
	int number;
	int factorial;
	
	public Factorial(int number) {
		super();
		this.number = number;
	}
	
	final public void calculateFactorial() {
		int num=number;
		factorial=1;
		while(num>=1)
			factorial*=num--;
	}

	public int getNumber() {
		return number;
	}

		public int getFactorial() {
		return factorial;
	}
	
}

class FactorialDerived extends Factorial{

	public FactorialDerived(int number) {
		super(number);
	}
	
	public int getFactorial() {
		System.out.println("Returning Factorial");
		return factorial;
	}
	
}
public class MyFinalMethodDemoClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
