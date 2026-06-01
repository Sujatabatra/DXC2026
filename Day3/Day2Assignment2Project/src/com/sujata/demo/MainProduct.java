package com.sujata.demo;

public class MainProduct {

	public static void main(String[] args) {

		double totalRetailValue = 0;
		Product product = new Product(1, 10);
		System.out.println("Retail Price for product number" + product.getProductNumber() + "for quantity "
				+ product.getQuantity() + " is " + product.getRetail());
//		
//		product.setQuantity(20);
//		System.out.println("Retail Price : "+product.getRetail());

		totalRetailValue += product.getRetail();

		product.setProductNumber(2);
		product.setQuantity(5);
		System.out.println("Retail Price for product number" + product.getProductNumber() + "for quantity "
				+ product.getQuantity() + " is " + product.getRetail());
		totalRetailValue += product.getRetail();

		product.setProductNumber(3);
		product.setQuantity(4);
		System.out.println("Retail Price for product number" + product.getProductNumber() + "for quantity "
				+ product.getQuantity() + " is " + product.getRetail());
		totalRetailValue += product.getRetail();

		System.out.println("Total Retail Value : " + totalRetailValue);

	}

}
