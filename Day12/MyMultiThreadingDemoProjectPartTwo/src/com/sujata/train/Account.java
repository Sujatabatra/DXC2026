package com.sujata.train;

/*
 * Synchronized can be a block or a method
 * its like putting a lock on synchronized block or method that if one thread is executing that block or method another thread will not get access over there.
 * 
 * Lock can be class level or object level
 */
public class Account implements Runnable {

	private static int balance = 1000;

	public void withdraw() {
		//class level locking
		synchronized (Account.class) {
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
		}
	}

	@Override
	public void run() {
		withdraw();
	}

}
