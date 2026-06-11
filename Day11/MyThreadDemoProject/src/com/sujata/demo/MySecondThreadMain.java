package com.sujata.demo;


class MySecondThread extends Thread{
	
	//1.Constructor : Thread() , when we are not giving the name, internally it allocates the name as Thread-0,thread-1 and so on
	public MySecondThread() {
		super();
	}
	//2.Constructor : Thread(String name), we can give our own names to threads while creating them
	public MySecondThread(String name) {
		super(name);
	}

	@Override
	public void run() {
		threadJob();
	}
	
	public void threadJob() {
		System.out.println(Thread.currentThread().getName()+" welcomes you! ");
		for(int count=1;count<=5;count++) {
			System.out.println(count+" : "+Thread.currentThread().getName());
		}
		System.out.println("Good Bye from "+Thread.currentThread().getName());
	}
}

public class MySecondThreadMain {

	
	public static void main(String[] args) {
		
		Thread thread1=new MySecondThread("Sujata"); 
		Thread thread2=new MySecondThread("Ambika");
		
		thread1.start(); 
		thread2.start();
		
		System.out.println(Thread.currentThread().getName()+" welcomes you! ");
		for(int count=1;count<=5;count++) {
			System.out.println(count+" : "+Thread.currentThread().getName());
		}
		System.out.println("Good Bye from "+Thread.currentThread().getName());


	}

}
