package com.sujata.persistence;



import java.util.List;

import com.sujata.entity.Employee;
import com.sujata.excep.DuplicateEmployeeIdException;

//Dao: Data Acceess Object
public interface EmployeeDao {
	
	public int insertRecord(Employee employee)throws DuplicateEmployeeIdException;
	public Employee getEmployeeById(int id);
	public int deleteRecord(int id);
	public int updateRecord(int id, int amount);
	public List<Employee> getAllRecords();

}
