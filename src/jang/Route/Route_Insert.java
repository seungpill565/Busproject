package jang.Route;

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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import jang.Route_DB;
import jang.Data.Route_Insert_Data;
import jang.Data.Route_Read_Data;

public class Route_Insert extends JFrame {

	JScrollPane scrolledpane;
	JPanel panel = new JPanel();

	JButton btn3 = new JButton("³ë¼± Á¶È¸");
	JButton btn1 = new JButton("Ãß°¡");
	JButton btn2 = new JButton("Ãß°¡");
	JButton btn4 = new JButton("È®ÀÎ");

	JLabel bus = new JLabel("¹ö½º Á¤º¸");
	JLabel route = new JLabel("³ë¼± Á¤º¸");

	JTextField tf1 = new JTextField();
	JTextField tf2 = new JTextField();
	JTextField tf3 = new JTextField();
	JTextField tf4 = new JTextField();
	JTextField tf5 = new JTextField();
	JTextField tf6 = new JTextField();
	JTextField tf7 = new JTextField();
	JTextField tf8 = new JTextField();

	JLabel l1 = new JLabel("³¯Â¥ : ");
	JLabel l2 = new JLabel("½Ã°£ : ");
	JLabel l3 = new JLabel("³ë¼± ID : ");
	JLabel l4 = new JLabel("Ãâ¹ß : ");
	JLabel l5 = new JLabel("µµÂø : ");
	JLabel l6 = new JLabel("¿ä±Ý : ");
	JLabel l7 = new JLabel("ÁÂ¼® ¹øÈ£ : ");
	JLabel l8 = new JLabel("¹ö½º ID : ");

	JLabel pName = new JLabel("³ë¼± Ãß°¡");

	Route_DB db = new Route_DB();

	public Route_Insert() {
		Route_Insert();
	}

	public void allView() {
		try {
			remove(scrolledpane);
		} catch (NullPointerException e) {

		}

		ArrayList<Route_Insert_Data> arr = db.route_readData();

		String[] colNames = { "³ë¼± ID", "Ãâ¹ßÁö", "µµÂøÁö", "¿ä±Ý" };
		String[][] rowData = new String[arr.size()][colNames.length];

		for (int row = 0; row < rowData.length; ++row) {
			rowData[row][0] = Integer.toString(arr.get(row).getRT_ID());
			rowData[row][1] = arr.get(row).getDepart();
			rowData[row][2] = arr.get(row).getArrive();
			rowData[row][3] = arr.get(row).getCharge();

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
					tf3.setText(rowData[row][0]);

				}

			}
		});

		model.fireTableDataChanged();
		scrolledpane = new JScrollPane();
		scrolledpane.setViewportView(table);
//		table.setEnabled(false);

		scrolledpane.setBounds(40, 320, 530, 230);
		getContentPane().add(scrolledpane);
	}

	public void Route_Insert() {
		setTitle("³ë¼± °ü¸® ÇÁ·Î±×·¥");
		add(panel);
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		setResizable(false);
		setBounds(10, 20, 650, 650);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);

		pName.setBounds(200, 30, 200, 50);
		pName.setFont(new Font("ÈÞ¸Õ¸ÅÁ÷Ã¼", Font.BOLD, 40));
		panel.add(pName);

		btn3.setBounds(40, 100, 100, 30); // ÀüÃ¼Á¶È¸
		btn3.setBackground(new Color(0XE7E6E6));
		btn1.setBounds(500, 185, 70, 30); // ³ë¼± Ãß°¡
		btn1.setBackground(new Color(0XE7E6E6));
		btn2.setBounds(500, 270, 70, 30); // ¹ö½º Ãß°¡
		btn2.setBackground(new Color(0XE7E6E6));
		btn4.setBounds(250, 570, 70, 30); // È®ÀÎ
		btn4.setBackground(new Color(0XE7E6E6));

		panel.add(btn3);
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn4);

		route.setBounds(40, 150, 80, 30);
		route.setFont(new Font("ÈÞ¸Õ¸ÅÁ÷Ã¼", Font.BOLD, 20));
		panel.add(route);
		bus.setBounds(40, 230, 80, 30);
		bus.setFont(new Font("ÈÞ¸Õ¸ÅÁ÷Ã¼", Font.BOLD, 20));
		panel.add(bus);
//		seat.setBounds(20, 260, 80, 30);
//		seat.setFont(new Font("ÈÞ¸Õ¸ÅÁ÷Ã¼", Font.BOLD, 20));
//		panel.add(seat);

		// ÀÔ·Â °ø°£ ¶óº§
		tf1.setBounds(90, 270, 80, 25);
		tf1.setFont(new Font("ÈÞ¸Õ¸ÅÁ÷Ã¼", Font.PLAIN, 15));
		panel.add(tf1); // ³¯Â¥
		tf2.setBounds(230, 270, 80, 25);
		tf2.setFont(new Font("ÈÞ¸Õ¸ÅÁ÷Ã¼", Font.PLAIN, 15));
		panel.add(tf2); // ½Ã°£
		tf3.setBounds(390, 270, 80, 25);
		tf3.setFont(new Font("ÈÞ¸Õ¸ÅÁ÷Ã¼", Font.PLAIN, 15));
		panel.add(tf3); // ³ë¼± ID
		tf4.setBounds(90, 190, 80, 25);
		tf4.setFont(new Font("ÈÞ¸Õ¸ÅÁ÷Ã¼", Font.PLAIN, 15));
		panel.add(tf4); // Ãâ¹ßÁö
		tf5.setBounds(230, 190, 80, 25);
		tf5.setFont(new Font("ÈÞ¸Õ¸ÅÁ÷Ã¼", Font.PLAIN, 15));
		panel.add(tf5); // µµÂøÁö
		tf6.setBounds(370, 190, 80, 25);
		tf6.setFont(new Font("ÈÞ¸Õ¸ÅÁ÷Ã¼", Font.PLAIN, 15));
		panel.add(tf6); // ¿ä±Ý

		// ÀÔ·Â °ø°£ ¶óº§ ÀÌ¸§
		l1.setBounds(40, 270, 80, 30);
		l1.setFont(new Font("ÈÞ¸Õ¸ÅÁ÷Ã¼", Font.PLAIN, 15));
		panel.add(l1); // ³¯Â¥
		l2.setBounds(180, 270, 80, 30);
		l2.setFont(new Font("ÈÞ¸Õ¸ÅÁ÷Ã¼", Font.PLAIN, 15));
		panel.add(l2); // ½Ã°£
		l3.setBounds(320, 270, 80, 30);
		l3.setFont(new Font("ÈÞ¸Õ¸ÅÁ÷Ã¼", Font.PLAIN, 15));
		panel.add(l3); // ³ë¼± ID
		l4.setBounds(40, 190, 80, 30);
		l4.setFont(new Font("ÈÞ¸Õ¸ÅÁ÷Ã¼", Font.PLAIN, 15));
		panel.add(l4); // Ãâ¹ßÁö
		l5.setBounds(180, 190, 80, 30);
		l5.setFont(new Font("ÈÞ¸Õ¸ÅÁ÷Ã¼", Font.PLAIN, 15));
		panel.add(l5); // µµÂøÁö
		l6.setBounds(320, 190, 80, 30);
		l6.setFont(new Font("ÈÞ¸Õ¸ÅÁ÷Ã¼", Font.PLAIN, 15));
		panel.add(l6); // ¿ä±Ý

		// ³ë¼± Ãß°¡
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String rt_depart_from = tf4.getText();
				String rt_arrive_at = tf5.getText();
				String rt_charge = tf6.getText();

				Pattern passPattern = Pattern.compile("^[°¡-ÆR]*$");
				Matcher passMatcher = passPattern.matcher(rt_depart_from);
				Pattern passPattern2 = Pattern.compile("^[°¡-ÆR]*$");
				Matcher passMatcher2 = passPattern.matcher(rt_arrive_at);
				Pattern passPattern3 = Pattern.compile("\\d");
				Matcher passMatcher3 = passPattern2.matcher(rt_charge);

				if (rt_depart_from.equals("") || rt_arrive_at.equals("") || rt_charge.equals("")) {
					JOptionPane.showMessageDialog(null, "Á¤º¸¸¦ ¸ðµÎ ÀÔ·ÂÇØÁÖ¼¼¿ä", "¾Ë¸²", 1);
					return;
				} else if (!passMatcher.find()) {
					JOptionPane.showMessageDialog(null, "Ãâ¹ßÁö¸¦ ´Ù½Ã ÀÔ·ÂÇØÁÖ¼¼¿ä\n(ÇÑ±Û¸¸ ÀÔ·Â °¡´É)", "Ãâ¹ßÁö ¿À·ù", 1);
					return;
				} else if (!passMatcher2.find()) {
					JOptionPane.showMessageDialog(null, "µµÂøÁö¸¦ ´Ù½Ã ÀÔ·ÂÇØÁÖ¼¼¿ä\n(ÇÑ±Û¸¸ ÀÔ·Â °¡´É)", "µµÂøÁö ¿À·ù", 1);
					return;
				} else if (!passMatcher3.find()) {
					JOptionPane.showMessageDialog(null, "¼ýÀÚ¸¸ ÀÔ·Â °¡´ÉÇÕ´Ï´Ù", "¿ä±Ý ¿À·ù", 1);
					return;
				} else {
					db.route_insertData(rt_depart_from, rt_arrive_at, rt_charge);
					JOptionPane.showMessageDialog(null, "Ãß°¡µÇ¾ú½À´Ï´Ù!");

				}

				tf4.setText("");
				tf5.setText("");
				tf6.setText("");
			}
		});

		// ¹ö½º Á¤º¸ Ãß°¡
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String bi_day = tf1.getText();
				String bi_time = tf2.getText();
				int rtfk_id = Integer.parseInt(tf3.getText());

				Pattern passPattern = Pattern.compile("\\d{2}/\\d{2}/\\d{2}");
				Matcher passMatcher = passPattern.matcher(bi_day);
				Pattern passPattern2 = Pattern.compile("\\d{2}:\\d{2}");
				Matcher passMatcher2 = passPattern2.matcher(bi_time);

				ArrayList<Route_Read_Data> arr = db.readData();
				
				
				if (!passMatcher.find()) {
					JOptionPane.showMessageDialog(null, "´Ù½Ã ÀÔ·ÂÇÏ¼¼¿ä\nex) xx/xx/xx", "³¯Â¥ ¿À·ù", 1);
					return;
				} else if (!passMatcher2.find()) {
					JOptionPane.showMessageDialog(null, "´Ù½Ã ÀÔ·ÂÇÏ¼¼¿ä\nex) 24:00", "½Ã°£ ¿À·ù", 1);
					return;
				} else {
					db.bus_info_insertData(bi_day, bi_time, rtfk_id);
					int i = db.get_currsq();
					db.seat_insertData(i);

					JOptionPane.showMessageDialog(null, "Ãß°¡µÇ¾ú½À´Ï´Ù!");
				}

				tf1.setText("");
				tf2.setText("");
				tf3.setText("");
				tf8.setText("");
			}
		});

		// Ãâ·Â ¹öÆ° ÀÌº¥Æ®
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				allView();
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
