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
import jang.Data.Route_Read_Data;
import jang.Route.Route_Insert;

public class RouteManageMentGUI extends JFrame {
	ArrayList<JTextField> tfList = new ArrayList<>();

	JScrollPane scrollpane;
	JPanel panel = new JPanel();

	RoundButton btn1 = new RoundButton("추가");
	RoundButton btn2 = new RoundButton("전체 조회");
	RoundButton btn3 = new RoundButton("수정");
	RoundButton btn4 = new RoundButton("삭제");
	RoundButton btn5 = new RoundButton("검색");

	JLabel pName = new JLabel("노선");

	JTextField tf1 = new JTextField();
	JTextField tf2 = new JTextField();
	JTextField tf3 = new JTextField();
	JTextField tf4 = new JTextField();
	JTextField search_tf = new JTextField("도착지 입력");
	JTextField delete = new JTextField();
	JTextField tf5 = new JTextField();

	JLabel l1 = new JLabel("버스 ID : ");
	JLabel l2 = new JLabel("노선 ID : ");
	JLabel l3 = new JLabel("날짜 : ");
	JLabel l4 = new JLabel("시간 : ");

	JButton homeBtn;

	ImageIcon image = new ImageIcon("Image/back2.png");
	ImageIcon image2 = new ImageIcon("Image/back3.png");

	ImageIcon home_image = new ImageIcon("Image/home.png");
	ImageIcon home_image2 = new ImageIcon("Image/home2.png");

	Route_DB db = new Route_DB();

	public RouteManageMentGUI() {
		RouteManageMentGUI();
		tfList.add(tf1);
		tfList.add(tf2);
		tfList.add(tf3);
		tfList.add(tf4);
		tfList.add(search_tf);
		tfList.add(delete);

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

	public void allView() {
		try {
			remove(scrollpane);
		} catch (NullPointerException e) {

		}

		ArrayList<Route_Read_Data> arr = db.readData();

		String[] colNames = { "버스 ID", "노선 ID", "출발지", "도착지", "요금", "날짜", "시간" };
		String[][] rowData = new String[arr.size()][colNames.length];

		for (int row = 0; row < rowData.length; ++row) {
			rowData[row][0] = Integer.toString(arr.get(row).getBI_ID());
			rowData[row][1] = Integer.toString(arr.get(row).getRT_ID());
			rowData[row][2] = arr.get(row).getDepart();
			rowData[row][3] = arr.get(row).getArrive();
			rowData[row][4] = arr.get(row).getCharge();
			rowData[row][5] = arr.get(row).getDay();
			rowData[row][6] = arr.get(row).getTime();
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
					tf3.setText(rowData[row][5]);
					tf4.setText(rowData[row][6]);
//					tf5.setText(rowData[row][0]);
//					search.setText(rowData[row][3]);
				}

			}
		});

		model.fireTableDataChanged();
		scrollpane = new JScrollPane();
		scrollpane.setViewportView(table);
//		table.setEnabled(false);
//		table.setFont(new Font("휴먼편지체", Font.PLAIN, 15));

		scrollpane.setBounds(40, 170, 700, 220);
		getContentPane().add(scrollpane);
	}

	public void searchView(String arrive) {
		try {
			remove(scrollpane);
		} catch (NullPointerException e) {

		}

		ArrayList<Route_Read_Data> arr = db.searchRoute(arrive);

		String[] colNames = { "버스 ID", "노선 ID", "출발지", "도착지", "요금", "날짜", "시간" };
		String[][] rowData = new String[arr.size()][colNames.length];

		for (int row = 0; row < rowData.length; ++row) {
			rowData[row][0] = Integer.toString(arr.get(row).getBI_ID());
			rowData[row][1] = Integer.toString(arr.get(row).getRT_ID());
			rowData[row][2] = arr.get(row).getDepart();
			rowData[row][3] = arr.get(row).getArrive();
			rowData[row][4] = arr.get(row).getCharge();
			rowData[row][5] = arr.get(row).getDay();
			rowData[row][6] = arr.get(row).getTime();
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
					tf3.setText(rowData[row][5]);
					tf4.setText(rowData[row][6]);
//					tf5.setText(rowData[row][0]);
//	               tf5.setText(rowData[row][4]);
				}

			}
		});

		
		model.fireTableDataChanged();
		scrollpane = new JScrollPane();
		scrollpane.setViewportView(table);
//		table.setEnabled(false);
//		table.setFont(new Font("휴먼편지체", Font.PLAIN, 15));
		
		scrollpane.setBounds(40, 150, 700, 300);
		getContentPane().add(scrollpane);
	}

	public void RouteManageMentGUI() {
		setTitle("노선 관리 프로그램");
		add(panel);
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		setResizable(false);
		setSize(800, 500);
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

		btn1.setBounds(160, 80, 70, 30); // 추가
		btn1.setBackground(new Color(0XE7E6E6));
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


		// 입력 공간 라벨
		tf1.setBounds(100, 130, 80, 25);
		tf1.setFont(new Font("휴먼편지체", Font.PLAIN, 15));
		panel.add(tf1); // 버스 ID
		search_tf.setBounds(490, 410, 100, 30);
		search_tf.setFont(new Font("휴먼편지체", Font.PLAIN, 15));
		panel.add(search_tf);
		tf2.setBounds(250, 130, 80, 25);
		tf2.setFont(new Font("휴먼편지체", Font.PLAIN, 15));
		panel.add(tf2); // 노선 ID
		tf3.setBounds(390, 130, 80, 25);
		tf3.setFont(new Font("휴먼편지체", Font.PLAIN, 15));
		panel.add(tf3); // 날짜
		tf4.setBounds(530, 130, 80, 25);
		tf4.setFont(new Font("휴먼편지체", Font.PLAIN, 15));
		panel.add(tf4); // 시간

		// 입력 공간 라벨 이름
		l1.setBounds(40, 130, 80, 30);
		l1.setFont(new Font("휴먼편지체", Font.PLAIN, 15));
		panel.add(l1); // 버스 ID
		l2.setBounds(190, 130, 80, 30);
		l2.setFont(new Font("휴먼편지체", Font.PLAIN, 15));
		panel.add(l2); // 노선 ID
		l3.setBounds(340, 130, 80, 30);
		l3.setFont(new Font("휴먼편지체", Font.PLAIN, 15));
		panel.add(l3); // 날짜
		l4.setBounds(480, 130, 80, 30);
		l4.setFont(new Font("휴먼편지체", Font.PLAIN, 15));
		panel.add(l4); // 시간

		// 홈 버튼
		homeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Admin_MainFrame(); // 나중에 메인으로 바꾸면 됨
//				new ManagerMainFrame2();
				dispose();
			}
		});

		// 입력 버튼
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Route_Insert();
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

		// 수정 버튼
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String bi_id = tf1.getText();
				String rt_id = tf2.getText();
				String bi_day = tf3.getText();
				String bi_time = tf4.getText();

				Pattern passPattern = Pattern.compile("\\d{2}/\\d{2}/\\d{2}");
				Matcher passMatcher = passPattern.matcher(bi_day);
				Pattern passPattern2 = Pattern.compile("\\d{2}:\\d{2}");
				Matcher passMatcher2 = passPattern2.matcher(bi_time);
				
				int update = JOptionPane.showConfirmDialog(null, "수정하시겠습니까?", "수정 확인", JOptionPane.YES_NO_OPTION);
				if (bi_day.equals("") || bi_time.equals("") || bi_id.equals("") || rt_id.equals("")) {
					if(update == JOptionPane.YES_OPTION) {
						JOptionPane.showMessageDialog(null, "정보를 모두 입력해주세요", "알림", 1);
						return;
					}
				} 
				else if (!passMatcher.find()) {
					JOptionPane.showMessageDialog(null, "날짜를 다시 입력해주세요\nex) xx/xx/xx", "날짜 오류", 1);
					return;
				} else if (!passMatcher2.find()) {
					JOptionPane.showMessageDialog(null, "시간을 다시 입력해주세요\nex) 24:00", "시간 오류", 1);
					return;
				} else {
					if (update == JOptionPane.YES_OPTION) {
						db.updateData(bi_id, rt_id, bi_day, bi_time);
						JOptionPane.showMessageDialog(null, "수정되었습니다!");
						
					}

				}

				tf1.setText("");
				tf2.setText("");
				tf3.setText("");
				tf4.setText("");

				allView();

			}
		});

		// 삭제 버튼 이벤트
		btn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String bi_id = tf1.getText();
				
				int delete = JOptionPane.showConfirmDialog(null, "삭제하시겠습니까?", "삭제 확인", JOptionPane.YES_NO_OPTION);
				if (bi_id.equals("")) {
					if(delete == JOptionPane.YES_OPTION) {
						JOptionPane.showMessageDialog(null, "버스 ID를 입력해주세요", "알림", 1);
						return;
					} 
				} else if(delete == JOptionPane.YES_OPTION) {
					db.rv_deleteData(bi_id);
					db.seat_deleteData(bi_id);
					db.deleteData(bi_id);					
					JOptionPane.showMessageDialog(null, "삭제되었습니다!", "알림", 1);
				} 
				
				tf1.setText("");
				tf2.setText("");
				tf3.setText("");
				tf4.setText("");
				
				allView();
			}
		});

		// 검색
		btn5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String arrive = search_tf.getText();
				ArrayList<Route_Read_Data> arr = new ArrayList<Route_Read_Data>();
				arr = db.searchRoute(arrive);

				// 전체 출력
				if (arr.isEmpty()) {
					JOptionPane.showMessageDialog(null, "저장된 노선이 없습니다", "오류", 1);
					return;
				} else {
					searchView(arrive);

				}

				search_tf.setText("");
			}

		});

	}

}
