package com.sujata.service;

import java.util.List;

import com.sujata.entity.Employee;
import com.sujata.excep.DuplicateEmployeeIdException;
import com.sujata.persistence.EmployeeDao;
import com.sujata.persistence.EmployeeDaoImpl;

public class EmployeeServiceImpl implements EmployeeService {

	
	private EmployeeDao employeeDao=new EmployeeDaoImpl();
	
	@Override
	public boolean addEmployee(Employee employee)throws DuplicateEmployeeIdException {
		if(employeeDao.insertRecord(employee)>0)
			return true;
		return false;
	}

	@Override
	public Employee searchEmployee(int employeeId) {
		return employeeDao.getEmployeeById(employeeId);
	}

	@Override
	public boolean deleteEmployee(int employeeId) {
		if(employeeDao.deleteRecord(employeeId)>0)
			return true;
		return false;
	}

	@Override
	public boolean salaryAppraisal(int employeeId, int appraisalAmount) {
		if(employeeDao.updateRecord(employeeId,appraisalAmount)>0)
			return true;
		return false;
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		return employeeDao.getAllRecords();
	}

}
