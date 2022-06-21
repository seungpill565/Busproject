package lee.mpcomponents;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import lee.OjdbcConnection;
import lee.mpmodel.MPreservationlistModel;

public class MPreservationlistPanel extends JPanel {
	
	//이 클래스에 예매번호 저장하는 변수 하나 만들어야겠음 그래야 체크박스 눌렀을 때 어떤 예매번호 선택한 건지 알 수 있을 것 같음
	int br_id;//예매번호
	String reservationdetailStr;
	
	
	JCheckBox MPcheckbox = new JCheckBox();
	
	int MPticketNum;
	
	
	public MPreservationlistPanel(Integer br_id, String reservationdetailStr) {
		
		this.br_id = br_id;//예매번호 받는거 성공!
		this.reservationdetailStr = reservationdetailStr;
		
		
		JLabel MPreservationdetailLb = new JLabel(reservationdetailStr);
		//예매정보 뜨는 라벨 설정
		MPreservationdetailLb.setBounds(20, 0, 300, 150);
		MPreservationdetailLb.setFont(new Font("고딕", Font.BOLD, 14));

		//쳌박 설정
		MPcheckbox.setBounds(400, 77, 18, 18);
		//MPcheckbox.setBackground(Color.LIGHT_GRAY);

		
		
		add(MPreservationdetailLb);		
		add(MPcheckbox);
		
		
		setLayout(null);
		setOpaque(true);
		//setBackground(Color.LIGHT_GRAY);  
		setSize(470, 180);
	}
}
