package com.sujata.client;

import java.util.Scanner;

import com.sujata.entity.Employee;
import com.sujata.persistence.EmployeeDatabase;

public class EmployeeDbMain {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Enter how many employee you have in your organization :");
		int totalEmployees=scanner.nextInt();
		
		EmployeeDatabase employeeDatabase=new EmployeeDatabase(totalEmployees);
		
		for(int index=0;index<totalEmployees;index++) {
			System.out.println("Enter Employee ID : ");
			int id=scanner.nextInt();
			System.out.println("Enter Employee Name : ");
			String name=scanner.next();
			System.out.println("Enter Employee Designation : ");
			String desig=scanner.next();
			System.out.println("Enter Employee Department : ");
			String deptt=scanner.next();
			System.out.println("Enter Employee Basic : ");
			double basic=scanner.nextDouble();
			
			Employee employee=new Employee(id, name, desig, deptt, basic);
			
			employeeDatabase.insertEmployee(employee, index);
		}
		
		
		employeeDatabase.showEmployeeList();
		

	}

}
