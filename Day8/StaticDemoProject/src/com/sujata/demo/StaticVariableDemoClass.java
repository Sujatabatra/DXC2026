package com.sujata.demo;

/*
 * Static can be a variable, method, block, import
 * 
 *  static variable is also known as class level variable, means
 *  static variable get memory area at class compilation time, i.e on stack
 *  and multiple object share one copy of static variable
 *  Static variable also exist in all the scopes , i.e private,public protected and default
 */
	

class StaticVariableDemo{
	
	int i;
	static int j;
	
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public int getJ() {
		return j;
	}
	public void setJ(int j) {
		this.j = j;
	}
	
	
}
public class StaticVariableDemoClass {

	public static void main(String[] args) {
		
		//even before object creation static variable exist
		/*
		 * to access static variable without object,
		 * call variable with classname
		 * Syntax : ClassName.staticVariable
		 */
		// j is visible thats why we were able to call it with class name
		StaticVariableDemo.j=10;
		System.out.println("j : "+StaticVariableDemo.j);
		
		StaticVariableDemo obj=new StaticVariableDemo();
		
		StaticVariableDemo obj1=new StaticVariableDemo();
		
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
