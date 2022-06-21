package lee.mpmodel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MPprofileModel {
	String user_id;
	String user_name;
	String user_phonenum;
	

	public MPprofileModel(ResultSet rs) throws SQLException {
		user_id = rs.getString("user_id");
		user_name = rs.getString("user_name");
		user_phonenum = rs.getString("user_phonenum");
	}

	
	@Override
	public String toString() {
		return String.format(
				"<html><pre style=\"font-family:고딕;\">아이디    : %s<br><br>"
				+ "이름       : %s<br><br>"
				+ "연락처    : %s</pre><html/>"
				, user_id, user_name, user_phonenum);	
	}
	
}
