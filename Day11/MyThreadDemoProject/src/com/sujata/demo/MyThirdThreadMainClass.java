package com.sujata.demo;
/*
 * Runnable is a Functional Interface nad has one function as run(), run() is thread job
 */

class BaseClass{
	
	public void show() {
		System.out.println(Thread.currentThread().getName()+" is running show method of BaseClass ");
	}
}

/*
 * As multiple inheritance is not allowed in Java so we can't extends thread class to override run() to give job for a thread in derived class.
 * 
 */
class DerivedClass extends BaseClass/*,Thread*/ implements Runnable{
	
	/*
	 * I want this show method be the job of Thread
	 */
	public void show() {
		super.show();
		System.out.println(Thread.currentThread().getName()+" welcomes you! ");
		for(int count=1;count<=5;count++) {
			System.out.println(count+" : "+Thread.currentThread().getName());
		}
		System.out.println("Good Bye from "+Thread.currentThread().getName());
	}

	@Override
	public void run() {
		show();
		
	}
}
public class MyThirdThreadMainClass {

	public static void main(String[] args) {
		//3.Constructor= Thread(Runnable job)
		Thread thread1=new Thread(new DerivedClass());
		thread1.start();

		//4.Constructor: Thread(Runnable job,String name)
		Thread thread2=new Thread(new DerivedClass(), "Marcial");
		thread2.start();
		
		System.out.println(Thread.currentThread().getName()+" welcomes you! ");
		for(int count=1;count<=5;count++) {
			System.out.println(count+" : "+Thread.currentThread().getName());
		}
		System.out.println("Good Bye from "+Thread.currentThread().getName());
		System.out.println("Checking if thread-0 is alive:"+thread1.isAlive());
		System.out.println("Checking if Marcial thread is still running : "+thread2.isAlive());
	}

}
