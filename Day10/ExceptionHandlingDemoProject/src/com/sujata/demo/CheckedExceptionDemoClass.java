package com.sujata.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CheckedExceptionDemoClass {


	public static void openFile(String fileName)throws FileNotFoundException {
//		try {
		FileInputStream readFile=new FileInputStream(fileName);
		System.out.println(fileName+" Opened for reading");
//		}
//		catch(FileNotFoundException fileNotFoundException) {
//			System.out.println("No Such File Exist with name "+fileName);
//		}
		
	}
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		String fileName=null;
		try {
		System.out.println("Enter File Name : ");
		fileName=scanner.next();
		
		openFile(fileName);
		}
		catch(FileNotFoundException fileNotFoundException) {
			System.out.println("No Such File Exist with name "+fileName);
		}
		catch(Exception exception) {
			System.out.println("Something went wrong please try after sometime!");
		}
		System.out.println("Good Bye from Main!");

	}

}
