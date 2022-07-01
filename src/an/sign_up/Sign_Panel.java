package an.sign_up;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import an.OjdbcConnection;
import an.sign_up.action.Sign_ButtonAction;
import an.sign_up.action.Sign_ComboAction;
import an.sign_up.action.Sign_IdButtonAction;
import an.sign_up.action.Sign_KeyIdAction;
import an.sign_up.action.Sign_KeyNameAction;
import an.sign_up.action.Sign_KeyPassAction;
import an.sign_up.action.Sign_KeyPassCkAction;
import an.sign_up.action.Sign_KeyPnAction;
import an.sign_up.action.Sign_PassButtonAction;


public class Sign_Panel extends JPanel{
	JButton button;
	JButton button2;
	JButton button3;
	String id = "", pass = "", passRe = "", name = "", phone = "", check ="" ,passck ="";
	//아이디
	JTextField idtext = new Sign_TextFeild(12);
	JButton checkid = new Action_button("아이디 중복확인");
	JPanel idPanel = new Id_Panel(idtext,checkid);
	JLabel idcheckLabel = new ErrorLabel("아이디는 영어 또는 숫자 최소 5자에서 최대 11자 입니다.");
	
	//비밀번호
	JPasswordField passtext= new JPasswordField(12);
	JButton checkpass = new Action_button("비밀번호 확인");
	JPanel passPanel = new Password_Panel(passtext,checkpass);
	JLabel passLabel = new ErrorLabel("비밀번호는 영문+숫자+특수문자 최소 8자에서 최대20자로 구성");
	
	//비밀번호 확인
	JPasswordField passCktext= new JPasswordField(12);
	JPanel passCkPanel = new Pass_CheckPanel(passCktext);
	JLabel passcheckLabel = new ErrorLabel("비밀번호와 동일하게 입력해주세요");
	
	//이름
	JTextField nametext = new Sign_TextFeild(12);
	JPanel namePanel = new Name_panel(nametext);
	JLabel nameLabel = new ErrorLabel("이름을 입력해주세요");
	final String REGEX = "[0-9]+";
	
	//전화번호
	JTextField pntext = new Sign_TextFeild(3);
	JTextField pntext2 = new Sign_TextFeild(3);
	JTextField pntext3 = new Sign_TextFeild(3);
	JPanel pnPanel = new Pn_Panel(pntext,pntext2,pntext3);
	JLabel pnLabel = new ErrorLabel("전화번호의 형식은 xxx-xxx-xxxx입니다.");
	
	//손님/관리자
	JComboBox<String> combo = new Combo();
	JPanel comboPanel = new Combo_Panel(combo);
	public JLabel comboLabel = new ErrorLabel("손님을 선택하셨습니다.");
	
	
	//JRadioButton client = new RadioButton("손님");
	//JRadioButton manager = new RadioButton("관리자");
	//ButtonGroup bg = new ButtonGroup();
	//JPanel radioPanel = new Radio_Panel(client,manager,bg);
	
	public Sign_Panel(JButton button) {
		setLayout(new GridLayout(12, 0));
		
		setBackground(new Color(0X4D7F86));
		this.button = button ;
		//this.button2= button2;
		//this.button3 = button3;
		comboLabel.setForeground(new Color(0XFFFFFF));
		
		add(idPanel);
		add(idcheckLabel);
		add(passPanel);
		add(passLabel);
		add(passCkPanel);
		add(passcheckLabel);
		add(namePanel);
		add(nameLabel);
		add(pnPanel);
		add(pnLabel);
		add(comboPanel);
		add(comboLabel);
		
		
		/////////////////////////////액션/////////////////////////////////
		Sign_ButtonAction btevent = new Sign_ButtonAction(this);
		Sign_IdButtonAction idevent = new Sign_IdButtonAction(this);
		Sign_PassButtonAction passevent = new Sign_PassButtonAction(this);
		checkid.addActionListener(idevent);
		checkpass.addActionListener(passevent);
		button.addActionListener(btevent);
		//button3.addActionListener(passevent);
		
		//키 액션(라벨)
		Sign_KeyIdAction idkeyevent = new Sign_KeyIdAction(this);
		Sign_KeyPassAction passkeyevent = new Sign_KeyPassAction(this);
		Sign_KeyPassCkAction passckkeyevent = new Sign_KeyPassCkAction(this);
		Sign_KeyNameAction namekeyevent = new Sign_KeyNameAction(this);
		Sign_KeyPnAction pnkeyevent = new Sign_KeyPnAction(this);
		Sign_ComboAction comboevent = new Sign_ComboAction(this);
		
		idtext.addKeyListener(idkeyevent);
		passtext.addKeyListener(passkeyevent);
		passCktext.addKeyListener(passckkeyevent);
		nametext.addKeyListener(namekeyevent);
		pntext.addKeyListener(pnkeyevent);
		pntext2.addKeyListener(pnkeyevent);
		pntext3.addKeyListener(pnkeyevent);
		combo.addActionListener(comboevent);
					
				
	}
	//////////////////////////////////////////////////메서드///////////////////////////////////////////////
	
	//회원가입 메서드
	public void signupAction() {
		id = idtext.getText();
		pass = new String(passtext.getPassword());
		passck = new String(passCktext.getPassword());
		name = nametext.getText();
		phone = (pntext.getText()+"-"+pntext2.getText() +"-"+pntext3.getText());
		check = combo.getSelectedItem().toString();

		String sql = "INSERT into user_info(user_id,user_passenger_manager,user_name,user_password,user_phonenum)"
				+ " values (?,?,?,?,?)"; 

		Pattern passPattern1 = Pattern.compile("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*\\W).{8,20}$"); //8자 영문+특문+숫자
		
		Matcher passMatcher = passPattern1.matcher(pass);
		
		
		boolean idchek = Pattern.matches("^[a-zA-Z]{1}[a-zA-Z0-9_]{4,11}$", id);
		
		boolean phcheck = Pattern.matches("\\d{3}-\\d{4}-\\d{4}", phone);
		
		boolean namecheck = Pattern.matches(REGEX, name);
		if(!passck.equals(pass)) {
			JOptionPane.showMessageDialog(null, "비밀번호와 비밀번호 확인이 다릅니다.", "비밀번호 오류", 1);	
			return;
		}	
		if (!passMatcher.find()) {
			JOptionPane.showMessageDialog(null, "비밀번호는 영문+숫자+특수문자 최소 8자에서 최대20자로 구성되어야 합니다", "비밀번호 오류", 1);
			return;
		} if(!phcheck) {
			JOptionPane.showMessageDialog(null, "xxx-xxxx-xxxx로 입력해 주세요", "번호 오류", 1);
			return;
		}if(!idchek) {
			JOptionPane.showMessageDialog(null, "아이디는 영문또는숫자로이루어진 5~12글자로 생성 해주세요", "아이디 오류", 1);
			return;
		}if(namecheck) {
			JOptionPane.showMessageDialog(null, "이름에는 숫자를 입력하실수 없습니다.", "이름 오류", 1);
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
				pstmt.setString(5, phone);
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
		
		
		String sql1 = "SELECT user_id from user_info where user_id = ?";
		
		boolean result = Pattern.matches("^[a-zA-Z]{1}[a-zA-Z0-9_]{4,11}$", id);
		
		try(Connection conn = OjdbcConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql1);
		) {
			pstmt.setString(1, idtext.getText());
			ResultSet rset = pstmt.executeQuery();
			if(!result) {
				JOptionPane.showMessageDialog(null, "아이디는 영문숫자로이루어진 5~12글자로 생성 해주세요", "아이디 오류", 1);
			}else {
			
				if(!rset.next()) {
					JOptionPane.showMessageDialog(null, "사용가능한 아이디 입니다.", "아이디 중복 체크", 1);
					idcheckLabel.setText("중복확인완료");
					
				}
				else {
					JOptionPane.showMessageDialog(null, "중복된 아이디 입니다.", "중복 체크", 1);
					idcheckLabel.setForeground(Color.red);
					idcheckLabel.setText("중복된 아이디입니다.아이디를 변경해 주세요");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	//비밀번호 체크 메서드
	public void checkpass() {
		pass = new String(passtext.getPassword());
		String sql1 = "SELECT user_password from user_info where user_password = ?";
		
		Pattern passPattern1 = Pattern.compile("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*\\W).{8,20}$"); //8자 영문+특문+숫자
		
		Matcher passMatcher = passPattern1.matcher(pass);
		
		if(!passMatcher.find()) {
			JOptionPane.showMessageDialog(null, "비밀번호는 영문+숫자+특수문자  최소 8자에서 최대20자로 구성되어야 합니다", "비밀번호 오류", 1);
		}else {
			try(
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql1);	
			) {
				pstmt.setString(1,pass);
				ResultSet rset = pstmt.executeQuery();
					rset.next();
						JOptionPane.showMessageDialog(null, "사용가능한 비밀번호 입니다.", "비밀번호 체크", 1);
						passLabel.setText("비밀번호 확인완료");
					
				}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	//아이디 경고 메세지 메서드
	
	public void iderror() {
		id = idtext.getText();
		if (id.length() < 5) {
			idcheckLabel.setForeground(Color.red);
			idcheckLabel.setText("아이디는 5글자 이상이여야 합니다");
		} else if (Pattern.matches("^[a-zA-Z]{1}[a-zA-Z0-9_]{4,11}$", id)) {
			idcheckLabel.setForeground(Color.BLACK);
			idcheckLabel.setText("아이디 중복을 눌러주세요");
		}else if(id.length()>=12) {
			idcheckLabel.setForeground(Color.red);
			idcheckLabel.setText("아이디는 11글자 이하이여야 합니다");
		}else {
			idcheckLabel.setForeground(Color.red);
			idcheckLabel.setText("올바른 아이디를 입력하세요");
		}
	}
	
	//비밀번호 경고 메세지 메서드
	public void passerror() {
		pass = new String(passtext.getPassword());
		if (pass.length() <= 7) {
			passLabel.setForeground(Color.red);
			passLabel.setText("8자이상으로 입력하세요");
		}
		else if(Pattern.matches("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*\\W).{8,20}$",pass)) {
			 passLabel.setForeground(Color.BLACK);
			 passLabel.setText("사용가능한 비밀번호 입니다. 비밀번호 확인을 눌러주세요");
		}
		else if(pass.length() >=21){
			passLabel.setForeground(Color.red);
			passLabel.setText("비밀번호는 20자 이하여야 됩니다.");
		}else {
			passLabel.setForeground(Color.red);
			passLabel.setText("비밀번호는 영문+숫자+특수문자 최소 8자에서 최대20자로 구성");
		}
		
	}
	
	//비밀번호 확인 메서드
	public void passckerror() {
		pass = new String(passtext.getPassword());
		passck =new String(passCktext.getPassword());
		if (!passck.equals(pass)) {
			passcheckLabel.setForeground(Color.red);
			passcheckLabel.setText("비밀번호가 일치 하지 않습니다.");
		} else if(passck.equals(pass)) {
			passcheckLabel.setForeground(Color.BLACK);
			passcheckLabel.setText("비밀번호가 일치 합니다.");
		}else {
			passcheckLabel.setText("비밀번호 입력하세요");
		}
		
	}
	
	//전화번호 경고 메세지 메서드
	
	public void pnerror() {
		
		
		String pnnum = (pntext.getText()+"-"+pntext2.getText() +"-"+pntext3.getText());
		
			
		if(!Pattern.matches("\\d{3}-\\d{4}-\\d{4}", pnnum)) {
			pnLabel.setForeground(Color.red);
			pnLabel.setText("전화번호의 형식은 xxx-xxx-xxxx입니다.");
			}else {
				pnLabel.setForeground(Color.BLACK);
			 	pnLabel.setText("올바른 형식의 비밀번호 입니다.");
			}
	}
	
	//이름 경고 메세지 메서드
	public void nameerror() {
		name = nametext.getText();
		
		if(name =="") {
			nameLabel.setText("이름을 입력하세요.");
			nameLabel.setForeground(Color.RED);
		}	
		else if(Pattern.matches(REGEX,name)) {
			nameLabel.setText("이름에는 숫자를 입력하실수 없습니다.");
			nameLabel.setForeground(Color.RED);
			}
		else {
			nameLabel.setText("이름을 입력하셨습니다.");
			nameLabel.setForeground(Color.BLACK);
		}
		
	}
	
	//손님/관리자 선택
	public void checkerror() {
		String check = combo.getSelectedItem().toString();
		if(check =="손님") {
			comboLabel.setText("손님을 선택하셨습니다.");
		}else {
			comboLabel.setText("관리자를 선택하셨습니다.");
			
		}
	}
}
