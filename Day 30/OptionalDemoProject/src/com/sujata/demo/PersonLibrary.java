package com.sujata.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PersonLibrary {

	List<Person> persons=new ArrayList<Person>();
	
	public PersonLibrary() {
		persons.add(new Person(1, "AAA"));
		persons.add(new Person(2, "BBB"));
		persons.add(new Person(3, "CCC"));
		persons.add(new Person(4, "DDD"));
		persons.add(new Person(5, "EEE"));
	}
	
	public Optional<Person> getPersonById(int id) {
		Person searchedPerson=null;
		for(Person p:persons) {
			if(p.getpId()==id)
				searchedPerson=p;
		}
		return Optional.ofNullable(searchedPerson);
	}
	
//	public Person getPersonById(int id) {
//		for(Person p:persons) {
//			if(p.getpId()==id)
//				return p;
//		}
//		
//		return null;
//	}
}
