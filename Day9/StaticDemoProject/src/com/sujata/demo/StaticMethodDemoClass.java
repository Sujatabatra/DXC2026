package com.sujata.demo;

/*
 * Static can be a variable, method, block, import
 * 
 *  static method is also known as class level method, means
 *  static method are available befofe object creation
 *  Static method also exist in all the scopes , i.e private,public protected and default
 *  
 *  from static method we can call only static members, because static method are available before object creation so
 *  the members which are available before object creation can only we called from static methods
 *  
 *  but from instance methods we can call both static as well as instance members
 *  
 */
	

class StaticMethodDemo{
	
	int i;
	private static int j;
	
	
	//instance method : to call these methods we need instance of a class
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	
	//class method: which can be called without object with ClassName
	public static int getJ() {
		return j;
	}
	public static void setJ(int j) {
		StaticMethodDemo.j = j;
	}
	
	
	public void show() {
		System.out.println("i : "+i); 
		System.out.println("j : "+j);
	}
	
	
	static public void display() {
//		System.out.println("i : "+i);
		System.out.println("j : "+j);
	}
}
public class StaticMethodDemoClass {

	public static void main(String[] args) {
		
		//even before object creation static variable exist
		/*
		 * to access static methods without object,
		 * call method with classname
		 * Syntax : ClassName.staticMethod()
		 */
		
		StaticMethodDemo.setJ(10);
		System.out.println("j : "+StaticMethodDemo.getJ());
		StaticMethodDemo.display();
		
		
		StaticMethodDemo obj=new StaticMethodDemo();
		
		StaticMethodDemo obj1=new StaticMethodDemo();
		
		obj.setI(10);
		obj1.setI(20);
		
		System.out.println("obj i "+obj.getI());
		System.out.println("obj1 i "+obj1.getI());

		
		obj.setJ(11);
		obj1.setJ(5);
		
		System.out.println("obj j "+obj.getJ());
		System.out.println("obj1 j "+obj1.getJ());
		
		
	}

}
