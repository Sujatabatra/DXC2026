package com.sujata.demo;

public class ShowDetailsThreadClass extends Thread {

	@Override
	public void run() {
		for(int count=1;count<=5;count++) {
			System.out.println("Thread id : "+Thread.currentThread().getId());
			System.out.println("Thread Name : "+Thread.currentThread().getName());
			System.out.println("Is thread Alive : "+Thread.currentThread().isAlive());
			System.out.println("Thread Priority : "+Thread.currentThread().getPriority());
			System.out.println("Thread State : "+Thread.currentThread().getState());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

