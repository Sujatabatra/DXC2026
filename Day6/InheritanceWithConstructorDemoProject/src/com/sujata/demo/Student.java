package com.sujata.demo;

public class Student {

	private int rollNumber;
	private String name;
	
	public Student() {
		//call parents class default constructor (implicit call) : default constructor is zero argument constructor
		System.out.println("Hi I am Student Class Constructor");
	}
	
	
	public Student(int rollNumber, String name) {
		System.out.println("Hi I am argumented Student class constructor");
		this.rollNumber = rollNumber;
		this.name = name;
	}

	public void input(int rollNumber,String name) {
		this.rollNumber=rollNumber;
		this.name=name;
	}
	
	public void display() {
		System.out.println("Roll Number : "+rollNumber);
		System.out.println("Name : "+name);
	}

	public int getRollNumber() {
		return rollNumber;
	}

	public String getName() {
		return name;
	}
	
	
}
