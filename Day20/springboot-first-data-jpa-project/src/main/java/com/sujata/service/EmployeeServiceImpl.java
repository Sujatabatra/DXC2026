package com.sujata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.sujata.entity.Employee;

import com.sujata.persistence.EmployeeDao;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	
	private EmployeeDao employeeDao;
	
	@Autowired
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	public boolean addEmployee(Employee employee){
		employeeDao.save(employee);
		return true;
	}

	@Override
	public Employee searchEmployee(int employeeId) {
		return employeeDao.findById(employeeId).get();
	}

	@Override
	public boolean deleteEmployee(int employeeId) {
		employeeDao.deleteById(employeeId);
		return true;
	}

	@Override
	public boolean salaryAppraisal(int employeeId, int appraisalAmount) {
		Employee employee=employeeDao.findById(employeeId).get();
		employee.setEmpBasicSalary(employee.getEmpBasicSalary()+appraisalAmount);
		employeeDao.save(employee);
		return true;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeDao.findAll();
	}

	@Override
	public List<Employee> findEmployeesByDepartment(String deptt) {
		
		return employeeDao.findByEmpDepartmentIgnoreCase(deptt);
		
	}

	
}
