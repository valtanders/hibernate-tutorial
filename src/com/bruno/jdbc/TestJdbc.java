package com.bruno.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSl=false";
		// &serverTimezone=UTC (not needed if u use the query for timezone)
		String user = "hbstudent";
		String pass = "hbstudent";
		Connection con;
		try {
			System.out.println("Connecting to DataBase: " + jdbcUrl);
			con = DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("Connection Successfull");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
