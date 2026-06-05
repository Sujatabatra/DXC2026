package com.sujata.demo;

//Gaurav : completed Contract by creating engine
public class Toyota extends Car {

	public Toyota(String model, String color) {
		super(model, color);
	}
	
	@Override
	public void engine() {
		System.out.println("Toyota Engine goes TOOOOM.......");
	}

}
