package com.sujata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.sujata.entity.Employee;
import com.sujata.entity.EmployeePayslip;
import com.sujata.persistence.EmployeeDao;
import com.sujata.persistence.EmployeeDaoImpl;

@Service
public class EmployeeServiceChangeRequest extends EmployeeServiceImpl {

	private EmployeeDao employeeDao;

	public EmployeeServiceChangeRequest(@Autowired EmployeeDao employeeDao) {
		super();
		this.employeeDao = employeeDao;
	}

	@Override
	public EmployeePayslip generatePayslip(int employeeId) {
		System.out.println("Calculating from changed request class");
		Employee employee = employeeDao.getEmployeeById(employeeId);

		EmployeePayslip employeePayslip = null;
		if (employee != null) {
			double allowances = employee.getEmpBasicSalary() * .35;
			double deduction = employee.getEmpBasicSalary() * .18;
			double netSalary = employee.getEmpBasicSalary() + allowances - deduction;
			employeePayslip = new EmployeePayslip(employee, allowances, deduction, netSalary);

		}
		return employeePayslip;
	}
}
