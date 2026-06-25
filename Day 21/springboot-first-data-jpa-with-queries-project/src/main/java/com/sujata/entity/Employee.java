package com.sujata.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	
	@Column
	private double empBasicSalary;
	
	public Employee() {
		
	}

	
	public Employee(String empName, String empDepartment, String empDesignation, double empBasicSalary) {
		super();
		this.empName = empName;
		this.empDepartment = empDepartment;
		this.empDesignation = empDesignation;
		this.empBasicSalary = empBasicSalary;
	}


	public Employee(int empId, String empName, String empDepartment, String empDesignation, double empBasicSalary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empDepartment = empDepartment;
		this.empDesignation = empDesignation;
		this.empBasicSalary = empBasicSalary;
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

	public double getEmpBasicSalary() {
		return empBasicSalary;
	}

	public void setEmpBasicSalary(double empBasicSalary) {
		this.empBasicSalary = empBasicSalary;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empDepartment=" + empDepartment
				+ ", empDesignation=" + empDesignation + ", empBasicSalary=" + empBasicSalary + "]";
	}
	
	
}
