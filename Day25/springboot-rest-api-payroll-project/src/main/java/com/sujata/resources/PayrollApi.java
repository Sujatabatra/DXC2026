package com.sujata.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sujata.entity.Payroll;
import com.sujata.service.PayrollService;

@RestController
public class PayrollApi {

	@Autowired
	private PayrollService payrollService;

	@GetMapping(path = "payroll/employees/{id}")
	public Payroll getPayrollByEmpId(@PathVariable("id") int empId) {
		return payrollService.getPayrollByEmpId(empId);
	}
}
