package jang;

import java.awt.Color;

import java.awt.Font;
import java.awt.color.ColorSpace;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.channels.SelectableChannel;
import java.util.ArrayList;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.plaf.basic.BasicSliderUI.ScrollListener;
import javax.swing.table.DefaultTableModel;

import jang.Data.Member_Data;
import jang.Data.Member_Update_Data;

public class MemberManagementGUI extends JFrame {

	JPanel panel = new JPanel();
	JTextField tf1 = new JTextField();
	JTextField tf2 = new JTextField();
	JTextField tf3 = new JTextField();
	JTextField tf4 = new JTextField();
	JTextField tf5 = new JTextField();
	JTextArea ta = new JTextArea();

	JButton btn1 = new JButton("추가");
	JButton btn2 = new JButton("조회");
	JButton btn3 = new JButton("수정");
	JButton btn4 = new JButton("삭제");
	JButton btn5 = new JButton("검색");

	JLabel l1 = new JLabel("ID : ");
	JLabel l2 = new JLabel("이름 : ");
	JLabel l3 = new JLabel("비밀번호 : ");
	JLabel l4 = new JLabel("전화번호 : ");
	JLabel l5 = new JLabel("관리자/손님 : ");

	JLabel pName = new JLabel("관리자");
	JLabel label = new JLabel("회원");
	JButton backBtn;
	JButton homeBtn;

	ImageIcon image = new ImageIcon("Image/back2.png");
	ImageIcon image2 = new ImageIcon("Image/back3.png");

	ImageIcon home_image = new ImageIcon("Image/home.png");
	ImageIcon home_image2 = new ImageIcon("Image/home2.png");

	final String[] colNames = { "아이디", "이름", "비밀전호", "전화번호", "관리자/손님" };
	DefaultTableModel model = new DefaultTableModel(colNames, 0);

	JTable table = new JTable(model);
	JScrollPane scrolledpane = new JScrollPane(table);

	MemberManagementGUI() {
		ManagementGUI();
	}

	public void ManagementGUI() {
		setTitle("회원 관리 프로그램");
		add(panel);
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		setResizable(false);
		setBounds(10, 20, 800, 650);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		ta.setEditable(false);

		scrolledpane.setSize(500, 200);
		add(scrolledpane);

		backBtn = new JButton(image);
		backBtn.setRolloverIcon(image2);
		backBtn.setBorderPainted(false);
		backBtn.setBounds(30, 30, 48, 50);
		panel.add(backBtn);

		homeBtn = new JButton(home_image);
		homeBtn.setRolloverIcon(home_image2);
		homeBtn.setBorderPainted(false);
		homeBtn.setBounds(700, 30, 50, 50);
		panel.add(homeBtn);

		pName.setBounds(330, 30, 200, 50);
		pName.setFont(new Font("휴먼매직체", Font.BOLD, 40));
		panel.add(pName);
		label.setBounds(40, 120, 50, 30);
		label.setFont(new Font("휴먼매직체", Font.PLAIN, 30));
		panel.add(label);

		// 입력 공간
		tf1.setBounds(55, 170, 80, 25);
		tf1.setFont(new Font("휴먼매직체", Font.PLAIN, 15));
		panel.add(tf1); // 아이디 입력 공간
		tf2.setBounds(187, 170, 80, 25);
		tf2.setFont(new Font("휴먼매직체", Font.PLAIN, 15));
		panel.add(tf2); // 이름 입력 공간
		tf3.setBounds(347, 170, 80, 25);
		tf3.setFont(new Font("휴먼매직체", Font.PLAIN, 15));
		panel.add(tf3); // 비번
		tf4.setBounds(505, 170, 80, 25);
		tf4.setFont(new Font("휴먼매직체", Font.PLAIN, 15));
		panel.add(tf4); // 전번
		tf5.setBounds(680, 170, 80, 25);
		tf5.setFont(new Font("휴먼매직체", Font.PLAIN, 15));
		panel.add(tf5); // 관리자유무

		// 입력 공간 라벨 이름
		l1.setBounds(25, 170, 80, 30);
		l1.setFont(new Font("휴먼매직체", Font.PLAIN, 15));
		panel.add(l1); // 아이디 라벨
		l2.setBounds(145, 170, 80, 30);
		l2.setFont(new Font("휴먼매직체", Font.PLAIN, 15));
		panel.add(l2); // 이름 라벵
		l3.setBounds(280, 170, 80, 30);
		l3.setFont(new Font("휴먼매직체", Font.PLAIN, 15));
		panel.add(l3); // 비번
		l4.setBounds(440, 170, 80, 30);
		l4.setFont(new Font("휴먼매직체", Font.PLAIN, 15));
		panel.add(l4); // 전번
		l5.setBounds(595, 170, 90, 30);
		l5.setFont(new Font("휴먼매직체", Font.PLAIN, 15));
		panel.add(l5); // 관리자유무

		// 입력한 글이 보이는 창
		JScrollPane jsp = new JScrollPane(ta); // 창 스크롤
		jsp.setBounds(40, 300, 700, 250);
		panel.add(jsp);

		btn1.setBounds(250, 240, 70, 30);
		btn1.setBackground(new Color(0XE7E6E6));
		btn2.setBounds(145, 240, 70, 30);
		btn2.setBackground(new Color(0XE7E6E6));
		btn3.setBounds(355, 240, 70, 30);
		btn3.setBackground(new Color(0XE7E6E6));
		btn4.setBounds(460, 240, 70, 30);
		btn4.setBackground(new Color(0XE7E6E6));
		btn5.setBounds(565, 240, 70, 30);
		btn5.setBackground(new Color(0XE7E6E6));

		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(btn4);
		panel.add(btn5);

		Member_DB db = new Member_DB();

		// 뒤로가기 버튼
		backBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ManagerMainFrame2();
				setVisible(false);
			}
		});

		// 홈 버튼
		homeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ManagerMainFrame2(); // 나중에 메인으로 바꾸면 됨
				setVisible(false);
			}
		});

		// 입력 버튼 이벤트
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ta.setText("");

				String user_id = tf1.getText();
				String user_name = tf2.getText();
				String user_password = tf3.getText();
				String user_phonenum = tf4.getText();
				String user_passenger_manager = tf5.getText();

				Pattern passPattern = Pattern.compile("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*\\W).{8,20}$");
				Matcher passMatcher = passPattern.matcher(user_password);
				Pattern passPattern2 = Pattern.compile("\\d");
				Matcher passMatcher2 = passPattern2.matcher(user_phonenum);
				if (!passMatcher.find()) {
					JOptionPane.showMessageDialog(null, "비밀번호는 영문+특수문자+숫자 8자로 구성되어야 합니다", "비밀번호 오류", 1);
					return;
				} else if (!passMatcher2.find()) {
					JOptionPane.showMessageDialog(null, "전화번호는 숫자로만 구성되어야 합니다", "전화번호 오류", 1);
					return;
				} else if (user_id.equals(user_id)) {
					JOptionPane.showMessageDialog(null, "아이디가 존재합니다", "아이디 중복", 1);
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
			}
		});

		// 출력 버튼 이벤트
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ta.setText("");
				ArrayList<Member_Data> arr = new ArrayList<Member_Data>();
				arr = db.readData();

				ta.append("\t아이디\t" + "이름\t" + "비밀번호\t" + "전화번호\t\t" + "관리자/손님\n");
				ta.append("\t"
						+ "-----------------------------------------------------------------------------------------------------------------------\n");

				// 전체출력
				for (int i = 0; i < arr.size(); i++) {
					ta.append("\t" + arr.get(i).getID() + "\t" + arr.get(i).getName() + "\t" + arr.get(i).getPassword()
							+ "\t" + arr.get(i).getPhonenum() + "\t\t" + arr.get(i).getPassenger() + "\n");

				}

			}
		});

		// 수정 버튼 이벤트
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ta.setText("");

				String user_id = tf1.getText();
				String user_name = tf2.getText();
				String user_password = tf3.getText();
				String user_phonenum = tf4.getText();

				Pattern passPattern = Pattern.compile("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*\\W).{8,20}$");
				Matcher passMatcher = passPattern.matcher(user_password);
				Pattern passPattern2 = Pattern.compile("\\d");
				Matcher passMatcher2 = passPattern2.matcher(user_phonenum);

				if (!passMatcher.find()) {
					JOptionPane.showMessageDialog(null, "비밀번호는 영문+특수문자+숫자 8자로 구성되어야 합니다", "비밀번호 오류", 1);
					return;
				} else if (!passMatcher2.find()) {
					JOptionPane.showMessageDialog(null, "전화번호는 숫자로만 구성되어야 합니다", "전화번호 오류", 1);
					return;
				} else {
					db.updateData(new Member_Update_Data(user_id, user_name, user_password, user_phonenum));
					JOptionPane.showMessageDialog(null, "수정되었습니다!", "알림", 1);
				}

				tf1.setText("");
				tf2.setText("");
				tf3.setText("");
				tf4.setText("");
			}
		});

		// 삭제 버튼 이벤트
		btn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ta.setText("");

				String user_id = tf1.getText();
				db.deleteData(user_id);
				JOptionPane.showMessageDialog(null, "삭제되었습니다!", "알림", 1);

				tf1.setText("");
				tf2.setText("");
				tf3.setText("");
				tf4.setText("");
				tf5.setText("");
			}
		});

		// 검색 버튼 이벤트
		btn5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ta.setText("");
				String user_id = tf1.getText();
				ArrayList<Member_Data> arr = new ArrayList<Member_Data>();
				arr = db.search(user_id);

				ta.append("\t아이디\t" + "이름\t" + "비밀번호\t" + "전화번호\t\t" + "관리자/손님\n");
				ta.append("\t"
						+ "-----------------------------------------------------------------------------------------------------------------------\n");

				// 전체출력
				if (arr.isEmpty()) {
					JOptionPane.showMessageDialog(null, "저장된 아이디가 없습니다", "아이디 오류", 1);
					return;
				} else {
					
					for (int i = 0; i < arr.size(); i++) {
						ta.append("\t" + arr.get(i).getID() + "\t" + arr.get(i).getName() + "\t" + arr.get(i).getPassword()
								+ "\t" + arr.get(i).getPhonenum() + "\t\t" + arr.get(i).getPassenger() + "\n");
					}
				}

			}
		});
	}
}
