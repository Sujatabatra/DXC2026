package com.sujata.demo;

public class PalindromeClass {

	/*
	 * number : modifiable, setter
	 * palindrome : readable , getter
	 */
	private int number;
	private boolean palindrome;  //boolean can strore either true or false
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public boolean isPalindrome() {
		checkPalindrome();
		return palindrome;
	}
	
	private void checkPalindrome() {
		ReverseNumber reverseNumber=new ReverseNumber();
		
		reverseNumber.setNumber(number);
		
		if(number==reverseNumber.getReverse())
			palindrome=true;
		else
			palindrome=false;
	}
	
}
