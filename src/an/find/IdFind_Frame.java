package an.find;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import an.OjdbcConnection;

public class IdFind_Frame extends JFrame{
	JTextField nameText = new Find_TextField(10);
	JTextField pnText = new Find_TextField(10);
	
	JButton button = new Find_Button("찾기");
	JButton button2 = new Find_Button("비밀번호 찾기");
	JButton out = new Find_Button("나가기");
	
	public IdFind_Frame() {
		
		
		JPanel ipmain = new IdFind_Panel();
		
		
		JPanel idPn = new IdFind_ALLPanel(nameText,pnText);
		
		
		JPanel buttonPanel = new IdFind_ButtonPanel(button,button2,out);
		
		add(ipmain,BorderLayout.NORTH);
		add(idPn,BorderLayout.CENTER);
		add(buttonPanel,BorderLayout.SOUTH);
		
		//////////////////////////////////////////////////////////////////////////////////////
		
		button. addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String sql = String.format("SELECT user_id from user_info where user_name = '%s' and user_phonenum = '%s'",
						nameText.getText() ,pnText.getText());
				System.out.println(nameText.getText());
				System.out.println(pnText.getText());
				
				try(Connection conn = OjdbcConnection.getConnection();
						PreparedStatement pstmt = conn.prepareStatement(sql);) {
						
						ResultSet rset = pstmt.executeQuery();
						
						rset.next();
						
						String id =rset.getString(1);
						
						JOptionPane.showMessageDialog(null, "아이디 :   "+id, "아이디 찾기", 1);
						
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "올바른 정보를 입력하세요", "정보 없음", 1);
				}
				
			}
		});
		
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new PassFind_Frame();
				
			}
		});
		
		
		out.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		
		
		
		
		
		//////////////////////////////////////////////////////
		
		
		
		
		setBounds(660, 350, 400, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);  
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new IdFind_Frame();
		
		
	}

}
