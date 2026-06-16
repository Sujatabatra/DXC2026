package com.sujata.presentation;

public class EmployeePresentationImpl implements EmployeePresentation {

	@Override
	public void showMenu() {
		System.out.println("============================");
		System.out.println("Employee Management System");
		System.out.println("============================");
		System.out.println("1. Add New Employee");
		System.out.println("2. Search Employee By ID");
		System.out.println("3. Delete Employee");
		System.out.println("4. Appraisal");
		System.out.println("6. Exit");

	}

	@Override
	public void performMenu(int choice) {
		switch (choice) {
		case 1:
			System.out.println("This module is under development ");
			break;
		case 2:
			System.out.println("This module is under development ");
			break;
		case 3:
			System.out.println("This module is under development ");
			break;
		case 4:
			System.out.println("This module is under development ");
			break;
		case 6:
			System.out.println("Thanks for using Employee Management System ");
			System.exit(0);
		default:
			System.out.println("Invalid Choice");
		}

	}

}
