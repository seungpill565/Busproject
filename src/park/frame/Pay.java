package park.frame;

import javax.swing.JFrame;

import park.ReservationInfo;
import park.panel.HomeBeforeBtnPanel;
import park.panel.PayWayPanel;

public class Pay extends JFrame{ // 결제 방식 고르고 결제할 화면
	
	static ReservationInfo user;
	static HomeBeforeBtnPanel panel1 = new HomeBeforeBtnPanel(); // 홈버튼, 이전버튼이 들어가는 판넬 (플로우레이아웃)
	static PayWayPanel payPanel = new PayWayPanel();
	
	public Pay(ReservationInfo user) {
		super("결제 화면");
		this.user = user;
		add(panel1); 
		add(payPanel);
		
		setLayout(null);
		setBounds(100,100,500,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Pay(user);
	}
}
