package lee.mpcomponents;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import lee.OjdbcConnection;
import lee.mpmodel.MPreservationlistModel;

//예매내역 있을 때 패널
public class MPreservationPanel_2 extends JPanel {
	
	//디비에서 예매내역 데려올 때 오늘 날짜 이후의 예매내역만 가져와야 됨... 
	
	String user_id = "abc123";// 일단 임시로(다른 프레임에서 전달받을 거임) 
	
	JButton MPreservationcancleBtn = new JButton("예매취소");
	
	BorderLayout MPborderlayout = new BorderLayout();
	
	JPanel MPreservation_3 = new JPanel();
	BoxLayout MPboxlayout = new BoxLayout(MPreservation_3, BoxLayout.Y_AXIS);
	JScrollPane MPscroll = new JScrollPane(MPreservation_3, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	
	
	public MPreservationPanel_2() {  
		
		setLayout(MPborderlayout);
		MPreservation_3.setLayout(MPboxlayout);


		
		//예매 티켓 수에 따라 레저리스트패널 추가
		ArrayList<MPreservationlistPanel> MPreservationlistArrList = new ArrayList<>();
	
		try (Connection conn = OjdbcConnection.getConnection();){	
			
			//일단 이너조인 검색결과를 어레리로 받고
			ArrayList<MPreservationlistModel> sqlResults = MPreservationlistModel.get(conn, user_id, "22/06/20");
			int ticketNum = sqlResults.size();
			
			//int spHeight = 0;
			for(int i = 0; i < ticketNum; ++i) {  			
				MPreservationlistArrList.add(new MPreservationlistPanel(sqlResults.get(i).getBr_id(), sqlResults.get(i).toString()));
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
