package lee.mpcomponents;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

//예매내역 있을 때 패널
public class MPreservationPanel_2 extends JPanel {
	
	//디비에서 예매내역 데려올 때 오늘 날짜 이후의 예매내역만 가져와야 됨... 
	
	JButton MPreservationcancleBtn = new JButton("예매취소");
	
	ArrayList<MPreservationlistPanel> MPreservationlistArrList = new ArrayList<>();

	BorderLayout MPborderlayout = new BorderLayout();
	
	JPanel MPreservation_3 = new JPanel();
	BoxLayout MPboxlayout = new BoxLayout(MPreservation_3, BoxLayout.Y_AXIS);
	JScrollPane MPscroll = new JScrollPane(MPreservation_3, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	
	
	public MPreservationPanel_2() {  
		
		setLayout(MPborderlayout);
		MPreservation_3.setLayout(MPboxlayout);
		
	
		MPreservationcancleBtn.setBorderPainted(false);
		
		 
		
		int spHeight = 0;
		//일단 예매 티켓 수가 3장이라고 가정 
		for(int i = 0; i < 4; ++i) { //이거 왜 티켓 수 늘어나면 스크롤 되야 되는데 스크롤은 안 되고 라벨이 겹쳐서 나타나냐 
			MPreservationlistArrList.add(new MPreservationlistPanel());
			MPreservation_3.add(MPreservationlistArrList.get(i));
			spHeight++;//일단은 임시로 spHeight 변수 생성해서 거기에 티켓수 담아주는데 나중에 DB 연결하면 지우고 그걸로 하기  
		}
		MPreservation_3.setPreferredSize(new Dimension(500, 180*spHeight)); //리스트패널의 높이에 티켓수 곱해줘야됨★
		
		MPscroll.getVerticalScrollBar().setUnitIncrement(6);// 스크롤 속도 조절
		
		
		
		
		add(MPreservationcancleBtn, "South");
		add(MPscroll, "Center");
	}
}
