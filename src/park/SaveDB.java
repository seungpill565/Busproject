package park;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SaveDB {

	public SaveDB(ReservationInfo user) { // 결제수단 , 연령, 유저아이디, 버스 아이디, 좌석id
		String sql = "insert into bus_reservation values (br_id_sq.nextval, ?, ?, ?,?,?) "; // 유저 1 버스 1000 좌석 1
		
		String sql2 = "update bus_seat set bu_is_reserved = '0' where bs_id = ?";

		try(Connection conn = OjdbcConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			PreparedStatement pstmt2 = conn.prepareStatement(sql2);
		){		// execute() 업데이트만 executeUpdate() int형으로 반환, executeQuery() resultset에 담을 수 있다
			System.out.println("db 진입 성공");
			for(int i=0;i<user.getSeatSize();i++) {
		    // 	int i=0;
				System.out.println("포문 시작");
				pstmt.setString(1, user.getPayWay());
				pstmt.setString(2, user.getAgeBySeat().get(user.getSeatKeys().get(i)));
				pstmt.setString(3, user.getUserId());
				pstmt.setInt(4, user.getBusId());
				pstmt.setInt(5, user.getSeatKeys().get(i));
				System.out.println("익스큐트 직전");
				pstmt.executeUpdate();
				System.out.println("sql1 실행 끝");
				
				pstmt2.setInt(1, user.getSeatKeys().get(i));
				pstmt2.execute();
				System.out.println("포문 끝");
		
			}
			
			System.out.println("DB저장 성공");
				
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DB저장 실패");
		}
	}
		//String sql = "insert into bus_reservation values (br_id_sq.nextval, ?, ?, ?,?,?) ";
		//+ "\r\n";
		//String sql =  "delete from artist where artist_name = ? "; 
 //String sql = "insert into artist values(?, ?, ?, ?); ";
//
//		try(Connection conn = OjdbcConnection.getConnection();
//				PreparedStatement pstmt = conn.prepareStatement(sql);	
//				) {
//			pstmt.setString(1,  "nell");
////			pstmt.setString(2,  "아");
////			pstmt.setInt(3,  1111);
////			pstmt.setString(4,  "t");
//			//pstmt.setInt(5,  1);
//			//pstmt.setString(1, "김건모" );
//
//			int row = pstmt.executeUpdate();
//
//			System.out.println(row + " row(s) update");
//
//		}catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
	public static void main(String[] args) {
		new SaveDB(new ReservationInfo());
	}
}

//String sql3 = "select br_id from bus_reservation inner join user_info using(user_id) "
//+ "inner join bus_info using(bi_id) "
//+ "inner join bus_seat using(bs_id) "
//+ "where user_id = ? and bi_id = ? and bs_id ?";