package com.sujata.service;

import java.util.List;

import com.sujata.entity.Employee;
import com.sujata.entity.Payroll;
import com.sujata.entity.Project;

public interface EmployeeService {

	public void addEmployee(Employee employee, Payroll payroll, List<Integer> projectIds);

	public void assignProject(int empId, int projectId);

	public void transferProject(int empId, int oldProjectId, int newProjectId);

	public void reviseSalary(int empId, double increment);

	public Employee getEmployee(int empId);

	public void deleteEmployee(int empId);

	public void rollbackDemo(Employee emp, Payroll payroll, List<Integer> projectIds);
}
