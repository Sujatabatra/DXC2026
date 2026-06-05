package com.sujata.demo;

/*
 * Gaurav :used Car class created by Sujata and
 * took action by reading mail send by sujata 
 * of creating its own version of engine functionality
 * by using Sujata model and color
 */
public class Toyota extends Car {

	public Toyota(String model, String color) {
		super(model, color);
	}
	
	@Override
	public void engine() {
		System.out.println("Toyota Engine goes TOOOOM.......");
	}

}
