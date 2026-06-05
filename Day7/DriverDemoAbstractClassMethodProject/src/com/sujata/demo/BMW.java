package com.sujata.demo;


//Ambika
/*
 * abstract is saying either fulfill the complete contract or mark urself as abstract
 * so if you are marked abstract, no one will able to create object of you and use you as a concerete class
 */
abstract public class BMW extends Car {

	public BMW(String model, String color) {
		super(model, color);
	}
	
	
	public void bmwEngine() {
		System.out.println("BMW Engine goes BOOOOM.......");
	}


//	@Override
//	public void engine() {
//		bmwEngine();
//		
//	}

}
