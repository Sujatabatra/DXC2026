package com.sujata.misc;

public class EqualDemoClass {

	public static void main(String[] args) {
		int i=10;
		int j=10;
		if(i==j)
			System.out.println("i and j are equal");
		else
			System.out.println("i and j are not equal");
		
		Person person1=new Person("AAAA", 35);
		Person person2=new Person("AAAA", 35);

		/*
		 * ==, it is checking wheather both the reference variable are pointing to same object on heap or not
		 */
		if(person1==person2)
			System.out.println("person1 and person2 are equal");
		else
			System.out.println("person1 and person2 are not equal");
	
		/*
		 * equals method is from Object class and is checking the same way as that of ==
		 * if we want that equals method should check wheather two objects are meaningfully equal or not, we need to modify its behaviour by over riding it
		 */
	
		if(person1.equals(person2))
			System.out.println("person1 and person2 are equal");
		else
			System.out.println("person1 and person2 are not equal");
	
		System.out.println("person 1 hashcode : "+person1.hashCode());
		System.out.println("person 2 hashcode : "+person2.hashCode());
	
		String str1="Sujata";
		String str2="Sujata";
		
		System.out.println(str1.compareTo(str2));
			
	}

}
