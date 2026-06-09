package com.sujata.versiontwo;

public class CalculateShape2D {

	//Reference Variable of an interface
	private Shape shape;
	

	public void setShape(Shape shape) {
		this.shape = shape;
	}


	public Shape getShape() {
		return shape;
	}


	public void calculate() {
		shape.area();
		shape.perimeter();
	}
	
}
