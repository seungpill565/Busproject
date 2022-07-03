package lee.mpcomponents;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
	
	
	JLabel MPcategoryLb = new JLabel("카테고리명");
	
	MPnavPanel MPnav = new MPnavPanel();
	MPcontentsPanel MPcontents;
	
	//체크된 체크박스에 담긴 예매번호 담는 어레리 
	ArrayList<Integer> br_id_list = new ArrayList<>();
	
	//이미지 아이콘 준비
	ImageIcon homeImg1 = new ImageIcon("image/MPhome1.png");
	ImageIcon homeImg2 = new ImageIcon("image/MPhome2.png");
	ImageIcon backImg = new ImageIcon("image/mp배경.png");
	
	MPwarningSF deleted;
	MPrealSF realSF;
	
//액션리스너에서 쓰일 메서드들 모음
	
	//카테고리명 라벨 텍스트 바꾸는 메서드
		public void setCategoryLabelText(String title) {
			MPcategoryLb.setText(title);	
		}
	
		
	//네비게이션 3버튼 동작 메서드
	public void navBtnCtrl (JButton btn) {
		
		if(btn.getText().equals("내 정보")) {
			setCategoryLabelText("내 정보 조회");
			MPcontents.MPcontentsCard.show(MPcontents, "내정보");
			MPcontents.MPprofile.showMPprofile_1();
			
		} else if(btn.getText().equals("예매 확인")) {
			setCategoryLabelText(btn.getText());
			MPcontents.MPcontentsCard.show(MPcontents, "예매내역");
			
			//예매내역이 있으면 예매내역 있음 패널 띄우기
			try(Connection conn = OjdbcConnection.getConnection();) {
				//System.out.println("예매내역 갯수 : " + MPreservationlistModel.get(conn, user_id).size());
				if(MPreservationlistModel.get(conn, user_id).size() > 0) {
					MPcontents.MPreservation.MPreservationCard.show(MPcontents.MPreservation, "예매내역 있음");
					//예매내역의 전체 체크박스 해제
					MPcontents.MPreservation.MPreservation_2.setChkAllUnselected();
					//예매내역의 모든 체크박스 선택 해제
					for(JCheckBox cb : MPcontents.MPreservation.MPreservation_2.cbArr) {
						cb.setSelected(false);
					}
				} 
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		} else if(btn.getText().equals("계정 탈퇴")) {
			setCategoryLabelText(btn.getText());
			MPcontents.MPcontentsCard.show(MPcontents, "계정탈퇴");
			MPcontents.MPleave.setPfEmpty();
		}
		
	}	
	
	
	//프로필수정하기 버튼 눌렀을 때 메서드 
	public void editBtnCtrl () {		
		
		//수정하기 버튼 비활성화
		MPcontents.MPprofile.MPprofile_1.MPeditBtn.setEnabled(false);
		
		//비밀번호 확인창
	 	MPinputpwSF inputpwSF = new MPinputpwSF();
	 	
	 	//비밀번호 입력 창 떠 있는 동안 수정하기 버튼 비활성화 시키는 리스너
	 	inputpwSF.addWindowListener(new WindowAdapter() {
	 		@Override
	 		public void windowClosed(WindowEvent e) {
	 			MPcontents.MPprofile.MPprofile_1.MPeditBtn.setEnabled(true);
	 		}
	 	});
	 	
		//비밀번호 확인창의 '입력'버튼 눌렀을 때 입력된 비번과 user_id의 비번을 비교하는 액션 리스너 
		inputpwSF.completeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				inputpwSF.completeBtn.setEnabled(false);
				try (Connection conn = OjdbcConnection.getConnection();){
					
					String str = inputpwSF.MPgetPwd(inputpwSF.inputpwPf);
					
					if(str.equals(MPprofileModel.MPgetUserPw(conn, user_id))) {
						inputpwSF.dispose(); //비번확인창 끄고
						dispose(); //메인프레임 끄고
						MPmainFrame MPnewmainF = new MPmainFrame(saveInfo); //메인 프레임 새로 띄우기
						MPnewmainF.MPcontents.MPprofile.showMPprofile_2(); 		
						MPnewmainF.setCategoryLabelText("내 정보 수정");
						
					} else {
						MPwarningSF warningSF = new MPwarningSF("비밀번호 오류", "<html><pre>잘못된 비밀번호입니다.<br> 다시 입력해주세요.</pre></html>", 110, 60, 340, 30);
						warningSF.addWindowListener(new WindowAdapter() {
							public void windowClosed(WindowEvent e) {
								inputpwSF.completeBtn.setEnabled(true);	
							};
						});
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}	
		});
		
		
		
	}				
		
	
	//프로필수정하기 화면에서 뒤로가기 버튼 눌렀을 때 메서드
	public void backBtnCtrl () {
		setCategoryLabelText("내 정보 조회");
		MPcontents.MPprofile.showMPprofile_1();
	}
	
	
	//프로필수정하기 화면에서 수정 완료 버튼 눌렀을 때 메서드 
	public void completeBtnCtrl() {
		
		//뒤로가기 버튼, 완료 버튼 일단 비활성화
		MPcontents.MPprofile.MPprofile_2.MPbackBtn.setEnabled(false);
		MPcontents.MPprofile.MPprofile_2.MPcompleteBtn.setEnabled(false);
				
		
		//입력되지 않은 빈 칸이 있을 때 경고창 띄우기
		if(MPcontents.MPprofile.MPprofile_2.MPnameTf.getText().equals("") 
			|| MPcontents.MPprofile.MPprofile_2.MPphoneTf_1.getText().equals("")
			|| MPcontents.MPprofile.MPprofile_2.MPphoneTf_2.getText().equals("")
			|| MPcontents.MPprofile.MPprofile_2.MPphoneTf_3.getText().equals("")
			|| MPcontents.MPprofile.MPprofile_2.MPgetPwd(MPcontents.MPprofile.MPprofile_2.MPnewpwTf).equals("")) {			
			MPwarningSF warningSF = new MPwarningSF("입력 오류", "빈 칸을 모두 입력해주세요", 95, 60, 200, 30);
			warningSF.addWindowListener(new WindowListener() {
				public void windowOpened(WindowEvent e) {} public void windowIconified(WindowEvent e) {} public void windowDeiconified(WindowEvent e) {} public void windowDeactivated(WindowEvent e) {} public void windowClosing(WindowEvent e) {} public void windowActivated(WindowEvent e) {}
				public void windowClosed(WindowEvent e) {MPcontents.MPprofile.MPprofile_2.MPcompleteBtn.setEnabled(true); MPcontents.MPprofile.MPprofile_2.MPbackBtn.setEnabled(true);}
			});
			return;
		}
		
		//비밀번호 텍스트필드 제한 경고창 띄우기
		Pattern passPattern1 = Pattern.compile("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*\\W).{8,20}$"); //8자 영문+특문+숫자
		Matcher passMatcher = passPattern1.matcher(MPcontents.MPprofile.MPprofile_2.MPgetPwd(MPcontents.MPprofile.MPprofile_2.MPnewpwTf));
		if (!passMatcher.find()) {
			MPwarningSF warningSF = new MPwarningSF("입력 오류", "<html><pre>비밀번호는 영문+특수문자+숫자<br> 8~20자로 구성되어야 합니다</pre></html>", 80, 60, 200, 40);
			warningSF.addWindowListener(new WindowListener() {
				public void windowOpened(WindowEvent e) {} public void windowIconified(WindowEvent e) {} public void windowDeiconified(WindowEvent e) {} public void windowDeactivated(WindowEvent e) {} public void windowClosing(WindowEvent e) {} public void windowActivated(WindowEvent e) {}
				public void windowClosed(WindowEvent e) {MPcontents.MPprofile.MPprofile_2.MPcompleteBtn.setEnabled(true); MPcontents.MPprofile.MPprofile_2.MPbackBtn.setEnabled(true);}
			});
			return;
		}
		
		//비밀번호 불일치 경고창 띄우기 
		if(!MPcontents.MPprofile.MPprofile_2.MPgetPwd(MPcontents.MPprofile.MPprofile_2.MPchknewpwTf).equals(MPcontents.MPprofile.MPprofile_2.MPgetPwd(MPcontents.MPprofile.MPprofile_2.MPnewpwTf))) {
			MPwarningSF warningSF = new MPwarningSF("입력 오류", "비밀번호가 일치하지 않습니다.", 85, 60, 200, 30);
			warningSF.addWindowListener(new WindowListener() {
				public void windowOpened(WindowEvent e) {} public void windowIconified(WindowEvent e) {} public void windowDeiconified(WindowEvent e) {} public void windowDeactivated(WindowEvent e) {} public void windowClosing(WindowEvent e) {} public void windowActivated(WindowEvent e) {}
				public void windowClosed(WindowEvent e) {MPcontents.MPprofile.MPprofile_2.MPcompleteBtn.setEnabled(true); MPcontents.MPprofile.MPprofile_2.MPbackBtn.setEnabled(true);}
			});
			return;
		}
		
		
		//경고창 아무것도 안 뜨면 바뀐 정보 DB에 업데이트 하면서 내 정보 조회 화면 새로 띄우기
		//수정한 정보 DB에 업데이트
		try(Connection conn = OjdbcConnection.getConnection()
		) {
			conn.setAutoCommit(false);
			
			//새 이름, 새 비밀번호 업데이트
			MPprofileModel.MPupdateUserName(conn, user_id, MPcontents.MPprofile.MPprofile_2.MPnameTf.getText());
			MPprofileModel.MPupdateUserPw(conn, user_id, MPcontents.MPprofile.MPprofile_2.MPgetPwd(MPcontents.MPprofile.MPprofile_2.MPnewpwTf));
		
			//핸드폰번호는 01012341234를 010-1234-1234로 변환해서 DB에 업데이트
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
		
		//새로고침 (프레임 껐다 켜기)
		dispose();
		MPmainFrame MPnewmainF = new MPmainFrame(saveInfo);
		MPnewmainF.setCategoryLabelText("내 정보 조회");			
	}  

	
	//예매취소 버튼 눌렀을 때 메서드
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
			//예매취소버튼 비활성화
			MPcontents.MPreservation.MPreservation_2.MPreservationcancleBtn.setEnabled(false);
			//'정말 취소하시겠습니까?' 작은 창			
			MPrealSF sf = new MPrealSF("예매취소", "정말 취소하시겠습니까?", 100, 60, 300, 30);
			
			//'정말취소하시겠습니까?' 작은 창 꺼지면 예매취소버튼 활성화 
			sf.addWindowListener(new WindowListener() {
				public void windowOpened(WindowEvent e) {} public void windowIconified(WindowEvent e) {} public void windowDeiconified(WindowEvent e) {} public void windowDeactivated(WindowEvent e) {} public void windowClosing(WindowEvent e) {} public void windowActivated(WindowEvent e) {}
				public void windowClosed(WindowEvent e) {MPcontents.MPreservation.MPreservation_2.MPreservationcancleBtn.setEnabled(true);}
			});
			//'정말취소하시겠습니까?' 작은 창에서 '예'버튼 눌렀을 떄 
			sf.yesBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
					try (Connection conn = OjdbcConnection.getConnection();){	
						conn.setAutoCommit(false);

						int cancleNum = br_id_list.size(); //취소하려는 예매번호 갯수 
						
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
					
						
						//예매내역 새로고침
						br_id_list = new ArrayList<>(); //체크박스 선택된 예매번호(br_id) 담는 어레리 비워주고 
						dispose(); //메인 프레임 새로 띄우기
						MPmainFrame MPnewmainF = new MPmainFrame(saveInfo);
						MPnewmainF.setCategoryLabelText("예매확인");
						// 메인프레임 껐다 킨 후에 예매내역 패널이 뜨도록 하는 코드들
						MPnewmainF.MPcontents.MPcontentsCard.show(MPnewmainF.MPcontents, "예매내역");						
						if(MPreservationlistModel.get(conn, user_id).size() > 0) {
							MPnewmainF.MPcontents.MPreservation.MPreservationCard.show(MPnewmainF.MPcontents.MPreservation, "예매내역 있음");
						}
						
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			});
			
	
		}	
	}
	

	
	
	//계정 탈퇴 '예' 버튼 메서드
	public void leaveBtnCtrl() {
		
		
		String confirmPw = MPcontents.MPleave.MPgetPwd(MPcontents.MPleave.MPleavePf);
		String userPw = "";
		try {
			Connection conn = OjdbcConnection.getConnection();
			userPw = MPprofileModel.MPgetUserPw(conn, user_id);
		} catch (SQLException e2) {
		}
		
		//'예' 버튼 비활성화
		MPcontents.MPleave.MPleaveYesBtn.setEnabled(false);
		
		//비밀번호 일치하면 정말 탈퇴 하시겠습니까? 작은 창 띄우기
		if(confirmPw.equals(userPw)) {
			
			//정말 탈퇴 하시겠습니까? 작은 창 
			realSF = new MPrealSF("계정 탈퇴", "정말 탈퇴하시겠습니까?", 100, 60, 300, 30);
			
			//정말 탈퇴? 작은 창 꺼지면 '예' 버튼 활성화
			realSF.addWindowListener(new WindowListener() {
				public void windowOpened(WindowEvent e) {} public void windowIconified(WindowEvent e) {} public void windowDeiconified(WindowEvent e) {} public void windowDeactivated(WindowEvent e) {} public void windowClosing(WindowEvent e) {} public void windowActivated(WindowEvent e) {}
				public void windowClosed(WindowEvent e) {MPcontents.MPleave.MPleaveYesBtn.setEnabled(true);}
			});
			
			//정말 탈퇴?창 '예' 누르면 bus_seat에서 좌석 1>0으로 바꾸고, bus_reservation에서 예매기록 삭제한 후에 user_id삭제  
			realSF.yesBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					realSF.yesBtn.setEnabled(false);//버튼 비활성화
					try(Connection conn = OjdbcConnection.getConnection();) {
						conn.setAutoCommit(false);
						
						//user_id가 얘매한 bs_id(좌석id)에 해당하는 bus_is_reserved를 1에서 0으로 바꾸기
						ArrayList<Integer> bs_id_list = MPreservationlistModel.get_bs_id(conn, user_id);
						for(int bs_id : bs_id_list) {
							MPreservationlistModel.update_bs_is_reserved(conn, bs_id);
						}
						//user_id가 예매한 예매내역 지우기
						MPreservationlistModel.delete_user_id_row(conn, user_id);
						//user_info테이블에서 user_id에 해당하는 행 지우기
						MPprofileModel.MPdeleteUserInfo(conn, user_id);
							
						conn.commit();
						realSF.dispose();
						
						//삭제되었습니다 작은 창 띄유기 
						deleted = new MPwarningSF("탈퇴 완료", "<html><pre>     탈퇴 완료.<br>홈화면으로 이동합니다.</pre></html>", 107, 60, 300, 30);	
						
						deleted.addWindowListener(new WindowListener() {
							public void windowOpened(WindowEvent e) {} public void windowIconified(WindowEvent e) {} public void windowDeiconified(WindowEvent e) {} public void windowDeactivated(WindowEvent e) {} public void windowClosing(WindowEvent e) {} public void windowActivated(WindowEvent e) {}
							public void windowClosed(WindowEvent e) {realSF.yesBtn.setEnabled(true);}
						});
						
						deleted.closeBtn.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								deleted.dispose();
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
			MPwarningSF warningSF = new MPwarningSF("비밀번호 오류", "<html><pre>잘못된 비밀번호입니다.<br> 다시 입력해주세요.</pre></html>", 110, 60, 340, 30);
			warningSF.addWindowListener(new WindowListener() {
				public void windowOpened(WindowEvent e) {} public void windowIconified(WindowEvent e) {} public void windowDeiconified(WindowEvent e) {} public void windowDeactivated(WindowEvent e) {} public void windowClosing(WindowEvent e) {} public void windowActivated(WindowEvent e) {}
				public void windowClosed(WindowEvent e) {MPcontents.MPleave.MPleaveYesBtn.setEnabled(true);}
			});
		}	
	}


	

	
	
	
	
	
	
	
	
//드디어 생성자
	public MPmainFrame(SaveInfo saveInfo) {
		
		this.saveInfo = saveInfo;
		this.user_id = saveInfo.get_user_id();
		
		MPcontents = new MPcontentsPanel(saveInfo);
	
		setLayout(null);

		//맨 처음 로드되는 화면은 내 정보 조회 화면이니까 카테고리 라벨을 '내 정보 조회'로 설정
		setCategoryLabelText("내 정보 조회");
		MPcategoryLb.setBounds(230, 30, 700, 100);
		MPcategoryLb.setFont(new Font("휴먼편지체", Font.BOLD, 30));
		MPcategoryLb.setForeground(Color.BLACK);
		this.add(MPcategoryLb);
		
		//홈버튼에 이미지 달기
		JButton MPhomeBtn = new JButton(homeImg1);
		MPhomeBtn.setBounds(10, 10, 50, 50);
		MPhomeBtn.setBorderPainted(false);
		MPhomeBtn.setContentAreaFilled(false);
		MPhomeBtn.setFocusPainted(false);
		
		
		//홈버튼 액션 달기
		MPhomeBtn.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Info_MainFrame(saveInfo);
			}
		});
		
		MPhomeBtn.setRolloverIcon(homeImg2);
		
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
		
		
		//프레임 배경 설정
		JPanel backPn = new JPanel();
		JLabel backLb = new JLabel(backImg);
		backPn.setBounds(0, 0, 800, 650);
		backPn.setOpaque(true);
		backLb.setBounds(0, 0, 800, 650);
		backPn.add(backLb);
		add(backPn);

		
		//프레임 설정
		setTitle("마이페이지");		
		setSize(800, 650);
		setLocationRelativeTo(null);//창이 가운데 나오게
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.WHITE);
	}

}
