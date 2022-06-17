package lee.mpcomponents;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MPleavePanel extends JPanel {
	
	
	JLabel MPleaveConfirmLb = new JLabel("정말 탈퇴하시겠습니까?");
	JButton MPleaveYesBtn = new JButton("예");
	
	
	public MPleavePanel() {
		
		setLayout(null);
		
		//탈퇴하시겠? 라벨 설정
		MPleaveConfirmLb.setBounds(30, 30, 400, 60);
		MPleaveConfirmLb.setOpaque(true);
		MPleaveConfirmLb.setBackground(Color.pink);
		
		//예 버튼 설정
		MPleaveYesBtn.setBounds(380, 100, 90, 38);
		MPleaveYesBtn.setBorderPainted(false);
		

		
		
		add(MPleaveConfirmLb);
		add(MPleaveYesBtn);
		
	}
}
