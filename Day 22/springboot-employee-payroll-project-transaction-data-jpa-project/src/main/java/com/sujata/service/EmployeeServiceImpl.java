package com.sujata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sujata.entity.Employee;
import com.sujata.entity.Payroll;
import com.sujata.entity.Project;
import com.sujata.persistence.EmployeeDao;
import com.sujata.persistence.PayrollDao;
import com.sujata.persistence.ProjectDao;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeRepo;

	@Autowired
	private PayrollDao payrollRepo;

	@Autowired
	private ProjectDao projectRepo;

	// =============================
	// Add Employee
	// =============================
	public Employee addEmployee(Employee employee, Payroll payroll, List<Integer> projectIds) {

		payrollRepo.save(payroll);

		employee.setPayroll(payroll);

		List<Project> projects = projectRepo.findAllById(projectIds);

		employee.getProjects().addAll(projects);

		return employeeRepo.save(employee);
	}

	// =============================
	// Assign Project
	// =============================
	public void assignProject(int empId, int projectId) {

		Employee emp = employeeRepo.findById(empId).orElseThrow(() -> new RuntimeException("Employee not found"));

		Project project = projectRepo.findById(projectId).orElseThrow(() -> new RuntimeException("Project not found"));

		emp.getProjects().add(project);
	}

	// =============================
	// Transfer Project
	// =============================
	public void transferProject(int empId, int oldProjectId, int newProjectId) {

		Employee emp = employeeRepo.findById(empId).orElseThrow(() -> new RuntimeException("Employee not found"));

		Project oldProject = projectRepo.findById(oldProjectId)
				.orElseThrow(() -> new RuntimeException("Old Project not found"));

		Project newProject = projectRepo.findById(newProjectId)
				.orElseThrow(() -> new RuntimeException("New Project not found"));

		emp.getProjects().remove(oldProject);

		emp.getProjects().add(newProject);
	}

	// =============================
	// Salary Revision
	// =============================
	public void reviseSalary(int empId, double increment) {

		Employee emp = employeeRepo.findById(empId).orElseThrow(() -> new RuntimeException("Employee not found"));

		Payroll payroll = emp.getPayroll();

		payroll.setBasicSalary(payroll.getBasicSalary() + increment);
	}

	// =============================
	// Display Employee
	// =============================
	@Transactional(readOnly = true)
	public Employee getEmployee(int empId) {
		return employeeRepo.findById(empId).orElse(null);
	}

	// =============================
	// Delete Employee
	// =============================
	public void deleteEmployee(int empId) {
		employeeRepo.deleteById(empId);
	}

	// =============================
	// Rollback Demo
	// =============================
	public void rollbackDemo(Employee emp, Payroll payroll, List<Integer> projectIds) {

		payrollRepo.save(payroll);

		emp.setPayroll(payroll);

		List<Project> projects = projectRepo.findAllById(projectIds);

		emp.getProjects().addAll(projects);

		employeeRepo.save(emp);

		throw new RuntimeException("Exception generated intentionally");
	}
	
	
}
