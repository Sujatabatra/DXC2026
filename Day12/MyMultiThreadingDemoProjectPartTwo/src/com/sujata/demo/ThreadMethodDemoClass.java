package com.sujata.demo;

class MyThread extends Thread{
	
	@Override
	public void run() {
		System.out.println("Currently Running Thread Name :"+Thread.currentThread().getName());
		System.out.println("Currently Running Thread ID :"+Thread.currentThread().threadId());
		System.out.println("Current Thread Priority : "+Thread.currentThread().getPriority());
		System.out.println("Good Bye from "+Thread.currentThread().getName());
	}
}
public class ThreadMethodDemoClass {

	public static void main(String[] args) {
		
		Thread thread1=new MyThread();
		
		Thread thread2=new MyThread();
		thread2.setName("MyThread-1");
		
		Thread thread3=new MyThread();
		/*
		 * Even if we are setting the priority,
		 * its like requestiong OS to give the desired priority to the thread,
		 * but again it depends upon OS to approve our request or disapprove it,
		 * even if request disapproved we will not get any message but thread will be executed as per OS Scheduler.
		 */
		thread3.setPriority(Thread.MAX_PRIORITY);
		thread2.setPriority(Thread.MIN_PRIORITY);
		
		thread1.start();
		thread2.start();
		thread3.start();
		
		System.out.println("Currently Running Thread Name : "+Thread.currentThread().getName());
		System.out.println("Currently Running Thread ID :"+Thread.currentThread().threadId());
		System.out.println("Current Thread Priority : "+Thread.currentThread().getPriority());

		System.out.println("Good Bye from "+Thread.currentThread().getName());
	}

}
