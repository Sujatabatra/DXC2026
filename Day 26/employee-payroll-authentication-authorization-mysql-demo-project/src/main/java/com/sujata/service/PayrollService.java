package com.sujata.service;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sujata.entity.Employee;
import com.sujata.entity.Payroll;
import com.sujata.repository.EmployeeRepository;
import com.sujata.repository.PayrollRepository;

@Service
@Transactional
public class PayrollService {

	private final PayrollRepository payrollRepository;

	private final EmployeeRepository employeeRepository;

	public PayrollService(PayrollRepository payrollRepository, EmployeeRepository employeeRepository) {

		this.payrollRepository = payrollRepository;
		this.employeeRepository = employeeRepository;
	}

	@PreAuthorize("hasAnyRole('ADMIN','HR')")
	public Payroll createPayroll(Long employeeId, Payroll payroll) {

		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new RuntimeException("Employee not found"));

		payroll.setEmployee(employee);

		employee.setPayroll(payroll);

		return payrollRepository.save(payroll);

	}

	@PreAuthorize("hasAnyRole('ADMIN','HR','EMPLOYEE')")
	@Transactional(readOnly = true)
	public List<Payroll> findAll() {

		return payrollRepository.findAll();

	}

	@PreAuthorize("hasAnyRole('ADMIN','HR','EMPLOYEE')")
	@Transactional(readOnly = true)
	public Payroll findById(Long id) {

		return payrollRepository.findById(id).orElseThrow(() -> new RuntimeException("Payroll not found"));

	}

	@PreAuthorize("hasAnyRole('ADMIN','HR')")
	public Payroll updatePayroll(Long id, Payroll payroll) {

		Payroll existing = findById(id);

		existing.setSalary(payroll.getSalary());
		existing.setBonus(payroll.getBonus());

		return payrollRepository.save(existing);

	}

	@PreAuthorize("hasRole('ADMIN')")
	public void deletePayroll(Long id) {

		Payroll payroll = findById(id);

		payrollRepository.delete(payroll);

	}

}