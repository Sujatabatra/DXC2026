package com.sujata.demo;

import com.sujata.demo.Student;


public class Marks extends Student {

	private int marks1;
	private int marks2;
	private int marks3;
	
	public Marks() {
		super(); //implicit call , so writing super is optional
		System.out.println("Hi I am Marks class Constructor");
	}
	
	public Marks(int rollNumber, String name, int marks1, int marks2, int marks3) {
		super(rollNumber, name); //explicit call to argumented constructor , so not optional
		this.marks1 = marks1;
		this.marks2 = marks2;
		this.marks3 = marks3;
	}


	public void input(int rollNumber,String name,int marks1,int marks2, int marks3) {
		input(rollNumber, name);
		this.marks1=marks1;
		this.marks2=marks2;
		this.marks3=marks3;
	}
	
	/*
	 * While over riding the method of the base class in derived class,
	 * we can keep the over ridden method in same scope
	 * or we can broader the scope but we cannot narrow the scope while over riding
	 */
	@Override
	public void display() {
		/*
		 * over ridden method is getting called , call should not go to over ridden method,
		 * but to the parent version of the over ridden method
		 * so to call the parent version of over ridden method, we use super keyword
		 */
//		display();  
		super.display();
		System.out.println("Marks1 : "+marks1);
		System.out.println("Marks2 : "+marks2);
		System.out.println("Marks3 : "+marks3);
	}

	public int getMarks1() {
		return marks1;
	}

	public int getMarks2() {
		return marks2;
	}

	public int getMarks3() {
		return marks3;
	}
	
	
}
