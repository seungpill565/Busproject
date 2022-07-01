package jang.GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ManagerMainFrame2 extends JFrame{
	
	MemberManagementGUI mmgui;
	
	JPanel panel = new JPanel();
	JButton logo = new JButton();
	JLabel pName = new JLabel("관리자");
	JLabel label = new JLabel("조회");
	JButton member = new JButton("회원 관리");
	JButton route = new JButton("노선 관리");
	JButton backBtn; 
	JButton homeBtn; 
	
	ImageIcon back_Image = new ImageIcon("Image/back2.png");
	ImageIcon back_Image2 = new ImageIcon("Image/back3.png");
	
	
	ImageIcon home_image = new ImageIcon("Image/home2-1.png");
	ImageIcon home_image2 = new ImageIcon("Image/home2.png");
	
	
	public ManagerMainFrame2() {
		backBtn = new JButton(back_Image);
		backBtn.setRolloverIcon(back_Image2);
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
		label.setBounds(375, 100, 50, 30);
		label.setFont(new Font("휴먼매직체", Font.PLAIN, 20));
		member.setBounds(180, 150, 420, 50);
		member.setFont(new Font("휴먼매직체", Font.PLAIN, 30));
		route.setBounds(180, 250, 420, 50);
		route.setFont(new Font("휴먼매직체", Font.PLAIN, 30));
		
		panel.setBackground(Color.WHITE);
		member.setBackground(new Color(0XE7E6E6));
		route.setBackground(new Color(0XE7E6E6));
		
		panel.add(logo);
		panel.add(pName);
		panel.add(label);
		panel.add(member);
		panel.add(route);
		
		// 뒤로가기 버튼
		backBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				new MainHom();
				setVisible(false);
			}
		});
		
		
		member.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MemberManagementGUI();
				dispose();
			}
		});
		
		route.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new RouteManageMentGUI();
				setVisible(false);
			}
		});
		
		panel.setLayout(null);
		add(panel);
		setTitle("관리자 창");		
		setResizable(false);
		setBounds(10, 20, 800, 650);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

}
