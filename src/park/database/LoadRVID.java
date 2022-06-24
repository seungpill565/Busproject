package park.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import park.OjdbcConnection;
import park.ReservationInfo;

public class LoadRVID { // 결제 후 db에 저장되면 예매번호가 생성되고 그걸 다시 user에 예매번호로 넣어준다

	public LoadRVID(ReservationInfo user) {
		String sql = "select br_id from bus_reservation where user_id = ? and bi_id = ? and bs_id = ?";
		
		try(Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);

			){
			for(int i=0 ; i<user.getSeatSize();i++) {
				pstmt.setString(1, user.getUserId());
				pstmt.setInt(2,  user.getBusId());
				pstmt.setInt(3, user.getSeatId().get(i));

				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					user.setReservationId(rs.getInt("br_id"));
				}
				System.out.println("db불러오기 성공");
			}
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DB불러오기 실패");
		}
	}
}
