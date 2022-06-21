package lee.mpcomponents;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import lee.OjdbcConnection;
import lee.mpevents.MPcheckboxIL;
import lee.mpmodel.MPreservationlistModel;

//예매내역 있을 때 패널
//디비에서 예매내역 데려올 때 오늘 날짜 이후의 예매내역만 가져와야 됨...
public class MPreservationPanel_2 extends JPanel {
	 
	String user_id = "abc123";// 일단 임시로(다른 프레임에서 전달받을 거임) 
	
	JButton MPreservationcancleBtn = new JButton("예매취소");
	
	BorderLayout MPborderlayout = new BorderLayout();
	
	JPanel MPreservation_3 = new JPanel();
	BoxLayout MPboxlayout = new BoxLayout(MPreservation_3, BoxLayout.Y_AXIS);
	JScrollPane MPscroll = new JScrollPane(MPreservation_3, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	
	JCheckBox[] cbArr;
	
	public MPreservationPanel_2() {  
		
		setLayout(MPborderlayout);
		MPreservation_3.setLayout(MPboxlayout);
	
		//이걸 메서드화 해서 샤로고침 하는 방법이 없나? ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
		//예매 티켓 수에 따라 레저리스트패널 추가
		ArrayList<MPreservationlistPanel> MPreservationlistArrList = new ArrayList<>();
	
		//JCheckBox[] cbArr = null;
		int ticketNum = 0;
		
		try (Connection conn = OjdbcConnection.getConnection();){	
			
			//일단 이너조인 검색결과를 어레리로 받고
			ArrayList<MPreservationlistModel> sqlResults = MPreservationlistModel.get(conn, user_id, "22/06/20");
			ticketNum = sqlResults.size();
			
			//체크박스 넣기
			cbArr =new JCheckBox[ticketNum];//티켓수만큼 체크박스 생성할 거니까 
			
			//int spHeight = 0;
			for(int i = 0; i < ticketNum; ++i) {  			
				
				int br_id = sqlResults.get(i).getBr_id();
				
				
				//예매 리스트 패널의 첵박 설정
				cbArr[i] = new JCheckBox(Integer.toString(br_id));
				cbArr[i].setBounds(400, 77, 18, 18);
				cbArr[i].addItemListener(new MPcheckboxIL()); //----이제 아템 리스너 클래스 만들기
				
				
				//예매 리스트 패널의 라벨 설정
				MPreservationlistArrList.add(new MPreservationlistPanel(br_id, sqlResults.get(i).toString()));
				MPreservationlistArrList.get(i).add(cbArr[i]);
				
				MPreservation_3.add(MPreservationlistArrList.get(i));  
				MPreservation_3.setPreferredSize(new Dimension(500, 180*ticketNum));//리스트패널의 높이에 티켓수 곱해줘야됨★
	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		MPscroll.getVerticalScrollBar().setUnitIncrement(6);// 스크롤 속도 조절
		
		
		
		
		

		
		
		
		MPreservationcancleBtn.setBorderPainted(false);
		
		add(MPreservationcancleBtn, "South");
		add(MPscroll, "Center");
	}
}
