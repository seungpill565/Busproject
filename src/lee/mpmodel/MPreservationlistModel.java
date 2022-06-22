package lee.mpmodel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class MPreservationlistModel {
	
	// 예매번호
	Integer br_id;
	//날짜, 시간
	String bi_day;
	String bi_time;
	//출발지, 도착지
	String rt_depart_from;
	String rt_arrive_at;
	//좌석번호
	String bs_name;
	//최종 요금 구하기 위해서 연령구분, 요금
	String br_age_group;
	Integer  rt_charge;
//-------------------------------------
	Integer bs_id; //좌석 id
	
	
	
	
	public Integer getBr_id() {
		return br_id;
	}
	

	
	public static void delete_bs_id_row(Connection conn, int bs_id) {
		String sql = "DELETE FROM bus_seat WHERE bs_id = ?";
		try(PreparedStatement pstmt = conn.prepareStatement(sql); ) {	
			pstmt.setInt(1, bs_id);
			System.out.println("bs_id의 행 삭제 성공? : " + pstmt.executeUpdate());	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void delete_br_id_row(Connection conn, int br_id) {
		String sql = "DELETE FROM bus_reservation WHERE br_id = ?";
		try(PreparedStatement pstmt = conn.prepareStatement(sql); ) {
			pstmt.setInt(1, br_id);
			System.out.println("br_id의 행 삭제 성공? : " + pstmt.executeUpdate());	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	//Bus_Seat + Bus_Reservation 이너조인 해서 예매번호를 매개변수로 전달하면 bs_id(좌석id)를 리턴하는 메서드
	public static int get_bs_id(Connection conn, int br_id) {
		
		String sql = "SELECT bs_id, br_id FROM bus_seat INNER JOIN bus_Reservation USING(bs_id) WHERE br_id = ?";
				
		int bs_id = 0;
		try(PreparedStatement pstmt = conn.prepareStatement(sql); ) {
			
			pstmt.setInt(1, br_id);
			
			try(ResultSet rs = pstmt.executeQuery();) {
				while(rs.next() ) {
					bs_id = rs.getInt("bs_id");
				}
			}
						
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bs_id;
	}
	
	
	
	
	
	
	
	//특정 예매번호를 입력하면 해당 예매번호의 행을 반환하는 메서드
	public static MPreservationlistModel get(Connection conn, int br_id) {
	
		String sql = 
				"SELECT br_id, bi_day, bi_time, rt_depart_from, rt_arrive_at, bs_name, br_age_group, rt_charge"
				+ " FROM user_info"
				+ " INNER JOIN bus_reservation USING(user_id)"
				+ " INNER JOIN bus_info USING (bi_id)"
				+ " INNER JOIN bus_route USING (rt_id)"
				+ " INNER JOIN bus_seat USING (bs_id)"
				+ " WHERE br_id = ?";
		
		MPreservationlistModel result = null;
		try(
				PreparedStatement pstmt = conn.prepareStatement(sql); 
						
		) {
			pstmt.setInt(1, br_id);
			
			try(ResultSet rs = pstmt.executeQuery();) {
				while(rs.next() ) {
					result = new MPreservationlistModel(rs);
				}
			}
						
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	//회원아이디와 오늘 날짜를 입력하면 오늘 날짜 이후의 예매 내역에 대한 데이터(행)를 반환하는 메서드
	public static ArrayList<MPreservationlistModel> get(Connection conn, String user_id, String todaysDate) {
		ArrayList<MPreservationlistModel> list = new ArrayList<>();
		
		
		String sql = 
				"SELECT br_id, bi_day, bi_time, rt_depart_from, rt_arrive_at, bs_name, br_age_group, rt_charge"
				+ " FROM user_info"
				+ " INNER JOIN bus_reservation USING(user_id)"
				+ " INNER JOIN bus_info USING (bi_id)"
				+ " INNER JOIN bus_route USING (rt_id)"
				+ " INNER JOIN bus_seat USING (bs_id)"
				+ " WHERE user_id = ?"
				+ " AND bus_info.bi_day >= ?";
		try(
				PreparedStatement pstmt = conn.prepareStatement(sql); 
						
		) {
			
			pstmt.setString(1, user_id);
			pstmt.setString(2, todaysDate);
			
			try(ResultSet rs = pstmt.executeQuery();) {
				while(rs.next() ) {
					list.add(new MPreservationlistModel(rs));
				}
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	public static ArrayList<MPreservationlistModel> getAll(Connection conn) {
		ArrayList<MPreservationlistModel> list = new ArrayList<>();
		
		String sql = 
				"SELECT br_id, bi_day, bi_time, rt_depart_from, rt_arrive_at, bs_name, br_age_group, rt_charge"
				+ " FROM user_info"
				+ " INNER JOIN bus_reservation USING(user_id)"
				+ " INNER JOIN bus_info USING (bi_id)"
				+ " INNER JOIN bus_route USING (rt_id)"
				+ " INNER JOIN bus_seat USING (bs_id)"
				+ " WHERE user_id = 'abc123'"
				+ " AND bus_info.bi_day >= '22/06/20'";
		try(
				PreparedStatement pstmt = conn.prepareStatement(sql); 
				ResultSet rs = pstmt.executeQuery();		
		) {
			while(rs.next() ) {
				list.add(new MPreservationlistModel(rs));
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public MPreservationlistModel(ResultSet rs) throws SQLException {
		br_id = rs.getInt("br_id");
		bi_day = rs.getString("bi_day");
		bi_time = rs.getString("bi_time");
		rt_depart_from = rs.getString("rt_depart_from");
		rt_arrive_at = rs.getString("rt_arrive_at");
		bs_name = rs.getString("bs_name");
		br_age_group = rs.getString("br_age_group");
		rt_charge = rs.getInt("rt_charge");
	}
	
	
	@Override
	public String toString() {	
		return String.format("<html><pre style=\"font-family:고딕;\">예매번호 : %s<br>"
			+ "%s  %s<br>"
			+ "%s - %s<br>"
			+ "좌석 : %s<br>"
			+ "연령구분 : %s<br>"
			+ "요금 : %d</pre></html>",
			br_id, bi_day, bi_time, rt_depart_from, rt_arrive_at, bs_name, br_age_group, rt_charge);
	}

	
	//나중에 지우기
	public static void main(String[] args) {
		
		/* 테스트 코드 (정상작동함)
		Connection conn;
		try {
			conn = OjdbcConnection.getConnection();
			//System.out.println(getAll(conn));
			//System.out.println(getAll(conn).get(1));
			//System.out.println(get(conn, 10010));
			//System.out.println(get(conn, "abc123", "22/06/20"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		*/
		
		
	}
	
	
} 
