package lee.mpmodel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
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
	
	
	
	public double totalCharge() {
		if(br_age_group.equals("성인")) {
			return rt_charge * 1;
		} else if(br_age_group.equals("청소년")) {
			return rt_charge * 0.85;
		} else if(br_age_group.equals("아동")) {
			return rt_charge * 0.7;
		}
		return 0; 
	}
	
	
	
	
	public Integer getBr_id() {
		return br_id;
	}
	
	
	
	public static void delete_user_id_row(Connection conn, String user_id) {
		String sql = "DELETE FROM bus_reservation WHERE user_id = ?";
		try(PreparedStatement pstmt = conn.prepareStatement(sql); ) {
			pstmt.setString(1, user_id);
			System.out.println("user_id의 행 삭제 성공? : " + pstmt.executeUpdate());
		} catch (SQLException e) {
			System.out.println("행 삭제 안 됨");
		}
	}
	

	
	public static void delete_bs_id_row(Connection conn, int bs_id) {
		String sql = "DELETE FROM bus_seat WHERE bs_id = ?";
		try(PreparedStatement pstmt = conn.prepareStatement(sql); ) {	
			pstmt.setInt(1, bs_id);
			System.out.println("bs_id의 행 삭제 성공? : " + pstmt.executeUpdate());	
		} catch (SQLException e) {
			System.out.println("삭제 안 됨");
		}
	}
	

//●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●
	// bs_id(버스좌석 아이디. 좌석번호 아님!) 에 해당하는 좌석예매여부 (1= 예매됨, 0=예매안됨)를 1에서 0으로 바꾸는 메서드
	public static void update_bs_is_reserved(Connection conn, int bs_id) {
		String sql = "UPDATE bus_seat SET bs_is_reserved = 0 WHERE bs_id = ?";
		try(PreparedStatement pstmt = conn.prepareStatement(sql); ) {	
			
			pstmt.setInt(1, bs_id);
			
			System.out.println("bs_id에 해당하는 bs_is_reserved 0으로 바꾸기 성공? : " + pstmt.executeUpdate());	
		
		} catch (SQLException e) {
			System.out.println("삭제 안 됨");
		}
	}
//●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●	
	
	
	
	
	
	public static void delete_br_id_row(Connection conn, int br_id) {
		String sql = "DELETE FROM bus_reservation WHERE br_id = ?";
		try(PreparedStatement pstmt = conn.prepareStatement(sql); ) {
			pstmt.setInt(1, br_id);
			System.out.println("br_id의 행 삭제 성공? : " + pstmt.executeUpdate());	
		} catch (SQLException e) {
			System.out.println("");
		}
	}
	
	
	
	
	//user_info 입력하면 bs_id들 구해서 ArrayList에 담아주는 메서드 
	public static ArrayList<Integer> get_bs_id(Connection conn, String user_id) {
		ArrayList<Integer> bs_id_list = new ArrayList<>();
		String sql = "SELECT user_id, br_id, bs_id"
				+ " FROM user_info"
				+ " INNER JOIN bus_reservation USING(user_id)"
				+ " INNER JOIN bus_seat USING (bs_id)"
				+ " WHERE user_id = ?";
		
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql); ) {
			
			pstmt.setString(1, user_id);
			
			try(ResultSet rs = pstmt.executeQuery();) {
				while(rs.next() ) {
					bs_id_list.add(rs.getInt("bs_id"));
				}
			}
			
		} catch (SQLException e) {
			System.out.println("");
		}
		return bs_id_list;
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
			System.out.println("");
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
	
	
	//회원아이디를 입력하면 오늘 날짜 이후의 예매 내역에 대한 데이터(행)를 반환하는 메서드
	public static ArrayList<MPreservationlistModel> get(Connection conn, String user_id) {
		
		ArrayList<MPreservationlistModel> list = new ArrayList<>();
		
		//오늘 날짜 구하기
		String[] split1 = LocalDate.now().toString().split("-");
		String join1 = String.join("/", split1);
		String today = join1.substring(2);
		String time = LocalTime.now().toString().substring(0, 5);
		//내일날짜 구하기
		String[] split2 = LocalDate.now().plusDays(1).toString().split("-");
		String join2 = String.join("/", split2);
		String tomorrow = join2.substring(2);
		
		//현재 시간 이후의 오늘 티켓만 조회
		String sql1 = "SELECT br_id, bi_day, bi_time, rt_depart_from,"
				+ "rt_arrive_at, bs_name, br_age_group, rt_charge, bs_is_reserved"
				+ " FROM user_info"
				+ " INNER JOIN bus_reservation USING(user_id)"
				+ " INNER JOIN bus_info USING (bi_id)"
				+ " INNER JOIN bus_route USING (rt_id)"
				+ " INNER JOIN bus_seat USING (bs_id)"
				+ " WHERE user_id = ?"
				+ " AND bus_seat.bs_is_reserved = 1"
				+ " AND bus_info.bi_day = ?"
				+ " AND bus_info.bi_time >= ?"
				+ " ORDER BY bus_info.bi_time";
		
		//내일 이후의 티켓 조회
		String sql2 = "SELECT br_id, bi_day, bi_time, rt_depart_from,"
				+ "rt_arrive_at, bs_name, br_age_group, rt_charge, bs_is_reserved"
				+ " FROM user_info"
				+ " INNER JOIN bus_reservation USING(user_id)"
				+ " INNER JOIN bus_info USING (bi_id)"
				+ " INNER JOIN bus_route USING (rt_id)"
				+ " INNER JOIN bus_seat USING (bs_id)"
				+ " WHERE user_id = ?"
				+ " AND bus_seat.bs_is_reserved = 1"
				+ " AND bus_info.bi_day >= ?"
				+ " ORDER BY bus_info.bi_day, bus_info.bi_time";
		
		//현재 시간 이후의 오늘 티켓 정보 list에 저장
		try(PreparedStatement pstmt1 = conn.prepareStatement(sql1);) {
			pstmt1.setString(1, user_id);
			pstmt1.setString(2, today);
			pstmt1.setString(3, time);
			try(ResultSet rs = pstmt1.executeQuery();) {
				while(rs.next() ) {
					list.add(new MPreservationlistModel(rs));
				}
			}
		//내일 이후의 티켓 정보 list에 저장
		try(PreparedStatement pstmt2 = conn.prepareStatement(sql2);) {
			pstmt2.setString(1, user_id);
			pstmt2.setString(2, tomorrow);
			try(ResultSet rs = pstmt2.executeQuery();) {
				while(rs.next() ) {
					list.add(new MPreservationlistModel(rs));
				}
			}	
		}	
					
		} catch (SQLException e) {
			System.out.println("예매내역 없음");
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
			br_id, bi_day, bi_time, rt_depart_from, rt_arrive_at, bs_name, br_age_group, Math.round(totalCharge()));
	}

	

	
	
} 
