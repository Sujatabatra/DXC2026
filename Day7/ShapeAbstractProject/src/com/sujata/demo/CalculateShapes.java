package com.sujata.demo;

public class CalculateShapes {

	private Shapes shapes;
	
	public void setShapes(Shapes shapes) {
		this.shapes = shapes;
	}


	public void calculate() {
		shapes.area();
		shapes.perimeter();
		shapes.circumference();
	}
}
