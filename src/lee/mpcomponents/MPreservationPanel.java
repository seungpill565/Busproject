package lee.mpcomponents;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MPreservationPanel extends JPanel {

	
	JLabel MPreservationLb = new JLabel("현재 예매내역이 존재하지 않습니다.");
	JButton MPreservationcancleBtn = new JButton("예매취소");

	public MPreservationPanel() {
		
		setLayout(null);
		
		//예매내역 띄울 라벨 설정 (존재하지 x / 예매내역) 
		MPreservationLb.setOpaque(true);
		MPreservationLb.setBackground(Color.PINK);
		MPreservationLb.setBounds(65, 30, 450, 350);
		MPreservationLb.setFont(new Font("궁서체", Font.PLAIN, 17));
		
		//예매 취소 버튼 설정 (예매내역 없으면 setVisible(false))
		MPreservationcancleBtn.setBounds(450, 400, 90, 38);
		MPreservationcancleBtn.setBorderPainted(false);
		
		
		add(MPreservationLb);
		add(MPreservationcancleBtn);
	}

	
}
