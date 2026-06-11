package com.sujata.demo;

import java.util.Scanner;

import com.sujata.exception.AgeCheckedException;
import com.sujata.exception.AgeUncheckedException;

public class AgeInputMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int age = 0;
		int age1 = 0;

		try {
			System.out.println("Enter Age : ");
			age = scanner.nextInt();
			AgeInput ageInput1 = new AgeInput();
			ageInput1.setAge(age); // if age is less than 18 , AgeUncheckedException should come, Unchecked expection are not forced by compiler
			System.out.println("Person is eligible for voting as you entered age : " + ageInput1.getAge());

			System.out.println("Enter Age : ");
			age1 = scanner.nextInt();
			AgeInput ageInput2 = new AgeInput(age1); // if age is less than 18, AgeCheckedException should come, Checked exception is forced my compiler that i must check it
			System.out.println("Person is eligible for employement as you entered age : " + ageInput2.getAge());

		} catch (AgeUncheckedException ageUncheckedException) {
			System.out.println("Person is not eligible for voting at the age : " + age);
		}

		catch (AgeCheckedException ageCheckedException) {
			System.out.println("Person is not eligible for employement as you entered age : " + age1);
		}

	}

}
