package com.sujata.training;

/*
 * Synchronized can be a block or a method
 * its like putting a lock on synchronized block or method that if one thread is executing that block or method another thread will not get access over there.
 * 
 * Lock can be class level or object level
 * 
 * in synchronized block we have flexibility to put object or class level locking
 * whereas in case ofsynchronized method, if instance method is synchronized that means object level locking
 * and if static method is marked synchronized that means class level locking and we can't change it .
 */
public class Account implements Runnable {

	private int balance = 1000;

	/*
	 * withdraw method is instance method, by marking it synchronized I put object level locking
	 */
	public synchronized void withdraw() {
		//object level locking : a001
//		synchronized (this) {
			if (balance > 800) {
				System.out.println(Thread.currentThread().getName()
						+ " you have sufficient balance to withdraw and ur current balance : Rs." + balance);

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				balance -= 800;
				System.out.println(Thread.currentThread().getName() + " your balance after withdrawl is Rs." + balance);
			} else {
				System.out.println(Thread.currentThread().getName()
						+ " you don't have sufficient balance to withdraw and ur current balance : Rs." + balance);
			}
//		}
	}

	@Override
	public void run() {
		withdraw();
	}

}
