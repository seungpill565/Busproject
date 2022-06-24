package jang;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jang.Data.Member_Data;
import jang.Data.Member_Update_Data;

public class Member_DB {
	
	
	// Create
	public void insertData(Member_Data data) {
		String sql = "INSERT INTO USER_INFO (user_id, user_name, user_password, user_phonenum, user_passenger_manager) VALUES(?, ?, ?, ?, ?)";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			){
			
			pstmt.setString(1, data.user_id);
			pstmt.setString(2, data.user_name);
			pstmt.setString(3, data.user_password);
			pstmt.setString(4, data.user_phonenum);
			pstmt.setString(5, data.user_passenger_manager);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	// Read
	public ArrayList<Member_Data> readData() {
		ArrayList<Member_Data> arr = new ArrayList<Member_Data>();
		String sql = "select user_id, user_name, user_password, user_phonenum, user_passenger_manager from user_info ORDER BY user_passenger_manager ASC, user_name ASC";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				){
			
			while(rs.next()) {
				arr.add(new Member_Data(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return arr;
	}
	
	// Update
	public void updateData(Member_Update_Data data) {
		String sql = "UPDATE USER_INFO SET user_name = ?, user_password = ?, user_phonenum = ? WHERE user_id = ?";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				) {
			
			pstmt.setString(1, data.user_name);
			pstmt.setString(2, data.user_password);
			pstmt.setString(3, data.user_phonenum);
			pstmt.setString(4, data.user_id);

			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	// Delete
	public void deleteData(String user_id) {
		String sql = "DELETE FROM USER_INFO WHERE user_id = ?";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			){

			pstmt.setString(1, user_id);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
}
