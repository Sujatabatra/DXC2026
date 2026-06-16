package com.sujata.listdemos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedListDemo {

	public static void main(String[] args) {
		/*
		 * LinkedList is the indexed ordered collection of objects , where duplicates are allowed
		 * collection is auto-growable and auto-shrinkable
		 * internal representation is of doubly linked list
		 */
		List<Integer> collection=new LinkedList<Integer>();
		
		System.out.println("Size of collection : "+collection.size());
		System.out.println(collection);
		
		collection.add(10);
		collection.add(20);
		collection.add(15);

		System.out.println("Size of collection : "+collection.size());
		System.out.println(collection);
		
		collection.add(56);
		collection.add(10);
		collection.add(78);
		
		System.out.println("Size of collection : "+collection.size());
		System.out.println(collection);
		
		collection.remove(Integer.valueOf(20));  //in remove i gave Integer type object, that means removing the respective object value
	
		System.out.println("Size of collection : "+collection.size());
		System.out.println(collection);
		
		collection.remove(1); //in remove i gave int type value and that is index
		System.out.println("Size of collection : "+collection.size());
		System.out.println(collection);
		
		System.out.println("Traversal using traditional for loop");
		for(int index=0;index<collection.size();index++) {
			System.out.println(collection.get(index));
		}
		
		System.out.println("Backward Traversal using traditional for loop");
		for(int index=collection.size()-1;index>=0;index--) {
			System.out.println(collection.get(index));
		}
		
		
		System.out.println("Traversal using for each loop");
		for(Integer element:collection) {
			System.out.println(element);
		}
		
		System.out.println("Traversal using Iterator");
		Iterator<Integer> iterator=collection.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		/*
		 * Available only to the child classes of List interface,
		 * ListIterator allows both forward and backward traversal
		 */
		ListIterator<Integer> listIterator=collection.listIterator();
		System.out.println("Backward Traversal using ListIterator");
		while(listIterator.hasNext())
			listIterator.next();
		
		while(listIterator.hasPrevious())
			System.out.println(listIterator.previous());
	}

}
