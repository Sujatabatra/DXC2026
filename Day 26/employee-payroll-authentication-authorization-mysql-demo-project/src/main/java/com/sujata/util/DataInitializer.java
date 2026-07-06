package com.sujata.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.sujata.entity.Role;
import com.sujata.entity.User;
import com.sujata.repository.RoleRepository;
import com.sujata.repository.UserRepository;

import java.util.Set;

@Component
public class DataInitializer implements CommandLineRunner {

	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private final PasswordEncoder passwordEncoder;

	public DataInitializer(@Autowired UserRepository userRepository,@Autowired RoleRepository roleRepository,
			@Autowired PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public void run(String... args) {

		Role employeeRole = roleRepository.findByRoleName("ROLE_EMPLOYEE")
				.orElseGet(() -> roleRepository.save(new Role(null, "ROLE_EMPLOYEE")));

		if (!userRepository.existsByUsername("employeeX")) {

			User employee = new User();

			employee.setUsername("employeeX");

			employee.setPassword(passwordEncoder.encode("employeeX123"));

			employee.setEnabled(true);

			employee.setRoles(Set.of(employeeRole));

			userRepository.save(employee);
		}
	}
}