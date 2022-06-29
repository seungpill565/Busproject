package an.find;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Find_ButtonPanel extends JPanel{
	JButton id = new Find_Button("아이디 찾기");
	JButton pass = new Find_Button("비밀번호 찾기"); 
	
	
	public Find_ButtonPanel(JButton i, JButton p) {
		setBackground(new Color(0X4D7F86));
		this.id= i;
		this.pass = p;
		
		setLayout(new FlowLayout());
		add(id);
		add(pass);
		
		
	}

	

}
