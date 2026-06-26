package com.sujata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sujata.entity.Employee;
import com.sujata.entity.Project;
import com.sujata.persistence.ProjectDao;


@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

	private ProjectDao projectDao;
	
	@Autowired
	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}

	@Override
	public Project addProject(Project project) {
		return projectDao.save(project);
		
	}

}
