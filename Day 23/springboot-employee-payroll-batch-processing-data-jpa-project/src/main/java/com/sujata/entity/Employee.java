package com.sujata.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {
	@Id
	@SequenceGenerator(name = "emp_seq", sequenceName = "EMP_SEQ", allocationSize = 50)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emp_seq")
	private Long empId;
	
	private String empName;
	
	private Double salary;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PAYROLL_ID")
	private Payroll payroll;

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Payroll getPayroll() {
		return payroll;
	}

	public void setPayroll(Payroll payroll) {
		this.payroll = payroll;
	}
}
