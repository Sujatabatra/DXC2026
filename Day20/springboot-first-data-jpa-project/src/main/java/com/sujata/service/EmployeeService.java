package com.sujata.service;

import java.util.List;

import com.sujata.entity.Employee;


public interface EmployeeService {

	public boolean addEmployee(Employee employee);
	public Employee searchEmployee(int employeeId);
	public boolean deleteEmployee(int employeeId);
	public boolean salaryAppraisal(int employeeId,int appraisalAmount);
	public List<Employee> getAllEmployees();
	public List<Employee> findEmployeesByDepartment(String deptt);
	
	
}
