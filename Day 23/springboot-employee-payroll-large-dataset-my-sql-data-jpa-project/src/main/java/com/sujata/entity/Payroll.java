package com.sujata.entity;

import jakarta.persistence.*;

@Entity
public class Payroll {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long payrollId;
	private Double basic;
	private Double hra;
	private Double bonus;

	public Long getPayrollId() {
		return payrollId;
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