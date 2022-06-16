package an.login;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import an.OjdbcConnection;

public class All_Panel extends JPanel{
	JPanel idpanel = new IdPanel();
	JTextField ptext = new IdPwd_TextFeild(10);
	JPanel idPanel2 = new IdPanel2(ptext);
	
	JPanel pwdPanel = new pwdPanel();
	JTextField itext = new IdPwd_TextFeild(10);
	JPanel pwdPanel2 = new pwdPanel2(itext);
	
	JButton login = new Lg_Button("로그인");
	JPanel loginPanel = new loginPanel(login);

	JPanel joinPanel = new JoinPanel();
	JPanel findPanel = new findPanel();
	
	
	public All_Panel() {
		setLayout(new GridLayout(3, 2));
		login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = ptext.getText();
				String pass = itext.getText();
				
				
			String sql = String.format("SELECT su_password FROM sign_up WHERE user_id = '%s' AND su_password ='%s'",
					id, pass);	
			try(Connection conn = OjdbcConnection.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql);) {
					
					ResultSet rset = pstmt.executeQuery();

					rset.next();
					
					if (pass.equals(rset.getString(1))) {
						JOptionPane.showMessageDialog(null, "Login Success", "로그인 성공", 1);
					
					} else
						JOptionPane.showMessageDialog(null, "Login Failed", "로그인 실패", 1);

				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(null, "Login Failed", "로그인 실패", 1);
					System.out.println("SQLException" + ex);
				}
				
			}
		});
		add(idpanel);add(idPanel2);
		add(pwdPanel);add(pwdPanel2);
		add(loginPanel);add(joinPanel); 
	}

}
