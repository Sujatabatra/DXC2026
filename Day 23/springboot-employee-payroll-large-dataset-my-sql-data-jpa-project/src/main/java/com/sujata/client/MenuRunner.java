package com.sujata.client;

import com.sujata.service.EmployeeService;
import java.util.Scanner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MenuRunner implements CommandLineRunner {
	private final EmployeeService service;

	public MenuRunner(EmployeeService service) {
		this.service = service;
	}

	public void run(String... args) throws Exception {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println(
					"\n1.Generate Data\n2.Pagination\n3.Slice\n4.Stream\n5.Batch Update\n6.Projection\n0.Exit");
			int c = sc.nextInt();
			switch (c) {
			case 1 -> {
				System.out.println("Count?");
				service.generateEmployees(sc.nextInt());
			}
			case 2 -> service.processUsingPagination();
			case 3 -> service.processUsingSlice();
			case 4 -> service.processUsingStream();
			case 5 -> service.increaseSalary();
			case 6 -> service.displayProjection();
			case 0 -> {
				return;
			}
			}
		}
	}
}