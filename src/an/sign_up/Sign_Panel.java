package an.sign_up;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import an.OjdbcConnection;
import an.sign_up.action.Sign_ButtonAction;
import an.sign_up.action.Sign_IdButtonAction;
import an.sign_up.action.Sign_PassButtonAction;


public class Sign_Panel extends JPanel{
	JButton button;
	JButton button2;
	JButton button3;
	String id = "", pass = "", passRe = "", name = "", phone = "", check ="" ,passck ="";
	
	JTextField idtext = new Sign_TextFeild(12);
	JButton checkid = new Action_button("아이디 중복확인");
	JPanel idPanel = new Id_Panel(idtext,checkid);
	
	JLabel idcheckLabel = new ErrorLabel("아이디는 영어+숫자 최소 5자에서 최대 11자로 구성");
	
	JTextField passtext= new Sign_TextFeild(12);
	JButton checkpass = new Action_button("비밀번호 확인");
	JPanel passPanel = new Password_Panel(passtext,checkpass);
	JLabel passLabel = new ErrorLabel("비밀번호는 영문+특수문자+숫자 최소 8자에서 최대20자로 구성");
	
	JTextField passCktext= new Sign_TextFeild(12);
	JPanel passCkPanel = new Pass_CheckPanel(passCktext);
	JLabel passcheckLabel = new ErrorLabel("비밀번호와 동일하게 입력해주세요");
	
	
	JTextField nametext = new Sign_TextFeild(12);
	JPanel namePanel = new Name_panel(nametext);
	
	JTextField pntext = new Sign_TextFeild(3);
	JTextField pntext2 = new Sign_TextFeild(3);
	JTextField pntext3 = new Sign_TextFeild(3);
	JPanel pnPanel = new Pn_Panel(pntext,pntext2,pntext3);
	
	JComboBox<String> combo = new Combo();
	JPanel comboPanel = new Combo_Panel(combo);
	
	
	//JRadioButton client = new RadioButton("손님");
	//JRadioButton manager = new RadioButton("관리자");
	//ButtonGroup bg = new ButtonGroup();
	//JPanel radioPanel = new Radio_Panel(client,manager,bg);
	
	public Sign_Panel(JButton button) {
		setLayout(new GridLayout(9, 0,0,0));
		
		
		this.button = button ;
		//this.button2= button2;
		//this.button3 = button3;
		
		add(idPanel);
		add(idcheckLabel);
		add(passPanel);
		add(passLabel);
		add(passCkPanel);
		add(passcheckLabel);
		add(namePanel);
		add(pnPanel);
		add(comboPanel);
		
		
		//////////////////////////////////////////////////////////////
		Sign_ButtonAction btevent = new Sign_ButtonAction(this);
		Sign_IdButtonAction idevent = new Sign_IdButtonAction(this);
		Sign_PassButtonAction passevent = new Sign_PassButtonAction(this);
		checkid.addActionListener(idevent);
		checkpass.addActionListener(passevent);
		button.addActionListener(btevent);
		//button3.addActionListener(passevent);
		
		
		///////////////////////////////////////////////////////////
		
		//아이디 경고 라벨
		idtext.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				id = idtext.getText();
				if (id.length() < 5) {
					idcheckLabel.setForeground(Color.red);
					idcheckLabel.setText("아이디는 5글자 이상이여야 합니다");
				} else if (Pattern.matches("^[a-zA-Z]{1}[a-zA-Z0-9_]{4,11}$", id)) {
					idcheckLabel.setForeground(Color.BLUE);
					idcheckLabel.setText("사용가능한 아이디입니다. 아이디 중복을 눌러주세요");
				}else if(id.length()>=12) {
					idcheckLabel.setForeground(Color.red);
					idcheckLabel.setText("아이디는 11글자 이하이여야 합니다");
				}else {
					idcheckLabel.setForeground(Color.red);
					idcheckLabel.setText("옳바른 아이디를 입력하세요");
				}
			}
		});
		
		//비밀번호 경고 라벨
		passtext.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				pass = new String(passtext.getText());
				if (pass.length() <= 8) {
					passLabel.setForeground(Color.red);
					passLabel.setText("8자이상으로 입력하세요");
				}
				else if(Pattern.matches("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*\\W).{8,20}$",pass)) {
					 passLabel.setForeground(Color.BLUE);
					 passLabel.setText("사용가능한 비밀번호 입니다. 비밀번호 확인을 눌러주세요");
				}
				else if(pass.length() >=21){
					passLabel.setForeground(Color.red);
					passLabel.setText("비밀번호는 20자 이하여야 됩니다.");
				}else {
					passLabel.setForeground(Color.red);
					passLabel.setText("비밀번호는 영문+특수문자+숫자 최소 8자에서 최대20자로 구성");
				}
			}
		});
		
		//중복비밀번호 확인
		passCktext.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				pass = new String(passtext.getText());
				passck =new String(passCktext.getText());
				if (!passck.equals(pass)) {
					passcheckLabel.setForeground(Color.red);
					passcheckLabel.setText("비밀번호가 일치 하지 않습니다.");
				} else if(passck.equals(pass)) {
					passcheckLabel.setForeground(Color.BLUE);
					passcheckLabel.setText("비밀번호가 일치 합니다.");
				}else {
					passcheckLabel.setText("비밀번호 입력하세요");
				}
			}	
		});
	}
	//////////////////////////////////////////////////메서드///////////////////////////////////////////////
	
	//회원가입 메서드
	public void signupAction() {
		id = idtext.getText();
		pass = new String(passtext.getText());
		passck = new String(passCktext.getText());
		name = nametext.getText();
		phone = (pntext.getText()+"-"+pntext2.getText() +"-"+pntext3.getText());
		check = combo.getSelectedItem().toString();

		String sql = "INSERT into user_info(user_id,user_passenger_manager,user_name,user_password,user_phonenum)"
				+ " values (?,?,?,?,?)"; 

		Pattern passPattern1 = Pattern.compile("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*\\W).{8,20}$"); //8자 영문+특문+숫자
		
		Matcher passMatcher = passPattern1.matcher(pass);
		
		
		boolean idchek = Pattern.matches("^[a-zA-Z]{1}[a-zA-Z0-9_]{4,11}$", id);
		
		boolean phcheck = Pattern.matches("\\d{3}-\\d{4}-\\d{4}", phone);
		if(!passck.equals(pass)) {
			JOptionPane.showMessageDialog(null, "비밀번호와 비밀번호 확인이 다릅니다.", "비밀번호 오류", 1);	
			return;
		}	
		if (!passMatcher.find()) {
			JOptionPane.showMessageDialog(null, "비밀번호는 영문+특수문자+숫자 최소 8자에서 최대20자로 구성되어야 합니다", "비밀번호 오류", 1);
			return;
		} if(!phcheck) {
			JOptionPane.showMessageDialog(null, "xxx-xxxx-xxxx로 입력해 주세요", "번호 오류", 1);
			return;
		}if(!idchek) {
			JOptionPane.showMessageDialog(null, "아이디는 영문숫자로이루어진 5~12글자로 생성 해주세요", "아이디 오류", 1);
			return;
		}
		
		else {
			try(Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
					
					) {
				
				pstmt.setString(1, id);
				pstmt.setString(2, check);
				pstmt.setString(3, name);
				pstmt.setString(4, pass);
				pstmt.setString(5, pntext.getText());
				pstmt.executeUpdate();
				JOptionPane.showMessageDialog(null, "회원 가입 완료!", "회원가입", 1);
				
				
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, "정보를 제대로 입력해주세요!", "오류", 1);
			} 
		}
	}
	
	//아이디 중복 체크 메서드
	public void checkid() {
		id = idtext.getText();
		
		
		String sql1 = String.format("SELECT user_id from user_info where user_id = '%s'",id);
		
		boolean result = Pattern.matches("^[a-zA-Z]{1}[a-zA-Z0-9_]{4,11}$", id);
		
		try(Connection conn = OjdbcConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql1);
		) {
			ResultSet rset = pstmt.executeQuery();
			if(!result) {
				JOptionPane.showMessageDialog(null, "아이디는 영문숫자로이루어진 5~12글자로 생성 해주세요", "아이디 오류", 1);
			}else {
			
				if(!rset.next()) {
					JOptionPane.showMessageDialog(null, "사용가능한 아이디 입니다.", "아이디 중복 체크", 1);
				}
				else {
					JOptionPane.showMessageDialog(null, "중복된 아이디 입니다.", "중복 체크", 1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	//비밀번호 체크 메서드
	public void checkpass() {
		pass = passtext.getText();
		String sql1 = String.format("SELECT user_password from user_info where user_password = '%s'",pass);
		
		Pattern passPattern1 = Pattern.compile("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*\\W).{8,20}$"); //8자 영문+특문+숫자
		
		Matcher passMatcher = passPattern1.matcher(pass);
		
		if(!passMatcher.find()) {
			JOptionPane.showMessageDialog(null, "비밀번호는 영문+특수문자+숫자 최소 8자에서 최대20자로 구성되어야 합니다", "비밀번호 오류", 1);
		}else {
			try(
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql1);	
			) {
				ResultSet rset = pstmt.executeQuery();
					if(rset.next()) {
						JOptionPane.showMessageDialog(null, "사용가능한 비밀번호 입니다.", "비밀번호 체크", 1);
					}else {
						JOptionPane.showMessageDialog(null, "비밀번호는 영문+특수문자+숫자 최소 8자에서 최대20자로 구성되어야 합니다.", "비밀번호 체크", 1);
					}
				}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
