package com.sujata.demo;

public class MainClassDemoInSamePackage {

	public static void main(String[] args) {
		
		//Different class but same package
		ClassDemo classDemo=new ClassDemo();
//		classDemo.privateShow();
		classDemo.publicShow();
		classDemo.protectedShow();
		classDemo.defaultShow();
		
//		classDemo.value1=10;
		classDemo.value2="Sujata";
		classDemo.value3=34.5;
		classDemo.value4=25;
	}

}
