package com.sujata.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.sujata.entity.Employee;
import com.sujata.excep.DuplicateEmployeeIdException;

public class EmployeeDaoImpl implements EmployeeDao {

	private String driverClassName;
	private String url;
	private String username;
	private String password;
	
	private static final Logger logger=LoggerFactory.getLogger(EmployeeDaoImpl.class);

	public EmployeeDaoImpl(String driverClassName, String url, String username, String password) {
		super();
		this.driverClassName = driverClassName;
		this.url = url;
		this.username = username;
		this.password = password;
	}

	@Override
	public int insertRecord(Employee employee) throws DuplicateEmployeeIdException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int rows = 0;

		try {
//			1.Connect
//			1.1 Register Driver
			Class.forName(driverClassName);

//			1.2 Connect to Database
			connection = DriverManager.getConnection(url, username, password);

//			2.Query

			String query = "INSERT INTO EMPLOYEE VALUES(?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, employee.getEmpId());
			preparedStatement.setString(2, employee.getEmpName());
			preparedStatement.setString(3, employee.getEmpDesignation());
			preparedStatement.setString(4, employee.getEmpDepartment());
			preparedStatement.setDouble(5, employee.getEmpBasicSalary());

//			whenever we are using DML i.e insert, delete, update, we will be using executeUpdate() and return type of executeUpdate is int, which is total number of rows affected by DML Operation
			rows = preparedStatement.executeUpdate();

//			3. Process the Result
//			in this case no processing, we are simply returning the rows
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			throw new DuplicateEmployeeIdException("Employee ID is Duplicate");
		} finally {

			try {
//				4. Close
				connection.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return rows;
	}

	@Override
	public Employee getEmployeeById(int id) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Employee employee = null;
		try {
//			1.Connect
//			1.1 Register Driver
			Class.forName(driverClassName);

//			1.2 Connect to Database
			connection = DriverManager.getConnection(url, username, password);

//			2.Query
//			String query="SELECT * FROM EMPLOYEE WHERE ID="+id;
			String query = "SELECT * FROM EMPLOYEE WHERE ID=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id); // 1 is the sequence number of ?

//			whenever we are using DQL i.e select query, we will be using executeQuery() and will be storing the resullt in ResultSet
			ResultSet resultSet = preparedStatement.executeQuery();

//			3. Process the Result
			if (resultSet.next()) {
				employee = new Employee();
				employee.setEmpId(resultSet.getInt("ID"));
				employee.setEmpName(resultSet.getString("NAME"));
				employee.setEmpDesignation(resultSet.getString("DESIGNATION"));
				employee.setEmpDepartment(resultSet.getString("DEPARTMENT"));
				employee.setEmpBasicSalary(resultSet.getDouble("SALARY"));
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
//				4. Close
				connection.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return employee;
	}

	@Override
	public int deleteRecord(int id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int rows = 0;

		try {
//			1.Connect
//			1.1 Register Driver
			Class.forName(driverClassName);

//			1.2 Connect to Database
			connection = DriverManager.getConnection(url, username, password);

//			2.Query

			String query = "DELETE FROM EMPLOYEE WHERE ID=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);

			// whenever we are using DML i.e insert, delete, update, we will be using
			// executeUpdate() and return type of executeUpdate is int, which is total
			// number of rows affected by DML Operation
			rows = preparedStatement.executeUpdate();

//			3. Process the Result
//			in this case no processing, we are simply returning the rows
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
//				4. Close
				connection.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return rows;
	}

	@Override
	public int updateRecord(int id, int amount) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int rows = 0;

		try {
//			1.Connect
//			1.1 Register Driver
			Class.forName(driverClassName);

//			1.2 Connect to Database
			connection = DriverManager.getConnection(url, username, password);

			
//			2.Query

			String query = "UPDATE EMPLOYEE SET SALARY=SALARY+? WHERE ID=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, amount);
			preparedStatement.setInt(2, id);

			// whenever we are using DML i.e insert, delete, update, we will be using
			// executeUpdate() and return type of executeUpdate is int, which is total
			// number of rows affected by DML Operation
			rows = preparedStatement.executeUpdate();

//			3. Process the Result
//			in this case no processing, we are simply returning the rows
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
//				4. Close
				connection.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return rows;
	}

	@Override
	public List<Employee> getAllRecords() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Employee employee = null;
		List<Employee> employeeList = new ArrayList<Employee>();
		try {
//			1.Connect
//			1.1 Register Driver
			Class.forName(driverClassName);

//			1.2 Connect to Database
			connection = DriverManager.getConnection(url, username, password);
			logger.info("DataBase Connection established on"+url);
//			2.Query
//			String query="SELECT * FROM EMPLOYEE WHERE ID="+id;
			String query = "SELECT * FROM EMPLOYEE";
			preparedStatement = connection.prepareStatement(query);

//			whenever we are using DQL i.e select query, we will be using executeQuery() and will be storing the resullt in ResultSet
			ResultSet resultSet = preparedStatement.executeQuery();

			logger.info(query+" executed! ");
//			3. Process the Result
			while (resultSet.next()) {
				employee = new Employee();
				employee.setEmpId(resultSet.getInt("ID"));
				employee.setEmpName(resultSet.getString("NAME"));
				employee.setEmpDesignation(resultSet.getString("DESIGNATION"));
				employee.setEmpDepartment(resultSet.getString("DEPARTMENT"));
				employee.setEmpBasicSalary(resultSet.getDouble("SALARY"));

				employeeList.add(employee);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		} finally {

			try {
//				4. Close
				connection.close();
				logger.info("Connection closed");
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return employeeList;

	}

}
