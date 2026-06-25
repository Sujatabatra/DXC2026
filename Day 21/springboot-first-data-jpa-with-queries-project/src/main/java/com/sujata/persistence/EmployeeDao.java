package com.sujata.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sujata.entity.Employee;

import jakarta.transaction.Transactional;

/*
 * HQL/JPQl : Hibernate Query Language/ Java Persistence Query Language
 * 
 * SQL: select * from employees;
 * HQL : from Employee;
 * 
 * SQL : select emp_id,emp_name from employees where emp_department=?
 * HQL : select empId,empName from Employee where empDepartment=?
 * 
 * HQL does not  support insert query
 */
@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {

	List<Employee> findByEmpDepartmentIgnoreCase(String empDepartment);

	@Query("from Employee where empDesignation=:desig")
	List<Employee> getEmployeeByDesignation(@Param("desig") String designation);

	@Query("select empName from Employee where empDepartment=?2 and empDesignation=?1")
	List<String> getNameByDesignationandDepartment(String desination, String department);

	/*
	 * @Modifying when @Query performs an update,insert or delete operation instead
	 * of select
	 * 
	 * without @Modifying , Spring assumes query is a select query and throws an
	 * exceptions
	 */
	@Modifying
	@Query("update Employee set empBasicSalary=empBasicSalary+:amount where empId=:id")
	int updateBasicSalaryById(@Param("id") int empId, @Param("amount") int incrementAmount);

	@Query(value = "insert into employees(emp_id,emp_name,emp_department,emp_designation,emp_basic_salary)"
			+ " values(?1,?2,?3,?4,?5)", 
			nativeQuery = true)
	int insertEmployeeRecord(int id, int name, int department, int designation, double salary);
}
