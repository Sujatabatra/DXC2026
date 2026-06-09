package com.sujata.demo;


class BaseStatic{
	
	public void show() {
		System.out.println("Hi I am show method of BaseStatic");
	}
	//static method can not be over ridden but can be re written for the derived class
	static public void display() {
		System.out.println("Hi I am display method of BaseStatic");
	}
}

class DerivedStatic extends BaseStatic{
	
	@Override
	public void show() {
		System.out.println("Hi I am show method of DerivedStatic");
	}
	
//	@Override
	//Re written
	static public void display() {
		System.out.println("Hi I am display method of DerivedStatic");
	}
}

public class StaticMethodOverrideDemoClass {

	public static void main(String[] args) {
		//Reference Variable is of Base Class
		BaseStatic baseStatic;
		
		baseStatic=new BaseStatic();
		baseStatic.show();
		baseStatic.display();
		
		System.out.println("=============");
		
		baseStatic=new DerivedStatic();
		baseStatic.show(); 
		baseStatic.display();
		
		System.out.println("-----------------");
		DerivedStatic derivedStatic=new DerivedStatic();
		derivedStatic.display();
		
		

	}

}
