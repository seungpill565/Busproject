package lee.mpcomponents;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import lee.mpevents.MPBackBtnEvent;
import lee.mpevents.MPcompleteBtnEvent;
import lee.mpevents.MPeditBtnEvent;
import lee.mpevents.MPnavBtnsEvent;
import lee.mpevents.MPreservationCancleBtnEvent;

public class MPmainFrame extends JFrame {

	JButton MPhomeBtn = new JButton();
	JLabel MPcategoryLb = new JLabel("카테고리명");
	
	MPnavPanel MPnav = new MPnavPanel();
	MPcontentsPanel MPcontents = new MPcontentsPanel();
	
	//카테고리명 라벨 텍스트 바꾸는 메서드
	public void setCategoryLabelText(String title) {
		MPcategoryLb.setText(title);	
	}
	
	
//액션리스너에서 쓰일 메서드들 모음_____________________________________________________________________________________________________________
	
	//네비게이션 3버튼 액션
	public void navBtnCtrl (JButton btn) {
		if(btn.getText().equals("내 정보 조회/수정")) {
			setCategoryLabelText("내 정보 조회");
			MPcontents.MPcontentsCard.show(MPcontents, "내정보");
		} else if(btn.getText().equals("예매 확인")) {
			setCategoryLabelText(btn.getText());
			MPcontents.MPcontentsCard.show(MPcontents, "예매내역");
		} else if(btn.getText().equals("계정 탈퇴")) {
			setCategoryLabelText(btn.getText());
			MPcontents.MPcontentsCard.show(MPcontents, "계정탈퇴");
		}
	}	
	
	
	//프로필수정하기 버튼 눌렀을 때
	public void editBtnCtrl () {		
		setCategoryLabelText("내 정보 수정");
		MPcontents.MPprofile.showMPprofile_2(); 
	}
	
	//프로필수정하기 화면에서 뒤로가기 버튼 눌렀을 때 (수정값 저장하면 안 됨 ★)
	public void backBtnCtrl () {
		setCategoryLabelText("내 정보 조회");
		MPcontents.MPprofile.showMPprofile_1();
	}
	
	//프로필수정하기 화면에서 수정 완료 버튼 눌렀을 때 (수정값 저장해야됨 ★)
	public void completeBtnCtrl() {
		setCategoryLabelText("내 정보 조회");
		MPcontents.MPprofile.showMPprofile_1();	
		//여기에 수정한 정보 저장하는 기능 넣기★ 
	} //내정보 보기 화면에는 항상 최신 값만 뜨도록 해놔야겠네 

	
 
	
	public void reservationCancelBtnCtrl () {
		 setVisible(false);//나중에 삭제 
	}
	
//____________________________________________________________________________________________________________________________________	
	
	
	
	public MPmainFrame() {
		
		setLayout(null);

		setCategoryLabelText("내 정보 조회");
		
		MPcategoryLb.setBounds(230, 30, 700, 100);
		MPcategoryLb.setFont(new Font("고딕", Font.PLAIN, 25));
		this.add(MPcategoryLb);
		
		
		MPhomeBtn.setBounds(10, 10, 50, 50);
		MPhomeBtn.setBorderPainted(false);
		MPhomeBtn.setBackground(Color.cyan);
			
		
		/*
		//홈버튼 누르면 홈화면으로 가기 
		//(아 근데 어차피 전체 카드레아로 이을 거랬으니까 나중에 합치면 show(카드레아가 달려 있는 곳 ,"홈?") 으로 하면 되겠네
		MPhomeBtn.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		*/
		
		
		//네비게이션 바 버튼 3개 액션
		MPnav.MPprofileBtn.addActionListener(new MPnavBtnsEvent(this, MPnav.MPprofileBtn));
		MPnav.MPleaveBtn.addActionListener(new MPnavBtnsEvent(this, MPnav.MPleaveBtn));
		MPnav.MPreservationBtn.addActionListener(new MPnavBtnsEvent(this, MPnav.MPreservationBtn));
		
		
		
		// 프로필 패널 버튼들 액션
		MPcontents.MPprofile.MPprofile_1.MPeditBtn.addActionListener(new MPeditBtnEvent(this));
		MPcontents.MPprofile.MPprofile_2.MPbackBtn.addActionListener(new MPBackBtnEvent(this));
		MPcontents.MPprofile.MPprofile_2.MPcompleteBtn.addActionListener(new MPcompleteBtnEvent(this));
		
		
		
		
		
		//예약취소버튼 액션
		MPcontents.MPreservation.MPreservationcancleBtn.addActionListener(new MPreservationCancleBtnEvent(this));
		
		
		
		
		
		
		add(MPnav);
		add(MPcontents);	
		add(MPhomeBtn);
			
		
		//프레임 설정
		setTitle("마이페이지");
		getContentPane().setBackground(Color.WHITE);//배경색 나중에 맞추기		
		setBounds(0, 0, 800, 650);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	

	
	//테스트용 메인부. 나중에 삭제
	public static void main(String[] args) {
		new MPmainFrame();
	}
}
