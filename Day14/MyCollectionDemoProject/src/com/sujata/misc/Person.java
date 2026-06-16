package com.sujata.misc;

import java.util.Objects;

public class Person {

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

	/*
	 * we need to override equals and hashcode together 
	 * because we want 
	 * that if two objects are meaningfully equal then their hashcode should also be same
	 * and if two objects hashcodes are same they might not be meaningfully equal
	 */
	@Override
	public int hashCode() {
		return Objects.hash(personAge, personName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return personAge == other.personAge && Objects.equals(personName, other.personName);
	}
	


}
