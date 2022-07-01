package jang.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import an.OjdbcConnection;
import jang.Data.Member_Data;
import jang.Data.Member_Update_Data;

public class Member_DB {
	
	ArrayList<Integer> bs_id_list = new ArrayList<>();

	// Create
	public void insertData(Member_Data data) {
		String sql = "INSERT INTO USER_INFO (user_id, user_name, user_password, user_phonenum, user_passenger_manager) VALUES(?, ?, ?, ?, ?)";
		try (Connection conn = OjdbcConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {

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
		try (Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {

			while (rs.next()) {
				arr.add(new Member_Data(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}

	// Update
	public void updateData(Member_Update_Data data) {
		String sql = "UPDATE USER_INFO SET user_name = ?, user_password = ?, user_phonenum = ? WHERE user_id = ?";
		try (Connection conn = OjdbcConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {

			pstmt.setString(1, data.user_name);
			pstmt.setString(2, data.user_password);
			pstmt.setString(3, data.user_phonenum);
			pstmt.setString(4, data.user_id);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Delete user_info
	public void deleteData(String user_id) {
		String sql = "DELETE FROM USER_INFO WHERE user_id = ?";
		try (Connection conn = OjdbcConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {

			pstmt.setString(1, user_id);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// get bs_id by user_id 
	public void get_bs_id(String user_id) {
		String sql = "SELECT bs_id FROM bus_reservation WHERE user_id = ?";
		try (Connection conn = OjdbcConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {

			pstmt.setString(1, user_id);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bs_id_list.add(rs.getInt("bs_id"));
			}

		} catch (SQLException e) {

		}
	}
	
	public void reset_is_reserved() {
		String sql = "UPDATE bus_seat SET bs_is_reserved = 0 WHERE bs_id = ?";
		try (Connection conn = OjdbcConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			
			int size = bs_id_list.size();
			
			for(int i = 0; i < size; ++i) {
				pstmt.setInt(1, bs_id_list.get(i));
				pstmt.executeUpdate();
			}

		} catch (SQLException e) {

		}
	}
	
	// delete reservation by user_id
	public void deleteRV(String user_id) {
		String sql = "DELETE FROM bus_reservation WHERE user_id = ?";
		try (Connection conn = OjdbcConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {

			pstmt.setString(1, user_id);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//

	// search
	public ArrayList<Member_Data> search(String user_id) {
		ArrayList<Member_Data> arr = new ArrayList<Member_Data>();
		String sql = "select user_id, user_name, user_password, user_phonenum, user_passenger_manager from user_info WHERE user_id LIKE '%"
				+ user_id + "%'";
		try (Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {

			while (rs.next()) {
				arr.add(new Member_Data(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}

	// ID Check
	public ArrayList<Member_Data> user_id_check(String user_id) {
		ArrayList<Member_Data> arr = new ArrayList<Member_Data>();
		String sql = "select * from user_info WHERE user_id LIKE '" + user_id + "'";
		try (Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {

			while (rs.next()) {
				arr.add(new Member_Data(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}
}
