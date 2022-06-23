package lee.mpcomponents;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MPreservationlistPanel extends JPanel {
	
	//이 클래스에 예매번호 저장하는 변수 하나 만들어야겠음 그래야 체크박스 눌렀을 때 어떤 예매번호 선택한 건지 알 수 있을 것 같음
	int br_id;//예매번호
	String reservationdetailStr;
	
	
	int MPticketNum;
	
	
	public MPreservationlistPanel(Integer br_id, String reservationdetailStr) {
		
		this.br_id = br_id;//예매번호 받는거 성공!
		this.reservationdetailStr = reservationdetailStr;
		
		
		JLabel MPreservationdetailLb = new JLabel(reservationdetailStr);
		//예매정보 뜨는 라벨 설정
		MPreservationdetailLb.setBounds(20, 0, 300, 150);
		MPreservationdetailLb.setFont(new Font("고딕", Font.BOLD, 14));


		add(MPreservationdetailLb);		

		
		setLayout(null);
		setOpaque(true);
		//setBackground(Color.LIGHT_GRAY);  
		setSize(470, 180);
	}
}
