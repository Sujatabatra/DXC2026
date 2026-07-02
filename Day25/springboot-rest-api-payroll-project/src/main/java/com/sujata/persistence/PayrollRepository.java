package com.sujata.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sujata.entity.Payroll;

@Repository
public interface PayrollRepository extends JpaRepository<Payroll, Integer> {

	
	Payroll getByEmpId(int empId);
}
