package com.sujata.client;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.sujata.service.EmployeeService;

/*
Why do we use batching?
To reduce:
Database round trips
Memory consumption
Execution time
 */
@SpringBootApplication(scanBasePackages = "com.sujata")
@EntityScan(basePackages = "com.sujata.entity")
@EnableJpaRepositories(basePackages = "com.sujata.persistence")
public class SpringbootFirstDataJpaProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootFirstDataJpaProjectApplication.class, args);
	}

}
