package com.sujata.demo;

public class Product {

	private int productNumber;
	private int quantity;
	private double price;
	private double retail;
	
	public Product() {
		
	}
	public Product(int productNumber, int quantity) {
		super();
		setProductNumber(productNumber);
		setQuantity(quantity);
	}

	public void setProductNumber(int productNumber) {
		this.productNumber = productNumber;
		switch (productNumber) {
		case 1: 	
			price=22.50;
		case 2:
			price=44.50;
		case 3:
			price=9.98;
		}
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
		retail=quantity*price;
	}

	public int getProductNumber() {
		return productNumber;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getPrice() {
		return price;
	}

	public double getRetail() {
		return retail;
	}	
	
	
}
