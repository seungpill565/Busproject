package park.frame;

import javax.swing.JFrame;

import an.userinfo.Info_MainFrame;
import hong.SaveInfo;
import park.button.HomeButton;
import park.event.PayInfoButtonEvent;
import park.label.SucceedPayLabel;
import park.panel.RvInfoColumnNamePanel;
import park.panel.RvInfoPanel;

public class PayInfo extends JFrame{
	
	SaveInfo user;

	HomeButton homeBtn;

	SucceedPayLabel payLabel = new SucceedPayLabel(); 
	RvInfoColumnNamePanel columnNamePanel = new RvInfoColumnNamePanel();
	RvInfoPanel routePanel ;
	
	public PayInfo(SaveInfo user) {
		super("예매 완료");
		this.user = user;
		homeBtn = new HomeButton(user);

		homeBtn.addActionListener(new PayInfoButtonEvent(this));
		routePanel = new RvInfoPanel(user);


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
	public void homeButtonEvent() {
		user.remove_bs_map(user.getSeatId(), user.getSeatNames());		
		user.setTotalCharge();
		dispose();
		new Info_MainFrame(user);
	}
	
}
