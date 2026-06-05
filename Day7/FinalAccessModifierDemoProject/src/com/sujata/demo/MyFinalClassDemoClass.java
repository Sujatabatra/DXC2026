package com.sujata.demo;

/*
 * if class is final, we won't be able to extend it 
 */
final class Base{
	
	private int value;
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}


	public void show() {
		System.out.println("Hi I am Base show() method");
	}
}

//class Derived extends Base{
//	
//}

public class MyFinalClassDemoClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
