package jang.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OjdbcConnection {
	
	private static String driverName = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@15.164.233.121:1521:XE";
	private static String user = "BusProject";
	private static String password = "1234";
	
	static {
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			System.out.println("driver Name error : " + driverName);
		}
	}
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url,user,password);
	}

}


