package com.sujata.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sujata.entity.Employee;

import jakarta.transaction.Transactional;


@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {

	List<Employee> findByEmpDepartmentIgnoreCase(String empDepartment);

	@Query("from Employee where empDesignation=:desig")
	List<Employee> getEmployeeByDesignation(@Param("desig") String designation);

	@Query("select empName from Employee where empDepartment=?2 and empDesignation=?1")
	List<String> getNameByDesignationandDepartment(String desination, String department);

	@Modifying
	@Query("update Employee set empBasicSalary=empBasicSalary+:amount where empId=:id")
	int updateBasicSalaryById(@Param("id") int empId, @Param("amount") int incrementAmount);

}
