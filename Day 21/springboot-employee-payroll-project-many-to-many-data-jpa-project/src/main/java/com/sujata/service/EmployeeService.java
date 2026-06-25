package com.sujata.service;

import java.util.List;

import com.sujata.entity.Employee;
import com.sujata.entity.Project;

public interface EmployeeService {

	public boolean addEmployee(Employee employee);

	public Employee searchEmployee(int employeeId);

	public boolean deleteEmployee(int employeeId);

	public List<Employee> getAllEmployees();

	public List<Employee> findEmployeesByDepartment(String deptt);
	
	public boolean addProject(Project project);
	
	public void assignProject(int empId, int projectId);

}
