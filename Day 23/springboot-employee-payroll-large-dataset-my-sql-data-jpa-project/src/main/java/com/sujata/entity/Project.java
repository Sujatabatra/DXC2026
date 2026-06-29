package com.sujata.entity;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long projectId;
	
	private String projectName;
	
	@ManyToMany(mappedBy = "projects")
	private Set<Employee> employees = new HashSet<>();

	public Long getProjectId() {
		return projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
}