package com.sujata.demo;

public class Kia extends Car {

	public Kia(String model, String color) {
		super(model, color);
	}
	
	@Override
	public void engine() {
		System.out.println("Kia engine goes KOOOOOM.....");
	}

}
