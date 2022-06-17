package lee.mpcomponents;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MPnavPanel extends JPanel {
	
	// 홈버튼은 누르면 무조건 버스예약프로그램 처음으로 돌아가고
	
	
	// 나머지 버튼은 누르면 각 버튼에 해당하는 패널들이 MP메인프레임에 뜨도록
	JButton MPprofileBtn = new JButton("내 정보 조회/수정");
	JButton MPreservationBtn = new JButton("예매 확인");
	JButton MPleaveBtn = new JButton("계정 탈퇴");
	
	GridLayout gl = new GridLayout(3, 1);
	
	public MPnavPanel() {
		
		setLayout(gl);
		
		MPprofileBtn.setBorderPainted(false);
		MPreservationBtn.setBorderPainted(false);
		MPleaveBtn.setBorderPainted(false);
		add(MPprofileBtn);
		add(MPreservationBtn);
		add(MPleaveBtn);
	
		
		setBackground(Color.CYAN);
		setBounds(0, 120, 180, 150);
		setVisible(true);
	}
	
}
