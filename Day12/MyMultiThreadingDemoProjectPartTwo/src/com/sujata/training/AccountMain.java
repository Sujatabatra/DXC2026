package com.sujata.training;

public class AccountMain {

	public static void main(String[] args) {
		
		Account a001=new Account();
		
		Thread siva=new Thread(a001, "Siva");
		Thread bruno=new Thread(a001, "Bruno");
		
		siva.start();
		bruno.start();

	}

}
