package lee.mpcomponents;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class MPprofilePanel_2 extends JPanel {
	
	JButton MPbackBtn = new JButton("뒤로가기");
	JButton MPcompleteBtn = new JButton("수정완료");
	
	JPanel MPlabelPanel = new JPanel();//레이아웃은 그리드백레이아웃으로
	
	//그리드백레이아웃
	GridBagLayout gbl = new GridBagLayout();
	GridBagConstraints gblc = new GridBagConstraints();

	JLabel MPviewLb1 = new JLabel("   이름 "); //이 라벨 글자만 앞으로 튀어나와 있어서 앞에 공백 넣어줌
	JLabel MPviewLb2 = new JLabel("핸드폰 번호 ");
	JLabel MPviewLb3 = new JLabel("새 비밀번호 ");
	
	
	JTextField MPnameTf = new JTextField(25);
	JTextField MPphoneTf = new JTextField(25);
	JPasswordField MPnewpwTf = new JPasswordField(25);
	 
	JLabel MPprofilerestrictLb = new JLabel("<html><pre style=\"font-family:고딕; font-size:13;\">이름, 비밀번호는 10글자까지 입력 가능합니다.<br>핸드폰번호 ex. 01012341234</pre></htnl>"); 
	
	
	public MPprofilePanel_2() {
		setLayout(null);

		MPviewLb1.setFont(new Font("고딕", Font.BOLD, 14));
		MPviewLb2.setFont(new Font("고딕", Font.BOLD, 14));
		MPviewLb3.setFont(new Font("고딕", Font.BOLD, 14));
	
		MPprofilerestrictLb.setBounds(120, 355, 400, 50);
		add(MPprofilerestrictLb);
		
		//새비밀번호 텍스트필드 입력할 때 ●로 표시 
		MPnewpwTf.setEchoChar('●');
	
		//비밀번호텍필에 입력한 비번(새로 바꿀거) String으로 가져오기
		MPgetPwd(MPnewpwTf);		
	
		
		MPphoneTf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isDigit(c) || c=='\b')) {
					MPphoneTf.setText("숫자만 입력해주세요.");
					return;
				}
			}
		}); 
		
			
		
//그리드백레이아웃 적용하는 부분_______________________________________________________________
		//인풋패널 설정
		MPlabelPanel.setLayout(new GridLayout());
		MPlabelPanel.setBounds(85, 90, 350, 170);
		MPlabelPanel.setLayout(gbl);
		
	
		//그백레 설정 + 컴포넌트 넣기 
		gblc.weightx = 1.0;
		gblc.weighty = 1.0;

	
		gbInsert(MPviewLb1, 0, 0, 1, 1);
		gbInsert(MPnameTf, 1, 0, 3, 1);
		gbInsert(MPviewLb2, 0, 1, 1, 1);
		gbInsert(MPphoneTf, 1, 1, 3, 1);
		gbInsert(MPviewLb3, 0, 2, 1, 1);
		gbInsert(MPnewpwTf, 1, 2, 3, 1);		

		
		//수정완료버튼 설정
		MPcompleteBtn.setBounds(280, 300, 90, 38);
		MPcompleteBtn.setBorderPainted(false);
		
		//뒤로가기 버튼 설정
		MPbackBtn.setBounds(150, 300, 90, 38 );
		MPbackBtn.setBorderPainted(false);
		
		
		
		add(MPcompleteBtn);
		add(MPbackBtn);
		add(MPlabelPanel);
	}
	
	
	
	public void gbInsert(Component c, int gridx, int gridy, int gridwidth, int gridheight) {
		//gridx부터 순서대로 행번호, 열번호, 너비, 높이를 의미
		
		gblc.fill = gblc.BOTH;//전체를 채우라는거래 
		gblc.gridx = gridx;
		gblc.gridy = gridy;
		gblc.gridwidth = gridwidth;
		gblc.gridheight = gridheight;
		gbl.setConstraints(c,  gblc);
		gblc.insets = new Insets(15, 10, 10, 10);
		MPlabelPanel.add(c);
	}
	

	
	//JPasswordField에서 얻어온 char[]배열을 String으로 변환
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






