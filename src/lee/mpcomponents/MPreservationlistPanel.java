package lee.mpcomponents;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MPreservationlistPanel extends JPanel {
	
	//이 클래스에 예매번호 저장하는 변수 하나 만들어야겠음 그래야 체크박스 눌렀을 때 어떤 예매번호 선택한 건지 알 수 있을 것 같음 ▲
	
	JLabel MPreservationdetailLb = new JLabel(
			"<html>예매번호 : 01204<br>"
			+ "2022/05/12  12시 24분<br>"
			+ "동서울 고속 터미널 - 속초 고속 터미널<br>"
			+ "좌석 : 01<br>"
			+ "연령구분 : 어린이<br>"
			+ "요금 : 5500(할인 적용 값)</html>"); //이건 예시. db에서 내려 받은 정보로 바꾸기
	
	JCheckBox MPcheckbox = new JCheckBox();
	
	
	public MPreservationlistPanel() {
		
		setLayout(null);
		setOpaque(true);
		//setBackground(Color.LIGHT_GRAY);  
		setSize(470, 180);
		
		
		//예매정보 뜨는 라벨 설정
		MPreservationdetailLb.setBounds(20, 0, 300, 150);
		MPreservationdetailLb.setFont(new Font("고딕", Font.BOLD, 14));
		
		
		//쳌박 설정
		MPcheckbox.setBounds(400, 77, 18, 18);
		//MPcheckbox.setBackground(Color.LIGHT_GRAY);
		
		
		add(MPreservationdetailLb);		
		add(MPcheckbox);
	}
}
