package jang.Data;

public class Member_Update_Data {
	public String user_id;
	public String user_name;
	public String user_phonenum;
	public String user_password;
	
	public Member_Update_Data() {
		
	}
	
	public Member_Update_Data(String user_id, String user_name, String user_password, String user_phonenum) {
		this.user_phonenum = user_phonenum;
		this.user_password = user_password;
		this.user_name = user_name;
		this.user_id = user_id;
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
	
}
