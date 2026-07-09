package com.sujata.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sujata.entity.Employee;
import com.sujata.persistence.EmployeeDao;

//Enabling the Mockito Support
@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {

	@Mock
	// Mocking Employee Dao , that means creating Fake object of EmployeeDao
	private EmployeeDao employeeDao;

	// Create the real object of EmployeeService and inject Mock/Fake EmployeeDao
	// Object into it
	@InjectMocks
	private EmployeeServiceImpl employeeServiceImpl;

	private Employee employee;

	@BeforeEach
	void setup() {

		employee = new Employee();

		employee.setEmpId(1);

		employee.setEmpName("Rahul");

		employee.setEmpDepartment("IT");

		employee.setEmpDesignation("Associate");

		employee.setEmpBasicSalary(50000);

	}

	@Test
	void testAddEmployee() {

		//Stubbing the behaviour of save() method of EmployeeDao
		when(employeeDao.save(employee)).thenReturn(employee);

		Employee savedEmployee = employeeServiceImpl.addEmployee(employee);
		assertEquals("Rahul", savedEmployee.getEmpName());
	}

	@Test
	void testSearchEmployee() {
		
		//Stuibbing the behaviour of findById method of EmployeeDao
		when(employeeDao.findById(1)).thenReturn(Optional.of(employee));

		Employee result = employeeServiceImpl.searchEmployee(1);

		assertEquals("Rahul", result.getEmpName());
	}

	@Test
	void testDeleteEmployee() {
		//Stubbing the behaviour of two methods i.e findById() and deleteById() method of EmployeeDao
		when(employeeDao.findById(1)).thenReturn(Optional.of(employee));
		doNothing().when(employeeDao).deleteById(1);

		employeeServiceImpl.deleteEmployee(1);

		verify(employeeDao).deleteById(1); //verifying the method call and not checking any return value

	}

	@Test
	void testSalaryAppraisal() {
		when(employeeDao.updateBasicSalaryById(1, 1000)).thenReturn(1);
		
		assertTrue(employeeServiceImpl.salaryAppraisal(1, 1000));
	}
//
//	@Test
//	void testGetAllEmployees() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testFindEmployeesByDepartment() {
//		fail("Not yet implemented");
//	}

}
