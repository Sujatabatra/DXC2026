package com.sujata.entity;

//POJO : Plain Old Java Object
public class Employee {

	private int empId;
	private String empName;
	private String empDesig;
	private String empDeptt;
	private double basic;
	
	public Employee() {
	}
	
	public Employee(int empId, String empName, String empDesig, String empDeptt, double basic) {
		this.empId = empId;
		this.empName = empName;
		this.empDesig = empDesig;
		this.empDeptt = empDeptt;
		this.basic = basic;
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
	public String getEmpDesig() {
		return empDesig;
	}
	public void setEmpdesig(String empDesig) {
		this.empDesig = empDesig;
	}
	public String getEmpDeptt() {
		return empDeptt;
	}
	public void setEmpDeptt(String empDeptt) {
		this.empDeptt = empDeptt;
	}
	public double getBasic() {
		return basic;
	}
	public void setBasic(double basic) {
		this.basic = basic;
	}
	
	
	
}
