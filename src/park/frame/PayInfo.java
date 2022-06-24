package park.frame;

import javax.swing.JFrame;

import hong.SaveInfo;
import park.ReservationInfo;
import park.button.HomeButton;
import park.label.SucceedPayLabel;
import park.panel.RouteInfoColumnNamePanel;
import park.panel.RouteInfoPanel;

public class PayInfo extends JFrame{
	
	SaveInfo user;
	HomeButton homeBtn = new HomeButton(user);
	SucceedPayLabel payLabel = new SucceedPayLabel(); 
	RouteInfoColumnNamePanel columnNamePanel = new RouteInfoColumnNamePanel();
	RouteInfoPanel routePanel ;
	
	public PayInfo(SaveInfo user) {
		super("예매 완료");
		this.user = user;
		//new LoadRVID(user); // 시퀀스로 저장되는 예매번호들 user에 저장하고 출력
		routePanel = new RouteInfoPanel(user);
		homeBtn.setBounds(190, 500, 100, 50);
		add(payLabel);
		add(homeBtn);
		add(routePanel);
		
		setLayout(null);
		setResizable(false);
		setBounds(100,100,500,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
}
