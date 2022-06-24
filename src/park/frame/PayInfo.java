package park.frame;

import javax.swing.JFrame;

import park.ReservationInfo;
import park.button.HomeButton;
import park.label.SucceedPayLabel;

public class PayInfo extends JFrame{
	
	ReservationInfo user;
	HomeButton homeBtn = new HomeButton(user);
	SucceedPayLabel payLabel = new SucceedPayLabel(); 
	
	public PayInfo(ReservationInfo user) {
		super("예매 완료");
		this.user = user;
		homeBtn.setBounds(190, 500, 100, 50);
		add(payLabel);
		add(homeBtn);
		
		setLayout(null);
		setResizable(false);
		setBounds(100,100,500,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
}
