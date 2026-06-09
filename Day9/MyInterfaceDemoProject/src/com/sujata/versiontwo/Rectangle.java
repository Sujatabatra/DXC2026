package com.sujata.versiontwo;

public class Rectangle implements Shape {

	private int length,breadth;
	
	public Rectangle(int length, int breadth) {
		super();
		this.length = length;
		this.breadth = breadth;
	}

	@Override
	public void area() {
		int area=length*breadth;
		System.out.println("Area of Rectangle : "+area);

	}

	@Override
	public void perimeter() {
		int perimeter=2*(length+breadth);
		System.out.println("Perimeter of Rectangle : "+perimeter);
		

	}

}
