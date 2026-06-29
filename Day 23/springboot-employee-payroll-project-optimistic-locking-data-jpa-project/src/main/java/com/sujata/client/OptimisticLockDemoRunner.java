package com.sujata.client;

import com.sujata.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.concurrent.*;

@Component
public class OptimisticLockDemoRunner implements CommandLineRunner {
	
	private final EmployeeService service;

	public OptimisticLockDemoRunner(@Autowired EmployeeService service) {
		this.service = service;
	}

	@Override
	public void run(String... args) throws Exception {
		
		service.createData();
		/*
		 * creating the Thread Pool of Size 2
		 */
		ExecutorService executor = Executors.newFixedThreadPool(2);
		/*
		 * Future is a way to give job to Thread and that job returns something too
		 */
		Future<?> f1 = executor.submit(() -> {
			try {
				service.updateSalary(1L, 80000.0, 10000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		Thread.sleep(1000);
		Future<?> f2 = executor.submit(() -> {
			try {
				service.updateSalary(1L, 90000.0, 2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		try {
			f1.get();
		} catch (Exception ignored) {
		}
		try {
			f2.get();
		} catch (Exception ignored) {
		}
		executor.shutdown();
	}
}
