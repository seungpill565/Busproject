package an.userinfo;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import an.login.Login_Mainframe;
import an.userinfo.action.Info_LogoutAction;
import an.userinfo.action.Info_MyInfoAction;
import an.userinfo.action.Info_ReservationAction;
import hong.SaveInfo;
import hong.selectroute.SelectRouteMainFrame;
import lee.mpcomponents.MPmainFrame;

public class Info_MainFrame extends JFrame{
	ImageIcon myinfoimage = new ImageIcon("image/button1.png");
	ImageIcon Reservationimage = new ImageIcon("image/button2.png");
	ImageIcon logoutimage = new ImageIcon("image/button3.png");
	
	JButton Reservation = new Info_JButton("예약");
	JButton myinfo 		= new Info_JButton("내정보");
	JButton logout 		= new Info_JButton("로그 아웃");
	
	JPanel buttonPanel = new Info_Panel(Reservation,myinfo,logout);
	JPanel imagePanel = new Info_ImagePanel();
	JPanel titlePanel = new Info_TitlePanel();

	SaveInfo saveInfo;
	
	
	public Info_MainFrame(SaveInfo saveInfo) {
		
		this.saveInfo = saveInfo;
		
		Reservation.setText("");
		Reservation.setIcon(Reservationimage);
		
		myinfo.setText("");
		myinfo.setIcon(myinfoimage);
		
		logout.setText("");
		logout.setIcon(logoutimage);
		
		setTitle("버스예약");
		
		add(titlePanel,BorderLayout.NORTH);
		add(imagePanel,BorderLayout.CENTER);
		add(buttonPanel,BorderLayout.SOUTH);
		/////////////////////////////////////////
		
		Info_ReservationAction rvevent = new Info_ReservationAction(this);
		Info_MyInfoAction myevent = new Info_MyInfoAction(this);
		Info_LogoutAction logevent = new Info_LogoutAction(this);
		
		Reservation.addActionListener(rvevent);
		myinfo.addActionListener(myevent);
		logout.addActionListener(logevent);
			
		
		/////////////////////////////////////////
		setSize(1100, 750);
		setLocationRelativeTo(null);
		setResizable(false);  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	//예약 이동 이벤트
	public void ReservationAction() {
		new SelectRouteMainFrame(saveInfo);
		dispose();
	}
	
	//내정보 이동 이벤트
	public void myinfoAction() {
		new MPmainFrame(saveInfo);
		dispose();
	}
	
	//로그아웃 이동 이벤트
	public void logoutAction() {
		new Login_Mainframe();
		dispose();
	}

}
