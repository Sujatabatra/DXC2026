package com.sujata.demo;

/*
 * static block is the very first block which gets executed "JUST ONCE" at the class loading time
 * 
 * before every constructor call instance block will get called
 */
class StaticBlockDemo{
	
	//static block
	static
	{
		System.out.println("Hi I am static block!");
	}
	
	//instance block
	{
		System.out.println("Hi I am instance block!");
	}
	
	//constructor
	StaticBlockDemo(){
		System.out.println("Hi I am StaticBlockDemo Constructor");
	}
	
}

class StaticBlockDemoDerived extends StaticBlockDemo{
	
	//static block
		static
		{
			System.out.println("Hi I am static block of Derived Class!");
		}
		
		//instance block
		{
			System.out.println("Hi I am instance block of Derived Class!");
		}
		
		//constructor
		StaticBlockDemoDerived(){
			/*
			 * implicit call will go to base class default constructor,
			 * if base class don't have default constructor , 
			 * then give explicit call to base class available constructor with "super" keyword 
			 */
			System.out.println("Hi I am StaticBlockDemoDerived Constructor");
		}
	
}
public class StaticBlockDemoClass {

	public static void main(String args[]) {
		
		/*
		 * static block of base => instance block => constructor
		 */
		StaticBlockDemo obj2=new StaticBlockDemo();
		
		System.out.println("========================");
		
		/*
		 * we are creating the derived class object by called derived class constructor
		 * static block of derived => instance block of base=> base constructor => instance block of derived => derived constructor
		 */
		StaticBlockDemoDerived obj1=new StaticBlockDemoDerived(); 
		
		
		
		
	}
}
