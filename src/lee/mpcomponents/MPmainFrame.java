package lee.mpcomponents;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import lee.OjdbcConnection;
import lee.mpevents.MPBackBtnEvent;
import lee.mpevents.MPcheckboxIL;
import lee.mpevents.MPcompleteBtnEvent;
import lee.mpevents.MPeditBtnEvent;
import lee.mpevents.MPleaveYesBtnEvent;
import lee.mpevents.MPnavBtnsEvent;
import lee.mpevents.MPreservationCancleBtnEvent;
import lee.mpmodel.MPprofileModel;
import lee.mpmodel.MPreservationlistModel;

public class MPmainFrame extends JFrame {

	String user_id = "abc123";
	
	JButton MPhomeBtn = new JButton();
	JLabel MPcategoryLb = new JLabel("카테고리명");
	
	MPnavPanel MPnav = new MPnavPanel();
	MPcontentsPanel MPcontents = new MPcontentsPanel();
	
	//체크된 체크박스에 담긴 예매번호 담는 어레리 
	ArrayList<Integer> br_id_list = new ArrayList<>();
	

	
//액션리스너에서 쓰일 메서드들 모음##########################################################################################
	
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
			
			//예매내역이 없으면 예매내역 없음 패널이 뜨도록
			try(Connection conn = OjdbcConnection.getConnection();) {
				if(MPreservationlistModel.get(conn, user_id).size() > 0) {
					MPcontents.MPreservation.MPreservationCard.show(MPcontents.MPreservation, "예매내역 있음");
				}
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		} else if(btn.getText().equals("계정 탈퇴")) {
			setCategoryLabelText(btn.getText());
			MPcontents.MPcontentsCard.show(MPcontents, "계정탈퇴");
		}
	}	
	
	
	//프로필수정하기 버튼 눌렀을 때
	public void editBtnCtrl () {		
		setCategoryLabelText("내 정보 수정");
		dispose();
		MPmainFrame MPnewmainF = new MPmainFrame();
		MPnewmainF.MPcontents.MPprofile.showMPprofile_2(); 		
	}

	//프로필수정하기 화면에서 뒤로가기 버튼 눌렀을 때 (수정값 저장하면 안 되도록)
	public void backBtnCtrl () {
		setCategoryLabelText("내 정보 조회");
		MPcontents.MPprofile.showMPprofile_1();
	}
	
	
	//프로필수정하기 화면에서 수정 완료 버튼 눌렀을 때 (수정값 저장되게) 
	public void completeBtnCtrl() {
		if(MPcontents.MPprofile.MPprofile_2.MPnameTf.getText().equals("") 
			|| MPcontents.MPprofile.MPprofile_2.MPphoneTf.getText().equals("") 
			|| MPcontents.MPprofile.MPprofile_2.MPgetPwd(MPcontents.MPprofile.MPprofile_2.MPnewpwTf).equals("")) {
			new MPpreventnulltfSF();
			return;
		}
		
		
		//이제 숫자 아닌거 넣으면 작은 창 뜨도록 해야됨
		boolean result = Pattern.matches("\\d{11}", MPcontents.MPprofile.MPprofile_2.MPphoneTf.getText());
		if(!result) {
			new MPincorrectphonenumSF();
			return;
		}
			
		
		//이름이랑 비밀번호 글자수 제한하는 거 할까... ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
		if((MPcontents.MPprofile.MPprofile_2.MPnameTf.getText().length() > 10)||(MPcontents.MPprofile.MPprofile_2.MPgetPwd(MPcontents.MPprofile.MPprofile_2.MPnewpwTf).length() > 10)) {		
			new MPnamelengthrestrictSF();
			return;
		}
		

	
		setCategoryLabelText("내 정보 조회");	
		//수정한 정보 DB에 업데이트
		try(Connection conn = OjdbcConnection.getConnection()
		) {
			conn.setAutoCommit(false);
			MPprofileModel.MPupdateUserName(conn, user_id, MPcontents.MPprofile.MPprofile_2.MPnameTf.getText());
			MPprofileModel.MPupdateUserPw(conn, user_id, MPcontents.MPprofile.MPprofile_2.MPgetPwd(MPcontents.MPprofile.MPprofile_2.MPnewpwTf));
			//핸드폰번호는 01012341234 로 입력받아서 010-1234-1234로 저장	
			String str = MPcontents.MPprofile.MPprofile_2.MPphoneTf.getText();
			ArrayList<String> arr = new ArrayList<>();
			arr.add(str.substring(0, 3));
			arr.add(str.substring(3, 7));
			arr.add(str.substring(7, 11));
			MPprofileModel.MPupdateUserPhoneNum(conn, user_id, String.join("-", arr));
			
			conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dispose();
		MPmainFrame MPnewmainF = new MPmainFrame();
		MPcontents.MPprofile.showMPprofile_1();		
	} //내정보 보기 화면에는 항상 최신 값만 뜨도록 해놔야겠네 

	
	//예매취소 버튼 눌렀을 때
	public void reservationcancleBtnCtrl() {

		int checkNum = 0;
		//System.out.println(MPcontents.MPreservation.MPreservation_2.cbArr.length);
		for(JCheckBox cb : MPcontents.MPreservation.MPreservation_2.cbArr) {
			if(cb.isSelected()) {
				br_id_list.add(Integer.parseInt(cb.getText()));
				checkNum++;
			} 
		}
		System.out.println(checkNum);
		//체크된 체크박스가 없을 땐 작은 창이 안 뜨고, 하나라도 있으면 작은 창(정말 취소?) 뜸
		if(checkNum > 0) {
			
			//정말 취소하시겠습니까? 작은 창
			MPreservationSF sf = new MPreservationSF();
			
			//정말취소?스몰창에서 '예'버튼 눌렀을 떄 
			sf.yesBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
					try (Connection conn = OjdbcConnection.getConnection();){
						
						conn.setAutoCommit(false);
						
						int cancleNum = br_id_list.size();
						
						for(int i = 0; i < cancleNum; ++i) {
							
							//체크된 체크박스에 해당하는 예매번호, 좌석번호
							int br_id = br_id_list.get(i);
							int bs_id = MPreservationlistModel.get_bs_id(conn, br_id_list.get(i));
							
							//예매번호에 해당하는 행 bus_reservation 테이블에서 지우고 좌석번호에 해당하는 행 bus_seat테이블에서 지우면 됨!
							MPreservationlistModel.delete_br_id_row(conn, br_id);
							MPreservationlistModel.delete_bs_id_row(conn, bs_id);
						}
						
						conn.commit();//커밋 오라클 가서 안 해도 되고 여기서 바로 됨
						sf.dispose();//예 누르면 작은 창 닫기
					
						//_______________________________예매내역 새로고침 부분_________________________________________
						MPcontents.MPreservation.remove(MPcontents.MPreservation.MPreservation_2);
						MPreservationPanel_2 newMPreservationPanel_2 = new MPreservationPanel_2();
						btnAddAction(newMPreservationPanel_2.MPreservationcancleBtn);
						MPcontents.MPreservation.add(newMPreservationPanel_2);
						
						br_id_list = new ArrayList<>(); //체크박스 선택된 예매번호(br_id) 담는 어레리 비워주고 
						
						//예매내역 패널 새로고침
						dispose();
						MPmainFrame MPnewmainF = new MPmainFrame();
						MPnewmainF.setCategoryLabelText("예매확인");
						MPnewmainF.MPcontents.MPcontentsCard.show(MPnewmainF.MPcontents, "예매내역");
						
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			});
		}	
	}
	
	
	
	public void btnAddAction(JButton btn) {
		btn.addActionListener(new MPreservationCancleBtnEvent(this));
	}
	
	
	
	public void leaveBtnCtrl() {
		
		//정말 삭제하시겠습니까? 작은 창 띄우기
		MPleaveRealSF sf = new MPleaveRealSF();
		
		//user_info 테이블에서 user_info에 해당하는 행 DELETE 
		sf.yesBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try(Connection conn = OjdbcConnection.getConnection();) {
					conn.setAutoCommit(false);
					
					//레저테이블의 user_id 행을  먼저 삭제하고 그 다음에 user_info의 user_id행을 삭제해야됨
					MPreservationlistModel.delete_user_id_row(conn, user_id);	
					MPprofileModel.MPdeleteUserInfo(conn, user_id);
					
					conn.commit();
					sf.dispose();
					
					//삭제되었습니다 작은 창 띄유기 
					MPleavecompleteSF sf1 = new MPleavecompleteSF();	
					sf1.yesBtn.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							sf1.dispose();
							dispose();
							
							
							
							// 이을 때 여기에 홈화면으로 가는 기능 추가하기!!!!★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★

							
							
						}
					});
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});	
	}
	
	
	
//####################################################################################################################################	
	
	
	
	
	
	
	public MPmainFrame() {

		
		setLayout(null);

		setCategoryLabelText("내 정보 조회");
		
		MPcategoryLb.setBounds(230, 30, 700, 100);
		MPcategoryLb.setFont(new Font("고딕", Font.PLAIN, 25));
		this.add(MPcategoryLb);
		
		
		MPhomeBtn.setBounds(10, 10, 50, 50);
		MPhomeBtn.setBorderPainted(false);
		

		/* ★★★★★★★★★★★★★★★★★★★이을 때 할 것!★★★★★★★★★★★★★★★★★★★★
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

		
		//예약취소버튼 액션 
		MPcontents.MPreservation.MPreservation_2.MPreservationcancleBtn.addActionListener(new MPreservationCancleBtnEvent(this));
		
		
		//탈퇴하기 예 버튼 액션  
		MPcontents.MPleave.MPleaveYesBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				leaveBtnCtrl();
			}
		});
		
		
		
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
