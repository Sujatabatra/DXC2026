package com.sujata.versionone;

import java.util.Scanner;

public class MainCalculateShape {

	public static void main(String[] args) {
		Scanner  scanner=new Scanner(System.in);
		CalculateShape2D calculateShape2D=new CalculateShape2D();
		while(true) {
			System.out.println("1. Rectangle");
			System.out.println("2. Square");
			System.out.println("3. Exit");
			System.out.println("Enter Choice");
			int choice=scanner.nextInt();
			switch (choice) {
			case 1: 
				System.out.println("Enter Length of Rectangle : ");
				int length=scanner.nextInt();
				System.out.println("Enter Breadth of Rectangle : ");
				int breadth=scanner.nextInt();
				calculateShape2D.setShape(new Rectangle(length, breadth));
				calculateShape2D.calculate();
				break;
			case 2:
				System.out.println("Enter side of square : ");
				int side=scanner.nextInt();
				calculateShape2D.setShape(new Square(side));
				calculateShape2D.calculate();
				break;
			case 3:
				System.out.println("Thanks for using our Shape system...");
				System.exit(0);
				
			default:
				System.out.println("Invalid Choice");
			}
		}

	}

}
