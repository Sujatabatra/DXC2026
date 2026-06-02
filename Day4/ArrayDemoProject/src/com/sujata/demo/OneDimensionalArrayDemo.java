package com.sujata.demo;

import java.util.Scanner;

public class OneDimensionalArrayDemo {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		/*
		 * declaring an array
		 * create a reference variable on stack with the name arr  
		 */
		int arr[];
		
		System.out.println("Enter Number of elements in an array : ");
		int elements=scanner.nextInt();
		/*
		 * Array is the dynamic datastructure, as memory allocation happens at run time on heap
		 */
		arr=new int[elements];
		
		
		for(int index=0;index<elements;index++) {
			System.out.println("Enter element at location "+(index+1)+" : ");
			arr[index]=scanner.nextInt();
		}
		
//		for(int index=0;index<elements;index++) {
//			System.out.println("Element at location "+(index+1)+" : "+arr[index]);
//			
//		}
		
		//for-each loop
		for(int element:arr) {
			System.out.println(element);
		}

	}

}
