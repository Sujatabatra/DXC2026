package com.sujata.service;

import com.sujata.entity.Employee;
import com.sujata.entity.Payroll;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/*
 * JPA, Java Persistence API is a specification and Hiberntae is its implementation and both are ORM (Object Relational Mapping)
 * 
 * ORM
 * 1. Mapping Metadata (e.g @Entity, @Id, @Column)
 * 2. HQL/JPQL 
 * 3. API (collection of classes and interfaces to perform various db operation)
 * 
 * JPA
 * EntityManagerFactory -> EntityManager (for each transaction)
 * 
 * Hibernate 
 * SessionFactory -> Session (for each transaction)
 */
@Service
public class EmployeeService {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void importEmployees(int count) {
		for (int i = 1; i <= count; i++) {
			Payroll payroll = new Payroll();
			payroll.setBasic(50000.0);
			payroll.setHra(10000.0);
			payroll.setBonus(5000.0);

			Employee emp = new Employee();
			emp.setEmpName("Employee-" + i);
			emp.setSalary(70000.0);
			emp.setPayroll(payroll);

			entityManager.persist(emp);  //on first level cache which is entityManager level

			if (i % 50 == 0) {
				entityManager.flush();  //put persistent state object to detached
				entityManager.clear();   //clear first level cache
				System.out.println("Inserted : " + i);
			}
		}
		entityManager.flush();
		entityManager.clear();
	}
}
