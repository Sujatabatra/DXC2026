package com.sujata.setdemos;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetBookDemoClass {

	public static void main(String[] args) {
		/*
		 * Hashset is the "unordered unique collection" of objects and collection is auto
		 * growable and auto shrinkable
		 */
		/*
		 * whenever you are storing unique user defined objects either in HashSet or in LinkedHashSet, always override equals() and hashcode() in the class
		 */
		Set<Book> collection = new TreeSet<Book>();

		System.out.println("Collection current size : " + collection.size());
		System.out.println(collection);

		collection.add(new Book(1, "Book 1", "Author A", 780));
		collection.add(new Book(2, "Book 2", "Author B", 800));
		collection.add(new Book(3, "Book 3", "Author A", 1500));

		System.out.println("Collection current size : " + collection.size());
		System.out.println(collection);

		collection.add(new Book(1, "Book 1", "Author A", 780));  //duplicate object
		collection.add(new Book(4, "Book 4", "Author Z", 1450));

		System.out.println("Collection current size : " + collection.size());
		System.out.println(collection);

		
		System.out.println("Using for each loop");
		for (Book element : collection) {
			System.out.println(element);
		}

		System.out.println("Traversal using Iterator");
		Iterator<Book> iterator = collection.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

}
