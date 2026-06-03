package com.student.client;


//Sub class in same package
public class StudentGrade extends Marks {

	private double percentage;
	private String grade;
	public double getPercentage() {
		percentage=(getMarks1()+getMarks2()+getMarks3())/3;
		return percentage;
	}
	public String getGrade() {
		if(percentage>75)
			grade="A Grade";
		else
			grade="B Grade";
		return grade;
	}
	
	public void showDetails() {
		show();
		System.out.println("Percentage : "+getPercentage());
		System.out.println("Grade :" +getGrade());
	}
	
}
