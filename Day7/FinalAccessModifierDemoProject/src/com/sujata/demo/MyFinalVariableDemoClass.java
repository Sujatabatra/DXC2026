package com.sujata.demo;
/*
 * final : can be a variable, method or class
 * 
 * if a variable is final we won't be able to change its values after initialising its values
 */


class DemoClass{
	
	final private int value1=10;
	private int value2;
	
	public int getValue1() {
		return value1;
	}

	public void setValue1(int value1) {
		/*
		 * as value1 is marked as final and already initialised with 10 while declaring it, so we can't change its value
		 */
//		this.value1 = value1;
	}

	public int getValue2() {
		return value2;
	}

	public void setValue2(int value2) {
		this.value2 = value2;
	}
	
	
}

class TryClass{
	final private int value1;
	private int value2;
	
	
	public TryClass(int value1, int value2) {
		super();
		this.value1 = value1;
		this.value2 = value2;
	}

	public int getValue1() {
		return value1;
	}

	public void setValue1(int value1) {
		/*
		 * as value1 is marked as final and already initialised with 10 while declaring it, so we can't change its value
		 */
//		this.value1 = value1;
	}

	public int getValue2() {
		return value2;
	}

	public void setValue2(int value2) {
		this.value2 = value2;
	}
	
}
public class MyFinalVariableDemoClass {
	public static void main(String args[]) {
		
		TryClass tryClass1=new TryClass(20, 2);
		
		TryClass tryClass2=new TryClass(10, 2);
		
		TryClass tryClass3=new TryClass(67, 2);
		
	}

}
