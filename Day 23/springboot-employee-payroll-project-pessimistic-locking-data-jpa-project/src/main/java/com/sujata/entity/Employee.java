package com.sujata.entity;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {
	@Id
	@SequenceGenerator(name = "emp_seq", sequenceName = "EMP_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emp_seq")
	private Long empId;
	
	private String empName;
	
	private Double salary;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PAYROLL_ID")
	private Payroll payroll;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "EMPLOYEE_PROJECT", joinColumns = @JoinColumn(name = "EMP_ID"), inverseJoinColumns = @JoinColumn(name = "PROJECT_ID"))
	private Set<Project> projects = new HashSet<>();

	public Employee() {
	}

	public Employee(String empName, Double salary) {
		this.empName = empName;
		this.salary = salary;
	}

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

	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}
}
