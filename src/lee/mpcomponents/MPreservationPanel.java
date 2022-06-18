package lee.mpcomponents;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MPreservationPanel extends JPanel {

	
	JPanel MPreservationlistPanel = new JPanel();
	JButton MPreservationcancleBtn = new JButton("예매취소");

	public MPreservationPanel() {
		
		setLayout(null);

		
		//예매내역 없음 라벨 / 예매내역 있음 패널  
		//예매내역 있음 패널 안에는 사용자의 예매티켓 목록이 떠야 하는데 그거 패널로 만들어야 하나... 패널 개수도 예매개수에 따라 변해야겠네
		MPreservationlistPanel.setBounds(65, 30, 390, 350);
		MPreservationlistPanel.setOpaque(true);
		MPreservationlistPanel.setBackground(Color.YELLOW);
		
		
		
		//예매 취소 버튼 설정 (예매내역 없으면 setVisible(false) 해줘야됨 ▲▲▲▲)
		MPreservationcancleBtn.setBounds(400, 400, 90, 38);
		MPreservationcancleBtn.setBorderPainted(false);
		
		
		add(MPreservationlistPanel);
		add(MPreservationcancleBtn);
		
	}
}
