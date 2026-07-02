package com.sujata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sujata.entity.Employee;
import com.sujata.entity.EmployeePayslip;
import com.sujata.entity.Payroll;

@Service
public class EmployeePayrollServiceImpl implements EmployeePayrollService {

	/*
	 * with RestTemplate, we will call any other Rest API
	 */
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public EmployeePayslip getEmployeePayslip(int empId) {

		Employee employee = restTemplate.getForObject("http://localhost:8085/employees/" + empId, Employee.class);

		Payroll payroll = restTemplate.getForObject("http://localhost:8088/payroll/employees/" + empId, Payroll.class);

		EmployeePayslip employeePayslip = new EmployeePayslip();

		employeePayslip.setEmpId(employee.getEmpId());
		employeePayslip.setEmpName(employee.getEmpName());
		employeePayslip.setEmpSalary(employee.getEmpBasicSalary());
		employeePayslip.setEmpAllowances(payroll.getAllowance());
		employeePayslip.setEmpDeductions(payroll.getDeductions());
		employeePayslip.setNetSalary(employee.getEmpBasicSalary() + payroll.getAllowance() - payroll.getDeductions());
		
		return employeePayslip;
	}

}
