package jang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jang.Data.Route_Insert_Data;
import jang.Data.Route_Read_Data;

public class Route_DB {

	// Insert Create
	public void bus_info_insertData(String bi_day, String bi_time, String rtfk_id) {
		String sql = "INSERT INTO BUS_INFO (bi_id, bi_day, bi_time, rt_id) VALUES(BI_ID_SQ.nextval, ?, ?, ?)";
		try (Connection conn = OjdbcConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {

			pstmt.setString(1, bi_day);
			pstmt.setString(2, bi_time);
			pstmt.setInt(3, Integer.parseInt(rtfk_id));

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// ROUTE Create
	public void route_insertData(String rt_depart_from, String rt_arrive_at, String rt_charge) {
		String sql = "INSERT INTO BUS_ROUTE (rt_id, rt_depart_from, rt_arrive_at, rt_charge) VALUES(rt_id_sq.nextval, ?, ?, ?)";
		try (Connection conn = OjdbcConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {

			pstmt.setString(1, rt_depart_from);
			pstmt.setString(2, rt_arrive_at);
			pstmt.setString(3, rt_charge);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int get_currsq() {
		String sql = "SELECT * FROM user_sequences WHERE sequence_name ='BI_ID_SQ'";
		int i = 0;

		try (Connection conn = OjdbcConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				i = rs.getInt("last_number");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(i);
		return i - 1;
	}

	// SEAT Create
	public void seat_insertData(int bi_id) {
		String sql = "INSERT INTO BUS_SEAT (bs_id, bs_name, bs_is_reserved, bi_id) VALUES(BS_ID_SQ.nextval, ?, 0, ?)";
		try (Connection conn = OjdbcConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {

			for (int i = 1; i < 22; ++i) {
				pstmt.setString(1, "" + i);
				pstmt.setInt(2, bi_id);
				pstmt.executeUpdate();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Read
	public ArrayList<Route_Read_Data> readData() {
		ArrayList<Route_Read_Data> arr = new ArrayList<Route_Read_Data>();
		String sql = "SELECT bi_id, rt_id, rt_depart_from, rt_arrive_at, rt_charge, bi_day, bi_time "
				+ "FROM BUS_ROUTE " + "INNER JOIN BUS_INFO USING (rt_id) ORDER BY bi_id";
		try (Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {

			while (rs.next()) {
				arr.add(new Route_Read_Data(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}

	// Route_Read
	public ArrayList<Route_Insert_Data> route_readData() {
		ArrayList<Route_Insert_Data> arr = new ArrayList<Route_Insert_Data>();
		String sql = "SELECT rt_id, rt_depart_from, rt_arrive_at, rt_charge " + "FROM BUS_ROUTE ORDER BY rt_id";
		try (Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {

			while (rs.next()) {
				arr.add(new Route_Insert_Data(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}

	// Seat_Read
	public ArrayList<Integer> seat_readData(int bs_id, int bi_id) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		String sql = "SELECT bs_id, bi_id " + "FROM BUS_SEAT";
		try (Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {

			while (rs.next()) {
				arr.add(rs.getInt(bs_id), rs.getInt(bi_id));
			}

		} catch (SQLException e) { 
			e.printStackTrace();
		}
		return arr;
	}

	// Update
	public void updateData(String bi_id, String rt_id, String bi_day, String bi_time) {
		String sql = "UPDATE BUS_INFO SET bi_id = ?, rt_id = ?, bi_day = ?, bi_time = ? WHERE bi_id = ?";
		try (Connection conn = OjdbcConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {

			pstmt.setInt(1, Integer.parseInt(bi_id));
			pstmt.setInt(2, Integer.parseInt(rt_id));
			pstmt.setString(3, bi_day);
			pstmt.setString(4, bi_time);
			pstmt.setInt(5, Integer.parseInt(bi_id));

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Seat_Delete
	public void seat_deleteData(String bs_id) {
		String sql = "DELETE FROM BUS_SEAT WHERE bs_id = ?";
		try (Connection conn = OjdbcConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {

			pstmt.setInt(1, Integer.parseInt(bs_id));
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Delete
	public void deleteData(String bi_id) {
		String sql = "DELETE FROM BUS_INFO WHERE bi_id = ?";
		try (Connection conn = OjdbcConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {

			pstmt.setInt(1, Integer.parseInt(bi_id));
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// search
	public ArrayList<Route_Read_Data> searchRoute(String arrive) {
		ArrayList<Route_Read_Data> arr = new ArrayList<Route_Read_Data>();
		String sql = "SELECT bi_id, rt_id, rt_depart_from, rt_arrive_at, rt_charge, bi_day, bi_time "
				+ "FROM BUS_ROUTE " + "INNER JOIN BUS_INFO USING (rt_id) " + "WHERE rt_arrive_at LIKE '%" + arrive
				+ "%'";
		try (Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {

			while (rs.next()) {
				arr.add(new Route_Read_Data(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;

	}

}
