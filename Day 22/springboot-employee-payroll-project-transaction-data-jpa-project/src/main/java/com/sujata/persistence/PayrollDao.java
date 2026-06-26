package com.sujata.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sujata.entity.Payroll;

public interface PayrollDao extends JpaRepository<Payroll, Integer> {

}
