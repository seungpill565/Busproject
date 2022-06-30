package jang;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
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
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import an.admin.Admin_MainFrame;
import jang.Data.Member_Data;
import jang.Data.Member_Update_Data;

public class MemberManagementGUI extends JFrame {
	ArrayList<JTextField> tfList = new ArrayList<>();

	JScrollPane scrollpane;
	JLabel panel = new JLabel();
	JTextField tf1 = new JTextField();
	JTextField tf2 = new JTextField();
	JTextField tf3 = new JTextField();
	JTextField tf4 = new JTextField();
	JTextField tf5 = new JTextField();
	JTextField tf6 = new JTextField();

	RoundButton btn1 = new RoundButton("추가");
	RoundButton btn2 = new RoundButton("전체 조회");
	RoundButton btn3 = new RoundButton("수정");
	RoundButton btn4 = new RoundButton("삭제");
	RoundButton btn5 = new RoundButton("검색");

	JLabel l1 = new JLabel("ID : ");
	JLabel l2 = new JLabel("이름 : ");
	JLabel l3 = new JLabel("비밀번호 : ");
	JLabel l4 = new JLabel("전화번호 : ");
	JLabel l5 = new JLabel("관리자/손님 : ");
	JLabel l6 = new JLabel("ID : ");
	JLabel imageLabel = new JLabel();

	JLabel pName = new JLabel("회원");
	// JButton backBtn;
	JButton homeBtn;

	ImageIcon image = new ImageIcon("Image/back2.png");
	ImageIcon image2 = new ImageIcon("Image/back3.png");
	ImageIcon image3 = new ImageIcon("Image/yujin2.jpg");

	ImageIcon home_image = new ImageIcon("Image/home.png");
	ImageIcon home_image2 = new ImageIcon("Image/home2.png");

	public MemberManagementGUI() {
		MemberManagementGUI();

		tfList.add(tf1);
		tfList.add(tf2);
		tfList.add(tf3);
		tfList.add(tf4);
		tfList.add(tf5);
		tfList.add(tf6);

		for (int i = 0; i < tfList.size(); ++i) {
			JTextField tf = tfList.get(i);
			tf.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					tf.setText("");
				}
			});
		}

	}

	Member_DB db = new Member_DB();

	public void allView() {
		try {
			remove(scrollpane);
		} catch (NullPointerException e) {

		}

		ArrayList<Member_Data> arr = db.readData();

		String[] colNames = { "아이디", "이름", "비밀번호", "전화번호", "관리자/손님" };
		String[][] rowData = new String[arr.size()][colNames.length];

		for (int row = 0; row < rowData.length; ++row) {
			rowData[row][0] = arr.get(row).getID();
			rowData[row][1] = arr.get(row).getName();
			rowData[row][2] = arr.get(row).getPassword();
			rowData[row][3] = arr.get(row).getPhonenum();
			rowData[row][4] = arr.get(row).getPassenger();
		}

		DefaultTableModel model = new DefaultTableModel(rowData, colNames) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		JTable table = new JTable(model);
		ListSelectionModel selectionModel = table.getSelectionModel();
		selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getTableHeader().setReorderingAllowed(false);

		selectionModel.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {

				if (!e.getValueIsAdjusting()) {
					System.out.println("select row : " + table.getSelectedRow());
					int row = table.getSelectedRow();
					tf1.setText(rowData[row][0]);
					tf2.setText(rowData[row][1]);
					tf3.setText(rowData[row][2]);
					tf4.setText(rowData[row][3]);
					tf5.setText(rowData[row][4]);
				}

			}
		});

		model.fireTableDataChanged();
		scrollpane = new JScrollPane();
		scrollpane.setViewportView(table);
//		table.setEnabled(false);
//		table.setFont(new Font("휴먼편지체", Font.PLAIN, 15));

		scrollpane.setBounds(40, 170, 710, 220);
		getContentPane().add(scrollpane);
	}

	public void searchView(String user_id) {
		try {
			remove(scrollpane);
		} catch (NullPointerException e) {

		}

		ArrayList<Member_Data> arr = db.search(user_id);

		String[] colNames = { "아이디", "이름", "비밀번호", "전화번호", "관리자/손님" };
		String[][] rowData = new String[arr.size()][colNames.length];

		for (int row = 0; row < rowData.length; ++row) {
			rowData[row][0] = arr.get(row).getID();
			rowData[row][1] = arr.get(row).getName();
			rowData[row][2] = arr.get(row).getPassword();
			rowData[row][3] = arr.get(row).getPhonenum();
			rowData[row][4] = arr.get(row).getPassenger();
		}

		DefaultTableModel model = new DefaultTableModel(rowData, colNames) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		JTable table = new JTable(model);

		ListSelectionModel selectionModel = table.getSelectionModel();
		selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getTableHeader().setReorderingAllowed(false);

		selectionModel.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {

				if (!e.getValueIsAdjusting()) {
					System.out.println("select row : " + table.getSelectedRow());
					int row = table.getSelectedRow();
					tf1.setText(rowData[row][0]);
					tf2.setText(rowData[row][1]);
					tf3.setText(rowData[row][2]);
					tf4.setText(rowData[row][3]);
					tf5.setText(rowData[row][4]);
				}

			}
		});

		model.fireTableDataChanged();
		scrollpane = new JScrollPane();
		scrollpane.setViewportView(table);
//		table.setFont(new Font("휴먼편지체", Font.PLAIN, 15));

		scrollpane.setBounds(40, 170, 710, 220);
		getContentPane().add(scrollpane);
	}

	public void MemberManagementGUI() {
		setTitle("회원 관리 프로그램");
		add(panel);
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		setResizable(false);
		setSize(800, 650);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		homeBtn = new JButton(home_image);
//		homeBtn.setRolloverIcon(home_image2);
		homeBtn.setBorderPainted(false);
		homeBtn.setBounds(700, 20, 50, 50);
		homeBtn.setContentAreaFilled(false);
		panel.add(homeBtn);

		pName.setBounds(350, 10, 200, 50);
		pName.setFont(new Font("휴먼편지체", Font.BOLD, 35));
		panel.add(pName);

//		panel.add(imageLabel);
		panel.setIcon(image3);

		btn1.setBounds(160, 80, 70, 30); // 추가
		btn1.setBackground(Color.white);
		btn1.setFont(new Font("휴먼편지체", Font.BOLD, 15));
		btn2.setBounds(40, 80, 100, 30); // 조회
		btn2.setBackground(new Color(0XE7E6E6));
		btn2.setFont(new Font("휴먼편지체", Font.BOLD, 15));
		btn3.setBounds(250, 80, 70, 30); // 수정
		btn3.setBackground(new Color(0XE7E6E6));
		btn3.setFont(new Font("휴먼편지체", Font.BOLD, 15));
		btn4.setBounds(680, 410, 70, 30); // 삭제
		btn4.setBackground(new Color(0XE7E6E6));
		btn4.setFont(new Font("휴먼편지체", Font.BOLD, 15));
		btn5.setBounds(600, 410, 70, 30); // 검색
		btn5.setBackground(new Color(0XE7E6E6));
		btn5.setFont(new Font("휴먼편지체", Font.BOLD, 15));

		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(btn4);
		panel.add(btn5);

//		TextHint tHint = new TextHint(" 아이디 입력");
//		tHint.setBounds(490, 410, 100, 30);
//		panel.add(tHint);

		// 입력 공간
		tf1.setBounds(70, 130, 80, 25);
		tf1.setFont(new Font("휴먼편지체", Font.PLAIN, 15));
		panel.add(tf1); // 아이디 입력 공간
		tf6.setBounds(490, 410, 100, 30);
		tf6.setFont(new Font("휴먼편지체", Font.PLAIN, 15));
		tf6.setText("아이디 입력");
		panel.add(tf6); // 아이디 입력 공간 (검색)
		tf2.setBounds(195, 130, 60, 25);
		tf2.setFont(new Font("휴먼편지체", Font.PLAIN, 15));
		panel.add(tf2); // 이름 입력 공간
		tf3.setBounds(325, 130, 80, 25);
		tf3.setFont(new Font("휴먼편지체", Font.PLAIN, 15));
		panel.add(tf3); // 비번
		tf4.setBounds(475, 130, 120, 25);
		tf4.setFont(new Font("휴먼편지체", Font.PLAIN, 15));
		panel.add(tf4); // 전번
		tf5.setBounds(685, 130, 60, 25);
		tf5.setFont(new Font("휴먼편지체", Font.PLAIN, 15));
		panel.add(tf5); // 관리자유무

		// 입력 공간 라벨 이름
		l1.setBounds(40, 130, 80, 30);
		l1.setFont(new Font("휴먼편지체", Font.PLAIN, 15));
		panel.add(l1); // 아이디 라벨
		l2.setBounds(155, 130, 80, 30);
		l2.setFont(new Font("휴먼편지체", Font.PLAIN, 15));
		panel.add(l2); // 이름 라벵
		l3.setBounds(260, 130, 80, 30);
		l3.setFont(new Font("휴먼편지체", Font.PLAIN, 15));
		panel.add(l3); // 비번
		l4.setBounds(410, 130, 80, 30);
		l4.setFont(new Font("휴먼편지체", Font.PLAIN, 15));
		panel.add(l4); // 전번
		l5.setBounds(600, 130, 90, 30);
		l5.setFont(new Font("휴먼편지체", Font.PLAIN, 15));
		panel.add(l5); // 관리자유무

		// 홈 버튼
		homeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Admin_MainFrame(); // 나중에 메인으로 바꾸면 됨
//				new ManagerMainFrame2();
				dispose();
			}
		});

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
				Pattern passPattern2 = Pattern.compile("\\d{3}-\\d{4}-\\d{4}");
				Matcher passMatcher2 = passPattern2.matcher(user_phonenum);
				Pattern passPattern3 = Pattern.compile("[0-9]+");
				Matcher passMatcher3 = passPattern3.matcher(user_name);
				Pattern passPattern4 = Pattern.compile("^[a-zA-Z]{1}[a-zA-Z0-9_]{4,11}$");
				Matcher passMatcher4 = passPattern4.matcher(user_id);

				Member_Data data = new Member_Data(user_id, user_name, user_password, user_phonenum,
						user_passenger_manager);
				if (user_id.equals("") || user_name.equals("") || user_password.equals("") || user_phonenum.equals("")
						|| user_passenger_manager.equals("")) {
					JOptionPane.showMessageDialog(null, "정보를 모두 입력해주세요", "알림", 1);
					return;
				} else if (!arr.isEmpty()) {
					JOptionPane.showMessageDialog(null, "아이디가 중복됩니다", "아이디 중복", 1);
					return;
				} else if (!passMatcher4.find()) {
					JOptionPane.showMessageDialog(null, "한글 또는 영문만 입력해주세요", "아이디 오류", 1);
					return;
				} else if (!passMatcher3.find()) {
					JOptionPane.showMessageDialog(null, "한글 또는 영문만 입력해주세요", "이름 오류", 1);
					return;
				} else if (!passMatcher.find()) {
					JOptionPane.showMessageDialog(null, "비밀번호는 영문+특수문자+숫자 8자로 구성되어야 합니다", "비밀번호 오류", 1);
					return;
				} else if (!passMatcher2.find()) {
					JOptionPane.showMessageDialog(null, "전화번호를 다시 입력하세요\nex) xxx-xxxx-xxxx", "전화번호 오류", 1);
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
				allView();
			}

		});

		// 출력 버튼 이벤트
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				allView();
			}
		});

		// 수정 버튼 이벤트
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String user_id = tf1.getText();
				String user_name = tf2.getText();
				String user_password = tf3.getText();
				String user_phonenum = tf4.getText();

				Pattern passPattern = Pattern.compile("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*\\W).{8,20}$");
				Matcher passMatcher = passPattern.matcher(user_password);
				Pattern passPattern2 = Pattern.compile("\\d{3}-\\d{4}-\\d{4}");
				Matcher passMatcher2 = passPattern2.matcher(user_phonenum);
				Pattern passPattern3 = Pattern.compile("[0-9]+");
				Matcher passMatcher3 = passPattern3.matcher(user_name);
				Pattern passPattern4 = Pattern.compile("^[a-zA-Z]{1}[a-zA-Z0-9_]{4,11}$");
				Matcher passMatcher4 = passPattern4.matcher(user_id);

				ArrayList<Member_Data> arr = new ArrayList<Member_Data>();
				arr = db.search(user_id);

				int update = JOptionPane.showConfirmDialog(null, "수정하시겠습니까?", "수정 확인", JOptionPane.YES_NO_OPTION);
				if (user_id.equals("") || user_name.equals("") || user_password.equals("")
						|| user_phonenum.equals("")) {
					JOptionPane.showMessageDialog(null, "정보를 모두 입력해주세요", "알림", 1);
					return;
				} else if (!passMatcher4.find()) {
					JOptionPane.showMessageDialog(null, "한글 또는 영문만 입력해주세요", "아이디 오류", 1);
					return;
				} else if (!passMatcher3.find()) {
					JOptionPane.showMessageDialog(null, "한글 또는 영문만 입력해주세요", "이름 오류", 1);
					return;
				} else if (!passMatcher.find()) {
					JOptionPane.showMessageDialog(null, "비밀번호는 영문+특수문자+숫자 8자로 구성되어야 합니다", "비밀번호 오류", 1);
					return;
				} else if (!passMatcher2.find()) {
					JOptionPane.showMessageDialog(null, "전화번호를 다시 입력하세요\\nex) xxx-xxxx-xxxx", "전화번호 오류", 1);
					return;
				} else {
					if (update == JOptionPane.YES_OPTION) {
						db.updateData(new Member_Update_Data(user_id, user_name, user_password, user_phonenum));
						JOptionPane.showMessageDialog(null, "수정되었습니다!", "알림", 1);

					}
					allView();
				}
				tf1.setText("");
				tf2.setText("");
				tf3.setText("");
				tf4.setText("");
				tf5.setText("");

			}
		});

		// 삭제 버튼 이벤트
		btn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String user_id = tf1.getText();
				ArrayList<Member_Data> arr = new ArrayList<Member_Data>();
				arr = db.search(user_id);
				int delete = JOptionPane.showConfirmDialog(null, "삭제하시겠습니까?", "삭제 확인", JOptionPane.YES_NO_OPTION);

				if (user_id.equals("")) {
					JOptionPane.showMessageDialog(null, "ID를 입력해주세요", "알림", 1);
					return;
				} else if (arr.isEmpty()) {
					JOptionPane.showMessageDialog(null, "아이디가 존재하지 않습니다", "아이디 오류", 1);
					return;
				} else {
					if (delete == JOptionPane.YES_OPTION) {
						db.deleteData(user_id);
						JOptionPane.showMessageDialog(null, "삭제되었습니다!", "알림", 1);

					}
					allView();

				}

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
				String user_id = tf6.getText();
				ArrayList<Member_Data> arr = new ArrayList<Member_Data>();
				arr = db.search(user_id);

				// 전체 출력
				if (arr.isEmpty()) {
					JOptionPane.showMessageDialog(null, "아이디가 존재하지 않습니다", "아이디 오류", 1);
					return;
				} else {
					searchView(user_id);

				}

				tf6.setText("");

			}
		});
	}
}
