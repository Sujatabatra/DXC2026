package com.sujata.misc;
/*
 * with the help of generics we can create class, interface or methods which are independent of object type
 */


class IntegerInput{
	private int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
}

class DoubleInput{
	private double value;

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
	
}

class StringInput{
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}

class Person{
	private String personName;
	private int personAge;
	
	public Person() {
		
	}

	public Person(String personName, int personAge) {
		super();
		this.personName = personName;
		this.personAge = personAge;
	}


	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public int getPersonAge() {
		return personAge;
	}

	public void setPersonAge(int personAge) {
		this.personAge = personAge;
	}

	@Override
	public String toString() {
		return "Person [personName=" + personName + ", personAge=" + personAge + "]";
	}
	
	
	
}
/*
 * GenericInput class is indepdent of any of the object type, means works with all kind of objects
 */
class GenericInput<T>{
	private T value;

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
	
}
public class GenericDemoClass {

	public static void main(String[] args) {
		GenericInput<Integer> intInput=new GenericInput<Integer>();
		intInput.setValue(20);
		System.out.println("intInput value : "+intInput.getValue());
		
		GenericInput<String> strInput=new GenericInput<>();
		strInput.setValue("Sujata");
		System.out.println("strInput value : "+strInput.getValue());

		GenericInput<Person> personInput=new GenericInput<>();
		personInput.setValue(new Person("AAAA",45));
		Person person=personInput.getValue();
		/*
		 * whenever we are printing the object with System.out.print() method , implicit call goes to toString() of Object class
		 */
		System.out.println("personInput Value "+person);
		

	}

}
