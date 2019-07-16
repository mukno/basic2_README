package org.web.dbconnect;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBConnect {

	public static Connection getConnection() {
		Connection conn =null;
		DataSource dataSource;
		
		Context context;
		
		try {
			context = new InitialContext();
			dataSource=(DataSource) context.lookup("java:comp/env/jdbc/mysqlDB");
			
			conn=dataSource.getConnection();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return conn;
		
	}
	
}
