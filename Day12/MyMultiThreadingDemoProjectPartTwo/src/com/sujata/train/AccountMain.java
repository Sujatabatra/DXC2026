package com.sujata.train;

public class AccountMain {

	public static void main(String[] args) {
		
		Account a1=new Account();
		Account a2=new Account();
		
		Thread siva=new Thread(a1, "Siva");
		Thread bruno=new Thread(a2, "Bruno");
		
		siva.start();
		bruno.start();

	}

}
