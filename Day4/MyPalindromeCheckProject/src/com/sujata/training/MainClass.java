package com.sujata.training;

public class MainClass {

	public static void main(String[] args) {
		
//		PalindromeClass palindromeClass=new PalindromeClass();
		
		//1st statement : Reference variable got created on stacks
		PalindromeClass palindromeClass;
		//2nd statement: create or allocates memory for object in heap
		palindromeClass=new PalindromeClass();
		
		palindromeClass.setNumber(12300);
		
		if(palindromeClass.isPalindrome())
			System.out.println("User entered mirror number");
		else
			System.out.println("User not enterd mirror number");

	
		int sum=0;
	for(int count=1;count<=100;count++) {
		palindromeClass.setNumber(count);
		if(palindromeClass.isPalindrome())
			sum=sum+count;
	}
	
	System.out.println("Sum of first 100 palindrome numbers : "+sum);
	}
}
