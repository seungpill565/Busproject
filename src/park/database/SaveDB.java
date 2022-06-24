package park.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import park.OjdbcConnection;
import park.ReservationInfo;

public class SaveDB {

	public SaveDB(ReservationInfo user) { // 결제수단 , 연령, 유저아이디, 버스 아이디, 좌석id
		String sql = "insert into bus_reservation values (br_id_sq.nextval, ?, ?, ?,?,?) "; // 유저 1 버스 1000 좌석 1

		String sql2 = "update bus_seat set bu_is_reserved = '1' where bs_id = ?";

		try(Connection conn = OjdbcConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			PreparedStatement pstmt2 = conn.prepareStatement(sql2);
			){		// execute() 업데이트만 executeUpdate() int형으로 반환, executeQuery() resultset에 담을 수 있다
			System.out.println("db 진입 성공");
			for(int i=0;i<user.getSeatSize();i++) {
				System.out.println("포문 시작");
				pstmt.setString(1, user.getPayWay()); // 결제방식
				pstmt.setString(2, user.getAgeBySeat().get(user.getSeatId().get(i))); // 해당 좌석에 대한 연령 
				pstmt.setString(3, user.getUserId()); // 유저id
				pstmt.setInt(4, user.getBusId()); // 버스 id
				pstmt.setInt(5, user.getSeatId().get(i)); // 0번째 부터 들어있는 좌석의 번호
				pstmt.executeUpdate();
				// -------------------------
				pstmt2.setInt(1, user.getSeatId().get(i));
				pstmt2.execute();
			}
			
			System.out.println("DB저장 성공");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DB저장 실패");
		}
	}
}

//String sql3 = "select br_id from bus_reservation inner join user_info using(user_id) "
//+ "inner join bus_info using(bi_id) "
//+ "inner join bus_seat using(bs_id) "
//+ "where user_id = ? and bi_id = ? and bs_id ?";