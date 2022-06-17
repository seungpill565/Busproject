package an.sign_up;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import an.OjdbcConnection;


public class Sign_Panel extends JPanel{
	JButton button;
	JButton button2;
	String id = "", pass = "", passRe = "", name = "", phone = "", check ="";
	
	JTextField idtext = new Sign_TextFeild(10);
	JPanel idPanel = new Id_Panel(idtext);
	
	JTextField passtext= new Sign_TextFeild(10);
	JPanel passPanel = new Password_Panel(passtext);
	
	JTextField nametext = new Sign_TextFeild(10);
	JPanel namePanel = new Name_panel(nametext);
	
	JTextField pntext = new Sign_TextFeild(10);
	JPanel pnPanel = new Pn_Panel(pntext);
	
	JComboBox<String> combo = new Combo();
	
	//JRadioButton client = new RadioButton("손님");
	//JRadioButton manager = new RadioButton("관리자");
	//ButtonGroup bg = new ButtonGroup();
	//JPanel radioPanel = new Radio_Panel(client,manager,bg);
	
	public Sign_Panel(JButton button,JButton button2) {
		setLayout(new GridLayout(5, 1));
		
		
		this.button = button ;
		
		add(idPanel);
		add(passPanel);
		add(namePanel);
		add(pnPanel);
		add(combo);
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			id = idtext.getText();
			pass = new String(passtext.getText());
			name = nametext.getText();
			phone = pntext.getText();
			check = combo.getSelectedItem().toString();

			String sql = "INSERT into sign_up(user_id,su_passenger_manager,su_user_name,su_password,su_phonenum)"
					+ " values (?,?,?,?,?)"; 

			Pattern passPattern1 = Pattern.compile("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*\\W).{8,20}$"); //8자 영문+특문+숫자
			Matcher passMatcher = passPattern1.matcher(pass);

			if (!passMatcher.find()) {
				JOptionPane.showMessageDialog(null, "비밀번호는 영문+특수문자+숫자 8자로 구성되어야 합니다", "비밀번호 오류", 1);
			} 
			
			else {
				try(Connection conn = OjdbcConnection.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql);
						
						) {
					
					pstmt.setString(1, id);
					pstmt.setString(2, check);
					pstmt.setString(3, pass);
					pstmt.setString(4, name);
					pstmt.setString(5, pntext.getText());

					pstmt.executeUpdate();
					JOptionPane.showMessageDialog(null, "회원 가입 완료!", "회원가입", 1);
					
				} catch (SQLException err) {
					if (err.getMessage().contains("PRIMARY")) {
						//중복된 값 = PRIMARY 라서 거를수있음
						JOptionPane.showMessageDialog(null, "아이디 중복!", "아이디 중복 오류", 1);
					} else
						JOptionPane.showMessageDialog(null, "정보를 제대로 입력해주세요!", "오류", 1);
				} 
			}
		}
	});
		
		
	}

}
