package com.bridgelabz.Day_34;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class RetrieveByDateUC5 {

	public static Connection getConnection() throws SQLException {
		String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service?useSSL=false";
		String userName = "root";
		String passWord = "Softramesh27";
		Connection con;
		con = DriverManager.getConnection(jdbcURL, userName, passWord);
		return con;		
	}
	
	public static void main(String [] args) {
		String sql = "SELECT * FROM EMPLOYEE_PAYROLL WHERE START BETWEEN CAST('2019-01-01' AS DATE) AND DATE(NOW())";
		try {
			Connection connection = getConnection();
			java.sql.Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String gender = resultSet.getString("gender");
				double salary = resultSet.getDouble("salary");
				LocalDate start = resultSet.getDate("start").toLocalDate();
				System.out.println(id+" "+name+" "+gender+" "+salary+" "+start);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		  }
	}
}
