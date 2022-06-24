package jang.Route;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import jang.Route_DB;
import jang.Data.Businfo_Data;

public class Route_Update extends JFrame {

	JPanel panel = new JPanel();

	JButton btn1 = new JButton("수정");
	JButton btn4 = new JButton("확인");

	JLabel bus = new JLabel("버스 정보");

	JTextField tf1 = new JTextField();
	JTextField tf2 = new JTextField();
	JTextField tf3 = new JTextField();
	JTextField tf4 = new JTextField();

	JLabel l1 = new JLabel("날짜 : ");
	JLabel l2 = new JLabel("시간 : ");
	JLabel l3 = new JLabel("노선 ID : ");
	JLabel l4 = new JLabel("버스 ID : ");

	JLabel pName = new JLabel("노선 추가");

	Route_DB db = new Route_DB();

	public Route_Update() {
		Route_Update();
	}

	public void Route_Update() {
		setTitle("수정");
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

		bus.setBounds(20, 100, 80, 30);
		bus.setFont(new Font("휴먼매직체", Font.BOLD, 20));
		panel.add(bus);

		// 입력 공간 라벨
		tf1.setBounds(80, 170, 80, 25);
		tf1.setFont(new Font("휴먼매직체", Font.PLAIN, 15));
		panel.add(tf1); // 날짜
		tf2.setBounds(240, 170, 80, 25);
		tf2.setFont(new Font("휴먼매직체", Font.PLAIN, 15));
		panel.add(tf2); // 시간
		tf3.setBounds(240, 140, 80, 25);
		tf3.setFont(new Font("휴먼매직체", Font.PLAIN, 15));
		panel.add(tf3); // 노선 ID
		tf4.setBounds(80, 140, 80, 25);
		tf4.setFont(new Font("휴먼매직체", Font.PLAIN, 15));
		panel.add(tf4); // 버스 ID

		// 입력 공간 라벨 이름
		l1.setBounds(20, 170, 80, 30);
		l1.setFont(new Font("휴먼매직체", Font.PLAIN, 15));
		panel.add(l1); // 날짜
		l2.setBounds(180, 170, 80, 30);
		l2.setFont(new Font("휴먼매직체", Font.PLAIN, 15));
		panel.add(l2); // 시간
		l3.setBounds(180, 140, 80, 30);
		l3.setFont(new Font("휴먼매직체", Font.PLAIN, 15));
		panel.add(l3); // 노선 ID
		l4.setBounds(20, 140, 80, 30);
		l4.setFont(new Font("휴먼매직체", Font.PLAIN, 15));
		panel.add(l4); // 버스 ID

		// 수정 버튼 이벤트
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int bi_id = Integer.parseInt(tf4.getText());
				String bi_day = tf1.getText();
				String bi_time = tf2.getText();
				int rt_id = Integer.parseInt(tf3.getText());

				db.updateData(new Businfo_Data(bi_id, bi_day, bi_time, rt_id));

				tf1.setText("");
				tf2.setText("");
				tf3.setText("");
				tf4.setText("");

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
