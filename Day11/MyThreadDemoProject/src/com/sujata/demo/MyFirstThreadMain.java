package com.sujata.demo;

/*
 * I want to create the job of a thread, and for that i need to specify job in run method of Thread class
 * Thread class .java is not with us, so we are extending Thread class and Overriding run(), to give out behaviour
 */
class MyFirstThread extends Thread{
	
	//Job of a Thread
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" welcomes you! ");
		for(int count=1;count<=5;count++) {
			System.out.println(count+" : "+Thread.currentThread().getName());
		}
		System.out.println("Good Bye from "+Thread.currentThread().getName());
		
	}
}
public class MyFirstThreadMain {

	/*
	 * Execution starts with main() : main is the main thread where execution begins
	 */
	public static void main(String[] args) {
		
		Thread thread1=new MyFirstThread();   //New Born
		
		thread1.start(); //thread will enter ready or running state depending upon scheduling

		Thread thread2=new MyFirstThread(); 
		thread2.start();
		
		System.out.println(Thread.currentThread().getName()+" welcomes you! ");
		for(int count=1;count<=5;count++) {
			System.out.println(count+" : "+Thread.currentThread().getName());
		}
		System.out.println("Good Bye from "+Thread.currentThread().getName());


	}

}
