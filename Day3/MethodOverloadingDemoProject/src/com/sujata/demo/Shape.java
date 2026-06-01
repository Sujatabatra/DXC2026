package com.sujata.demo;

public class Shape {

	public void area(int length,int breadth) {
		int area=length*breadth;
		System.out.println("Area of Rectangle : "+area);
	}
	
	public void area(int side) {
		int area=side*side;
		System.out.println("Area of Square : "+area);
	}
	
	public void area(double radius) {
		double area=3.142*radius*radius;
		System.out.println("Area of Circle : "+area);
	}
}
