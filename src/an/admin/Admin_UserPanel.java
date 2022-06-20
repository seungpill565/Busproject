package an.admin;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import an.OjdbcConnection;
import an.userinfo.Info_MainFrame;

public class Admin_UserPanel extends JPanel{
	JTextField checktext = new Admin_textFeild(10);
	JTextField idtext = new Admin_textFeild(10);
	JTextField nametext = new Admin_textFeild(10);
	JTextField pntext = new Admin_textFeild(10);
	JTextField passtext = new Admin_textFeild(10);
	
	JPanel idPanel = new User_IdPanel(idtext);
	JPanel namePanel = new User_NamePanel(nametext);
	JPanel passPanel = new User_PassPanel(passtext);
	JPanel checkPanel = new User_CheckPanel(checktext);
	JPanel pnPanel = new User_PhonePanel(pntext);
	
	JButton input = new JButton("입력");
	JButton modify = new JButton("수정");
	JButton output = new JButton("출력");
	JButton delete = new JButton("삭제");
	
	JLabel label = new JLabel("hi");
	
	
	JPanel buttonPanel = new User_ButtonPanel(input, modify, output, delete);
	
	
	public Admin_UserPanel() {
		setLayout(new GridLayout(3,1));
		add(idPanel);add(namePanel);add(passPanel);add(checkPanel);add(pnPanel);
		add(buttonPanel);add(label);
		
		//입력버튼 누를 때  
		input.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		//수정버튼 누를 때
		modify.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		//출력 버튼 누를때
		output.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			String sql = String.format("SELECT * FROM sign_up");
			try(Connection conn = OjdbcConnection.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql);) {
					
					ResultSet rset = pstmt.executeQuery();

					while(rset.next()) {
						System.out.println(rset.getString(0));
						
						label.setText(rset.getString(""));
					}
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(null, "error", "정보가없습니다.", 1);
				}
				
			}
		});
		//삭제 버튼 누를때
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
	}
	


}
