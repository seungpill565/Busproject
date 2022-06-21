package lee.mpcomponents;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import lee.OjdbcConnection;
import lee.mpevents.MPBackBtnEvent;
import lee.mpevents.MPcompleteBtnEvent;
import lee.mpevents.MPeditBtnEvent;
import lee.mpevents.MPnavBtnsEvent;
import lee.mpevents.MPreservationCancleBtnEvent;
import lee.mpmodel.MPreservationlistModel;

public class MPmainFrame extends JFrame {

	
	JButton MPhomeBtn = new JButton();
	JLabel MPcategoryLb = new JLabel("카테고리명");
	
	MPnavPanel MPnav = new MPnavPanel();
	MPcontentsPanel MPcontents = new MPcontentsPanel();
	
	//체크된 체크박스에 담긴 예매번호 담는 어레리 
	ArrayList<Integer> br_id_list = new ArrayList<>();
	

//액션리스너에서 쓰일 메서드들 모음_____________________________________________________________________________________________________________
	
	//카테고리명 라벨 텍스트 바꾸는 메서드
		public void setCategoryLabelText(String title) {
			MPcategoryLb.setText(title);	
		}
	
	//네비게이션 3버튼 액션
	public void navBtnCtrl (JButton btn) {
		if(btn.getText().equals("내 정보 조회/수정")) {
			setCategoryLabelText("내 정보 조회");
			MPcontents.MPcontentsCard.show(MPcontents, "내정보");
			MPcontents.MPprofile.showMPprofile_1();
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
		MPcontents.MPprofile.MPprofile_2.setTfEmpty();
	}
	
	//프로필수정하기 화면에서 뒤로가기 버튼 눌렀을 때 (수정값 저장하면 안 됨 ★)▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
	public void backBtnCtrl () {
		setCategoryLabelText("내 정보 조회");
		MPcontents.MPprofile.MPprofile_2.setTfEmpty();
		MPcontents.MPprofile.showMPprofile_1();
	}
	
	
	//프로필수정하기 화면에서 수정 완료 버튼 눌렀을 때 (수정값 저장해야됨 ★)▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
	public void completeBtnCtrl() {
		setCategoryLabelText("내 정보 조회");
			
		//여기에 수정한 정보 저장하는 기능 넣기 ★★★★★★★★★★★★★▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒

		MPcontents.MPprofile.MPprofile_2.setTfEmpty();
		MPcontents.MPprofile.showMPprofile_1();		

	} //내정보 보기 화면에는 항상 최신 값만 뜨도록 해놔야겠네 

	
	
	public void reservationcancleBtnCtrl() {
		int checkNum = 0;
		for(JCheckBox cb : MPcontents.MPreservation.MPreservation_2.cbArr) {
			if(cb.isSelected()) {
				br_id_list.add(Integer.parseInt(cb.getText()));
				checkNum++;
			} 
		}
		
		//체크된 체크박스가 없을 땐 작은 창이 안 뜨고, 하나라도 있으면 작은 창(정말 취소?) 뜸
		if(checkNum > 0) {
			
			//정말 취소하시겠습니까? 작은 창
			MPreservationSF sf = new MPreservationSF();
			
			//정말취소?스몰창에서 '예'버튼 눌렀을 떄 
			sf.yesBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
					try (Connection conn = OjdbcConnection.getConnection();){
						int cancleNum = br_id_list.size();
						
						for(int i = 0; i < cancleNum; ++i) {
							
							//체크된 체크박스에 해당하는 예매번호, 좌석번호
							int br_id = br_id_list.get(i);
							int bs_id = MPreservationlistModel.get_bs_id(conn, br_id_list.get(i));
							
							//예매번호에 해당하는 행 bus_reservation 테이블에서 지우고 좌석번호에 해당하는 행 bus_seat테이블에서 지우면 됨!
							MPreservationlistModel.delete_br_id_row(conn, br_id);
							MPreservationlistModel.delete_bs_id_row(conn, bs_id);
							
							//■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
							//아 이제 삭제는 되는데 문제 1: 커밋을 여기서 하게 만들어야 할 듯
							
							sf.dispose();//예 누르면 작은 창 닫기
							
							//문제 3 : 리스트 패널이 새로고침 되야됨
							//아 이게 문제네 ....
							
							//문제 4 : 어레리 비우는 거 
							dispose();
							setVisible(true); // 이런다고 새로고침 안 되네 망할
							//결국 패널에 데이터 다시 띄우는 수밖에 없는듯 
							
							/*
							new MPreservationPanel_2() 해서 MPreservationPanel에 다시 붙이는 방법이 없나? 
							add하는 건 가능할 것 같은데 그럼 기존에 있던 MPreservationPanel_2객체를 지우는게 문제네 
							아 아니다 MPreservationPanel 을 MAin에 다시 붙이면 되겠다! 근데 그 방법도 기존에 있던 패널 없애는게 문제다 
							*/

							//헐 그리고 사용자가 체크 해놓고 네브 버튼 누를 수도 있짜늠 그러면 체크 버튼 비우게 해놔야됨!
						
						
							//아나 예매내역 없으면 패널1로 변환하는 것도 해야됨ㅠㅠㅠㅠ할거 개많아
						}
						
						
						
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
			
					
				}
			});
		}
		
	}
	
	//■■■■■■■■■헐 어레리로 바꿨으니까 어레리 비우는 걸로 바꿔야겠네■■■■■■■■■■■■■■■■■■■■■
	public void br_idsSbSetVacate() {
		//br_idsSb.setLength(0); //이렇게 하면 StringBuilder 비워짐
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
		

		/*
		//홈버튼 누르면 홈화면으로 가기 
		MPhomeBtn.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				//아 이거 main 쓰려면 액션 클래스 따로 파야하나? 
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

		
		//예약취소버튼 액션■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■ㅍ
		MPcontents.MPreservation.MPreservation_2.MPreservationcancleBtn.addActionListener(new MPreservationCancleBtnEvent(this));
		
		
	
		
		
		
		add(MPnav);
		add(MPcontents);	
		add(MPhomeBtn);
			
		
		//프레임 설정
		setTitle("마이페이지");
		getContentPane().setBackground(Color.WHITE);//배경색 나중에 맞추기		
		setBounds(0, 0, 800, 650);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	

	
	//테스트용 메인부. 나중에 삭제
	public static void main(String[] args) {
		new MPmainFrame();
	}
}
