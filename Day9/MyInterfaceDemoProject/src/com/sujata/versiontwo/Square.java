package com.sujata.versiontwo;

public class Square implements Shape {

	private int side;
	
	public Square(int side) {
		super();
		this.side = side;
		
	}

	@Override
	public void area() {
		int area=side*side;
		System.out.println("Area of Square : "+area);

	}

	@Override
	public void perimeter() {
		int perimeter=4*side;
		System.out.println("Perimeter of Square : "+perimeter);
		

	}

}
