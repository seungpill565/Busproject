package an.find;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Pattern;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Pass_AllPanel extends JPanel{
	JTextField nameText = new Find_TextField(10);
	JTextField idText = new Find_TextField(10);
	final String REGEX = "[0-9]+";
	
	JLabel nameLabel = new Find_ErrorLabel("이름을 입력해 주세요."); 
	JLabel idLabel = new Find_ErrorLabel("아이디는 영어 또는 숫자 최소 5자에서 최대 11자 입니다.");
	
	
	
	public Pass_AllPanel(JTextField j ,JTextField j2) {
		setLayout(new GridLayout(4,1));
		idText = j;
		nameText = j2;
		JPanel name = new Pass_NamePanel(nameText);
		JPanel id = new Pass_IdPanel(idText);	
		
		add(name);add(nameLabel);add(id);add(idLabel);
		
		
		
		//아이디 경고 메세지 형식
		idText.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				String id = idText.getText();
				if (id.length() < 5) {
					idLabel.setForeground(Color.red);
					idLabel.setText("아이디는 5글자 이상이여야 합니다");
				} else if (Pattern.matches("^[a-zA-Z]{1}[a-zA-Z0-9_]{4,11}$", id)) {
					idLabel.setForeground(Color.BLUE);
					idLabel.setText("옳바른 아이디 형식입니다.");
				}else if(id.length()>=12) {
					idLabel.setForeground(Color.red);
					idLabel.setText("아이디는 11글자 이하이여야 합니다");
				}else {
					idLabel.setForeground(Color.red);
					idLabel.setText("옳바른 아이디 형식을 입력하세요");
				}
			}
		});
		
		nameText.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				String name = nameText.getText();
				
				if(name =="") {
					nameLabel.setText("이름을 입력하세요.");
					nameLabel.setForeground(Color.red);
				}	
				else if(Pattern.matches(REGEX,name)) {
					nameLabel.setText("이름에는 숫자를 입력하실수 없습니다.");
					nameLabel.setForeground(Color.RED);
					}
				else {
					nameLabel.setText("이름을 입력하셨습니다.");
					nameLabel.setForeground(Color.blue);
				}
				
			}
			
		});	
	}

}
