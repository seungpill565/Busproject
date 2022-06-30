package an.find;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import an.OjdbcConnection;
import an.find.action.Id_FindAction;
import an.find.action.Id_OutAction;
import an.find.action.Id_PassAction;

public class IdFind_Frame extends JFrame{
	JTextField nameText = new Find_TextField(10);
	JTextField pnText = new Find_TextField(10);
	
	ImageIcon buttonimage = new ImageIcon("image/find2.png");
	ImageIcon passimage = new ImageIcon("image/findpass.png");
	ImageIcon outimage = new ImageIcon("image/out.png");
	
	JButton button = new Find_Button("");
	JButton button2 = new Find_Button("");
	JButton out = new Find_Button("");
	
	public IdFind_Frame() {
		
		button.setIcon(buttonimage);
		button2.setIcon(passimage);
		out.setIcon(outimage);
		JPanel ipmain = new IdFind_Panel();
		
		
		JPanel idPn = new IdFind_ALLPanel(nameText,pnText);
		
		
		JPanel buttonPanel = new IdFind_ButtonPanel(button,button2,out);
		
		add(ipmain,BorderLayout.NORTH);
		add(idPn,BorderLayout.CENTER);
		add(buttonPanel,BorderLayout.SOUTH);
		
		//////////////////////////////////////////////////////////////////////////////////////
		
		Id_FindAction findevent = new Id_FindAction(this);
		Id_OutAction  outevent = new Id_OutAction(this); 
		Id_PassAction passevent = new Id_PassAction(this);
		
		button. addActionListener(findevent);
		button2.addActionListener(passevent);//비밀번호 이동
		out.addActionListener(outevent);
			
		//////////////////////////////////////////////////////////////////////////////////////
		
		
		
		
		setSize( 500, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);  
		setVisible(true);
	}
	
	
	//아이디 찾기 액션
	public void idFindAction() {
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
			JOptionPane.showMessageDialog(null, "옳바른 정보를 입력하세요", "정보 없음", 1);
		}
		
	}
	//비밀번호찾기 이동 액션
	public void idpassAction() {
		dispose();
		new PassFind_Frame();
		
	}
	//아이디찾기 이동 액션
	public void idoutAction() {
		dispose();
	}
	
}
