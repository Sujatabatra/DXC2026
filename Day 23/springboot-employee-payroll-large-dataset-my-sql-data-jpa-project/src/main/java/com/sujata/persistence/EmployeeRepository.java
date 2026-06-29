package com.sujata.persistence;

import com.sujata.entity.Employee;
import java.util.List;
import java.util.stream.Stream;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	
	
	
//	Used for: Slice processing : Slice and Paging is supported in Oracle 12 and above version
	Slice<Employee> findAllByOrderByEmpId(Pageable pageable);

//	Used for: Streaming
	@Query("select e from Employee e")
	Stream<Employee> streamAllEmployees();

//	Used for: Projection
	List<EmployeeView> findBySalaryGreaterThan(Double salary);
}