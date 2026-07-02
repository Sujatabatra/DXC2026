package com.sujata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sujata.entity.Payroll;
import com.sujata.persistence.PayrollRepository;

@Service
public class PayrollServiceImpl implements PayrollService {

	@Autowired
	private PayrollRepository payrollRepository;
	
	@Override
	public Payroll getPayrollByEmpId(int id) {
		
		return payrollRepository.getByEmpId(id);
	}

	@Override
	public void savePayroll(Payroll payroll) {
		payrollRepository.save(payroll);
		
	}

}
