package com.sujata.demo;

//Sub class in same package
public class StudentGrade extends Marks {

	private double percentage;
	private String grade;

	public StudentGrade() {
		// call parents class default constructor (implicit call)
		System.out.println("Hi I am StudentGrade class Constructor");
	}

	public StudentGrade(int rollNumber, String name, int marks1, int marks2, int marks3) {
		super(rollNumber, name, marks1, marks2, marks3);
	}

	public double getPercentage() {
		percentage = (getMarks1() + getMarks2() + getMarks3()) / 3;
		return percentage;
	}

	public String getGrade() {
		if (percentage > 75)
			grade = "A Grade";
		else
			grade = "B Grade";
		return grade;
	}

	public void display() {
		super.display();
		System.out.println("Percentage : " + getPercentage());
		System.out.println("Grade :" + getGrade());
	}

}
