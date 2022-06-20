package an.login;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import an.OjdbcConnection;
import an.admin.Admin_MainFrame;
import an.find.Find_MainFrame;
import an.sign_up.Combo;
import an.sign_up.SignupMain_Frame;
import an.userinfo.Info_MainFrame;

public class All_Panel extends JPanel{
	
	JButton login = new Lg_Button("로그인");
	JButton join = new Lg_Button("회원가입");
	JButton up = new Lg_Button("아이디/비밀번호 찾기");
	
	JPanel idpanel = new IdPanel();
	JTextField ptext = new IdPwd_TextFeild(10);
	JPanel idPanel2 = new IdPanel2(ptext);
	
	JPanel pwdPanel = new PwdPanel();
	JTextField itext = new IdPwd_TextFeild(10);
	JPanel pwdPanel2 = new PwdPanel2(itext);
	

	JPanel loginPanel = new Login_MainPanel(login);
	
	
	JPanel joinPanel = new JoinPanel(up);
	JPanel findPanel = new findPanel();
	
	JPanel buttonPanel = new Login_buttonPanel(login, up, join); 
	
	JComboBox<String> combo = new Login_Combo();
	
	// 로그인 버튼을 누를시 로그인 성공,실패 여부 확인
	public All_Panel() {
		
		
		setLayout(new FlowLayout());
		login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = ptext.getText();// 아이디 -- 이거 끌고 다니면 될거같은데..
				String pass = itext.getText();
				String check = combo.getSelectedItem().toString();
				
			
			String sql = String.format("SELECT su_password FROM sign_up WHERE user_id = '%s'"
					+ " AND su_password ='%s'and su_passenger_manager = '%s'",
					id, pass,check);	
			try(Connection conn = OjdbcConnection.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql);) {
					
					ResultSet rset = pstmt.executeQuery();

					rset.next();
					
					if (pass.equals(rset.getString(1))) {
						if(check == "손님") {
							new Info_MainFrame();
						}else {
						new Admin_MainFrame();
						}
					
					} else
						JOptionPane.showMessageDialog(null, "Login Failed", "로그인 실패", 1);

				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(null, "Login Failed", "로그인 실패", 1);
				}
				
			}
		});
		
		join.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new SignupMain_Frame();
				 
			}
		
		});
		
		up.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Find_MainFrame();
				
			}
		});
		setBackground(new Color(0x77757B));
		add(idpanel);add(idPanel2);
		add(pwdPanel);add(pwdPanel2);add(combo);
		add(buttonPanel); 
	}

}
