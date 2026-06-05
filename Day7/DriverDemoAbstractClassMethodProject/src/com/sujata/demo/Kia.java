package com.sujata.demo;


//Marcial : complete contract by creating engine()
public class Kia extends Car {

	public Kia(String model, String color) {
		super(model, color);
	}
	
	@Override
	public void engine() {
		System.out.println("Kia engine goes KOOOOOM.....");
	}

}
