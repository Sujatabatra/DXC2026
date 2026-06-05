package com.sujata.demo;


/*
 * Sujata : created Car class and mailed to entire team to use Car class
 * for functionality of having model and color but
 * create their own version of engine functionality 
 */
public class Car {

	private String model;
	private String color;
	
	public Car(String model, String color) {
		super();
		this.model = model;
		this.color = color;
	}

	public String getModel() {
		return model;
	}

	public String getColor() {
		return color;
	}
	
	public void engine() {
		System.out.println("Kindly create your own engine, this car don't have any engine");
	}
}
