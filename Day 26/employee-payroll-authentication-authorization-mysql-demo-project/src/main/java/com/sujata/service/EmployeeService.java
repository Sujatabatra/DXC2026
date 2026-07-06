package com.sujata.service;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sujata.entity.Employee;
import com.sujata.exception.ResourceNotFoundException;
import com.sujata.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeService {

	private final EmployeeRepository employeeRepository;

	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@PreAuthorize("hasAnyRole('ADMIN','HR')")
	public Employee save(Employee employee) {

		return employeeRepository.save(employee);

	}

	@PreAuthorize("hasAnyRole('ADMIN','HR','EMPLOYEE')")
	@Transactional(readOnly = true)
	public List<Employee> findAll() {

		return employeeRepository.findAll();

	}

	@PreAuthorize("hasAnyRole('ADMIN','HR','EMPLOYEE')")
	@Transactional(readOnly = true)
	public Employee findById(Long id) {

		return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found : " + id));

	}

	@PreAuthorize("hasAnyRole('ADMIN','HR')")
	public Employee update(Long id, Employee employee) {

		Employee existing = findById(id);

		existing.setEmployeeName(employee.getEmployeeName());
		existing.setEmail(employee.getEmail());

		return employeeRepository.save(existing);

	}

	@PreAuthorize("hasRole('ADMIN')")
	public void delete(Long id) {

		Employee employee = findById(id);

		employeeRepository.delete(employee);

	}

}