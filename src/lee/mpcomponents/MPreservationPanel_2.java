package lee.mpcomponents;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import an.OjdbcConnection;
import hong.SaveInfo;
import lee.RoundedButton;
import lee.mpevents.MPcheckboxIL;
import lee.mpmodel.MPreservationlistModel;

//예매내역 있을 때 패널
public class MPreservationPanel_2 extends JPanel {
	 
	SaveInfo saveInfo;
	String user_id; 
	
	
	RoundedButton MPreservationcancleBtn = new RoundedButton("예매취소");	
	BorderLayout MPborderlayout = new BorderLayout();
	
	//티켓이 들어갈 공간을 나누고 확보해놓는 패널(박스레이아웃 적용) 
	JPanel MPreservation_3 = new JPanel();
	
	JCheckBox[] cbArr;
	
	public MPreservationPanel_2(SaveInfo saveInfo) {  

		this.saveInfo = saveInfo;
		this.user_id = saveInfo.get_user_id();
		
		JScrollPane MPscroll = new JScrollPane(MPreservation_3, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		BoxLayout MPboxlayout = new BoxLayout(MPreservation_3, BoxLayout.Y_AXIS);		
		
		setLayout(MPborderlayout);
		
		//스크롤바랑 박스레이아웃 적용한 MPresevation_3패널 설정
		MPreservation_3.setLayout(MPboxlayout);
		MPreservation_3.setBackground(Color.WHITE);
	
		//스크롤바 배경 설정
		MPscroll.getVerticalScrollBar().setBackground(Color.WHITE);
		MPscroll.setBorder(null);	
		
		//예매 티켓 수에 따라 레저리스트패널 추가
		ArrayList<MPreservationlistPanel> MPreservationlistArrList = new ArrayList<>();
		
		int ticketNum = 0;
		ArrayList<MPreservationlistModel> sqlResults = null;
		try (Connection conn = OjdbcConnection.getConnection();){	
			//이너조인 검색결과를 어레리에 저장           
			sqlResults = MPreservationlistModel.get(conn, user_id);
			ticketNum = sqlResults.size();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//체크박스 담을 배열
		cbArr = new JCheckBox[ticketNum]; //티켓수만큼 체크박스 생성할 거니까 
		
		for(int i = 0; i < ticketNum; ++i) {  			
			
			int br_id = sqlResults.get(i).getBr_id();
			
			//예매 리스트 패널의 첵박 설정
			cbArr[i] = new JCheckBox(Integer.toString(br_id));//체크박스에 br_id를 텍스트로 담은 다음에 크기를 18, 18로 조절해서 안 보이게 함
			cbArr[i].setBounds(400, 77, 18, 18);
			cbArr[i].addItemListener(new MPcheckboxIL()); //MPcheckboxIL 은 아이템리스너 상속 받은 클래스. (쳌박에는 아이템리스너 달 수 있음) 
			cbArr[i].setBackground(Color.WHITE);
			//예매 리스트 패널의 라벨 설정
			MPreservationlistArrList.add(new MPreservationlistPanel(br_id, sqlResults.get(i).toString()));
			MPreservationlistArrList.get(i).add(cbArr[i]);//체크박스는 여기서 달아줌
			
			MPreservation_3.add(MPreservationlistArrList.get(i)); //완성된 예매리스트 패널(라벨+쳌박 들어 있음) 을 MPreservation_3(스크롤 붙은 JPanel) 에 붙이기 
			MPreservation_3.setPreferredSize(new Dimension(500, 180*ticketNum));//리스트패널의 높이에 티켓수 곱해줘야됨★
			//스크롤 작동하려면 setPreferredSize로 사이즈 조절해줘야 했던듯
		}
		
		
		MPscroll.getVerticalScrollBar().setUnitIncrement(6);// 스크롤 속도 조절
		//MPscroll.getVerticalScrollBar().setBackground(Color.WHITE);
		
		MPreservationcancleBtn.setBorderPainted(false);
		MPreservationcancleBtn.setBounds(125, 130, 90, 35);
		MPreservationcancleBtn.setFont(new Font("휴먼편지체", Font.BOLD, 17));
		
		
		
		setBackground(Color.WHITE);
		add(MPreservationcancleBtn, "South");
		add(MPscroll, "Center");
		
	}
	
}
