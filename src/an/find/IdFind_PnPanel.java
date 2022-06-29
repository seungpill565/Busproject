package an.find;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class IdFind_PnPanel extends JPanel{
	
	JLabel pnLabel = new Find_Label("전화번호 : ");
	JTextField pnText = new Find_TextField(10);
	public IdFind_PnPanel(JTextField j) {
		pnText = j;
		
		setLayout(new FlowLayout(FlowLayout.LEADING));
		setBackground(new Color(0X4D7F86));
		
		add(pnLabel); add(pnText);
	}

}
