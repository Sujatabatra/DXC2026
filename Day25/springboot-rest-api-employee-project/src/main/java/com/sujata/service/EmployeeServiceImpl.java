package com.sujata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sujata.entity.Employee;

import com.sujata.persistence.EmployeeDao;

@Transactional
@Service
public class EmployeeServiceImpl implements EmployeeService {

	
	private EmployeeDao employeeDao;
	
	@Autowired
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	public Employee addEmployee(Employee employee){
		return employeeDao.save(employee);
		
	}

	@Override
	public Employee searchEmployee(int employeeId) {
		Employee emp=employeeDao.findById(employeeId).orElseThrow(()->new RuntimeException("Employee with id "+employeeId+" does not exist!"));
		return emp;
	}

	@Override
	public boolean deleteEmployee(int employeeId) {
		Employee employee=searchEmployee(employeeId);
		if(employee==null)
			return false;
		employeeDao.deleteById(employeeId);
		return true;
	}

	
	@Override
	public boolean salaryAppraisal(int employeeId, int appraisalAmount) {
		
		return employeeDao.updateBasicSalaryById(employeeId, appraisalAmount)>0;
//		//select * from employees where emp_Id=employeeId
//		Employee employee=employeeDao.findById(employeeId).orElse(null);
//		if(employee!=null) {
//		employee.setEmpBasicSalary(employee.getEmpBasicSalary()+appraisalAmount);
//		//update query
//		employeeDao.save(employee);
//		return true;
//		}
		
		
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
