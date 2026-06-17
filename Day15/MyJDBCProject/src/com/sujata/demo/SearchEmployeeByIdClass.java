package com.sujata.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;



public class SearchEmployeeByIdClass {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Enter Employee ID");
		int id=scanner.nextInt();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Employee employee = null;
		try {
//			1.Connect
//			1.1 Register Driver
			Class.forName("oracle.jdbc.driver.OracleDriver");

//			1.2 Connect to Database
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "sujata");

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

		if(employee == null)
			System.out.println("No Such employee exist with id "+id);
		else
			System.out.println(employee);
	}

}
