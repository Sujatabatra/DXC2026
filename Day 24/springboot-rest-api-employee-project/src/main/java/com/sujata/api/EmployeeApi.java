package com.sujata.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sujata.entity.Employee;
import com.sujata.service.EmployeeService;

import jakarta.validation.Valid;

/*
 * Rest API means giving access to you bussiness logic with the help of URI
 * 
 * 
 * Rest architechture works on HTTP Protocol
 * HTTP Methods
 * GET() : if we are requesting any data from a resource
 * POST() : if we are storing any data through resource
 * DELETE() : if we are deleting any data with the resource
 * PUT() : if we are modifying any data with the resource 
 * 
 * Note : Resource : Business Logic
 */
@RestController
public class EmployeeApi {

	@Autowired
	private EmployeeService employeeService;

	/*
	 * requesting data from resource
	 */
	@GetMapping(path = "/employees")
	public List<Employee> getAllEmployeeApi() {
		return employeeService.getAllEmployees();
	}

	@GetMapping(path = "/employees/{id}")
	public ResponseEntity<Employee> getEmployeeByIdApi(@PathVariable("id") int empId) {
		Employee emp=employeeService.searchEmployee(empId);
		if(emp==null)
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(emp);
		return ResponseEntity.ok(emp);
	}

//	@PostMapping(path = "/employees")
//	public Employee saveEmployeeApi(@RequestBody Employee employee) {
//		return employeeService.addEmployee(employee);
//	}

	@PostMapping(path = "/employees")
	public ResponseEntity<Employee> saveEmployeeApi(@Valid @RequestBody Employee employee) {

		Employee empl = employeeService.addEmployee(employee);
		return ResponseEntity.status(201).body(empl);

	}

	@DeleteMapping(path = "/employees/{id}")
	public ResponseEntity<String> deleteEmployeeApi(@PathVariable("id") int id) {
		if (employeeService.deleteEmployee(id))
			return ResponseEntity.status(200).body("Record Deleted");
		return ResponseEntity.badRequest().body("Record Not Deleted");
		
	}

	@PutMapping(path = "/employees/{id}/{sal}")
	public ResponseEntity<String> updateEmployeeSalaryApi(@PathVariable("id") int id, @PathVariable("sal") int salary) {
		if (employeeService.salaryAppraisal(id, salary))
			return ResponseEntity.status(200).body("Record Deleted");
		return ResponseEntity.badRequest().body("Record Not Deleted");
	}
}
