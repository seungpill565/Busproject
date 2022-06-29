package an.find;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import an.find.action.Find_IdAction;
import an.find.action.Find_PassAction;

public class Find_MainFrame extends JFrame{
	ImageIcon idimage = new ImageIcon("image/findid.png");
	ImageIcon passimage = new ImageIcon("image/findpass.png");
	
	JButton id = new Find_Button("아이디 찾기");
	JButton pass = new Find_Button("비밀번호 찾기"); 
	
	
	public Find_MainFrame() {
		id.setText("");
		id.setIcon(idimage);
		
		pass.setText("");
		pass.setIcon(passimage);
		
		JPanel main  = new Find_Panel();
		JPanel bt = new Find_ButtonPanel(id,pass);
		
		/////////////////////////////////////////////////////////////
		Find_IdAction idevent = new Find_IdAction(this);
		Find_PassAction passevent = new Find_PassAction(this);
		
		id.addActionListener(idevent);
		pass.addActionListener(passevent);
		
		
		///////////////////////////////////////////////////////
		add(main,BorderLayout.NORTH);
		add(bt,BorderLayout.CENTER);
		
		setSize(400, 250);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);  
		setVisible(true);
	}
	//아이디 찾기 이동 이벤트
	public void Find_id() {		
		new IdFind_Frame();
		dispose();
		
	}
	
	//비밀번호 찾기 이동 이벤트
	public void Find_pass() {
		new PassFind_Frame();
		 dispose();
	}

}
