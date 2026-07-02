package com.sujata.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.sujata.entity.Payroll;
import com.sujata.service.PayrollService;

@SpringBootApplication(scanBasePackages = "com.sujata")
@EntityScan(basePackages = "com.sujata.entity")
@EnableJpaRepositories(basePackages = "com.sujata.persistence")
public class SpringbootRestApiPayrollProjectApplication /*implements CommandLineRunner*/ {

//	@Autowired
//	private PayrollService payrollService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestApiPayrollProjectApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		payrollService.savePayroll(new Payroll(1, 15000, 7800));
//		payrollService.savePayroll(new Payroll(2, 25000, 6200));
//		payrollService.savePayroll(new Payroll(3, 40000, 8000));
//		payrollService.savePayroll(new Payroll(4, 65000, 7000));
//		payrollService.savePayroll(new Payroll(7, 95000, 7400));
//		payrollService.savePayroll(new Payroll(8, 45000, 5600));
//	}

}
