package com.sujata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sujata.entity.Payroll;

@Repository
public interface PayrollRepository extends JpaRepository<Payroll, Long> {

}