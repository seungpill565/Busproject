package park.frame;

import java.awt.Color;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import an.userinfo.Info_MainFrame;
import hong.BeforeButton;
import hong.SaveInfo;
import hong.selectseat.SelectSeatMainFrame;
import park.button.BeforePayButton;
import park.button.HomeButton;
import park.button.PayButton;
import park.combobox.SelectPayWayBox;
import park.database.LoadRVID;
import park.database.SaveDB;
import park.event.BeforeButtonEvent;
import park.event.HomeButtonEvent;
import park.event.PayButtonEvent;
import park.label.RouteInfoLabel;
import park.panel.HomeBeforeBtnPanel;
import park.panel.RouteInfoPanel;
import park.panel.SelectSeatAgePanel;


public class Pay extends JFrame{
	// 레이아웃 널로 만들고 위에서부터 flow, table, label, combobox, button 
	static SaveInfo user;
	
	//static HomeBeforeBtnPanel panel1 ; // 홈버튼, 이전버튼이 들어가는 판넬 (플로우레이아웃)
	private HomeButton homeBtn;
	private BeforePayButton beforeBtn;
	private SelectSeatAgePanel seatPanel ; // 좌석별 연령대 고를 콤보박스 들어있는 판넬
	private PayButton payBtn ; // 결제하기 버튼
	private SelectPayWayBox payWayBox ; // 결제 방식 고르는 콤보박스
	private RouteInfoLabel route; // 행선지 정보 
	private RouteInfoPanel routePanel ; // 행선지 정보 표 형태로 보여줄 패널
	private ImageIcon background = new ImageIcon("image/payimage.jpg");
	private JLabel label = new JLabel();
	
	
	public void thisClose() {
		dispose();
	}
	
	
	public Pay(SaveInfo user) {
		super("결제 화면");
		user.setSeatId(); // 해쉬맵에 있는 좌석이름 어레이리스트에 넣기
		user.setSeatNames();
		this.user = user;
		
		// 접속 상태 유지하기위해서 다 매개변수로 받아온 user로 초기화 해줌
		homeBtn = new HomeButton(new ImageIcon("image/home1.png"));
		beforeBtn = new BeforePayButton(new ImageIcon("image/before.png"));
		//panel1 = new HomeBeforeBtnPanel(user);
		route = new RouteInfoLabel();

		routePanel = new RouteInfoPanel(user);
		seatPanel = new SelectSeatAgePanel(user); // 패널 초기화 해주면서 user 정보 계속 유지해야해서 매개변수로 넘겨준다
		payWayBox = new SelectPayWayBox(user);
		payBtn = new PayButton(user);

		
		
		// 액션들
		homeBtn.addActionListener(new HomeButtonEvent(this));
		beforeBtn.addActionListener(new BeforeButtonEvent(this));
		payBtn.addActionListener(new PayButtonEvent(this));
//<<<<<<< HEAD
//
//		add(panel1); // 홈버튼, 이전버튼 판넬
//		add(route); // 행선지 정보
//		//add(scroll);
//		//add(scroll2);
//		add(routePanel); // 행선지 정보 표 표시할 판넬
//		add(seatPanel); // 좌석별 연령 고르는 콤보박스
//		add(payWayBox); // 결제 수단 고를 콤보 박스
//		add(payBtn); // 결제하기 버튼
//		
//		
//=======
		
		label.setIcon(background);
		label.setSize(500,600);
		add(label);
	
		//label.add(panel1); // 홈버튼, 이전버튼 판넬
		label.add(homeBtn);
		label.add(beforeBtn);
		label.add(route); // 행선지 정보
		label.add(routePanel); // 행선지 정보 표 표시할 판넬
		label.add(seatPanel); // 좌석별 연령 고르는 콤보박스
		label.add(payWayBox); // 결제 수단 고를 콤보 박스
		label.add(payBtn); // 결제하기 버튼
	
//>>>>>>> refs/remotes/origin/masterpark2
		getContentPane().setBackground(Color.white);
		setLayout(null);
		setResizable(false);
		setBounds(100,100,500,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void homeButtonEvent() {
		String str = "메인 화면으로 돌아가시겠습니까?";
		int ok =JOptionPane.showConfirmDialog(null, str, "메인 화면", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
		if(ok==JOptionPane.OK_OPTION) { // ok를 누르면
			user.remove_bs_map(user.getSeatId(), user.getSeatNames());
			user.setTotalCharge();
			user.setPayWay(null);
			dispose();
			new Info_MainFrame(user);
		}
	}
	
	public void beforeButtonEvent() {
		user.remove_bs_map(user.getSeatId(), user.getSeatNames());
		user.setTotalCharge();
		user.setPayWay(null);
		dispose();
		new SelectSeatMainFrame(user);
	}
	
	public void payButtonEvent() {
		try {
			//if((!user.getPayWay().equals(null))&&user.isTotalChargeCheck()) {
			if((user.getdcBySeat().size() == user.getSeatNameBySeatId().size())&&(!user.getPayWay().equals(null))) {
				String str =String.format("결제 금액 : %d\n결제 수단 : %s\n결제 하시겠습니까?", (int)(user.getTotalCharge()), user.getPayWay());
				int ok =JOptionPane.showConfirmDialog(null, str, "결제 확인", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
				if(ok==JOptionPane.OK_OPTION) { // ok를 누르면
					new SaveDB(user); // 디비에 저장한다
					new LoadRVID(user); // 디비에 저장된 예매번호를 인스턴스에 저장함
					dispose();
					new PayInfo(user); // 결제 버튼 누르면 다음 화면으로 넘어가고
					System.out.println("db저장 성공");
				}
				else { // ok 이외의 것을 누르면
					user.setTotalCharge(); // 결제 팝업에서 취소한 것이므로 총요금을 초기화 해준다
				}
			}else {
				String str ="올바르지 않은 연령 및 결제 방식입니다.";
				JOptionPane.showMessageDialog(null, str, "오류 메시지", JOptionPane.PLAIN_MESSAGE);
			}
		}catch(NullPointerException e1){
			String str ="올바르지 않은 연령 및 결제 방식입니다.";
			JOptionPane.showMessageDialog(null, str, "오류 메시지", JOptionPane.PLAIN_MESSAGE);
		}
	}
	
	
	public static void main(String[] args) {
		new Pay(new SaveInfo());
	}

}
