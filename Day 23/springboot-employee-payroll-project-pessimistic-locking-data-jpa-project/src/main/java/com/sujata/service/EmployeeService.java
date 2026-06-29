package com.sujata.service;

import com.sujata.entity.*;
import com.sujata.persistence.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;


@Service
public class EmployeeService {
	private final EmployeeRepository repository;

	public EmployeeService(EmployeeRepository repository) {
		this.repository = repository;
	}

	@Transactional
	public void createData() {
		if (repository.count() > 0)
			return;
		Payroll p = new Payroll(50000.0, 10000.0, 5000.0);
		Employee e = new Employee("Rahul", 70000.0);
		e.setPayroll(p);
		repository.save(e);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void updateSalary(Long id, Double salary, int waitTime) throws Exception {
	
		System.out.println(Thread.currentThread().getName() + " trying lock"); //thread1 , thread2
		
		Employee emp = repository.findByIdForUpdate(id).orElseThrow();
		
		System.out.println(Thread.currentThread().getName() + " acquired lock"); //thread1
		
		Thread.sleep(waitTime);
		
		emp.setSalary(salary);
		
		repository.save(emp);
		
		System.out.println(Thread.currentThread().getName() + " committed");//thread1
	}
}
