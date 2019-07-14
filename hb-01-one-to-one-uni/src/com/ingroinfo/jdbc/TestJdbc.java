package com.ingroinfo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
	
	public static void main(String[]arg) {
		
		String jdbcUrl="jdbc:mysql://localhost:3307/hb-01-one-to-one-uni?useSSL=false";
		String user="hbstudent";
		String password="hbstudent";
		try {
			System.out.println("Connecting to database :" +jdbcUrl);
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection mycon=
					DriverManager.getConnection(jdbcUrl, user, password);
			
			System.out.println("Connection Sucessfull" );
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
