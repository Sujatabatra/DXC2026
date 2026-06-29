package com.sujata.persistence;

import com.sujata.entity.Employee;
import jakarta.persistence.LockModeType;
import jakarta.persistence.QueryHint;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Lock(LockModeType.PESSIMISTIC_WRITE)
	@QueryHints(@QueryHint(name = "jakarta.persistence.lock.timeout", value = "10000"))
	@Query("select e from Employee e where e.empId=:id")
	Optional<Employee> findByIdForUpdate(@Param("id") Long id);
}
