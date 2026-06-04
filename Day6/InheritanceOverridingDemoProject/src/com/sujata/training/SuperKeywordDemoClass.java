package com.sujata.training;

class Base{
	int number;
	
	public Base(int number) {
		this.number=number;
	}
}

class Derived extends Base{
	

	int number;
	
	public Derived(int number,int number1) {
		super(number);
		this.number=number1;
	}
	
	public void findGreater() {
		if(super.number>this.number) {
			System.out.println(super.number+" is greater");
		}
		else {
			System.out.println(this.number+" is greater");
		}
	}
}
public class SuperKeywordDemoClass {

	public static void main(String[] args) {
		Derived derived=new Derived(10, 20);
		derived.findGreater();

	}

}
