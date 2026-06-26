package com.sujata.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="projects")
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "project_seq")
	@SequenceGenerator(name = "project_seq",sequenceName = "PRJ_SEQ",allocationSize = 1)
	private int projectId;
	
	@Column
	private String projectName;
	
	@Column
	private String clientName;
	
	@Column
	private double budget;

	/*
	 * make Project inverse side
	 * Employee is the owner
	 * only employee can insert record into
	 * Employee_Project Table
	 */
	@ManyToMany(mappedBy = "projects")
	private Set<Employee> employees=new HashSet<Employee>();
	
	public Project() {
		
	}
	public Project(String projectName, String clientName, double budget) {
		super();
		this.projectName = projectName;
		this.clientName = clientName;
		this.budget = budget;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public double getBudget() {
		return budget;
	}
	public void setBudget(double budget) {
		this.budget = budget;
	}
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	
	

}
