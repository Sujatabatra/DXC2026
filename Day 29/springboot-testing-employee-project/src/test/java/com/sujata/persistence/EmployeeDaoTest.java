package com.sujata.persistence;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import com.sujata.SpringbootRestApiEmployeeProjectApplication;
import com.sujata.entity.Employee;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase.Replace;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;

/*
 * @DataJpaTest : testing Repository
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)  //Don't take embedded database for testing, instead take database configuration configured in application.properties
public class EmployeeDaoTest {

	//Real Object
	@Autowired
	private EmployeeDao repository;

	@Test
	@DisplayName("Save Employee Successfully")
	void testSaveEmployee() {

		Employee employee = new Employee();

		employee.setEmpName("Rahul");
		employee.setEmpDepartment("IT");
		employee.setEmpBasicSalary(50000);
		employee.setEmpDesignation("Associate");

		Employee savedEmployee = repository.save(employee);

		
		assertEquals("Rahul", savedEmployee.getEmpName());

	}

	@Test
	@DisplayName("Find Employee By Id")
	void testFindEmployeeById() {

		Employee employee = new Employee();

		employee.setEmpName("Amit");
		employee.setEmpDepartment("HR");
		employee.setEmpBasicSalary(45000);
		employee.setEmpDesignation("Executive");

		Employee saved = repository.save(employee);

		Optional<Employee> result = repository.findById(saved.getEmpId());

		assertTrue(result.isPresent());

		assertEquals("Amit", result.get().getEmpName());

	}

	@Test
	@DisplayName("Find All Employees")
	void testFindAllEmployees() {

		Employee emp1 = new Employee();

		emp1.setEmpName("A");
		emp1.setEmpDepartment("IT");
		emp1.setEmpBasicSalary(40000);
		emp1.setEmpDesignation("Consultant");

		Employee emp2 = new Employee();

		emp2.setEmpName("B");
		emp2.setEmpDepartment("Sales");
		emp2.setEmpBasicSalary(45000);
		emp2.setEmpDesignation("Manager");

		repository.save(emp1);

		repository.save(emp2);

		List<Employee> employees = repository.findAll();

		assertFalse(employees.isEmpty());

		assertTrue(employees.size() >= 2);

	}

	
	@Test
	@DisplayName("Delete Employee")
	void testDeleteEmployee() {

		Employee employee = new Employee();

		employee.setEmpName("Karan");

		employee.setEmpDepartment("Marketing");

		employee.setEmpBasicSalary(35000);

		employee.setEmpDesignation("Executive");

		Employee saved = repository.save(employee);

		Integer id = saved.getEmpId();

		repository.deleteById(id);

		Optional<Employee> result = repository.findById(id);

		assertFalse(result.isPresent());

	}

	@Test
	@DisplayName("Employee Should Not Exist")
	void testEmployeeNotFound() {

		Optional<Employee> employee = repository.findById(999);

		assertFalse(employee.isPresent());

	}

}