package com.sujata.demo;

import com.sujata.demo.Student;

public class StudentSport extends Student {

	private String sportName;
	private int sportScore;
	
	public void input(int rollNumber,String name,String sportName,int sportScore) {
		input(rollNumber, name);
		this.sportName=sportName;
		this.sportScore=sportScore;
	}
	
	public void show() {
		display();
		System.out.println("Sport Name : "+sportName);
		System.out.println("Sport Score : "+sportScore);
	}

	public String getSportName() {
		return sportName;
	}

	public int getSportScore() {
		return sportScore;
	}
	
	
	
}
