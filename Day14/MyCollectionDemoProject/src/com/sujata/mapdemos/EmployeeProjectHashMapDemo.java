package com.sujata.mapdemos;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EmployeeProjectHashMapDemo {

	public static void main(String[] args) {
		/*
		 * HashMap is the unordered collection of key-value pairs,
		 * where keys are unique and values can be duplicated, and unordering with respect to keys,
		 * collection is auto-growable and auto-shrinkable
		 */
		Map<Employee, Project> employees=new HashMap<Employee, Project>();
		
		System.out.println("size of employees collection : "+employees.size());
		System.out.println(employees);
		
		employees.put(new Employee(101, "AAAA","Manager"), new Project(111, "Project A"));
		employees.put(new Employee(102, "BBBB","Sr. Manager"), new Project(222, "Project B"));
		employees.put(new Employee(103, "CCCC","Sr. Associate"), new Project(111, "Project A"));
		employees.put(new Employee(104, "DDDD","System Arch"), new Project(111, "Project A"));
		
		System.out.println("size of employees collection : "+employees.size());
		System.out.println(employees);
		
		employees.put(new Employee(104, "DDDD","System Arch"), new Project(333, "Project Z"));
		
		System.out.println("size of employees collection : "+employees.size());
		System.out.println(employees);
		
		Set<Employee> emplys=employees.keySet();
		for(Employee employee:emplys) {
			System.out.println(employee +" is working on "+employees.get(employee)+" project ");
		}
		
		
	}

}
