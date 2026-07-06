package com.sujata.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeId;

	@Column(nullable = false)
	private String employeeName;

	@Column(unique = true)
	private String email;

	@OneToOne(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
	private Payroll payroll;

	private String department;
	
	private String designation;
	
	public Employee() {
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Payroll getPayroll() {
		return payroll;
	}

	public void setPayroll(Payroll payroll) {
		this.payroll = payroll;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

}