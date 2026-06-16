package com.sujata.setdemos;

import java.util.Comparator;

public class BookAuthorNameSort implements Comparator<Book> {

	/*
	 *  if first object is greater return 1
	 * if second object is greater return -1
	 * and if both the objects are equal return 0
	 */
	@Override
	public int compare(Book book1, Book book2) {
		if(book1.equals(book2))
			return 0;
		else if(book1.getAuthorName().compareTo(book2.getAuthorName())>0)
			return 1;
		else
			return -1;
	}

}
