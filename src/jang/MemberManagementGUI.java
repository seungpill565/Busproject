package jang;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import jang.Data.Member_Data;
import jang.Data.Member_Update_Data;

public class MemberManagementGUI extends JFrame {
	
	JScrollPane scrolledpane;
	JPanel panel = new JPanel();
	JTextField tf1 = new JTextField();
	JTextField tf2 = new JTextField();
	JTextField tf3 = new JTextField();
	JTextField tf4 = new JTextField();
	JTextField tf5 = new JTextField();
	JTextField tf6 = new JTextField();

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
	JLabel l6 = new JLabel("ID : ");

	JLabel pName = new JLabel("회원");
	// JButton backBtn;
	JButton homeBtn;

	ImageIcon image = new ImageIcon("Image/back2.png");
	ImageIcon image2 = new ImageIcon("Image/back3.png");

	ImageIcon home_image = new ImageIcon("Image/home.png");
	ImageIcon home_image2 = new ImageIcon("Image/home2.png");

	public MemberManagementGUI() {
		MemberManagementGUI();
	}

	Member_DB db = new Member_DB();

	public void allView() {
		try {
			remove(scrolledpane);			
		} catch(NullPointerException e) {
			
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
		scrolledpane = new JScrollPane();
		scrolledpane.setViewportView(table);
//		table.setEnabled(false);

		scrolledpane.setBounds(40, 150, 700, 330);
		getContentPane().add(scrolledpane);
	}

	public void searchView(String user_id) {
		try {
			remove(scrolledpane);			
		} catch(NullPointerException e) {
			
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
		scrolledpane = new JScrollPane();
		scrolledpane.setViewportView(table);

		scrolledpane.setBounds(40, 150, 700, 330);
		getContentPane().add(scrolledpane);
	}

	public void MemberManagementGUI() {
		setTitle("회원 관리 프로그램");
		add(panel);
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		setResizable(false);
		setBounds(500, 150, 800, 650);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		homeBtn = new JButton(home_image);
		homeBtn.setRolloverIcon(home_image2);
		homeBtn.setBorderPainted(false);
		homeBtn.setBounds(700, 30, 50, 50);
		panel.add(homeBtn);

		pName.setBounds(350, 30, 200, 50);
		pName.setFont(new Font("휴먼매직체", Font.BOLD, 40));
		panel.add(pName);

		// 입력 공간
		tf1.setBounds(70, 500, 80, 25);
		tf1.setFont(new Font("휴먼매직체", Font.PLAIN, 15));
		panel.add(tf1); // 아이디 입력 공간
		tf6.setBounds(70, 550, 80, 25);
		tf6.setFont(new Font("휴먼매직체", Font.PLAIN, 15));
//		tf6.setText("아이디 입력");
		panel.add(tf6); // 아이디 입력 공간 (검색)
		tf2.setBounds(195, 500, 60, 25);
		tf2.setFont(new Font("휴먼매직체", Font.PLAIN, 15));
		panel.add(tf2); // 이름 입력 공간
		tf3.setBounds(325, 500, 100, 25);
		tf3.setFont(new Font("휴먼매직체", Font.PLAIN, 15));
		panel.add(tf3); // 비번
		tf4.setBounds(495, 500, 100, 25);
		tf4.setFont(new Font("휴먼매직체", Font.PLAIN, 15));
		panel.add(tf4); // 전번
		tf5.setBounds(685, 500, 60, 25);
		tf5.setFont(new Font("휴먼매직체", Font.PLAIN, 15));
		panel.add(tf5); // 관리자유무

		// 입력 공간 라벨 이름
		l1.setBounds(40, 500, 80, 30);
		l1.setFont(new Font("휴먼매직체", Font.PLAIN, 15));
		panel.add(l1); // 아이디 라벨
		l6.setBounds(40, 550, 60, 30);
		l6.setFont(new Font("휴먼매직체", Font.PLAIN, 15));
		panel.add(l6); // 아이디 라벨
		l2.setBounds(155, 500, 80, 30);
		l2.setFont(new Font("휴먼매직체", Font.PLAIN, 15));
		panel.add(l2); // 이름 라벵
		l3.setBounds(260, 500, 80, 30);
		l3.setFont(new Font("휴먼매직체", Font.PLAIN, 15));
		panel.add(l3); // 비번
		l4.setBounds(430, 500, 80, 30);
		l4.setFont(new Font("휴먼매직체", Font.PLAIN, 15));
		panel.add(l4); // 전번
		l5.setBounds(600, 500, 90, 30);
		l5.setFont(new Font("휴먼매직체", Font.PLAIN, 15));
		panel.add(l5); // 관리자유무

		btn1.setBounds(130, 100, 70, 30);
		btn1.setBackground(new Color(0XE7E6E6));
		btn2.setBounds(40, 100, 70, 30);
		btn2.setBackground(new Color(0XE7E6E6));
		btn3.setBounds(355, 550, 70, 30);
		btn3.setBackground(new Color(0XE7E6E6));
		btn4.setBounds(240, 550, 70, 30);
		btn4.setBackground(new Color(0XE7E6E6));
		btn5.setBounds(160, 550, 70, 30);
		btn5.setBackground(new Color(0XE7E6E6));

		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(btn4);
		panel.add(btn5);
		
		// 홈 버튼
		homeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				new Admin_MainFrame(); // 나중에 메인으로 바꾸면 됨
				new ManagerMainFrame2();
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
				if (arr.isEmpty()) {
					JOptionPane.showMessageDialog(null, "아이디가 존재하지 않습니다", "아이디 오류", 1);
					return;
				} else {
					db.deleteData(user_id);
					JOptionPane.showMessageDialog(null, "삭제되었습니다!", "알림", 1);
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
