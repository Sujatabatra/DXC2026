package com.sujata.entity;

public class Employee {

	private int empId;

	private String empName;

	private String empDepartment;

	private String empDesignation;

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
