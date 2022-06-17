package lee.mpcomponents;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MPreservationPanel extends JPanel {

	
	JPanel MPreservationlistPanel = new JPanel();
	JButton MPreservationcancleBtn = new JButton("예매취소");

	public MPreservationPanel() {
		
		setLayout(null);

		MPreservationlistPanel.setBounds(65, 30, 390, 350);
		MPreservationlistPanel.setOpaque(true);
		MPreservationlistPanel.setBackground(Color.PINK);
		
		/*
		JLabel MPreservationLb = new JLabel("현재 예매내역이 존재하지 않습니다.");
		이걸 패널로 바꿔서 예매내역 없음 라벨 / 예매내역 있음 패널 띄워야 함 
		예매내역 있음 패널 안에는 사용자의 예매티켓 목록이 떠야 하는데 그거 패널로 만들어야 하나... 패널 개수도 예매개수에 따라 변해야겠네
	
		//예매내역 띄울 라벨 설정 (존재하지 x / 예매내역) 
		MPreservationLb.setOpaque(true);
		MPreservationLb.setBackground(Color.PINK);
		MPreservationLb.setBounds(65, 30, 450, 350);
		MPreservationLb.setFont(new Font("궁서체", Font.PLAIN, 17));
		
		add(MPreservationLb);
		*/
				
		//예매 취소 버튼 설정 (예매내역 없으면 setVisible(false))
		MPreservationcancleBtn.setBounds(400, 400, 90, 38);
		MPreservationcancleBtn.setBorderPainted(false);
		
		
		add(MPreservationlistPanel);
		add(MPreservationcancleBtn);
	}

	
}
