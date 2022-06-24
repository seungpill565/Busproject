package jang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jang.Data.BI_Insert_Data;
import jang.Data.Businfo_Data;
import jang.Data.Route_Insert_Data;
import jang.Data.Route_Read_Data;
import jang.Data.Seat_Insert_Data;

public class Route_DB {

	// Create
	public void bus_info_insertData(BI_Insert_Data data) {
		String sql = "INSERT INTO BUS_INFO (bi_id, bi_day, bi_time, rt_id) VALUES(BI_ID_SQ.nextval, ?, ?, ?)";
		try (
				Connection conn = OjdbcConnection.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(sql);
			) {

			pstmt.setString(1, data.bi_day);
			pstmt.setString(2, data.bi_time);
			pstmt.setInt(3, data.rtfk_id);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// ROUTE Create
		public void route_insertData(Route_Insert_Data data) {
			String sql = "INSERT INTO BUS_ROUTE (rt_id, rt_depart_from, rt_arrive_at, rt_charge) VALUES(br_id_sq.nextval, ?, ?, ?)";
			try (
					Connection conn = OjdbcConnection.getConnection(); 
					PreparedStatement pstmt = conn.prepareStatement(sql);
				) {

				pstmt.setString(1, data.rt_depart_from);
				pstmt.setString(2, data.rt_arrive_at);
				pstmt.setString(3, data.rt_charge);

				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		// SEAT Create
		public void seat_insertData(Seat_Insert_Data data) {
			String sql = "INSERT INTO BUS_SEAT (bs_id, bs_name, bu_is_reserved, bi_id) VALUES(BS_ID_SQ.nextval, ?, 0, ?)";
			try (
					Connection conn = OjdbcConnection.getConnection(); 
					PreparedStatement pstmt = conn.prepareStatement(sql);
				) {

				
				for (int i = 1; i < 22; ++i) {
					pstmt.setString(1, data.bs_name + i);
					pstmt.setInt(2, data.bifk_id);
					pstmt.executeUpdate();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	// Read
	public ArrayList<Route_Read_Data> readData() {
		ArrayList<Route_Read_Data> arr = new ArrayList<Route_Read_Data>();
		String sql = "SELECT bi_id, rt_depart_from, rt_arrive_at, rt_charge, bi_day, bi_time, bs_name, bu_is_reserved "
				+ "FROM BUS_ROUTE " + "INNER JOIN BUS_INFO USING (rt_id) " + "INNER JOIN BUS_SEAT USING (bi_id) ";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
			) {

			while (rs.next()) {
				arr.add(new Route_Read_Data(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}

	// Update
	public void updateData(Businfo_Data data) {
		String sql = "UPDATE BUS_INFO SET bi_day = ?, bi_time = ?, rt_id = ? WHERE bi_id = ?";
		try (
				Connection conn = OjdbcConnection.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(sql);
			) {

			pstmt.setString(1, data.bi_day);
			pstmt.setString(2, data.bi_time);
			pstmt.setInt(3, data.rt_id);
			pstmt.setInt(4, data.bi_id);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Delete
	public void deleteData(int bi_id) {
		String sql = "DELETE FROM BUS_SEAT WHERE bi_id = ?";
		try (
				Connection conn = OjdbcConnection.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(sql);
			) {

			pstmt.setInt(1, bi_id);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
