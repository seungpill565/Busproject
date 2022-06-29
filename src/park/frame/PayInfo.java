package park.frame;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import an.userinfo.Info_MainFrame;
import hong.SaveInfo;
import park.button.HomeButton;
import park.event.PayInfoButtonEvent;
import park.label.SucceedPayLabel;
import park.panel.RvInfoColumnNamePanel;
import park.panel.RvInfoPanel;

public class PayInfo extends JFrame{
	
	SaveInfo user;

	private HomeButton homeBtn;
	private SucceedPayLabel payLabel = new SucceedPayLabel(); 
	private RvInfoColumnNamePanel columnNamePanel = new RvInfoColumnNamePanel();
	private RvInfoPanel routePanel ;
	private ImageIcon background = new ImageIcon("image/payimage.jpg");
	private JLabel label = new JLabel();
	
	public PayInfo(SaveInfo user) {
		super("예매 완료");
		this.user = user;
		homeBtn = new HomeButton(new ImageIcon("image/home.png"));

		homeBtn.addActionListener(new PayInfoButtonEvent(this));
		routePanel = new RvInfoPanel(user);
		label.setIcon(background);
		label.setSize(500,600);


		homeBtn.setBounds(190, 480, 100, 50);
		add(label);
		label.add(payLabel);
		label.add(homeBtn);
		label.add(routePanel);
		
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
