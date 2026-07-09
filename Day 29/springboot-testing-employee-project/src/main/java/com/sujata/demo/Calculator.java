package com.sujata.demo;

public class Calculator {

	
	public int sum(int x,int y) {
		return x+y;
	}
	
	public int difference(int x,int y) {
		return x-y;
	}
	
	public int divide(int x,int y) {
		try {
		return x/y;
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return 0;
	}
	
	public int product(int x,int y) {
		return x*y;
	}
}
