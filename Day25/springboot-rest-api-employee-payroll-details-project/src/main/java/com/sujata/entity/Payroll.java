package com.sujata.entity;

public class Payroll {

	private int payrollId;
	private int empId;
	private double allowance;
	private double deductions;

	public Payroll() {

	}

	public Payroll(int empId, double allowance, double deductions) {
		super();
		this.empId = empId;
		this.allowance = allowance;
		this.deductions = deductions;
	}

	public int getPayrollId() {
		return payrollId;
	}

	public void setPayrollId(int payrollId) {
		this.payrollId = payrollId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public double getAllowance() {
		return allowance;
	}

	public void setAllowance(double allowance) {
		this.allowance = allowance;
	}

	public double getDeductions() {
		return deductions;
	}

	public void setDeductions(double deductions) {
		this.deductions = deductions;
	}

}
