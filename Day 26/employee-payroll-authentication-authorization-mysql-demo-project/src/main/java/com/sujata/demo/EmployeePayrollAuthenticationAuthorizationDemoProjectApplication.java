package com.sujata.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.sujata")
@EnableJpaRepositories(basePackages = "com.sujata.repository")
@EntityScan(basePackages = "com.sujata.entity")
public class EmployeePayrollAuthenticationAuthorizationDemoProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeePayrollAuthenticationAuthorizationDemoProjectApplication.class, args);
	}

}
