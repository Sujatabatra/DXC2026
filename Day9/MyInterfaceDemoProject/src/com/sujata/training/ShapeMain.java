package com.sujata.training;



import com.sujata.demo.Circle;
import com.sujata.demo.Rectangle;

public class ShapeMain {

	public static void main(String args[]) {
		
		Circle circle=new Circle(6);
		circle.area();
		circle.circumference();
		circle.displayResults();
		
		Rectangle rectangle=new Rectangle(4, 9);
		rectangle.area();
		rectangle.perimeter();
		rectangle.displayResults();
	}
}
