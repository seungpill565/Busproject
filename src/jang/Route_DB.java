package jang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jang.Data.Route_Insert_Data;
import jang.Data.Route_Read_Data;
import jang.Data.Seat_Data;

public class Route_DB {
	
	ArrayList<Integer> bi_id_list = new ArrayList<>();

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
//<<<<<<< HEAD
//		public void route_insertData(Route_Insert_Data data) {
//			String sql = "INSERT INTO BUS_ROUTE (rt_id, rt_depart_from, rt_arrive_at, rt_charge) VALUES(rt_id_sq.nextval, ?, ?, ?)";
//			try (
//					Connection conn = OjdbcConnection.getConnection(); 
//					PreparedStatement pstmt = conn.prepareStatement(sql);
//				) {
//=======
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

	// Update
	public void updateData(String bi_id, String rt_id, String bi_day, String bi_time) {
		String sql = "UPDATE BUS_INFO SET bi_id = ?, rt_id = ?, bi_day = ?, bi_time = ? WHERE bi_id = ?";
		try (Connection conn = OjdbcConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

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

	// Seat_bi_id_Delete
	public void seat_deleteData(String bi_id) {
		String sql = "DELETE FROM BUS_SEAT WHERE bi_id = ?";
		try (Connection conn = OjdbcConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, Integer.parseInt(bi_id));
			pstmt.executeUpdate();

		} catch (SQLException e) {
		}
	}

	// Bus_Info_bi_id Delete
	public void deleteData(String bi_id) {
		String sql = "DELETE FROM BUS_INFO WHERE bi_id = ?";
		try (Connection conn = OjdbcConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, Integer.parseInt(bi_id));
			pstmt.executeUpdate();

		} catch (SQLException e) {
		}
	}

	// Route_rt_id_Delete
	public void route_deleteData(String rt_id) {
		String sql = "DELETE FROM BUS_ROUTE WHERE rt_id = ?";
		try (Connection conn = OjdbcConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {

			pstmt.setInt(1, Integer.parseInt(rt_id));
			pstmt.executeUpdate();

		} catch (SQLException e) {
		}
	}

	// reservation_Delete
	public void rv_deleteData(String bi_id) {
		String sql = "DELETE FROM BUS_RESERAVATION WHERE bi_id = ?";
		try (Connection conn = OjdbcConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, Integer.parseInt(bi_id));
			pstmt.executeUpdate();

		} catch (SQLException e) {

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
	
	// rt_id_search
	public ArrayList<Seat_Data> idRead(String rt_id) {
		ArrayList<Seat_Data> arr = new ArrayList<Seat_Data>();
		String sql = "SELECT rt_id, bi_id " + "FROM BUS_ROUTE " + "INNER JOIN BUS_INFO USING (rt_id) "
				+ "WHERE rt_id LIKE '%" + rt_id + "%' ORDER BY rt_id";
		try (Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {

			while (rs.next()) {
				arr.add(new Seat_Data(rs.getInt(1), rs.getInt(2)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}

	// bi_id 가져오기
	public void get_bi_id(String rt_id) {
		String sql = "SELECT bi_id FROM bus_info WHERE rt_id = ?";
		try (Connection conn = OjdbcConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, Integer.parseInt(rt_id));
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bi_id_list.add(rs.getInt("bi_id"));
			}

		} catch (SQLException e) {

		}
	}

	// rt_id로 가져온 bi_id 리스트들을 가진 예매내역 다 지우기
	public void rv_delete() {
		String sql = "DELETE FROM bus_reservation WHERE bi_id = ?";
		try (Connection conn = OjdbcConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			for (int i = 0; i < bi_id_list.size(); ++i) {
				pstmt.setInt(1, bi_id_list.get(i));
				pstmt.executeUpdate();
			}

		} catch (SQLException e) {

		}
	}

	// rt_id로 가져온 bi_id 리스트들을 가진 좌석 다 지우기
	public void bs_delete() {
		String sql = "DELETE FROM bus_seat WHERE bi_id = ?";
		try (Connection conn = OjdbcConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			for (int i = 0; i < bi_id_list.size(); ++i) {
				pstmt.setInt(1, bi_id_list.get(i));
				pstmt.executeUpdate();
			}
		} catch (SQLException e) {

		}
	}

	// rt_id를 가진 bi들 다 지우기
	public void bi_delete(String rt_id) {
		String sql = "DELETE FROM bus_info WHERE rt_id = ?";
		try (Connection conn = OjdbcConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, Integer.parseInt(rt_id));
			pstmt.executeUpdate();

		} catch (SQLException e) {

		}
	}

}
