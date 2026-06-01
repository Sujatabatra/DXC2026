package com.sujata.demo;

public class ClassDemo {
	
	private int value1;
	String value2;
	protected double value3;
	public int value4;

	private void privateShow() {
		System.out.println("Hi I am private show method from com.sujata.demo.ClassDemo");
	}
	
	void defaultShow() {
		System.out.println("Hi I am default show method from com.sujata.demo.ClassDemo");
	}
	
	protected void protectedShow() {
		System.out.println("Hi I am protected show method from com.sujata.demo.ClassDemo ");
	}
	
	public void publicShow() {
		System.out.println("Hi I am public show method from com.sujata.demo.ClassDemo");
	}
}
