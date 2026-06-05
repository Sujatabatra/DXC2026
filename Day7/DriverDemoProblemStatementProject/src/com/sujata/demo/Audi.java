package com.sujata.demo;


/*
 * Bill : used Car class created by Sujata and
 * took action by reading mail send by sujata
 *  of creating its own version of engine functionality
 * by using Sujata model and color
 */

public class Audi extends Car {

	public Audi(String model, String color) {
		super(model, color);
	}
	
	@Override
	public void engine() {
		System.out.println("Audi Engine goes AOOOOM.......");
	}

}
