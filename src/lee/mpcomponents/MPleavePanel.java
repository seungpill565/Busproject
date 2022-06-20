package lee.mpcomponents;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MPleavePanel extends JPanel {
	
	
	JLabel MPleaveConfirmLb = new JLabel("Á¤¸» Å»ÅðÇÏ½Ã°Ú½À´Ï±î?");
	JButton MPleaveYesBtn = new JButton("¿¹");
	
	
	public MPleavePanel() {
		
		setLayout(null);
		
		//Å»ÅðÇÏ½Ã°Ú? ¶óº§ ¼³Á¤
		MPleaveConfirmLb.setBounds(30, 30, 300, 60);
		MPleaveConfirmLb.setOpaque(true);
		MPleaveConfirmLb.setFont(new Font("°íµñ", Font.BOLD, 15));
		//MPleaveConfirmLb.setBackground(Color.pink);
		
		//¿¹ ¹öÆ° ¼³Á¤
		MPleaveYesBtn.setBounds(380, 100, 90, 38);
		MPleaveYesBtn.setBorderPainted(false);
		MPleaveYesBtn.setFont(new Font("°íµñ", Font.BOLD, 13));
		
		
		add(MPleaveConfirmLb);
		add(MPleaveYesBtn);
		
	}
}
