package com.sujata.demo;

import com.sujata.demo.Student;

/*
 * Advantage of Inheritance :
 * 1. Resuability
 * 2. Extensibility
 */
//Sub class in different Package
public class Marks extends Student {

	private int marks1;
	private int marks2;
	private int marks3;
	
	public Marks() {
		//call parents class default constructor (implicit call)
		/*
		 * if the default constructor does not exist in parent class,
		 * we need to give explicit call to the available constructor of parents class ,
		 * with the help of super keyword
		 */
		super(0, null);
		System.out.println("Hi I am Marks class Constructor");
	}
	
	public Marks(int rollNumber, String name, int marks1, int marks2, int marks3) {
		super(rollNumber, name);
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
	
	public void show() {
		display();
		
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
