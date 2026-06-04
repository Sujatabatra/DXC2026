package com.sujata.client;

import com.sujata.demo.Marks;
import com.sujata.demo.Student;
import com.sujata.demo.StudentGrade;
import com.sujata.demo.StudentSport;

public class MyStudentClient {

	public static void main(String[] args) {
		/*
		 * Whenever we are calling any class constructor: first call will go to the base class constructor of that class
		 */
		
		Marks marks=new Marks();
		marks.input(101, "ABCD", 67, 89, 56);
		marks.display();
		
		System.out.println("===================");
		
		StudentGrade studentGrade=new StudentGrade(111, "MNOP", 56, 88, 99);
		studentGrade.display();
		
	}

}
