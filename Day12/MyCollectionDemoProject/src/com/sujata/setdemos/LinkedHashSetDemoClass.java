package com.sujata.setdemos;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetDemoClass {

	public static void main(String[] args) {
		/*
		 * LinkedHashset is the ordered unique collection of objects and 
		 * collection is auto growable and auto shrinkable
		 */
		Set<Integer> collection=new LinkedHashSet<Integer>();

		System.out.println("Collection current size : "+collection.size());
		System.out.println(collection);
		
		collection.add(10);
		collection.add(12);
		collection.add(5);
		
		System.out.println("Collection current size : "+collection.size());
		System.out.println(collection);
		
		collection.add(35);
		collection.add(10);
		
		System.out.println("Collection current size : "+collection.size());
		System.out.println(collection);
		
		collection.remove(12);
		System.out.println("Collection current size : "+collection.size());
		System.out.println(collection);
	
		System.out.println("Using for each loop");
		for(Integer element:collection) {
			System.out.println(element);
		}
		
		System.out.println("Traversal using Iterator");
		Iterator<Integer> iterator=collection.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

}
