package com.sujata.setdemos;

import java.util.Objects;

/*
 * For storing objects of Book class in HashSet and LinkedHashSet, we are overriding equals() and hashCode()
 * 
 * For storing objects of Book class in TreeSet, we need to identify which object is greater or small or equal
 * to identify that we need to implement an interface Comparable and Comparable is a "Functional Interface" 
 * Comparable have one method : compareTo() which will decide which object is greater or smaller or equal
 * 
 * So to Store the object in TreeSet we need to override compareTo() method of Comparable interface and this method is responsibile for maintaining the uniqueness too,
 * for treeset we don't need to override equals() and hashcode()
 */
public class Book implements Comparable<Book> {

	private int bookId;
	private String bookName;
	private String authorName;
	private int price;
	
	public Book() {
		
	}

	public Book(int bookId, String bookName, String authorName, int price) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.authorName = authorName;
		this.price = price;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", authorName=" + authorName + ", price=" + price
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(authorName, bookId, bookName, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(authorName, other.authorName) && bookId == other.bookId
				&& Objects.equals(bookName, other.bookName) && price == other.price;
	}

	/*
	 * compareTo method is responsible for finding which object is greater, smaller or equal
	 * if "this" object is greater return 1
	 * if the object specified as a argument is greater return -1
	 * and if both the objects are equal return 0
	 */
	@Override
	public int compareTo(Book book2) {
		if(this.equals(book2))
			return 0;
		else if(this.price>book2.price)
			return 1;
		else
			return -1;
	}
	
	
}
