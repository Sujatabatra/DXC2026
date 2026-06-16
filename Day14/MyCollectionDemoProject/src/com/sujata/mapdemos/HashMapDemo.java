package com.sujata.mapdemos;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {

	public static void main(String[] args) {
		/*
		 * HashMap is the unordered collection of key-value pairs,
		 * where keys are unique and values can be duplicated, and unordering with respect to keys,
		 * collection is auto-growable and auto-shrinkable
		 */
		Map<String, Integer> months=new HashMap<String, Integer>();
		
		System.out.println("size of months collection : "+months.size());
		System.out.println(months);
		
		months.put("Jan", 31);
		months.put("Feb", 28);
		months.put("Mar", 31);
		months.put("Apr", 30);
		
		System.out.println("size of months collection : "+months.size());
		System.out.println(months);
		
		months.put("May", 31);
		months.put("Feb", 29);  //if we are gicing duplicate key, value will be overridden
		
		System.out.println("size of months collection : "+months.size());
		System.out.println(months);
		
		months.remove("Jan");
		
		System.out.println("size of months collection : "+months.size());
		System.out.println(months);

		
		Set<String> monthNames=months.keySet();
		for(String month:monthNames) {
			System.out.println(month+" has "+months.get(month)+" days ");
		}
		
		
	}

}
