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
import lee.mpmodel.MPuserinfoModel;

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
	
	String MPprofileLbStr;
	
	JLabel MPprofileLb = new JLabel(MPprofileLbStr); 
	
	JButton MPeditBtn = new JButton("수정하기");
	
	public MPprofilePanel_1() {	 
		setLayout(null);
	
		try (
				Connection conn = OjdbcConnection.getConnection();				
				PreparedStatement pstmt = conn.prepareStatement("SELECT user_name, user_phonenum FROM user_info WHERE user_id = ?;");
				ResultSet rs = pstmt.executeQuery();
		){
			pstmt.setString(1, user_id);
			
			MPprofileLbStr = new MPuserinfoModel(rs).toString();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	
		

		
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
