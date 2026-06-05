package com.sujata.demo;


/*
 * Ambika: used Car class created by Sujata and
 * took action by reading mail send by sujata
 *  of creating its own version of engine functionality
 * by using Sujata model and color
 * 
 * As design decicions were communicated by mail or any other media not by program
 * so their is a possibility that design desicion might be misunderstood.
 * 
 * to solved this problem we should communicate design decision with out team programitically : by using abstract
 * and abstract explanation is in another project
 */
public class BMW extends Car {

	public BMW(String model, String color) {
		super(model, color);
	}
	
	public void bmwEngine() {
		System.out.println("BMW Engine goes BOOOOM.......");
	}

}
