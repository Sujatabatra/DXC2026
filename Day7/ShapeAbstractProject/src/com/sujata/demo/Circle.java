package com.sujata.demo;

public class Circle extends Shapes {

	public Circle(int value) {
		super(value);
	}

	@Override
	public void area() {
		double area=3.142*getValue()*getValue();
		System.out.println("Area of Circle : "+area);

	}

	@Override
	public void perimeter() {
		System.out.println("Circle does not support perimeter functionality");

	}

	@Override
	public void circumference() {
		double circumference=2*3.142*getValue();
		System.out.println("Circumference of Circle : "+circumference);

	}

}
