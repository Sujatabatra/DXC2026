package com.sujata.client;

import com.sujata.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sujata.persistence.EmployeeDao;
import com.sujata.persistence.EmployeeDaoImpl;
import com.sujata.presentation.EmployeePresentation;
import com.sujata.presentation.EmployeePresentationImpl;
import com.sujata.service.EmployeeService;
import com.sujata.service.EmployeeServiceChangeRequest;

@Configuration
public class EmployeeConfig {
	
	@Bean("dao")
	public EmployeeDao getDao(@Value("${app.driverclassname}") String driverClassName, @Value("${app.url}") String url,
			@Value("${app.username}") String username, @Value("${app.password}") String password) {
		
		return new EmployeeDaoImpl(driverClassName, url, username, password);
	}
	
	@Bean("service")
	public EmployeeService getService(@Value("${app.driverclassname}") String driverClassName, @Value("${app.url}") String url,
			@Value("${app.username}") String username, @Value("${app.password}") String password) {
		
		EmployeeServiceImpl empService=new EmployeeServiceImpl();
		empService.setEmployeeDao(getDao(driverClassName, url, username, password));
		return empService;
	}
	
	
	@Bean("changedService")
	public EmployeeService getChangedService(@Value("${app.driverclassname}") String driverClassName, @Value("${app.url}") String url,
			@Value("${app.username}") String username, @Value("${app.password}") String password) {
		return new EmployeeServiceChangeRequest(getDao(driverClassName, url, username, password));
	}
	
	
	@Bean("presentation")
	public EmployeePresentation getPresentation(@Value("${app.driverclassname}") String driverClassName, @Value("${app.url}") String url,
			@Value("${app.username}") String username, @Value("${app.password}") String password) {
		return new EmployeePresentationImpl(getService(driverClassName, url, username, password));
	}

}
