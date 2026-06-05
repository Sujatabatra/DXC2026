package com.sujata.demo;

public class Square extends Shapes {

	public Square(int value) {
		super(value);
	}

	@Override
	public void area() {
		int area=getValue()*getValue();
		System.out.println("Area of Square is "+area);

	}

	@Override
	public void perimeter() {
		int perimeter=4*getValue();
		System.out.println("Perimeter of Square is "+perimeter);

	}

	@Override
	public void circumference() {
		System.out.println("Square does not support circumference functionality");
	}
}
