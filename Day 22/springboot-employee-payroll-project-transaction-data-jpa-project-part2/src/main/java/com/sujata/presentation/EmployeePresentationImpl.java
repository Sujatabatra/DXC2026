package com.sujata.presentation;

import com.sujata.persistence.EmployeeDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.sujata.entity.Employee;
import com.sujata.entity.Payroll;
import com.sujata.entity.Project;
import com.sujata.service.EmployeeService;
import com.sujata.service.EmployeeServiceImpl;
import com.sujata.service.ProjectService;

@Component("presentation")
public class EmployeePresentationImpl implements EmployeePresentation {

	private EmployeeService employeeService;
	private ProjectService projectService;
	
	
	@Autowired
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@Autowired
	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	@Override
	public void showMenu() {
		System.out.println("============================");
		System.out.println("Employee Management System");
		System.out.println("============================");
		System.out.println("1. Add Employee");
        System.out.println("2. Assign Project");
        System.out.println("3. Transfer Project");
        System.out.println("4. Revise Salary");
        System.out.println("5. Display Employee");
        System.out.println("6. Delete Employee");
        System.out.println("7. Add Project");
        System.out.println("8. Rollback Demo");
        System.out.println("9. Exit");


	}

	@Override
	public void performMenu(int choice) {
		Scanner scanner = new Scanner(System.in);
		switch (choice) {
		case 1:
			addEmployee(scanner);
			break;
		case 2:
			assignProject(scanner);
			break;
		case 3:
			transferEmployeeToProject(scanner);
			break;
		case 4:
			incrementSalary(scanner);
			break;

		case 5:
			viewEmployee(scanner);
			break;
		case 6:
			deleteEmployee(scanner);
			break;
		case 7:
			addProject(scanner);
			break;
		case 8:
			rollBackMethod();
			break;
		case 9:
			System.out.println("Thanks for using Employee Management System ");
			System.exit(0);
		default:
			System.out.println("Invalid Choice");
		}

	}

	private void addEmployee(Scanner sc) {
		Employee emp = new Employee();

		System.out.println("Name:");
		emp.setEmpName(sc.next());

		System.out.println("Department:");
		emp.setEmpDepartment(sc.next());

		System.out.println("Designation:");
		emp.setEmpDesignation(sc.next());

		Payroll payroll = new Payroll();

		System.out.println("Basic Salary:");
		payroll.setBasicSalary(sc.nextDouble());

		System.out.println("Allowances:");
		payroll.setAllowances(sc.nextInt());

		System.out.println("Deductions:");
		payroll.setDeductions(sc.nextInt());

		System.out.println("How many projects?");

		int count = sc.nextInt();

		List<Integer> ids = new ArrayList<>();

		for (int i = 1; i <= count; i++) {

			System.out.println("Project Id:");

			ids.add(sc.nextInt());
		}

		employeeService.addEmployee(emp, payroll, ids);

		System.out.println("Employee Added");

	}

	private void assignProject(Scanner sc) {

		System.out.println("Employee Id:");

		int empId = sc.nextInt();

		System.out.println("Project Id:");

		int projectId = sc.nextInt();

		employeeService.assignProject(empId, projectId);

		System.out.println("Project Assigned");

	}

	private void transferEmployeeToProject(Scanner sc) {
		System.out.println("Employee Id:");

		int e = sc.nextInt();

		System.out.println("Old Project Id:");

		int oldP = sc.nextInt();

		System.out.println("New Project Id:");

		int newP = sc.nextInt();

		employeeService.transferProject(e, oldP, newP);

		System.out.println("Project Transferred");

	}

	private void incrementSalary(Scanner sc) {
		System.out.println("Employee Id:");
		int id = sc.nextInt();
		System.out.println("Increment:");
		double inc = sc.nextDouble();

		employeeService.reviseSalary(id, inc);

		System.out.println("Salary Updated");
	}

	private void viewEmployee(Scanner sc) {
		System.out.println("Employee Id:");

		Employee employee = employeeService.getEmployee(sc.nextInt());

		System.out.println("--------------------------------");
		System.out.println("Id : " + employee.getEmpId());

		System.out.println("Name : " + employee.getEmpName());

		System.out.println("Designation : " + employee.getEmpDesignation());

		System.out.println("Department : " + employee.getEmpDepartment());

		System.out.println("Salary : " + employee.getPayroll().getNetSalary());
		System.out.println("Projects: ");
		Set<Project> projects = employee.getProjects();
		for (Project project : projects) {
			System.out.println("Project Name " + project.getProjectName());
		}

	}

	private void deleteEmployee(Scanner sc) {
		System.out.println("Employee Id:");

		employeeService.deleteEmployee(sc.nextInt());

		System.out.println("Deleted");

	}

	private void addProject(Scanner scanner) {
		Project project=new Project();
		
		System.out.println("Enter Project Name : ");
		project.setProjectName(scanner.next());
	
		System.out.println("Enter Client Name : ");
		project.setClientName(scanner.next());
		
		System.out.println("Enter Project Budget : ");
		project.setBudget(scanner.nextDouble());
		
		projectService.addProject(project);
		System.out.println("Project Added!");
	}
	private void rollBackMethod() {
		try {

			Employee emp2 = new Employee();

			emp2.setEmpName("RollbackUser");

			emp2.setEmpDepartment("IT");

			emp2.setEmpDesignation("Developer");

			Payroll p = new Payroll();

			p.setBasicSalary(50000);

			p.setAllowances(5000);

			p.setDeductions(1000);

			List<Integer> list = List.of(1);

			employeeService.rollbackDemo(emp2, p, list);
		} catch (Exception ex) {
			System.out.println("Transaction Rolled Back");
		}

	}

}
