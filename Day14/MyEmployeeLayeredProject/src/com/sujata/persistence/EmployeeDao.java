package com.sujata.persistence;

import com.sujata.entity.Employee;

//Dao: Data Acceess Object
public interface EmployeeDao {
	
	public int insertRecord(Employee employee);
	public Employee getEmployeeById(int id);
	public int deleteRecord(int id);
	public int updateRecord(int id, int amount);

}
