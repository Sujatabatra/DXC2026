package com.sujata.presentation;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.sujata.entity.Employee;
import com.sujata.entity.EmployeePayslip;
import com.sujata.excep.DuplicateEmployeeIdException;
import com.sujata.service.EmployeeService;
import com.sujata.service.EmployeeServiceChangeRequest;
import com.sujata.service.EmployeeServiceImpl;


public class EmployeePresentationImpl implements EmployeePresentation {

	private EmployeeService employeeService;

	public EmployeePresentationImpl(EmployeeService employeeService) {
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
		System.out.println("4. Appraisal");
		System.out.println("5. List All Employees");
		System.out.println("6. Print PaySlip");
		System.out.println("7. Exit");

	}

	@Override
	public void performMenu(int choice) {
		Scanner scanner = new Scanner(System.in);
		switch (choice) {
		case 1:

			Employee newEmployee = new Employee();
			System.out.println("Enter Employee ID : ");
			newEmployee.setEmpId(scanner.nextInt());
			System.out.println("Enter Employee Name : ");
			newEmployee.setEmpName(scanner.next());
			System.out.println("Enter Employee Designation : ");
			newEmployee.setEmpDesignation(scanner.next());
			System.out.println("Enter Employee Department : ");
			newEmployee.setEmpDepartment(scanner.next());
			System.out.println("Enter Employee Salary : ");
			newEmployee.setEmpBasicSalary(scanner.nextDouble());
			try {
				employeeService.addEmployee(newEmployee);
				System.out.println("New Employee Added!");
			} catch (DuplicateEmployeeIdException duplicateEmployeeIdException) {
				System.out.println("Employee Insertion Failed!");
			}

			break;
		case 2:
			System.out.println("Enter Employee ID to be searched for :  ");
			int employeeId = scanner.nextInt();
			Employee employee = employeeService.searchEmployee(employeeId);
			if (employee == null)
				System.out.println("No such employee with employee id " + employeeId + " exist!");
			else
				System.out.println(employee);
			break;
		case 3:
			System.out.println("Enter Employee ID whoes record you want to delete : ");
			int empId = scanner.nextInt();
			if (employeeService.deleteEmployee(empId))
				System.out.println("Employee with id " + empId + " deleted!");
			else
				System.out.println("Employee with id " + empId + " does not exist for deletion");
			break;
		case 4:
			System.out.println("Enter Employee ID whoes salary you want to increment : ");
			int employId = scanner.nextInt();
			System.out.println("Enter Incremented Amount : ");
			int incrementedAmount = scanner.nextInt();
			if (employeeService.salaryAppraisal(employId, incrementedAmount))
				System.out.println("Congrats Employee with id " + employId + " for you Appraisal!");
			else
				System.out.println("Employee with id " + employId + " does not exist for Appraisal");
			break;
		case 5:
			List<Employee> employeeList = employeeService.getAllEmployees();
			for (Employee emp : employeeList) {
				System.out.println(emp);
			}
			break;
		case 6:
			/*
			 * payslip contains all info about employee like employee id, name, desination,
			 * department, basic salary, allowances(30% of basic salary), deduction(12 %of
			 * basic salary), net salary
			 */
			System.out.println("Enter Employee ID to generate Payslip : ");
			int eId = scanner.nextInt();

			EmployeePayslip employeePayslip = employeeService.generatePayslip(eId);
			if (employeePayslip != null)
				System.out.println(employeePayslip);
			else
				System.out.println("Employee with id " + eId + " does not exist");
			break;
		case 7:
			System.out.println("Thanks for using Employee Management System ");
			System.exit(0);
		default:
			System.out.println("Invalid Choice");
		}

	}

}
