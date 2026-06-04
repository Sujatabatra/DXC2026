package com.sujata.demo;

import com.sujata.demo.Student;

public class MyStudentClient {

	public static void main(String[] args) {
		/*
		 * Inheritance : Creation of new class 
		 * with the help of existing class
		 * but without changing the originality of existing classes
		 */
		Student student=new Student();
		student.input(111, "AAAAA");
		student.display();
		
		System.out.println("==================");
		
		Marks marks=new Marks();
		marks.input(101, "ABCD", 67, 89, 56);
		marks.show();
		
		System.out.println("==================");
		
		StudentGrade studentGrade=new StudentGrade();
		studentGrade.input(111, "XYZ", 89, 90, 67);
		studentGrade.showDetails();
		
		
		System.out.println("==================");
		
		StudentSport studentSport=new StudentSport();
		studentSport.input(234, "JKLM", "Football", 8);
		studentSport.show();
		
	}

}
