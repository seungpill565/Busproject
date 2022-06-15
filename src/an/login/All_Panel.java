package an.login;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class All_Panel extends JPanel{
	JPanel idpanel = new IdPanel();
	JPanel idPanel2 = new IdPanel2();
	
	JPanel pwdPanel = new pwdPanel();
	JPanel pwdPanel2 = new pwdPanel2();
	
	JPanel loginPanel = new loginPanel();
	JPanel joinPanel = new JoinPanel();
	JPanel findPanel = new findPanel();
	
	
	public All_Panel() {
		setLayout(new GridLayout(3, 2));
		
		add(idpanel);add(idPanel2);
		add(pwdPanel);add(pwdPanel2);
		add(loginPanel);add(joinPanel); 
	}

}
