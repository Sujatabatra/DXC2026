package com.sujata.service;

import com.sujata.entity.*;
import com.sujata.persistence.*;
import jakarta.persistence.*;
import java.util.List;
import java.util.stream.Stream;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

	@PersistenceContext
	private EntityManager em;

	private final EmployeeRepository repo;

	public EmployeeService(EmployeeRepository repo) {
		this.repo = repo;
	}

	// Insert large number of employees
	@Transactional
	public void generateEmployees(int count) {
		for (int i = 1; i <= count; i++) {
			Payroll p = new Payroll();
			p.setBasic(50000.0);
			p.setHra(10000.0);
			p.setBonus(5000.0);
			Employee e = new Employee();
			e.setEmpName("Employee-" + i);
			e.setSalary(70000.0 + i);
			e.setPayroll(p);
			em.persist(e);
			if (i % 50 == 0) {
				em.flush();
				em.clear();
				System.out.println("Inserted " + i);
			}
		}
	}

	/*
	 * Read large data page by page.
	 * 
	 * 
	 * Query 1 SELECT * FROM EMPLOYEE FETCH FIRST 1000 ROWS ONLY , count(*)
	 * 
	 * Query 2 OFFSET 1000 FETCH NEXT 1000 ROWS , count(*)
	 * 
	 * Query 3 OFFSET 2000 FETCH NEXT 1000 ROWS ,count(*)
	 * 
	 * Page<T> 
	 * Database Queries: 2 SQL Queries: One for data, one for COUNT(*).
	 * Total Record Count : Available via .getTotalElements(). 
	 * Total Page Count : Available via .getTotalPages() 
	 * Performance Overhead : High on large tables due to the COUNT scan. 
	 * Primary Use Case : Classic paginated UIs with explicit numbered pages.
	 * 
	 * 
	 * When you return Page<T> from your Spring Data JPA Repository, Spring Data generates a traditional offset pagination sequence:
	 * A data query utilizing LIMIT and OFFSET to grab the current batch.
	 * A separate SELECT COUNT(*) query matching your search criteria.
	 * This gives you a rich set of metadata, but calculating COUNT(*) on millions of records causes heavy CPU and I/O load on your database.
	 */
	@Transactional(readOnly = true)
	public void processUsingPagination() {
		int page = 0;
		Page<Employee> p;
		do {
			p = repo.findAll(PageRequest.of(page, 100));
			System.out.println("Page " + page + " size " + p.getNumberOfElements());
			page++;
		} while (p.hasNext());
	}

	/*
	 * Slice<T> 
	 * Database Queries: 1 SQL Query: Fetches pageSize + 1 rows. 
	 * Total Record Count : Not available. 
	 * Total Page Count : Not available. 
	 * Performance Overhead : Low, very performant for deep scrolling. 
	 * Primary Use Case : Mobile apps with infinite scrolling or "Load More" buttons.
	 * 
	 * Page<T> actually extends Slice<T>. 
	 * If your page size is set to 10, Slice will request 11 rows from the database behind the scenes.
	 * If the database returns 11 rows, 
	 * Slice drops the 11th row, returns the 10 requested items to your application, and marks .hasNext() as true.
	 * It completely skips the COUNT query, ensuring swift execution even if you are accessing a massive database table.
	 */
	@Transactional(readOnly = true)
	public void processUsingSlice() {
		Pageable pageable = PageRequest.of(0, 100);
		Slice<Employee> s;
		do {
			s = repo.findAllByOrderByEmpId(pageable);
			System.out.println("Slice size " + s.getNumberOfElements());
			pageable = s.nextPageable();
		} while (s.hasNext());
	}

	/*
	 * Streams Purpose : Process crores of records works like: Database Cursor Rows
	 * are fetched gradually. Memory usage remains: constant
	 * 
	 * Database Cursor ↓ 100 rows ↓ 100 rows ↓ 100 rows
	 */
	@Transactional(readOnly = true)
	public void processUsingStream() {
		try (Stream<Employee> st = repo.streamAllEmployees()) {
			st.limit(20).forEach(e -> System.out.println(e.getEmpName()));
		}
	}

	@Transactional
	public void increaseSalary() {
		int page = 0;
		Page<Employee> p;
		do {
			p = repo.findAll(PageRequest.of(page, 100));
			for (Employee e : p.getContent()) {
				e.setSalary(e.getSalary() + 1000);
			}
			repo.saveAll(p.getContent());
			page++;
		} while (p.hasNext());
	}

	@Transactional(readOnly = true)
	public void displayProjection() {
		List<EmployeeView> list = repo.findBySalaryGreaterThan(70000.0);
		list.
		stream().
		limit(15).
		forEach(v -> System.out.println(v.getEmpName() + " " + v.getSalary()));
	}
}