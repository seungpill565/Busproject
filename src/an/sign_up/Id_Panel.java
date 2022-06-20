package an.sign_up;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import an.OjdbcConnection;

public class Id_Panel extends JPanel{
	
	JLabel id = new Sign_Label("아이디 :");
	JTextField idtext ;
	JButton button =new  Sign_Button("중복확인");
	
public Id_Panel(JTextField idtext) {
	this.idtext = idtext;
	setLayout(new FlowLayout(FlowLayout.RIGHT));
	
	add(id);add(idtext);
	
	
	
}

}
