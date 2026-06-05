package com.sujata.demo;


/*
 * Marcial: used Car class created by Sujata and
 * took action by reading mail send by sujata
 *  of creating its own version of engine functionality
 * by using Sujata model and color
 */
public class Kia extends Car {

	public Kia(String model, String color) {
		super(model, color);
	}
	
	@Override
	public void engine() {
		System.out.println("Kia engine goes KOOOOOM.....");
	}

}
