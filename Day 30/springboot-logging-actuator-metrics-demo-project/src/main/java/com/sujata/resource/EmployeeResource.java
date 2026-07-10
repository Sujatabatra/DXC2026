package com.sujata.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.sujata.entity.Employee;
import com.sujata.service.EmployeeService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class EmployeeResource {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping(path = "/employees")
	public List<Employee> getAllEmployeeResource() {
		return employeeService.getAllEmployees();
	}

	@GetMapping(path = "/employees/{id}")
	public Employee getEmployeeByIdRespurce(@PathVariable("id") int eId) {
		return employeeService.searchEmployee(eId);
	}

	@PostMapping(path = "/employees")
	public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee) {
		System.out.println(employee);
		Employee saved = employeeService.addEmployee(employee);

		return ResponseEntity.status(HttpStatus.CREATED).body(saved);
	}
}
