package com.sujata.service;

import com.sujata.entity.*;
import com.sujata.persistence.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;


@Service
public class EmployeeService {
	
	private final EmployeeRepository repository;

	public EmployeeService(@Autowired EmployeeRepository repository) {
		this.repository = repository;
	}

	@Transactional
	public void createData() {
		if (repository.count() > 0)
			return;
		Payroll payroll = new Payroll(50000.0, 10000.0, 5000.0);
		Employee employee = new Employee("Rahul", 70000.0);
		employee.setPayroll(payroll);
		repository.save(employee);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void updateSalary(Long id, Double salary, int waitTime) throws Exception {
		try {
			Employee emp = repository.findById(id).orElseThrow();
			System.out.println(Thread.currentThread().getName() + " read version " + emp.getVersion());
			Thread.sleep(waitTime);
			emp.setSalary(salary);
			repository.saveAndFlush(emp);
			System.out.println(Thread.currentThread().getName() + " committed");
		} catch (ObjectOptimisticLockingFailureException ex) {
			System.out.println(Thread.currentThread().getName() + " failed due to optimistic locking");
			throw ex;
		}
	}
}
