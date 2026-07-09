package com.sujata.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	Logger logger=LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	@Autowired
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	public Employee addEmployee(Employee employee){
		logger.debug("Going to save employee");
		logger.info("Saving Employee with id{}",employee.getEmpId());
		
		Employee emp=employeeDao.save(employee);
		
		logger.info("Employee saved with id {}",emp.getEmpId());
		return emp;
	}

	@Override
	public Employee searchEmployee(int employeeId) {
		
		logger.debug("Going to search employee employee");
		logger.info("Searching Employee with id {} ",employeeId);
		
		Employee emp=employeeDao.findById(employeeId).
				orElseThrow(()->{
					logger.error("Employee not found with id {}", employeeId);
					return new RuntimeException("Employee with id "+employeeId+" does not exist!");	
				});
		
		logger.info("Employee found with id {}",employeeId);
		return emp;
	}

	@Override
	public boolean deleteEmployee(int employeeId) {
		Employee employee=searchEmployee(employeeId);   //findById()
		if(employee==null)
			return false;
		employeeDao.deleteById(employeeId);      //deleteById()
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
		logger.trace("Searching all employees");
		logger.debug("Getting List of Employees");
		logger.info("Fetching employee List");
		
		return employeeDao.findAll();
	}

	@Override
	public List<Employee> findEmployeesByDepartment(String deptt) {
		
		return employeeDao.findByEmpDepartmentIgnoreCase(deptt);
		
	}

	
}
