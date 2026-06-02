package com.sujata.persistence;

import com.sujata.entity.Employee;

public class EmployeeDatabase {

	private Employee[] employeeList;
	private int totalNoOfEmployees;
	
	public EmployeeDatabase(int totalNoOfEmployees) {
		this.totalNoOfEmployees = totalNoOfEmployees;
		employeeList=new Employee[totalNoOfEmployees];
	}
	
	public void insertEmployee(Employee employee,int index) {
		employeeList[index]=employee;
	}
	
	public void showEmployeeList() {
		for(Employee employee:employeeList) {
			System.out.println(employee.getEmpId()+"  "+employee.getEmpName()+"  "+employee.getEmpDesig()+"  "+employee.getBasic());
		}
	}
	
	
	
}
