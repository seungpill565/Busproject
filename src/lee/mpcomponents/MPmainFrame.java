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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	ImageIcon homeImg1 = new ImageIcon("image/home1.png");
	ImageIcon homeImg2 = new ImageIcon("image/home2.png");
	ImageIcon backImg = new ImageIcon("image/mp배경.png");
	
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
			
			//예매내역의 모든 체크박스 선택 해제
			for(JCheckBox cb : MPcontents.MPreservation.MPreservation_2.cbArr) {
				cb.setSelected(false);
			}
			
		} else if(btn.getText().equals("예매 확인")) {
			setCategoryLabelText(btn.getText());
			MPcontents.MPcontentsCard.show(MPcontents, "예매내역");
			
			//예매내역이 없으면 예매내역 없음 패널이 뜨도록
			try(Connection conn = OjdbcConnection.getConnection();) {
				System.out.println("예매내역 갯수 : " + MPreservationlistModel.get(conn, user_id).size());
				if(MPreservationlistModel.get(conn, user_id).size() > 0) {
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
	
	
	//프로필수정하기 버튼 눌렀을 때 메서드 
	public void editBtnCtrl () {		
		
		//비밀번호 확인창
	 	MPinputpwSF inputpwSF = new MPinputpwSF();
	 	
		//비밀번호 확인창의 '입력'버튼 눌렀을 때 입력된 비번과 user_id의 비번을 비교하는 액션 리스너 
		inputpwSF.completeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try (Connection conn = OjdbcConnection.getConnection();){
					
					String str = inputpwSF.MPgetPwd(inputpwSF.inputpwPf);
					
					if(str.equals(MPprofileModel.MPgetUserPw(conn, user_id))) {
						inputpwSF.dispose(); //비번확인창 끄고
						dispose(); //메인프레임 끄고
						MPmainFrame MPnewmainF = new MPmainFrame(saveInfo); //메인 프레임 새로 띄우기
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
		
	
	//프로필수정하기 화면에서 뒤로가기 버튼 눌렀을 때 메서드
	public void backBtnCtrl () {
		setCategoryLabelText("내 정보 조회");
		MPcontents.MPprofile.showMPprofile_1();
	}
	
	
	//프로필수정하기 화면에서 수정 완료 버튼 눌렀을 때 메서드 
	public void completeBtnCtrl() {
		
		//입력되지 않은 빈 칸이 있을 때 경고창 띄우기
		if(MPcontents.MPprofile.MPprofile_2.MPnameTf.getText().equals("") 
			|| MPcontents.MPprofile.MPprofile_2.MPphoneTf_1.getText().equals("")
			|| MPcontents.MPprofile.MPprofile_2.MPphoneTf_2.getText().equals("")
			|| MPcontents.MPprofile.MPprofile_2.MPphoneTf_3.getText().equals("")
			|| MPcontents.MPprofile.MPprofile_2.MPgetPwd(MPcontents.MPprofile.MPprofile_2.MPnewpwTf).equals("")) {
			//new MPpreventnulltfSF();
			JOptionPane.showMessageDialog(null, "빈 칸을 모두 입력해주세요", "입력 오류", 1);			
			return;
		}
				
		//이름 글자수 제한 경고창 띄우기
		if(MPcontents.MPprofile.MPprofile_2.MPnameTf.getText().length() > 10) {		
			//new MPnamelengthrestrictSF();
			JOptionPane.showMessageDialog(null, "이름은 10글자까지 입력 가능합니다.", "입력 오류", 1);
			return;
		}
		
		//비밀번호 텍스트필드 제한 경고창 띄우기
		Pattern passPattern1 = Pattern.compile("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*\\W).{8,20}$"); //8자 영문+특문+숫자
		Matcher passMatcher = passPattern1.matcher(MPcontents.MPprofile.MPprofile_2.MPgetPwd(MPcontents.MPprofile.MPprofile_2.MPnewpwTf));
		if (!passMatcher.find()) {
			JOptionPane.showMessageDialog(null, "비밀번호는 영문+특수문자+숫자 8~20자로 구성되어야 합니다", "입력 오류", 1);
			return;
		}
		
		//비밀번호 불일치 경고창 띄우기 
		if(!MPcontents.MPprofile.MPprofile_2.MPgetPwd(MPcontents.MPprofile.MPprofile_2.MPchknewpwTf).equals(MPcontents.MPprofile.MPprofile_2.MPgetPwd(MPcontents.MPprofile.MPprofile_2.MPnewpwTf))) {
			JOptionPane.showMessageDialog(null, "<html>비밀번호가 일치하지 않습니다.</html>", "입력 오류", 1);
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
			
			//'정말 취소하시겠습니까?' 작은 창
			MPreservationSF sf = new MPreservationSF();
			
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
		MPhomeBtn.setRolloverIcon(homeImg2);
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
