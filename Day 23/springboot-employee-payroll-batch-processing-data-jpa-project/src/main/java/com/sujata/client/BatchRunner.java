package com.sujata.client;

import com.sujata.service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BatchRunner implements CommandLineRunner {
	private final EmployeeService service;

	public BatchRunner(EmployeeService service) {
		this.service = service;
	}

	@Override
	public void run(String... args) throws Exception {
		long start = System.currentTimeMillis();
		service.importEmployees(10000);
		long end = System.currentTimeMillis();
		System.out.println("Time Taken : " + (end - start) + " ms");
	}
}
