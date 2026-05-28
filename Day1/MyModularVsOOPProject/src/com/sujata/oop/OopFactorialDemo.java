package com.sujata.oop;

//OOP says , we are giving equak importance to data along with algo 
/*
 * decide data: 
 * how you want outside class data accessibility
 * number : modified
 * factorial : can only be readable
 * 
 * Data, Modifiable : Create setter method
 * Data, readable : Create getter method
 * and if data is both modifiable as well as readbale : create both getter and setter
 */
/*
 * Encapsulation : class
 * Data hiding : private 
 * Data Abstraction : methods
 */
public class OopFactorialDemo {

	/*
	 * number is modifiable : setter
	 * factorial is readable : getter
	 */
	private int number,factorial;

		public void setNumber(int number) {
		this.number = number;
	}

	public int getFactorial() {
		calculateFactorial();
		return factorial;
	}
	
	private void calculateFactorial() {
		factorial=1;
		while(number>=1) {
			factorial*=number--;
		}
	}
	
	
}
