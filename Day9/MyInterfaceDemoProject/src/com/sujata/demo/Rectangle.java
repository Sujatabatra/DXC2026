package com.sujata.demo;

public class Rectangle implements Data, Shape, NonRoundedShape {

	private int length,breadth,area,perimeter;
	
	public Rectangle() {
		
	}
	
	public Rectangle(int length, int breadth) {
		super();
		this.length = length;
		this.breadth = breadth;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public void setBreadth(int breadth) {
		this.breadth = breadth;
	}
	
	public int getArea() {
		return area;
	}

	public int getPerimeter() {
		return perimeter;
	}

	@Override
	public void perimeter() {
		perimeter=2*(length+breadth);

	}

	@Override
	public void area() {
		area=length*breadth;

	}

	@Override
	public void displayResults() {
		System.out.println("Area of Rectangle : "+area);
		System.out.println("Perimeter of Rectangle : "+perimeter);

	}

}
