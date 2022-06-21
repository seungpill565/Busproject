package lee.mpcomponents;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import lee.OjdbcConnection;
import lee.mpmodel.MPprofileModel;

public class MPprofilePanel_1 extends JPanel {

	String user_id = "abc123"; //얘는 홈 프레임에서 받았다고 치고 ★ 
	
	
	/*
	String MPprofile = 
			"<html><pre style=\"font-family:고딕;\">아이디    : " + user_id 
			+ "<br><br>이름       : " + user_name + 
			"<br><br>연락처    : " + phoneNum + 
			"</pre><html/>";	
	 */
		
	//JLabel MPprofileLb = new JLabel(MPprofile); 
	
	JButton MPeditBtn = new JButton("수정하기");
	
	public MPprofilePanel_1() {	 
		setLayout(null);
	
		
		String sql = "SELECT user_id, user_name, user_phonenum FROM user_info WHERE user_id = ?";
		String MPprofileLbStr = "";
		
		try (
				Connection conn = OjdbcConnection.getConnection();				
				PreparedStatement pstmt = conn.prepareStatement(sql);		
		){
			pstmt.setString(1, "abc123");  // 아 pstmt.setString()로 물음표 먼저 채워주고 rs써야됨!
		
			try(ResultSet rs = pstmt.executeQuery();){
				while(rs.next()) {
					MPprofileLbStr = new MPprofileModel(rs).toString();				
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		//이거 여기 있어야겠네 멤버변수로 선언하면 라벨에 글자가 안 나타남
		JLabel MPprofileLb = new JLabel(MPprofileLbStr);
		

		
		//프로필라벨 설정
		MPprofileLb.setOpaque(true);//나중에 삭제 
		//MPprofileLb.setBackground(Color.PINK);
		MPprofileLb.setFont(new Font("고딕", Font.BOLD, 18)); 
		MPprofileLb.setBounds(50, 50, 390, 200);
		MPprofileLb.setVerticalAlignment(JLabel.TOP);
		
		
		//수정하기 버튼 설정
		MPeditBtn.setBounds(400, 400, 90, 38);
		MPeditBtn.setBorderPainted(false);
		
		
		add(MPprofileLb);
		add(MPeditBtn);		
	}
	
}
