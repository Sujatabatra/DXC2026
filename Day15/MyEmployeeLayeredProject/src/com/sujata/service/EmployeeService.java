package com.sujata.service;

import java.util.List;

import com.sujata.entity.Employee;
import com.sujata.excep.DuplicateEmployeeIdException;

public interface EmployeeService {

	public boolean addEmployee(Employee employee)throws DuplicateEmployeeIdException;
	public Employee searchEmployee(int employeeId);
	public boolean deleteEmployee(int employeeId);
	public boolean salaryAppraisal(int employeeId,int appraisalAmount);
	public List<Employee> getAllEmployees();
	
}
