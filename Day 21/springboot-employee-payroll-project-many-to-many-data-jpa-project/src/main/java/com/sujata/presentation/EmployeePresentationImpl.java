package com.sujata.presentation;

import com.sujata.persistence.EmployeeDao;
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

@Component("presentation")
public class EmployeePresentationImpl implements EmployeePresentation {

	private EmployeeService employeeService;

	public EmployeePresentationImpl(@Autowired EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@Override
	public void showMenu() {
		System.out.println("============================");
		System.out.println("Employee Management System");
		System.out.println("============================");
		System.out.println("1. Add New Employee");
		System.out.println("2. Search Employee By ID");
		System.out.println("3. Delete Employee");
		System.out.println("4. List All Employees");
		System.out.println("5. Search employee in a specific department");
		System.out.println("6. Add New Project");
		System.out.println("7. Assign Project");
		System.out.println("8. Exit");

	}

	@Override
	public void performMenu(int choice) {
		Scanner scanner = new Scanner(System.in);
		switch (choice) {
		case 1:
			addEmployee(scanner);
			break;
		case 2:
			searchEmployeeById(scanner);
			break;
		case 3:
			deleteEmployeeById(scanner);
			break;
		case 4:
			viewEmployees();
			break;

		case 5:
			viewEmployeesByDepartment(scanner);
			break;
		case 6:
			addProject(scanner);
			break;
		case 7:
			assignProject(scanner);
			break;
		case 8:
			System.out.println("Thanks for using Employee Management System ");
			System.exit(0);
		default:
			System.out.println("Invalid Choice");
		}

	}

	private void addProject(Scanner scanner) {
		Project project=new Project();
		
		System.out.println("Enter Project Name : ");
		project.setProjectName(scanner.next());
	
		System.out.println("Enter Client Name : ");
		project.setClientName(scanner.next());
		
		System.out.println("Enter Project Budget : ");
		project.setBudget(scanner.nextDouble());
		
		employeeService.addProject(project);
		System.out.println("Project Added!");
	}
	private void assignProject(Scanner scanner) {
		
		System.out.println("Enter employee ID : ");
		int eId=scanner.nextInt();
		
		System.out.println("Enter Project ID : ");
		int pId=scanner.nextInt();
		
		employeeService.assignProject(eId, pId);
		
		System.out.println("Project Assigned!");
	}
	private void addEmployee(Scanner scanner) {
		Employee newEmployee = new Employee();
		System.out.println("Enter Employee Name : ");
		newEmployee.setEmpName(scanner.next());
		System.out.println("Enter Employee Designation : ");
		newEmployee.setEmpDesignation(scanner.next());
		System.out.println("Enter Employee Department : ");
		newEmployee.setEmpDepartment(scanner.next());

		System.out.println("Enter Basic Salary ");
		double basic = scanner.nextDouble();
		System.out.println("Enter allowances ");
		int allowances = scanner.nextInt();
		System.out.println("Enter Deductions ");
		int deductions = scanner.nextInt();

		Payroll payroll = new Payroll(allowances, deductions, basic);

		newEmployee.setPayroll(payroll);

		employeeService.addEmployee(newEmployee);
		System.out.println("New Employee Added!");
	}

	private void searchEmployeeById(Scanner scanner) {
		System.out.println("Enter Employee ID to be searched for :  ");
		int employeeId = scanner.nextInt();
		Employee employee = employeeService.searchEmployee(employeeId);
		if (employee == null)
			System.out.println("No such employee with employee id " + employeeId + " exist!");
		else
			System.out.println(employee);
	}

	private void deleteEmployeeById(Scanner scanner) {
		System.out.println("Enter Employee ID whoes record you want to delete : ");
		int empId = scanner.nextInt();
		if (employeeService.deleteEmployee(empId))
			System.out.println("Employee with id " + empId + " deleted!");
		else
			System.out.println("Employee with id " + empId + " does not exist for deletion");
	}

	private void viewEmployees() {
		List<Employee> employeeList = employeeService.getAllEmployees();

		for (Employee employee : employeeList) {
			System.out.println("--------------------------------");
			System.out.println("Id : " + employee.getEmpId());

			System.out.println("Name : " + employee.getEmpName());

			System.out.println("Designation : " + employee.getEmpDesignation());

			System.out.println("Department : " + employee.getEmpDepartment());

			System.out.println("Salary : " + employee.getPayroll().getNetSalary());
			System.out.println("Projects: ");
			Set<Project> projects=employee.getProjects();
			for(Project project:projects) {
				System.out.println("Project Name "+project.getProjectName());
			}
		}
	}

	private void viewEmployeesByDepartment(Scanner scanner) {
		System.out.println("Enter Department Name : ");
		String depart = scanner.next();
		List<Employee> employeeList = employeeService.findEmployeesByDepartment(depart);

		for (Employee employee : employeeList) {
			System.out.println("--------------------------------");
			System.out.println("Id : " + employee.getEmpId());

			System.out.println("Name : " + employee.getEmpName());

			System.out.println("Designation : " + employee.getEmpDesignation());

			System.out.println("Department : " + employee.getEmpDepartment());

			System.out.println("Salary : " + employee.getPayroll().getNetSalary());
		}
	}

}
