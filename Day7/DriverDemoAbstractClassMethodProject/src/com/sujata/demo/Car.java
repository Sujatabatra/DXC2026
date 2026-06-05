package com.sujata.demo;

/*
 * abstract : abstract can be a class and a method
 * We can't instantiate(create Object) abstract class, abstract class is like
 * partial contract sharing with child class that some functionality abstract class is doing
 * and remaning unfulfilled functionality child class need to do 
 * 
 * how we specify unfulfilled functionality is by marking method as abstract
 * abstract method don't have method body
 * abstract method can be only public or protected
 * 
 * if any class is having any abstract method, then its mandatory to mark that class also abstract
 * and abstract class might not have any abstract method too
 * 
 * opposite of abstract class is known as concrete class
 */

abstract public class Car {

	private String model;
	private String color;
	
	public Car(String model, String color) {
		super();
		this.model = model;
		this.color = color;
	}

	public String getModel() {
		return model;
	}

	public String getColor() {
		return color;
	}
	
	//Signing contract with child class, to give the defination of abstract method
	abstract public void engine();
}
