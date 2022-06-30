package lee.mpcomponents;

import java.awt.CardLayout;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import an.OjdbcConnection;
import hong.SaveInfo;
import lee.mpmodel.MPprofileModel;

public class MPprofilePanel extends JPanel {

	
	SaveInfo saveInfo;
	String user_id; //나중에 수정

	MPprofilePanel_1 MPprofile_1;
	MPprofilePanel_2 MPprofile_2;
	
	CardLayout MPprofileCard = new CardLayout();

	
	public MPprofilePanel(SaveInfo saveInfo) {
		this.saveInfo = saveInfo;
		this.user_id = saveInfo.get_user_id();
		
		MPprofile_1 = new MPprofilePanel_1();
		MPprofile_2 = new MPprofilePanel_2();
		
		setLayout(MPprofileCard);

		add("내정보 보기", MPprofile_1);
		add("내정보 수정", MPprofile_2);

		
		ImageIcon backImg = new ImageIcon("image/mp컨텐츠패널배경.png");
		JLabel backLb = new JLabel(backImg);
		backLb.setBounds(0, 0, 510, 460);
		add(backLb);		

		//MPprofile_1에 회원정보 띄우기_________________________________________________________________________________________
		//데이터모델의 메서드를 이용해 회원정보를 String으로 가져온 후 프로필라벨에 넣기
		String MPprofileLbStr = MPprofileModel.MPprofileInfo(user_id);
		JLabel MPprofileLb = new JLabel(MPprofileLbStr);
		//프로필라벨 설정
		MPprofileLb.setOpaque(true);//나중에 삭제 
		MPprofileLb.setFont(new Font("고딕", Font.BOLD, 18)); 
		MPprofileLb.setBounds(50, 50, 390, 200);
		MPprofileLb.setVerticalAlignment(JLabel.TOP);
		MPprofile_1.add(MPprofileLb);
		//_________________________________________________________________________________________________________________
		
		//MPprofile_2의 tf들에 회원정보가 기본으로 떠 있게___________________________________________________________________________
		try (Connection conn = OjdbcConnection.getConnection();){
			//이름
			MPprofile_2.MPnameTf.setText(MPprofileModel.MPgetUserName(conn, user_id));		
			//핸드폰번호
			String str = MPprofileModel.MPgetUserPhoneNum(conn, user_id);
			String[] arr = str.split("-");
			MPprofile_2.MPphoneTf_1.setText(arr[0]);
			MPprofile_2.MPphoneTf_2.setText(arr[1]);
			MPprofile_2.MPphoneTf_3.setText(arr[2]);
			//비밀번호
			MPprofile_2.MPnewpwTf.setText(MPprofileModel.MPgetUserPw(conn, user_id));	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//__________________________________________________________________________________________________________________	
	}
	

	public void showMPprofile_2() {
		MPprofileCard.show(this, "내정보 수정");
	}
	
	
	public void showMPprofile_1() {
		MPprofileCard.show(this, "내정보 보기");
	}
	
}
