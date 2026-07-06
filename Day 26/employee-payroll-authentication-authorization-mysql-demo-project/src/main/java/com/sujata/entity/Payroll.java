package com.sujata.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "PAYROLL")
public class Payroll {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PAYROLL_ID")
	private Long payrollId;

	private Double salary;

	private Double bonus;

	@OneToOne
	@JoinColumn(name = "EMPLOYEE_ID", unique = true)
	private Employee employee;

	public Payroll() {
	}

	public Long getPayrollId() {
		return payrollId;
	}

	public void setPayrollId(Long payrollId) {
		this.payrollId = payrollId;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Double getBonus() {
		return bonus;
	}

	public void setBonus(Double bonus) {
		this.bonus = bonus;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
