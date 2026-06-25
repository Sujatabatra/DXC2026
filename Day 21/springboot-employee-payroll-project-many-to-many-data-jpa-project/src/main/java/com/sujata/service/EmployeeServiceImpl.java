package com.sujata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sujata.entity.Employee;
import com.sujata.entity.Project;
import com.sujata.persistence.EmployeeDao;
import com.sujata.persistence.ProjectDao;

@Transactional
@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao employeeDao;
	private ProjectDao projectDao;

	@Autowired
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	@Autowired
	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}

	@Override
	public boolean addEmployee(Employee employee) {
		employeeDao.save(employee);
		return true;
	}

	@Override
	public Employee searchEmployee(int employeeId) {
		return employeeDao.findById(employeeId).orElse(null);
	}

	@Override
	public boolean deleteEmployee(int employeeId) {
		if (employeeDao.existsById(employeeId)) {
			employeeDao.deleteById(employeeId);
			return true;
		}
		return false;
	}

	@Override
	public List<Employee> getAllEmployees() {
//		return employeeDao.findAll();
		return employeeDao.findAllWithProjects();
	}

	@Override
	public List<Employee> findEmployeesByDepartment(String deptt) {
		return employeeDao.findByEmpDepartmentIgnoreCase(deptt);
	}

	@Override
	public boolean addProject(Project project) {
		projectDao.save(project);
		return true;
	}

	/*
	 * whenever function throws RunTimeexception i.e unchecked Exception, Transaction RollBack
	 */
	@Override
	public void assignProject(int empId, int projectId) {
		
		Employee employee=employeeDao.findById(empId)
				.orElseThrow(()->new RuntimeException("Employee Not Found"));
		
		Project project=projectDao.findById(projectId)
				.orElseThrow(()->new RuntimeException("Project Not Found"));
	
		employee.getProjects().add(project);
		
		employeeDao.save(employee);
	}

	
}
