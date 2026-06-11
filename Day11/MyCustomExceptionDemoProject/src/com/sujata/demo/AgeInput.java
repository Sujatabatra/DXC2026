package com.sujata.demo;

import com.sujata.exception.AgeCheckedException;
import com.sujata.exception.AgeUncheckedException;

public class AgeInput {

	private int age;

	public AgeInput() {
		
	}
	public AgeInput(int age)throws AgeCheckedException {
		if(age<18) {
			throw new AgeCheckedException("Age must be Greater than 18");
		}
		this.age = age;
	}

//	public AgeInput(int age){
//		if(age<18) {
//			try {
//			throw new AgeCheckedException("Age must be Greater than 18");
//			}
//			catch(AgeCheckedException ex) {
//				System.out.println("something");
//			}
//		}
//		this.age = age;
//	}
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if(age<18) {
			throw new AgeUncheckedException("Age must be greater than 18");
		}
		this.age = age;
	}
	
	
}
