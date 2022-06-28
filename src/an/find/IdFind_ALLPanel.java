package an.find;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class IdFind_ALLPanel extends JPanel{
	JTextField nameText = new Find_TextField(10);
	JTextField pnText = new Find_TextField(10);
	//JLabel nameLabel = new Find_ErrorLabel("이름을 입력해 주세요."); 
	JLabel pnLabel = new Find_ErrorLabel("전화번호의 형식은 xxx-xxx-xxxx입니다.");
	
	
	public IdFind_ALLPanel(JTextField j, JTextField j2) {
		setLayout(new GridLayout(3,1));
		nameText = j;
		pnText = j2;
		
		JPanel name = new IdFind_NamePanel(nameText);
		JPanel pn = new IdFind_PnPanel(pnText);
		
		
		add(name);add(pn);add(pnLabel);
		
		
		//전화 번호 경고 이벤트
		pnText.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				
				String pnnum = pnText.getText();
				System.out.println(pnnum);
				
				if(!Pattern.matches("\\d{3}-\\d{4}-\\d{4}", pnnum)) {
					pnLabel.setForeground(Color.red);
					pnLabel.setText("전화번호의 형식은 xxx-xxx-xxxx입니다.");
				 }else {
					 pnLabel.setForeground(Color.BLUE);
					 pnLabel.setText("올바른 형식의 비밀번호 입니다.");
				 }
			}
		});	
	}

}
