package com.sujata.demo;

 abstract public class Shapes {

	private int value;

	public Shapes(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}

	abstract public void area();
	abstract public void perimeter();
	abstract public void circumference();
	
}
