package com.sujata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.sujata.entity.Employee;
import com.sujata.entity.EmployeePayslip;
import com.sujata.excep.DuplicateEmployeeIdException;
import com.sujata.persistence.EmployeeDao;
import com.sujata.persistence.EmployeeDaoImpl;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	
	private EmployeeDao employeeDao;
	
	@Autowired
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

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

	@Override
	public EmployeePayslip generatePayslip(int employeeId) {
		
		Employee employee=employeeDao.getEmployeeById(employeeId);
		
		EmployeePayslip employeePayslip=null;
		if(employee!=null) {
			double allowances=employee.getEmpBasicSalary()*.30;
			double deduction=employee.getEmpBasicSalary()*.12;
			double netSalary=employee.getEmpBasicSalary()+allowances-deduction;
			employeePayslip=new EmployeePayslip(employee, allowances, deduction, netSalary);
			
		}
		return employeePayslip;
	}

}
