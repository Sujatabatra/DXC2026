package com.sujata.entity;

public class EmployeePayslip {

	private int empId;
	private String empName;
	private double empSalary;
	private double empAllowances;
	private double empDeductions;
	private double netSalary;
	
	public EmployeePayslip() {
		
	}

	public EmployeePayslip(int empId, String empName, double empSalary, double empAllowances, double empDeductions,
			double netSalary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
		this.empAllowances = empAllowances;
		this.empDeductions = empDeductions;
		this.netSalary = netSalary;
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

	public double getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}

	public double getEmpAllowances() {
		return empAllowances;
	}

	public void setEmpAllowances(double empAllowances) {
		this.empAllowances = empAllowances;
	}

	public double getEmpDeductions() {
		return empDeductions;
	}

	public void setEmpDeductions(double empDeductions) {
		this.empDeductions = empDeductions;
	}

	public double getNetSalary() {
		return netSalary;
	}

	public void setNetSalary(double netSalary) {
		this.netSalary = netSalary;
	}
	
	
}
