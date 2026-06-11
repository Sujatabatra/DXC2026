package com.sujata.demo;


class MyFourthThread extends Thread{
	
	//1.Constructor : Thread() , when we are not giving the name, internally it allocates the name as Thread-0,thread-1 and so on
	public MyFourthThread() {
		super();
	}
	//2.Constructor : Thread(String name), we can give our own names to threads while creating them
	public MyFourthThread(String name) {
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
		
		try {
			
			Thread.sleep(1000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Good Bye from "+Thread.currentThread().getName());
	}
}

public class MyFourthThreadMain {

	
	public static void main(String[] args) {
		
		Thread thread1=new MyFourthThread("Sujata"); 
		Thread thread2=new MyFourthThread("Ambika");
		
		thread1.start(); 
		thread2.start();
		
		System.out.println(Thread.currentThread().getName()+" welcomes you! ");
		for(int count=1;count<=5;count++) {
			System.out.println(count+" : "+Thread.currentThread().getName());
		}
		System.out.println("Good Bye from "+Thread.currentThread().getName());


	}

}
