package com.sujata.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sujata.entity.Employee;
import com.sujata.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	private final EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	/**
	 * Add Employee
	 */
	@PostMapping
	public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee) {

		Employee savedEmployee = employeeService.save(employee);

		return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
	}

	/**
	 * Get All Employees
	 */
	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployees() {

		return ResponseEntity.ok(employeeService.findAll());
	}

	/**
	 * Get Employee By Id
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {

		return ResponseEntity.ok(employeeService.findById(id));
	}

	/**
	 * Update Employee
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @Valid @RequestBody Employee employee) {

		return ResponseEntity.ok(employeeService.update(id, employee));
	}

	/**
	 * Delete Employee
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {

		employeeService.delete(id);

		return ResponseEntity.noContent().build();
	}

}