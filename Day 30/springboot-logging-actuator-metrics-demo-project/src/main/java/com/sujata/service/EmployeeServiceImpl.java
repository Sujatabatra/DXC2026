package com.sujata.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sujata.entity.Employee;

import com.sujata.persistence.EmployeeDao;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

@Transactional
@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	private EmployeeDao employeeDao;
	
	private final MeterRegistry meterRegistry;
	private final Counter employeeCreatedCounter;
	private final Counter employeeSearchCounter;

	public EmployeeServiceImpl(EmployeeDao employeeDao, MeterRegistry meterRegistry) {
		super();
		this.employeeDao = employeeDao;
		this.meterRegistry = meterRegistry;
		/*
		 * Creating the custom Matrix named "employee.created" and 
		 * counter type registry we are creating
		 */
		this.employeeCreatedCounter =
                Counter.builder("employee.created")
                        .description("Total Employees Created")
                        .register(meterRegistry);
		
		employeeSearchCounter =
		        Counter.builder("employee.search")
		                .description("Employee Search Count")
		                .register(meterRegistry);
	}

	@Override
	public Employee addEmployee(Employee employee) {
		logger.info("Saving employee {}", employee.getEmpName());
		Employee emp = employeeDao.save(employee);
		
		employeeCreatedCounter.increment();
		
		logger.info("Employee saved successfully with ID {}", emp.getEmpId());
		return emp;

	}

	@Override
	public Employee searchEmployee(int employeeId) {
		logger.info("Finding Employee with ID {}", employeeId);
		
		employeeSearchCounter.increment();
		
		Employee emp = employeeDao.findById(employeeId)
				.orElseThrow(() -> new RuntimeException("Employee with " + employeeId + " does not exist"));
		logger.info("Employee successfully found with ID {}", emp.getEmpId());
		return emp;
		
	}

	@Override
	public boolean deleteEmployee(int employeeId) {
		logger.info("Deleting Employee with ID {}", employeeId);
		employeeDao.deleteById(employeeId);
		logger.info("Employee Deleted with ID {}", employeeId);
		return true;
	}

	@Override
	public boolean salaryAppraisal(int employeeId, int appraisalAmount) {
		logger.info("Updating Employee Salary for ID {}", employeeId);
		int row = employeeDao.updateBasicSalaryById(employeeId, appraisalAmount);
		logger.info("Employee updated successfully");
//		//select * from employees where emp_Id=employeeId
//		Employee employee=employeeDao.findById(employeeId).orElse(null);
//		if(employee!=null) {
//		employee.setEmpBasicSalary(employee.getEmpBasicSalary()+appraisalAmount);
//		//update query
//		employeeDao.save(employee);
//		return true;
//		}

		return row > 0;
	}

	@Override
	public List<Employee> getAllEmployees() {

		return employeeDao.findAll();
	}

	@Override
	public List<Employee> findEmployeesByDepartment(String deptt) {

		return employeeDao.findByEmpDepartmentIgnoreCase(deptt);

	}

}
