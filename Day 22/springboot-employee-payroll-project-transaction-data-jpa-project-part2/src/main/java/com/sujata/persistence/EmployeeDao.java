package com.sujata.persistence;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sujata.entity.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {
	
	List<Employee> findByEmpDepartmentIgnoreCase(String empDepartment);

	/*
	 * select e *
	 * from employees e join employee_project ep
	 * on e.employee_id=ep.employee_id
	 * join project p
	 * on ep.project_id=p.project_id
	 * where p.project_name=?
	 */
	@Query("select e from Employee e join e.projects p where p.projectName=:projectName")
	List<Employee> findEmployeeByProject(@Param("projectName") String projectName);


	@Query("select distinct e from Employee e left join fetch e.projects")
	List<Employee> findAllWithProjects();
}
