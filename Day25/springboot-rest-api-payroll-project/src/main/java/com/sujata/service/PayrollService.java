package com.sujata.service;

import com.sujata.entity.Payroll;

public interface PayrollService {

	public Payroll getPayrollByEmpId(int id);
	
	public void savePayroll(Payroll payroll);
}
