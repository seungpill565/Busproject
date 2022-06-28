package lee.mpcomponents;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class MPleavePanel extends JPanel {
	
	
	JLabel MPleaveConfirmLb = new JLabel("계정 탈퇴를 원하시면 비밀번호를 입력해주세요.");
	JButton MPleaveYesBtn = new JButton("확인");
	JPasswordField MPleavePf = new JPasswordField();
	
	public MPleavePanel() {
		
		setLayout(null);
		
		//탈퇴하시겠습니까? 라벨 설정
		MPleaveConfirmLb.setBounds(50, 30, 400, 60);
		MPleaveConfirmLb.setOpaque(true);
		MPleaveConfirmLb.setFont(new Font("고딕", Font.BOLD, 15));
		add(MPleaveConfirmLb);

		JLabel MPleavePwLb = new JLabel();
		MPleavePwLb.setText("비밀번호 ");
		MPleavePwLb.setBounds(50, 100, 100, 27);
		MPleavePwLb.setFont(new Font("고딕", Font.BOLD, 15));
		add(MPleavePwLb);
		
		//비밀번호 텍스트필드 설정
		MPleavePf.setBounds(120, 100, 250, 27);
		MPleavePf.setEchoChar('●');
		add(MPleavePf);
		
		//확인 버튼 설정
		MPleaveYesBtn.setBounds(380, 170, 90, 38);
		MPleaveYesBtn.setBorderPainted(false);
		MPleaveYesBtn.setFont(new Font("고딕", Font.BOLD, 13));
		add(MPleaveYesBtn);

	}


	//비밀번호 텍스트 얻기 메서드
	public String MPgetPwd(JPasswordField MPnewpwTf) {
		StringBuilder pw = new StringBuilder();	
		char[] secret_pw = MPnewpwTf.getPassword(); 

	    for(char cha : secret_pw){         
	        Character.toString(cha); 
	        pw.append(cha);
	    }
		return pw.toString();
	}


}
