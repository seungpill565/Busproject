package an.login.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import an.OjdbcConnection;
import an.login.IdPwd_TextFeild;



public class LoginButtonEvent implements ActionListener{
	
	/* 로그인 정보를 확인 */
	
	JTextField idTextField = new IdPwd_TextFeild(10);
	JTextField passTextField = new IdPwd_TextFeild(10);
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
				String id = idTextField.getText();
				String pass = passTextField.getText();
				
				
			String sql = String.format("SELECT password FROM user_info WHERE id = '%s' AND password ='%s'",
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
}

		
		

