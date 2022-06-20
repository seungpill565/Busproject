package lee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OjdbcConnection {
	
/*
<라이브러리 만들기>
	JavaBasic - 마우스 오른 - Build Path - Configure Build Path... 
	- Libraries - ClassPath - AddExternal JARs... - (JavaAWS - database - sqldeveloper - jdbc - ojdbc8 클릭)
	- Classpath 밑에 ojdbc8.jar - C:\JavaAWS\..어쩌고 길게 뜨면 된 거임 - Apply and Close
	JavaBasic 플젝에 Referenced Libraries - ojdbc8.jar - C:\JavaAWS\.. 생긴 거 확인
 */
	
	public static String driverName = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
								
	
	private static String user = "hr";
	private static String password = "1234"; 
	
	
	static {
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("driver Name Error : " + driverName);
		}
	}
	
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	} //Connection conn = OjdbcConnection.getConnection(); 이렇게 받아서 사용
}

