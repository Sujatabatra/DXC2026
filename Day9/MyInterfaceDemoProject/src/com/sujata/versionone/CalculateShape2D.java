package com.sujata.versionone;

public class CalculateShape2D {

	//Reference Variable of an interface
	private Shape shape;
	

	public void setShape(Shape shape) {
		this.shape = shape;
	}


	public void calculate() {
		shape.area();
		shape.perimeter();
	}
	
}
