package com.sujata.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "Payroll")
public class Payroll {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "payroll_seq")
	@SequenceGenerator(name = "payroll_seq",sequenceName = "PR_SEQ",allocationSize = 1)
	private int payrollId;
	
	@Column
	private int allowances;
	@Column
	private int deductions;
	@Column
	private double basicSalary;
	
	@Transient
	private double netSalary;
	
	
	public Payroll() {
		
	}
	

	public Payroll(int allowances, int deductions, double basicSalary) {
		super();
		this.allowances = allowances;
		this.deductions = deductions;
		this.basicSalary = basicSalary;
	}



	public Payroll(int allowances, int deductions, double basicSalary, double netSalary) {
		super();
		this.allowances = allowances;
		this.deductions = deductions;
		this.basicSalary = basicSalary;
		this.netSalary = netSalary;
	}


	public int getPayrollId() {
		return payrollId;
	}

	public void setPayrollId(int payrollId) {
		this.payrollId = payrollId;
	}

	public int getAllowances() {
		return allowances;
	}

	public void setAllowances(int allowances) {
		this.allowances = allowances;
	}

	public int getDeductions() {
		return deductions;
	}

	public void setDeductions(int deductions) {
		this.deductions = deductions;
	}

	public double getNetSalary() {
		return basicSalary+allowances-deductions;
	}

	

	public double getBasicSalary() {
		return basicSalary;
	}


	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}

	public void setNetSalary(double netSalary) {
		this.netSalary = netSalary;
	}

	@Override
	public String toString() {
		return "Payroll [payrollId=" + payrollId + ", allowances=" + allowances + ", deductions=" + deductions
				+ ", basicSalary=" + basicSalary + ", netSalary=" + netSalary + "]";
	}
	

	
}
