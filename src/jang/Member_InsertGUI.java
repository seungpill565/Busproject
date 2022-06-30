package jang;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import jang.Data.Member_Data;

public class Member_InsertGUI extends JFrame{
	JPanel panel = new JPanel();
	JTextField tf1 = new JTextField();
	JTextField tf2 = new JTextField();
	JTextField tf3 = new JTextField();
	JTextField tf4 = new JTextField();
	JTextField tf5 = new JTextField();

	JButton btn1 = new JButton("추가");

	JLabel l1 = new JLabel("ID : ");
	JLabel l2 = new JLabel("이름 : ");
	JLabel l3 = new JLabel("비밀번호 : ");
	JLabel l4 = new JLabel("전화번호 : ");
	JLabel l5 = new JLabel("관리자/손님 : ");
	
	JLabel pName = new JLabel("회원 추가");
	
	Member_DB db = new Member_DB();

	public Member_InsertGUI() {
		setTitle("회원 관리 프로그램");
		add(panel);
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		setResizable(false);
		setBounds(10, 20, 400, 400);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		
		pName.setBounds(50, 30, 200, 50);
		pName.setFont(new Font("휴먼매직체", Font.BOLD, 40));
		panel.add(pName);

		// 입력 공간
		tf1.setBounds(65, 100, 80, 25);
		tf1.setFont(new Font("휴먼매직체", Font.PLAIN, 15));
		panel.add(tf1); // 아이디 입력 공간
		tf2.setBounds(65, 140, 80, 25);
		tf2.setFont(new Font("휴먼매직체", Font.PLAIN, 15));
		panel.add(tf2); // 이름 입력 공간
		tf3.setBounds(260, 100, 80, 25);
		tf3.setFont(new Font("휴먼매직체", Font.PLAIN, 15));
		panel.add(tf3); // 비번
		tf4.setBounds(260, 140, 80, 25);
		tf4.setFont(new Font("휴먼매직체", Font.PLAIN, 15));
		panel.add(tf4); // 전번
		tf5.setBounds(110, 180, 80, 25);
		tf5.setFont(new Font("휴먼매직체", Font.PLAIN, 15));
		panel.add(tf5); // 관리자유무

		// 입력 공간 라벨 이름
		l1.setBounds(25, 100, 80, 30);
		l1.setFont(new Font("휴먼매직체", Font.PLAIN, 15));
		panel.add(l1); // 아이디 라벨
		l2.setBounds(25, 140, 80, 30);
		l2.setFont(new Font("휴먼매직체", Font.PLAIN, 15));
		panel.add(l2); // 이름 라벵
		l3.setBounds(190, 100, 80, 30);
		l3.setFont(new Font("휴먼매직체", Font.PLAIN, 15));
		panel.add(l3); // 비번
		l4.setBounds(190, 140, 80, 30);
		l4.setFont(new Font("휴먼매직체", Font.PLAIN, 15));
		panel.add(l4); // 전번
		l5.setBounds(25, 180, 90, 30);
		l5.setFont(new Font("휴먼매직체", Font.PLAIN, 15));
		panel.add(l5); // 관리자유무
		
		btn1.setBounds(150, 250, 80, 30);
		btn1.setBackground(new Color(0XE7E6E6));
		panel.add(btn1);

		// 입력 버튼 이벤트
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String user_id = tf1.getText();
				String user_name = tf2.getText();
				String user_password = tf3.getText();
				String user_phonenum = tf4.getText();
				String user_passenger_manager = tf5.getText();
				ArrayList<Member_Data> arr = new ArrayList<Member_Data>();
				arr = db.search(user_id);

				Pattern passPattern = Pattern.compile("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*\\W).{8,20}$");
				Matcher passMatcher = passPattern.matcher(user_password);
				Pattern passPattern2 = Pattern.compile("\\d{11}");
				Matcher passMatcher2 = passPattern2.matcher(user_phonenum);
				Member_Data data = new Member_Data(user_id, user_name, user_password, user_phonenum,
						user_passenger_manager);
				if (!arr.isEmpty()) {
					JOptionPane.showMessageDialog(null, "아이디가 중복됩니다", "아이디 중복", 1);
					return;
				} else if (!passMatcher.find()) {
					JOptionPane.showMessageDialog(null, "비밀번호는 영문+특수문자+숫자 8자로 구성되어야 합니다", "비밀번호 오류", 1);
					return;
				} else if (!passMatcher2.find()) {
					JOptionPane.showMessageDialog(null, "숫자만 입력해주세요", "전화번호 오류", 1);
					return;
				} else {
					db.insertData(
							new Member_Data(user_id, user_name, user_password, user_phonenum, user_passenger_manager));
					JOptionPane.showMessageDialog(null, "입력되었습니다!");
					
				}
				tf1.setText("");
				tf2.setText("");
				tf3.setText("");
				tf4.setText("");
				tf5.setText("");
				dispose();
			}

		});
	}

}
