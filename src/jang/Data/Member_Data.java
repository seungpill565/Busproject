package jang.Data;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Member_Data {
	public String user_id;
	public String user_name;
	public String user_phonenum;
	public String user_password;
	public String user_passenger_manager;
	
	public Member_Data() {
		
	}
	
	public Member_Data(String user_id, String user_name, String user_password, String user_phonenum, String user_passenger_manager) {
		this.user_phonenum = user_phonenum;
		this.user_password = user_password;
		this.user_name = user_name;
		this.user_id = user_id;
		this.user_passenger_manager = user_passenger_manager;
	}
	
	public String getID() {
		return user_id;
	}
	
	public void setID(String user_id) {
		this.user_id = user_id;
	}
	
	public String getName() {
		return user_name;
	}
	
	public void setName(String user_name) {
		this.user_name = user_name;
	}
	
	public String getPhonenum() {
		return user_phonenum;
	}
	
	public void setPhonenum(String user_phonenum) {
		this.user_phonenum = user_phonenum;
	}
	
	public String getPassword() {
		return user_password;
	}
	
	public void setPassword(String user_password) {
		this.user_password = user_password;
	}
	public String getPassenger() {
		return user_passenger_manager;
	}
	
	public void setPassenger(String user_passenger_manager) {
		this.user_passenger_manager = user_passenger_manager;
	}
}
