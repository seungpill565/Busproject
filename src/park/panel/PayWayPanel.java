package park.panel;

import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.JPanel;

import park.button.CardPay;
import park.button.SamsungPay;

public class PayWayPanel extends JPanel {
	
	CardPay card = new CardPay();
	SamsungPay samsung = new SamsungPay();
	
	public PayWayPanel() {
		LayoutManager manager = new FlowLayout(FlowLayout.CENTER); // 판넬의 레이아웃을 왼쪽부터 일렬로 컴포넌트를 출력하는 형태로 설정
		setLayout(manager);
		add(card);
		add(samsung);
		add(samsung);
			
	
		setBounds(10, 300, 500, 60);
	}

}
