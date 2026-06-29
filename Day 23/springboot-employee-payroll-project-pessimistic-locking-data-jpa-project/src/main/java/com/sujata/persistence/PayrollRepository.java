package com.sujata.persistence;

import com.sujata.entity.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PayrollRepository extends JpaRepository<Payroll, Long> {
}
