package jang.Route;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import jang.Route_DB;

public class Route_Delete extends JFrame {

	JPanel panel = new JPanel();

	JButton btn1 = new JButton("삭제");
	JButton btn4 = new JButton("확인");

	JTextField tf1 = new JTextField();

	JLabel l1 = new JLabel("버스 ID : ");

	JLabel pName = new JLabel("정보 삭제");

	Route_DB db = new Route_DB();
	
	public Route_Delete() {
		Route_Delete();
	}

	public void Route_Delete() {
		setTitle("삭제");
		add(panel);
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		setResizable(false);
		setBounds(10, 20, 370, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		pName.setBounds(100, 30, 200, 50);
		pName.setFont(new Font("휴먼매직체", Font.BOLD, 40));
		panel.add(pName);

		btn1.setBounds(90, 220, 70, 30);
		btn1.setBackground(new Color(0XE7E6E6));
		btn4.setBounds(180, 220, 70, 30);
		btn4.setBackground(new Color(0XE7E6E6));

		panel.add(btn1);
		panel.add(btn4);
		
		// 입력 공간 라벨
		tf1.setBounds(170, 120, 80, 25);
		tf1.setFont(new Font("휴먼매직체", Font.PLAIN, 15));
		panel.add(tf1); // 버스 id

		// 입력 공간 라벨 이름
		l1.setBounds(100, 120, 80, 30);
		l1.setFont(new Font("휴먼매직체", Font.PLAIN, 15));
		panel.add(l1); 
		
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int bi_id = Integer.parseInt(tf1.getText());
				
//				db.deleteData(bi_id);
				JOptionPane.showMessageDialog(null, "삭제되었습니다!", "알림", 1);
				
				tf1.setText("");
			}
		});
		
		btn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});

	}
	
}
