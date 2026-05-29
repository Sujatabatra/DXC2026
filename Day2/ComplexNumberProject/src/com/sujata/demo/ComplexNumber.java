package com.sujata.demo;

public class ComplexNumber {

	private int real,imagenary;
	
	public void input(int r,int i) {
		//this is the reference variable with holds the reference of current object( the object which is calling the above method)
		this.real=r;
		this.imagenary=i;
	}
	
	public void display() {
		System.out.print(real);
		if(imagenary>0) {
			System.out.println("+"+imagenary+"i");
		}
		else if(imagenary<0) {
			System.out.println(imagenary+"i");
		}
	}
	
}
