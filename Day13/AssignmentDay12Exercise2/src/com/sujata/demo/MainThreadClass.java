package com.sujata.demo;

public class MainThreadClass {

	public static void main(String[] args) {
		
		ShowDetailsThreadClass thread1=new ShowDetailsThreadClass();
		ShowDetailsThreadClass thread2=new ShowDetailsThreadClass();
		ShowDetailsThreadClass thread3=new ShowDetailsThreadClass();
		ShowDetailsThreadClass thread4=new ShowDetailsThreadClass();
	
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
	}

}
