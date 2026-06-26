package com.sujata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sujata.entity.Employee;
import com.sujata.entity.Payroll;
import com.sujata.entity.Project;
import com.sujata.persistence.AuditLogDao;
import com.sujata.persistence.EmployeeDao;
import com.sujata.persistence.PayrollDao;
import com.sujata.persistence.ProjectDao;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeRepo;

	@Autowired
	private PayrollDao payrollRepo;

	@Autowired
	private ProjectDao projectRepo;

	@Autowired
	private AuditService auditService;
	
	/*
	 * Transaction started for addEmployee (T1)
	 * insert on payroll
	 * select on project
	 * insert on employee_project
	 * insert in employee
	 * 
	 * T1 is suspended
	 * 
	 * T1 transaction came back
	 * commit 
	 * T1 finishes
	 * 
	 */

	// =============================
	// Add Employee
	// =============================
	@Transactional //default : Propagation: Required, Isolation=default, ReadOnly=false, timeOut= no time
	public void addEmployee(Employee employee, Payroll payroll, List<Integer> projectIds) {

		payrollRepo.save(payroll);

		employee.setPayroll(payroll);

		List<Project> projects = projectRepo.findAllById(projectIds);

		employee.getProjects().addAll(projects);

		employeeRepo.save(employee);

		auditService.saveAudit("Employee Created");
	}

	// =============================
	// Assign Project
	// =============================
	@Transactional
	public void assignProject(int empId, int projectId) {

		Employee emp = employeeRepo.findById(empId).orElseThrow(() -> new RuntimeException("Employee not found"));

		Project project = projectRepo.findById(projectId).orElseThrow(() -> new RuntimeException("Project not found"));

		emp.getProjects().add(project);
	}

	// =============================
	// Transfer Project
	// =============================
	/*
	 * if we are working on oracle 10G , it does not support Nested Transaction by itself,
	 * instead we need to configure it, for that we have seperate config class
	 */
	
	@Transactional(propagation = Propagation.NESTED)
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
	@Transactional(isolation = Isolation.READ_COMMITTED)
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
	@Transactional
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

	/*
	 * rollbackFor=Exception.class, means we are rolling back if getting checked exception too
	 */
	@Transactional(rollbackFor = Exception.class)
	public void rollbackDemo() throws Exception {

		Employee employee = employeeRepo.findById(1).orElseThrow();

		employee.setEmpDepartment("Finance");

		throw new Exception("Checked Exception");
	}

	@Transactional(rollbackFor = NullPointerException.class)
	public void rollbackDemoTwo() throws Exception {

		Employee employee = employeeRepo.findById(1).orElseThrow();

		employee.setEmpDepartment("Finance");

		throw new NullPointerException("Checked Exception");
	}
	
	// =============================
	// Timeout Demo
	// =============================
	/*
	 * if my transaction exceeds 5 seconds, it will throw TransactionTimeOutException
	 */
	@Transactional(timeout = 5)
	public void timeoutDemo() throws Exception {

		Thread.sleep(10000);

		Employee employee = employeeRepo.findById(1).orElseThrow();

		employee.setEmpDesignation("Architect");
	}

	// =============================
	// NOT_SUPPORTED Demo
	// =============================
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public void generateReport() {

		employeeRepo.findAll().forEach(System.out::println);
	}

	// =============================
	// MANDATORY Demo
	// =============================
	@Transactional(propagation = Propagation.MANDATORY)
	public void updatePayroll(int empId, double increment) {

		Employee employee = employeeRepo.findById(empId).orElseThrow();

		employee.getPayroll().setBasicSalary(employee.getPayroll().getBasicSalary() + increment);
	}

	@Transactional
	public void rollbackDemoXyz(Employee emp, Payroll payroll, List<Integer> projectIds) {
//		try {
//		payrollRepo.save(payroll); dml

		emp.setPayroll(payroll);

		List<Project> projects = projectRepo.findAllById(projectIds);  //dql

		emp.getProjects().addAll(projects);

		employeeRepo.save(emp);  //dml

		throw new RuntimeException("Exception generated intentionally"); //rollback should happen, but we captured it
//		}
//		catch(RuntimeException ex) {
//			System.out.println(ex.getMessage());
//		}
		//commit
		}

}
