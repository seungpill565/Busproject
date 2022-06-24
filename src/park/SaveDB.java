package park;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SaveDB {

	public SaveDB(ReservationInfo user) { // 결제수단 , 연령, 유저아이디, 버스 아이디, 좌석id
		String sql = "insert into bus_reservation values(br_id_sq.nextval, ?, ?, ?,?,?);\r\n"
				+ "update bus_seat set bs_is_reservated = 1 where bs_id = ?";
		
		String sql2 = "select br_id from bus_reservation inner join user_info using(user_id) "
				+ "inner join bus_info using(bi_id) "
				+ "inner join bus_seat using(bs_id) ";
		// execute() 업데이트만 executeUpdate() int형으로 반환, executeQuery() resultset에 담을 수 있다
//		select tml_depart_from, tml_arrive_at, bi_time, bi_day, bs_name 
//		from terminal 
//		    inner join bus_info using(tml_id)
//		    inner join bus_seat using(bi_id)
//		where user_id = 'test1';
		
		try(Connection conn = OjdbcConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			PreparedStatement pstmt2 = conn.prepareStatement(sql2);
		){
			pstmt.setString(1, user.getPayWay());
			pstmt.setString(2, user.getAge());
			pstmt.setString(3, user.getUserId());
			pstmt.setInt(4, user.getBusId());
			pstmt.setInt(5, user.getSeatId());
			pstmt.setInt(6, user.getSeatId());
			pstmt.execute();
			
			pstmt2.setString(1, sql2);
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
