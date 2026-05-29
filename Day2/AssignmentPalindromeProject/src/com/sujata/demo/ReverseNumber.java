package com.sujata.demo;

public class ReverseNumber {
	/*
	 * number : modifable , setter , input values reverse : readable , getter ,
	 * output variable
	 */
	private int number, reverse;

	public void setNumber(int number) {
		this.number = number;
	}

	public int getReverse() {
		calculateReverse();
		return reverse;
	}
	
	private void calculateReverse() {
		reverse=0;
		while(number>0) {
			int remainder=number%10;
			reverse=reverse*10+remainder;
			number=number/10;
		}
	}

}
