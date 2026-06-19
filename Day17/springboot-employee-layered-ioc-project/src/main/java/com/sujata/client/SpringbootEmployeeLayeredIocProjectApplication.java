package com.sujata.client;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.sujata.presentation.EmployeePresentation;

@SpringBootApplication(scanBasePackages = "com.sujata")
public class SpringbootEmployeeLayeredIocProjectApplication {

	public static void main(String[] args) {
		ApplicationContext springContainer= SpringApplication.run(SpringbootEmployeeLayeredIocProjectApplication.class, args);
	
		EmployeePresentation employeePresentation=(EmployeePresentation)springContainer.getBean("presentation");
		
		Scanner scanner=new Scanner(System.in);
		
		while(true) {
			employeePresentation.showMenu();
			System.out.println("Enter Choice : ");
			int choice=scanner.nextInt();
			employeePresentation.performMenu(choice);
			
		}
	}

}
