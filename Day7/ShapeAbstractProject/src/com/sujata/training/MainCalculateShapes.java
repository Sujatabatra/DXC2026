package com.sujata.training;

import com.sujata.demo.CalculateShapes;
import com.sujata.demo.Circle;
import com.sujata.demo.Rectangle;
import com.sujata.demo.Square;

public class MainCalculateShapes {

	public static void main(String[] args) {
		
		CalculateShapes calculateShapes=new CalculateShapes();
		
		calculateShapes.setShapes(new Rectangle(45, 8));
		calculateShapes.calculate();
		
		System.out.println("==============");
		calculateShapes.setShapes(new Square(7));
		calculateShapes.calculate();
		
		System.out.println("==============");
		calculateShapes.setShapes(new Circle(8));
		calculateShapes.calculate();

	}

}
