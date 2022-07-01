package lee.mpcomponents;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

import lee.RoundedButton;


public class MPprofilePanel_2 extends JPanel {
	
	RoundedButton MPbackBtn = new RoundedButton("뒤로가기");
	RoundedButton MPcompleteBtn = new RoundedButton("수정완료");
	
	JPanel MPlabelPanel = new JPanel();//레이아웃은 그리드백레이아웃으로
	
	//그리드백레이아웃
	GridBagLayout gbl = new GridBagLayout();
	GridBagConstraints gblc = new GridBagConstraints();

	JLabel MPviewLb1 = new JLabel("   이름 "); //이 라벨 글자만 앞으로 튀어나와 있어서 앞에 공백 넣어줌
	JLabel MPviewLb2 = new JLabel("핸드폰 번호 ");
	JLabel MPviewLb3 = new JLabel("새 비밀번호 ");
	JLabel MPviewLb4 = new JLabel("비밀번호 확인 ");
	
	
	
	
	
	JTextField MPnameTf = new JTextField(25);
	JTextField MPphoneTf_1 = new JTextField(4);
	JTextField MPphoneTf_2 = new JTextField(4);
	JTextField MPphoneTf_3 = new JTextField(4);
	JPasswordField MPnewpwTf = new JPasswordField(25);
	JPasswordField MPchknewpwTf = new JPasswordField(25);
	
	JLabel MPprofilerestrictLb = new JLabel("<html><pre style=\"font-family:고딕; font-size:13;\">이름은 10글자까지 입력 가능합니다.<br>비밀번호는 영문+특수문자+숫자 8~20자로 구성되어야 합니다.</pre></htnl>"); 
	
	
	JPanel phoneNumPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	
	JLabel stateLb = new JLabel();
	
	
	public MPprofilePanel_2() {
		setLayout(null);

		//텍스트필드들 테두리 없애고 배경 설정 
		MPnameTf.setBackground(new Color(219,219,219));
		MPnameTf.setBorder(null);
		MPphoneTf_1.setBackground(new Color(219,219,219));
		MPphoneTf_1.setBorder(null);
		MPphoneTf_2.setBackground(new Color(219,219,219));
		MPphoneTf_2.setBorder(null);
		MPphoneTf_3.setBackground(new Color(219,219,219));
		MPphoneTf_3.setBorder(null);
		MPnewpwTf.setBackground(new Color(219,219,219));
		MPnewpwTf.setBorder(null);
		MPchknewpwTf.setBackground(new Color(219,219,219));
		MPchknewpwTf.setBorder(null);
		
		
		
		//라벨들 폰트 설정하고 위치 크기 설정 + add
		MPviewLb1.setFont(new Font("고딕", Font.BOLD, 14));
		MPviewLb2.setFont(new Font("고딕", Font.BOLD, 14));
		MPviewLb3.setFont(new Font("고딕", Font.BOLD, 14));
		MPviewLb4.setFont(new Font("고딕", Font.BOLD, 14));
		MPprofilerestrictLb.setBounds(67, 330, 400, 85);
		add(MPprofilerestrictLb);
		
		//새비밀번호 텍스트필드 입력할 때 ●로 표시 
		MPnewpwTf.setEchoChar('●');
		MPchknewpwTf.setEchoChar('●');
		
		
		//그리드백레이아웃 적용하는 부분_______________________________________________________________
		//인풋패널 설정
		MPlabelPanel.setLayout(new GridLayout());
		MPlabelPanel.setBounds(57, 5, 400, 300);
		MPlabelPanel.setLayout(gbl);
		MPlabelPanel.setBackground(Color.WHITE);
		//그리드백레이아웃 설정 + 컴포넌트 넣기__________ 
		gblc.weightx = 1.0; //가로, 세로 패딩? 정하기
		gblc.weighty = 0.0;
		
		//이름
		gbInsert(MPviewLb1, 0, 0, 1, 1);
		gbInsert(MPnameTf, 1, 0, 3, 1);
		//전화번호 
        phoneNumPanel.add(MPphoneTf_1);
        phoneNumPanel.add(new JLabel(" - "));
        phoneNumPanel.add(MPphoneTf_2);
        phoneNumPanel.add(new JLabel(" - "));
        phoneNumPanel.add(MPphoneTf_3);	
        phoneNumPanel.setBackground(Color.WHITE);
		gbInsert(MPviewLb2, 0, 1, 1, 1);
		gbInsert(phoneNumPanel, 1, 1, 3, 1);		
		//비밀번호
		gbInsert(MPviewLb3, 0, 2, 1, 1);
		gbInsert(MPnewpwTf, 1, 2, 3, 1);	
		//비밀번호 확인
		gbInsert(MPviewLb4, 0, 3, 1, 1);
		gbInsert(MPchknewpwTf, 1, 3, 3, 1);
		//비밀번호 입력 상태 라벨 
		gbInsert(stateLb, 1, 4, 4, 1);
		//________________________________________________________________________________________
		
		
		
		
		
		//핸드폰번소 텍스트필드 제한~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		// 010, 016, 017... 입력하는 텍스트 필드 키리스너 설정
		MPphoneTf_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				JTextField src = (JTextField) e.getSource();
				if((src.getText().length() >= 3)) e.consume(); //3글자 제한
				if(!Character.isDigit(e.getKeyChar())) e.consume();	//숫자만 입력 가능
			}
		});
		
		// 1234 - 1234 입력하는 텍스트 필드 키리스너 설정
		KeyAdapter kA = new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				JTextField src = (JTextField) e.getSource();
				if((src.getText().length() >= 4)) e.consume(); //4글자 제한
				if(!Character.isDigit(e.getKeyChar())) e.consume(); //숫자만 입력 가능
			}
		};
		MPphoneTf_2.addKeyListener(kA);
		MPphoneTf_3.addKeyListener(kA);
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		
		
		//이름 텍스트필드 제한~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		MPnameTf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				JTextField src = (JTextField) e.getSource();
				if((src.getText().length() >= 10)) e.consume(); //10글자 제한
				if(Character.isDigit(e.getKeyChar())) e.consume(); //숫자만 입력 가능
			}
		});
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		
		
		//새 비밀번호 텍스트필드 키 리스너~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		MPnewpwTf.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent e) {
				JTextField src = (JTextField) e.getSource();
				if((src.getText().length() >= 20)) e.consume(); //20글자 제한
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				
				JTextField src = (JTextField) e.getSource();
				if (src.getText().equals(MPgetPwd(MPchknewpwTf))) {
					stateLb.setForeground(new Color(255,158,238));
					stateLb.setText("비밀번호가 일치합니다.");
				} else {
					stateLb.setForeground(new Color(217,158,255));
					stateLb.setText("비밀번호가 일치하지 않습니다.");
				}
				
				if(src.getText().length() == 0) {
					stateLb.setText("");
				}
			}
		});
				
				
		//비밀번호 확인 텍스트필드 키리스너~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		MPchknewpwTf.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				JTextField src = (JTextField) e.getSource();
				if((src.getText().length() >= 20)) e.consume(); //20글자 제한
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
	
				JTextField src = (JTextField) e.getSource();
				if (src.getText().equals(MPgetPwd(MPnewpwTf))) {
					stateLb.setForeground(new Color(255,158,238));
					stateLb.setText("비밀번호가 일치합니다.");
				} else {
					stateLb.setForeground(new Color(217,158,255));
					stateLb.setText("비밀번호가 일치하지 않습니다.");
				}
				
				if(src.getText().length() == 0) {
					stateLb.setText("");
				}
			}
		});
		
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		
		
		
		
		//수정완료버튼 설정
		MPcompleteBtn.setBounds(277, 280, 90, 38);
		MPcompleteBtn.setBorderPainted(false);
		MPcompleteBtn.setFont(new Font("휴먼편지체", Font.BOLD, 17));
		
		//뒤로가기 버튼 설정
		MPbackBtn.setBounds(147, 280, 90, 38 );
		MPbackBtn.setBorderPainted(false);
		MPbackBtn.setFont(new Font("휴먼편지체", Font.BOLD, 17));
		
		add(MPcompleteBtn);
		add(MPbackBtn);
		add(MPlabelPanel);
		
		setBackground(Color.WHITE);
	}
	
	
	
	public void gbInsert(Component c, int gridx, int gridy, int gridwidth, int gridheight) {
		//gridx부터 순서대로 열번호, 행번호, 너비, 높이를 의미
		
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

	
	
	public String MPgetPhoneNum() {
		return MPphoneTf_1.getText() + MPphoneTf_2.getText() + MPphoneTf_3.getText();
	}


}






