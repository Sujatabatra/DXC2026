package com.sujata.health;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.health.contributor.Health;
import org.springframework.boot.health.contributor.HealthIndicator;
import org.springframework.stereotype.Component;
import com.sujata.persistence.EmployeeDao;

@Component
public class EmployeeHealthIndicator implements HealthIndicator {

	private final EmployeeDao employeeRepository;

	public EmployeeHealthIndicator(@Autowired EmployeeDao employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Health health() {
		try {
			long count = employeeRepository.count();
					
			return Health.up().withDetail("Employee Count", count).build();
		} catch (Exception ex) {

			return Health.down(ex).withDetail("Database", "Unable to fetch employees").build();
		}
	}

}
