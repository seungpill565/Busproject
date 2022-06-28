package lee.mpcomponents;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

//예매내역 없을 때 패널
public class MPreservationPanel_1 extends JPanel {

	
	JLabel MPnoreservationLb = new JLabel("현재 예매내역이 존재하지 않습니다.");
	
	public MPreservationPanel_1() {
		
		setLayout(null);
		
		
		MPnoreservationLb.setBounds(30, 30, 300, 30);
		MPnoreservationLb.setFont(new Font("고딕", Font.BOLD, 15));
		add(MPnoreservationLb);
	}
	
	
}
