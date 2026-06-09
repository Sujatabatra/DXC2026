package com.sujata.demo;

/*
 * Syntax : class ClassName extends <BaseClass> implements <interface(s)>
 */
public class Circle extends DataInput implements RoundedShape {

	
	private double area,circumference;
	
	public Circle(int value) {
		super(value);
	}

	@Override
	public void displayResults() {
		System.out.println("Area of Circle : "+area);
		System.out.println("Circumference of Circle : "+circumference);

	}

	@Override
	public void area() {
		area=PI*getValue()*getValue();

	}

	@Override
	public void circumference() {
		circumference=2*PI*getValue();

	}

}
