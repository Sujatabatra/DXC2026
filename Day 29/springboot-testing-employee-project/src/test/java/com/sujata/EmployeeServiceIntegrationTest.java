package com.sujata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sujata.entity.Employee;
import com.sujata.persistence.EmployeeDao;

@SpringBootTest(classes = SpringbootRestApiEmployeeProjectApplication.class)
public class EmployeeServiceIntegrationTest {
	
	@Autowired
	private EmployeeDao repository;

	@Test
	@DisplayName("Save Employee Using Complete Spring Context")
	void testSaveEmployee() {
	
		Employee employee = new Employee();
		
		employee.setEmpName("Rahul");
		employee.setEmpDepartment("IT");
		employee.setEmpDesignation("Developer");
		employee.setEmpBasicSalary(50000);
		
		Employee saved = repository.save(employee);
		
		Optional<Employee> result = repository.findById(saved.getEmpId());
		
		assertTrue(result.isPresent());
		
		assertEquals("Rahul", result.get().getEmpName());
	}
}