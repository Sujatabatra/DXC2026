package com.sujata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.sujata.entity.Employee;
import com.sujata.service.EmployeeService;

/*
 * API in json format
 * http://localhost:8085/v3/api-docs
 * 
 */
@SpringBootApplication(scanBasePackages = "com.sujata")
public class SpringbootRestApiEmployeeProjectApplication /*implements CommandLineRunner*/ {

//	@Autowired
//	private EmployeeService employeeService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestApiEmployeeProjectApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		employeeService.addEmployee(new Employee("AAAAA", "IT", "Associate", 560000));
//		employeeService.addEmployee(new Employee("BBBBB", "Sales", "Sr. Associate", 760000));
//		employeeService.addEmployee(new Employee("CCCCC", "IT", "Manager", 150000));
//		employeeService.addEmployee(new Employee("DDDDD", "Marketing", "Executive", 360000));
//	}

}
