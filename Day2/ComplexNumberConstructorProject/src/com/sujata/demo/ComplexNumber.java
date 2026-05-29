package com.sujata.demo;

/*
 * Constructor : constructor is used to initialise the object at the time of declaration
 * Constructor is the very first function which gets called while creating the object
 * 
 * Rules of creating Constructor
 * 1. Constructor name is same as that of class name
 * 2. Constructor don't have any return type not even void
 * 3. Constructor can be argumented as well as non argumented
 * 4. Any class which does not have any constructor written by the developer in such case, compiler will create one default constructor for the class,
 * which is zero argument constructor otherwise not.
 * 5. Construtor can be public or private
 * 
 */
public class ComplexNumber {

	private int real,imagenary;
	
	/*
	 * constructor with two arguments
	 * 
	 * Constructor Overloading : 
	 * In constructor overloading one constructor is differentiated from one another wrt its signature
	 * and signature means number and types of arguments and its sequence
	 */
	public ComplexNumber(int real,int imagenary) {
		this.real=real;
		this.imagenary=imagenary;
	}
	
	private ComplexNumber() {
		
	}
	
	public ComplexNumber(int real) {
		this.real=real;
		imagenary=5;
				
	}
	
	public void input(int r,int i) {
		
		this.real=r;
		this.imagenary=i;
	}
	
	public void display() {
		System.out.print(real);
		if(imagenary>0) {
			System.out.println("+"+imagenary+"i");
		}
		else if(imagenary<0) {
			System.out.println(imagenary+"i");
		}
	}
	
	public ComplexNumber addTwoNumbers(ComplexNumber complex2) {
		/*
		 * as zero argument constructor is private , so we can use it only in same class
		 */
		ComplexNumber sumComplex=new ComplexNumber();
		sumComplex.real=this.real+complex2.real;
		sumComplex.imagenary=this.imagenary+complex2.imagenary;
		return sumComplex;
	}
}
