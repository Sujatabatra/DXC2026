package com.sujata.client;

import com.sujata.service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.concurrent.*;

@Component
public class PessimisticLockDemoRunner implements CommandLineRunner {
	private final EmployeeService service;

	public PessimisticLockDemoRunner(EmployeeService service) {
		this.service = service;
	}

	@Override
	public void run(String... args) throws Exception {
		
		service.createData();
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		Future<?> f1 = executor.submit(() -> {
			try {
				service.updateSalary(1L, 80000.0, 15000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		Thread.sleep(2000);
		
		Future<?> f2 = executor.submit(() -> {
			try {
				service.updateSalary(1L, 90000.0, 2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		f1.get();
		f2.get();
		
		executor.shutdown();
	}
}
