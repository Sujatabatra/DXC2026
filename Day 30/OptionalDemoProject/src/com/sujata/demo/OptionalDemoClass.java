package com.sujata.demo;

import java.util.Optional;
import java.util.Scanner;

public class OptionalDemoClass {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		PersonLibrary personLibrary=new PersonLibrary();
		
		System.out.println("Enter person id to be searched for : ");
		int id=scanner.nextInt();
		
//		Person person=personLibrary.getPersonById(id);
//		if(person!=null) {
//		System.out.println("Person id : "+person.getpId()+" Person Name "+person.getpName());
//		}
		
		Optional<Person> opPerson=personLibrary.getPersonById(id);
		
		Person person=opPerson.orElse(new Person());
		
		System.out.println("Person id : "+person.getpId()+" Person Name "+person.getpName());

	}

}
