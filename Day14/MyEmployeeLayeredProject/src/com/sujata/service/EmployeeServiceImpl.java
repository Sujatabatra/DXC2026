package com.sujata.service;

import com.sujata.entity.Employee;
import com.sujata.persistence.EmployeeDao;
import com.sujata.persistence.EmployeeDaoImpl;

public class EmployeeServiceImpl implements EmployeeService {

	
	private EmployeeDao employeeDao=new EmployeeDaoImpl();
	
	@Override
	public boolean addEmployee(Employee employee) {
		if(employeeDao.insertRecord(employee)>0)
			return true;
		return false;
	}

	@Override
	public Employee searchEmployee(int employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteEmployee(int employeeId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean salaryAppraisal(int employeeId, int appraisalAmount) {
		// TODO Auto-generated method stub
		return false;
	}

}
