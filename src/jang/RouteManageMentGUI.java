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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import jang.Data.Route_Read_Data;
import jang.Route.Route_Insert;

public class RouteManageMentGUI extends JFrame {
	ArrayList<JTextField> tfList = new ArrayList<>();

	JScrollPane scrolledpane;
	JPanel panel = new JPanel();

	JTextArea ta = new JTextArea();

	JButton btn1 = new JButton("추가");
	JButton btn2 = new JButton("전체 조회");
	JButton btn3 = new JButton("수정");
	JButton btn4 = new JButton("삭제");
	JButton btn5 = new JButton("검색");

	JLabel pName = new JLabel("노선");

	JTextField tf1 = new JTextField();
	JTextField tf2 = new JTextField();
	JTextField tf3 = new JTextField();
	JTextField tf4 = new JTextField();
	JTextField search = new JTextField("도착지 입력");
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
		tfList.add(search);
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
			remove(scrolledpane);
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
		scrolledpane = new JScrollPane();
		scrolledpane.setViewportView(table);
//		table.setEnabled(false);

		scrolledpane.setBounds(40, 200, 700, 330);
		getContentPane().add(scrolledpane);
	}

	public void searchView(String arrive) {
		try {
			remove(scrolledpane);
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
		scrolledpane = new JScrollPane();
		scrolledpane.setViewportView(table);
//		table.setEnabled(false);

		scrolledpane.setBounds(40, 200, 700, 330);
		getContentPane().add(scrolledpane);
	}

	public void RouteManageMentGUI() {
		setTitle("노선 관리 프로그램");
		add(panel);
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		setResizable(false);
		setBounds(10, 20, 800, 650);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		homeBtn = new JButton(home_image);
		homeBtn.setRolloverIcon(home_image2);
		homeBtn.setBorderPainted(false);
		homeBtn.setBounds(700, 30, 50, 50);
		panel.add(homeBtn);

		pName.setBounds(230, 30, 300, 50);
		pName.setFont(new Font("휴먼매직체", Font.BOLD, 40));
		panel.add(pName);

		btn1.setBounds(160, 100, 70, 30);
		btn1.setBackground(new Color(0XE7E6E6));
		btn2.setBounds(40, 100, 100, 30);
		btn2.setBackground(new Color(0XE7E6E6));
		btn3.setBounds(250, 100, 70, 30);
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

		search.setBounds(40, 550, 100, 30);
		panel.add(search);

		// 입력 공간 라벨
		tf1.setBounds(100, 150, 80, 25);
		tf1.setFont(new Font("휴먼매직체", Font.PLAIN, 15));
		panel.add(tf1); // 날짜 // 버스 ID
		tf2.setBounds(250, 150, 80, 25);
		tf2.setFont(new Font("휴먼매직체", Font.PLAIN, 15));
		panel.add(tf2); // 시간 // 노선 ID
		tf3.setBounds(390, 150, 80, 25);
		tf3.setFont(new Font("휴먼매직체", Font.PLAIN, 15));
		panel.add(tf3); // 노선 ID // 날짜
		tf4.setBounds(530, 150, 80, 25);
		tf4.setFont(new Font("휴먼매직체", Font.PLAIN, 15));
		panel.add(tf4); // 버스 ID // 시간

		// 입력 공간 라벨 이름
		l1.setBounds(40, 150, 80, 30);
		l1.setFont(new Font("휴먼매직체", Font.PLAIN, 15));
		panel.add(l1); // 버스 ID
		l2.setBounds(190, 150, 80, 30);
		l2.setFont(new Font("휴먼매직체", Font.PLAIN, 15));
		panel.add(l2); // 노선 ID
		l3.setBounds(340, 150, 80, 30);
		l3.setFont(new Font("휴먼매직체", Font.PLAIN, 15));
		panel.add(l3); // 날짜
		l4.setBounds(480, 150, 80, 30);
		l4.setFont(new Font("휴먼매직체", Font.PLAIN, 15));
		panel.add(l4); // 시간

		// 홈 버튼
		homeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				new Admin_MainFrame(); // 나중에 메인으로 바꾸면 됨
				new ManagerMainFrame2();
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
				int bi_id = Integer.parseInt(tf1.getText());
				int rt_id = Integer.parseInt(tf2.getText());
				String bi_day = tf3.getText();
				String bi_time = tf4.getText();

				Pattern passPattern = Pattern.compile("\\d{2}/\\d{2}/\\d{2}");
				Matcher passMatcher = passPattern.matcher(bi_day);
				Pattern passPattern2 = Pattern.compile("\\d{2}:\\d{2}");
				Matcher passMatcher2 = passPattern2.matcher(bi_time);
				
				if (bi_day.equals("") || bi_time.equals("")) {
					JOptionPane.showMessageDialog(null, "정보를 모두 입력해주세요", "알림", 1);
					return;
				} 
				else if (!passMatcher.find()) {
					JOptionPane.showMessageDialog(null, "날짜를 다시 입력하세요\nex) xx/xx/xx", "날짜 오류", 1);
					return;
				} else if (!passMatcher2.find()) {
					JOptionPane.showMessageDialog(null, "시간을 다시 입력하세요\nex) 24:00", "시간 오류", 1);
					return;
				} else {
					db.updateData(bi_id, rt_id, bi_day, bi_time);

					JOptionPane.showMessageDialog(null, "추가되었습니다!");
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
				int bi_id = Integer.parseInt(tf1.getText());

				int delete = JOptionPane.showConfirmDialog(null, "삭제하시겠습니까?", "삭제 확인", JOptionPane.YES_NO_OPTION);
				if(delete == JOptionPane.YES_OPTION) {
					db.deleteData(bi_id);					
				} 
//				JOptionPane.showMessageDialog(null, "삭제되었습니다!", "알림", 1);
				allView();
			}
		});

		// 검색
		btn5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String arrive = search.getText();
				ArrayList<Route_Read_Data> arr = new ArrayList<Route_Read_Data>();
				arr = db.searchRoute(arrive);

				// 전체 출력
				if (arr.isEmpty()) {
					JOptionPane.showMessageDialog(null, "저장된 노선이 없습니다", "오류", 1);
					return;
				} else {
					searchView(arrive);

				}

				search.setText("");
			}

		});

	}

}
