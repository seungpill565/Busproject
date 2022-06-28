package lee.mpcomponents;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import an.OjdbcConnection;
import an.login.Login_Mainframe;
import an.userinfo.Info_MainFrame;
import hong.SaveInfo;
import lee.mpevents.MPBackBtnEvent;
import lee.mpevents.MPcompleteBtnEvent;
import lee.mpevents.MPeditBtnEvent;
import lee.mpevents.MPnavBtnsEvent;
import lee.mpevents.MPreservationCancleBtnEvent;
import lee.mpmodel.MPprofileModel;
import lee.mpmodel.MPreservationlistModel;

//수정했는데 되돌릴 수 없네 커밋은 안 함 저장만 함
public class MPmainFrame extends JFrame {

	String user_id;
	SaveInfo saveInfo;
	
	JButton MPhomeBtn = new JButton();
	JLabel MPcategoryLb = new JLabel("카테고리명");
	
	MPnavPanel MPnav = new MPnavPanel();
	MPcontentsPanel MPcontents;
	
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
			
			//예매내역의 모든 체크박스 선택 해제
			for(JCheckBox cb : MPcontents.MPreservation.MPreservation_2.cbArr) {
				cb.setSelected(false);
			}
			
		} else if(btn.getText().equals("예매 확인")) {
			setCategoryLabelText(btn.getText());
			MPcontents.MPcontentsCard.show(MPcontents, "예매내역");
			
			//예매내역이 없으면 예매내역 없음 패널이 뜨도록
			try(Connection conn = OjdbcConnection.getConnection();) {
				if(MPreservationlistModel.get(conn, user_id).size() > 0) {
					//System.out.println("예매내역 없대...");
					MPcontents.MPreservation.MPreservationCard.show(MPcontents.MPreservation, "예매내역 있음");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		} else if(btn.getText().equals("계정 탈퇴")) {
			setCategoryLabelText(btn.getText());
			MPcontents.MPcontentsCard.show(MPcontents, "계정탈퇴");
			
			//예매내역의 모든 체크박스 선택 해제
			for(JCheckBox cb : MPcontents.MPreservation.MPreservation_2.cbArr) {
				cb.setSelected(false);
			}
		}
	}	
	
	
	//프로필수정하기 버튼 눌렀을 때
	public void editBtnCtrl () {		
		
	 	MPinputpwSF inputpwSF = new MPinputpwSF();
		
		
		inputpwSF.completeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try (Connection conn = OjdbcConnection.getConnection();){
					
					String str = inputpwSF.MPgetPwd(inputpwSF.inputpwPf);
					
					if(str.equals(MPprofileModel.MPgetUserPw(conn, user_id))) {
						inputpwSF.dispose();
						dispose();
						MPmainFrame MPnewmainF = new MPmainFrame(saveInfo);
						MPnewmainF.MPcontents.MPprofile.showMPprofile_2(); 		
						MPnewmainF.setCategoryLabelText("내 정보 수정");
					} else {
						new MPincorrectpwSF();
					}
				
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
	}

	//프로필수정하기 화면에서 뒤로가기 버튼 눌렀을 때 (수정값 저장하면 안 되도록)
	public void backBtnCtrl () {
		setCategoryLabelText("내 정보 조회");
		MPcontents.MPprofile.showMPprofile_1();
	}
	
	
	//프로필수정하기 화면에서 수정 완료 버튼 눌렀을 때 (수정값 저장되게) 
	public void completeBtnCtrl() {
		if(MPcontents.MPprofile.MPprofile_2.MPnameTf.getText().equals("") 
			|| MPcontents.MPprofile.MPprofile_2.MPphoneTf_1.getText().equals("")
			|| MPcontents.MPprofile.MPprofile_2.MPphoneTf_2.getText().equals("")
			|| MPcontents.MPprofile.MPprofile_2.MPphoneTf_3.getText().equals("")
			|| MPcontents.MPprofile.MPprofile_2.MPgetPwd(MPcontents.MPprofile.MPprofile_2.MPnewpwTf).equals("")) {
			
			//new MPpreventnulltfSF();
			JOptionPane.showMessageDialog(null, "빈 칸을 모두 입력해주세요", "입력 오류", 1);			
			return;
		}
		
			
		//이름 글자수 제한 
		if(MPcontents.MPprofile.MPprofile_2.MPnameTf.getText().length() > 10) {		
			//new MPnamelengthrestrictSF();
			JOptionPane.showMessageDialog(null, "이름은 10글자까지 입력 가능합니다.", "입력 오류", 1);
			return;
		}
		

		Pattern passPattern1 = Pattern.compile("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*\\W).{8,20}$"); //8자 영문+특문+숫자
		Matcher passMatcher = passPattern1.matcher(MPcontents.MPprofile.MPprofile_2.MPgetPwd(MPcontents.MPprofile.MPprofile_2.MPnewpwTf));
		if (!passMatcher.find()) {
			JOptionPane.showMessageDialog(null, "비밀번호는 영문+특수문자+숫자 8자로 구성되어야 합니다", "입력 오류", 1);
			return;
		}
		
		
		if(!MPcontents.MPprofile.MPprofile_2.MPgetPwd(MPcontents.MPprofile.MPprofile_2.MPchknewpwTf).equals(MPcontents.MPprofile.MPprofile_2.MPgetPwd(MPcontents.MPprofile.MPprofile_2.MPnewpwTf))) {
			JOptionPane.showMessageDialog(null, "<html>비밀번호가 일치하지 않습니다.</html>", "입력 오류", 1);
			return;
		}
		
		
		
		
		setCategoryLabelText("내 정보 조회");	

		//수정한 정보 DB에 업데이트
		try(Connection conn = OjdbcConnection.getConnection()
		) {
			conn.setAutoCommit(false);
			
			//새 이름, 새 비밀번호 업데이트
			MPprofileModel.MPupdateUserName(conn, user_id, MPcontents.MPprofile.MPprofile_2.MPnameTf.getText());
			MPprofileModel.MPupdateUserPw(conn, user_id, MPcontents.MPprofile.MPprofile_2.MPgetPwd(MPcontents.MPprofile.MPprofile_2.MPnewpwTf));
		
			//핸드폰번호는 01012341234 로 입력받아서 010-1234-1234로 저장	
			String str = MPcontents.MPprofile.MPprofile_2.MPgetPhoneNum();
			ArrayList<String> arr = new ArrayList<>();
			arr.add(str.substring(0, 3));
			arr.add(str.substring(3, 7));
			arr.add(str.substring(7, 11));
			MPprofileModel.MPupdateUserPhoneNum(conn, user_id, String.join("-", arr));

			conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//새로고침
		dispose();
		MPmainFrame MPnewmainF = new MPmainFrame(saveInfo);
		MPcontents.MPprofile.showMPprofile_1();		
	}  

	
	//예매취소 버튼 눌렀을 때
	public void reservationcancleBtnCtrl() {
		
		//체크된 체크박스 개수 세기
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
						conn.setAutoCommit(false);

						int cancleNum = br_id_list.size();
						
						for(int i = 0; i < cancleNum; ++i) {							
							//체크된 체크박스에 해당하는 예매번호, 좌석번호
							int br_id = br_id_list.get(i);
							int bs_id = MPreservationlistModel.get_bs_id(conn, br_id_list.get(i));
										
							//예매번호에 해당하는 행 bus_reservation 테이블에서 지우기 
							MPreservationlistModel.delete_br_id_row(conn, br_id);
							//좌석번호에 해당하는 bs_is_reserved 를 0으로 바꾸기 (bus_seat테이블) 
							MPreservationlistModel.update_bs_is_reserved(conn, bs_id);							
						}
						
						conn.commit(); //커밋 오라클 가서 안 해도 되고 여기서 바로 됨
						sf.dispose(); //예 누르면 작은 창 닫기
					
						//_______________________________예매내역 새로고침 부분______________________________________________________________
						
						br_id_list = new ArrayList<>(); //체크박스 선택된 예매번호(br_id) 담는 어레리 비워주고 
						
						//예매내역 패널 새로고침
						dispose();
						MPmainFrame MPnewmainF = new MPmainFrame(saveInfo);
						MPnewmainF.setCategoryLabelText("예매확인");
						
						// 메인프레임 껐다 킨 후에 예매내역 패널이 뜨도록 하는 코드들
						MPnewmainF.MPcontents.MPcontentsCard.show(MPnewmainF.MPcontents, "예매내역");						
						if(MPreservationlistModel.get(conn, user_id).size() > 0) {
							MPnewmainF.MPcontents.MPreservation.MPreservationCard.show(MPnewmainF.MPcontents.MPreservation, "예매내역 있음");
						}
						//______________________________________________________________________________________________________________
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			});
			
	
		}	
	}
	

	
	
	//계정 탈퇴 '예' 버튼
	public void leaveBtnCtrl() {
		
		
		String confirmPw = MPcontents.MPleave.MPgetPwd(MPcontents.MPleave.MPleavePf);
		String userPw = "";
		try {
			Connection conn = OjdbcConnection.getConnection();
			userPw = MPprofileModel.MPgetUserPw(conn, user_id);
		} catch (SQLException e2) {
		}
		
		//비밀번호 일치하면 정말 탈퇴 하시겠습니까? 작은 창 띄우기
		if(confirmPw.equals(userPw)) {
			
			//정말 탈퇴 하시겠습니까? 작은 창 
			MPleaveRealSF sf = new MPleaveRealSF();
			//정말 탈퇴?창 '예' 누르면 bus_seat에서 좌석 1>0으로 바꾸고, bus_reservation에서 예매기록 삭제한 후에 user_id삭제  
			sf.yesBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try(Connection conn = OjdbcConnection.getConnection();) {
						conn.setAutoCommit(false);
						
						//user_id에 해당하는 bs_id들을 1에서 0으로 바꾸기
						ArrayList<Integer> bs_id_list = MPreservationlistModel.get_bs_id(conn, user_id);
						for(int bs_id : bs_id_list) {
							MPreservationlistModel.update_bs_is_reserved(conn, bs_id);
						}
						//user_id가 예매한 예매내역 지우기
						MPreservationlistModel.delete_user_id_row(conn, user_id);
						//user_info테이블에서 user_id에 해당하는 행 지우기
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
								new Login_Mainframe();
							}
						});
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			});	

		} else {
			JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다 .", "입력 오류", 1);
		}	
	}


	
//####################################################################################################################################	
//####################################################################################################################################

	
	
	
	//드디어 생성자
	public MPmainFrame(SaveInfo saveInfo) {
		
		this.saveInfo = saveInfo;
		this.user_id = saveInfo.get_user_id();
		
		MPcontents = new MPcontentsPanel(saveInfo);
	
		setLayout(null);

		//맨 처음 로드되는 화면은 내 정보 조회 화면이니까 카테고리 라벨을 '내 정보 조회'로 설정
		setCategoryLabelText("내 정보 조회");
		MPcategoryLb.setBounds(230, 30, 700, 100);
		MPcategoryLb.setFont(new Font("고딕", Font.PLAIN, 25));
		this.add(MPcategoryLb);
		
		
		MPhomeBtn.setBounds(10, 10, 50, 50);
		MPhomeBtn.setBorderPainted(false);
		
		
		//홈버튼 액션 달기
		MPhomeBtn.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Info_MainFrame(saveInfo);
			}
		});
		
		
		
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

}
