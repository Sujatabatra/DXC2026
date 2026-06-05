package com.sujata.demo;

public class Rectangle extends Shapes {

	private int breadth;
	
	
	public Rectangle(int value, int breadth) {
		super(value);
		this.breadth = breadth;
	}

	@Override
	public void area() {
		int area=getValue()*breadth;
		System.out.println("Area of Rectangle = "+area);

	}

	@Override
	public void perimeter() {
		int perimeter=2*(getValue()+breadth);
		System.out.println("Perimeter of Rectangle = "+perimeter);

	}

	@Override
	public void circumference() {
		System.out.println("rectangle does not support circumference functionality");

	}

}
