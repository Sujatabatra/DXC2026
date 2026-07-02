package com.sujata.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sujata.entity.EmployeePayslip;
import com.sujata.service.EmployeePayrollService;

@RestController
public class EmployeePayrollApi {

	@Autowired
	private EmployeePayrollService employeePayrollService;
	
	@GetMapping(path = "/payslip/employees/{id}")
	public EmployeePayslip getEmployeePayslip(@PathVariable("id") int empId) {
		return employeePayrollService.getEmployeePayslip(empId);
	}
}
