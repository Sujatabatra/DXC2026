package com.sujata.mapdemos;

import java.util.Objects;

public class Employee implements Comparable<Employee> {

	private int employeeId;
	private String employeeName;
	private String designation;
	
	public Employee() {
		
	}

	public Employee(int employeeId, String employeeName, String designation) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.designation = designation;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", designation=" + designation
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(designation, employeeId, employeeName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(designation, other.designation) && employeeId == other.employeeId
				&& Objects.equals(employeeName, other.employeeName);
	}

	@Override
	public int compareTo(Employee o) {
		// write your logic for sorting as per the desired field 
		return 0;
	}
	
	
}
