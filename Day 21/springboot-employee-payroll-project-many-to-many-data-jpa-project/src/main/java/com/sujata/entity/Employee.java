package com.sujata.entity;

import java.util.HashSet;
import jakarta.persistence.*;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "employee_seq")
	@SequenceGenerator(name = "employee_seq",sequenceName = "EMP_SEQ",allocationSize = 1)
	private int empId;
	
	@Column	private String empName;
	
	@Column
	private String empDepartment;
	
	@Column
	private String empDesignation;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Payroll payroll;
	
	
	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(name = "employee_project",
	joinColumns = @JoinColumn(name="employee_id"),
	inverseJoinColumns = @JoinColumn(name="project_id"))
	private Set<Project> projects=new HashSet<Project>();
	
	public Employee() {
		
	}

	
	public Employee(String empName, String empDepartment, String empDesignation) {
		super();
		this.empName = empName;
		this.empDepartment = empDepartment;
		this.empDesignation = empDesignation;
		
	}


	public Employee(int empId, String empName, String empDepartment, String empDesignation) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empDepartment = empDepartment;
		this.empDesignation = empDesignation;
		
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpDepartment() {
		return empDepartment;
	}

	public void setEmpDepartment(String empDepartment) {
		this.empDepartment = empDepartment;
	}

	public String getEmpDesignation() {
		return empDesignation;
	}

	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
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
