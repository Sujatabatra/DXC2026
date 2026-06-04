package com.sujata.training;

import com.sujata.demo.ButterPopCorn;
import com.sujata.demo.CaramelPopCorn;
import com.sujata.demo.PopCorn;

public class PopCornShoppingMart {

	public static void main(String[] args) {
		/*
		 * Dynamic Method Dispatch
		 * 
		 * Base class Reference Variable is type compatible with derived class,
		 * but reverse is not true
		 * 
		 * if Base Class Reference Variable is holding Derived Class Object, 
		 * that reference variable will able to call only the functionality coming from base class,
		 * that functionality can be original functionality coming from base call or overridden functionality over ridden in derived class
		 */
		
		//Base Class Reference Variable
		PopCorn popCorn;
		
		popCorn=new PopCorn();
		popCorn.pop(); // pop() from PopCorn
		popCorn.quantity();
		
		//reference variable is of base class= Derived Class Object
		popCorn=new ButterPopCorn();
		popCorn.pop();  //pop() from ButterPopCorn
		popCorn.quantity();
		
//		popCorn.butterQuantity(); (Because of Object slicing new functionality cannot be called)
		
		popCorn=new CaramelPopCorn();
		popCorn.pop(); //pop() from CaramelPopCorn
		popCorn.quantity();
		
		/*
		 * Every time we are calling pop() with BaseClass reference Variable i.e PopCorn
		 * but whatever object is stored in that Reference variable depending upon that respective version of pop() is getting called
		 * that means, we achived polymorphism with the help of over riding
		 * 
		 * As object creation is run time activity, so which function will get the call will be decided at run time itself,
		 * so with the help of over riding we are achiveing run time polymorphism
		 */
//		popCorn.CaramelQuantity();(Because of Object slicing new functionality cannot be called)
		
		
		
		//Derived Class Reference Variable
//		ButterPopCorn butterPopCorn;
//		butterPopCorn=new PopCorn(); (Syntax wise not possible)

	}

}
