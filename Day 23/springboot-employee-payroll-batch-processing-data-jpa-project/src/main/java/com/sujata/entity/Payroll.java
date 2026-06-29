package com.sujata.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "PAYROLL")
public class Payroll {
	@Id
	@SequenceGenerator(name = "pay_seq", sequenceName = "PAYROLL_SEQ", allocationSize = 50)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pay_seq")
	private Long payrollId;
	private Double basic;
	private Double hra;
	private Double bonus;

	public Long getPayrollId() {
		return payrollId;
	}

	public void setPayrollId(Long payrollId) {
		this.payrollId = payrollId;
	}

	public Double getBasic() {
		return basic;
	}

	public void setBasic(Double basic) {
		this.basic = basic;
	}

	public Double getHra() {
		return hra;
	}

	public void setHra(Double hra) {
		this.hra = hra;
	}

	public Double getBonus() {
		return bonus;
	}

	public void setBonus(Double bonus) {
		this.bonus = bonus;
	}
}
