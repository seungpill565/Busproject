package park.frame;

import java.awt.Color;

import javax.swing.JFrame;

import hong.SaveInfo;
import park.ReservationInfo;
import park.button.PayButton;
import park.combobox.SelectPayWayBox;
import park.label.RouteInfoLabel;
import park.panel.HomeBeforeBtnPanel;
import park.panel.RouteInfoPanel;
import park.panel.SelectSeatAgePanel;
import park.scrollpane.PayInfoScrollpane;


public class Pay extends JFrame{
	// ���̾ƿ� �η� ����� ���������� flow, table, label, combobox, button 
	static SaveInfo user;
//	static String[][] rowData ; // ���� ������
//	static String[] columnNames = {"��¥", "�����", "������", "�ð�", "�¼���ȣ"};
	static HomeBeforeBtnPanel panel1 ; // Ȩ��ư, ������ư�� ���� �ǳ� (�÷ο췹�̾ƿ�)
	//static PayInfoTable table = new PayInfoTable(user);	// �¼����� ���̺�
	//static JScrollPane scroll = new JScrollPane(table); // �¼����� ���̺� ��� ��ũ��
	static SelectSeatAgePanel seatPanel ; // �¼��� ���ɴ� ���� �޺��ڽ� ����ִ� �ǳ�
	static PayButton payBtn ; // �����ϱ� ��ư
	static SelectPayWayBox payWayBox ; // ���� ��� ������ �޺��ڽ�
	static RouteInfoLabel route; // �༱�� ���� 
	static RouteInfoPanel routePanel ; // �༱�� ���� ǥ ���·� ������ �г�
	static PayInfoScrollpane scroll;
	
	
	public Pay(SaveInfo user) {
		super("���� ȭ��");
		user.setSeatId(); // �ؽ��ʿ� �ִ� �¼��̸� ��̸���Ʈ�� �ֱ�
		user.setSeatNames();
		this.user = user;
		
		// ���� ���� �����ϱ����ؼ� �� �Ű������� �޾ƿ� user�� �ʱ�ȭ ����
		seatPanel = new SelectSeatAgePanel(user); // �г� �ʱ�ȭ ���ָ鼭 user ���� ��� �����ؾ��ؼ� �Ű������� �Ѱ��ش�
		panel1 = new HomeBeforeBtnPanel(user);
		payBtn = new PayButton(user);
		payWayBox = new SelectPayWayBox(user);
		routePanel = new RouteInfoPanel(user); 
		scroll = new PayInfoScrollpane(); 
		route = new RouteInfoLabel();
			
		scroll.setViewportView(routePanel);
	
		add(panel1); // Ȩ��ư, ������ư �ǳ�
		add(route); // �༱�� ����
		add(scroll);
		//add(routePanel); // �༱�� ���� ǥ ǥ���� �ǳ�
		add(seatPanel); // �¼��� ���� ������ �޺��ڽ�
		add(payWayBox); // ���� ���� ���� �޺� �ڽ�
		add(payBtn); // �����ϱ� ��ư
	
		getContentPane().setBackground(Color.white);
		setLayout(null);
		setResizable(false);
		setBounds(100,100,500,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
//	public static void main(String[] args) {
//		new Pay(new ReservationInfo());
//	}

}