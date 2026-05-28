package com.sujata.modular;

public class ModularFactorialDemo {

	/*
	 * static keyword using here to create modular approach,
	 * but you need not to get into the meaning of it right now,
	 * we will discuss abt statuc later
	 * just focus on approach
	 */
	//data
	static int number,factorial;
	
	static void inputNumber(int n) {
		number=n;
	}
	
	static void calculateFactorial() {
		factorial=1;
		while(number>=1) {
			factorial*=number--;
		}
	}
	
	static void displayFactorial() {
		System.out.println("Factorial : "+factorial);
	}
	
	//execution starts with main()
	public static void main(String[] args) {
		
		inputNumber(4);
		calculateFactorial();
//		logical error which is corrupting data
		factorial=0;
		displayFactorial();

	}

}
