package com.sujata.entity;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "PROJECT")
public class Project {
	@Id
	@SequenceGenerator(name = "project_seq", sequenceName = "PROJECT_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_seq")
	private Long projectId;
	
	private String projectName;
	
	@ManyToMany(mappedBy = "projects")
	private Set<Employee> employees = new HashSet<>();

	public Project() {
	}

	public Project(String projectName) {
		this.projectName = projectName;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
}
