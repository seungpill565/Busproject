package park;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Park extends JFrame implements ActionListener { // 회원가입 긁어온거

	JPanel p;
	JTextField tfId, tfName, tfAddr, tfEmail;
	JTextField tfTel1, tfTel2, tfTel3; //전화
	JComboBox cbJob; //직업
	JPasswordField pfPwd; //비밀번호   
	JTextField tfYear, tfMonth, tfDate; //생년월일
	JRadioButton rbMan, rbWoman; //남, 여
	JTextArea taIntro;
	JButton btnInsert, btnCancel; //가입, 취소 버튼
	GridBagLayout gb;
	GridBagConstraints gbc;

	public Park(){
		super("회원가입");
		gb = new GridBagLayout();
		setLayout(gb);
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;


		//아이디
		JLabel bId = new JLabel("아이디 : ");
		tfId = new JTextField(20);     
		//그리드백에 붙이기
		gbAdd(bId, 0, 0, 1, 1);
		gbAdd(tfId, 1, 0, 3, 1);

		//비밀번호
		JLabel bPwd = new JLabel("비밀번호 : ");
		pfPwd = new JPasswordField(20);
		gbAdd(bPwd, 0, 1, 1, 1);
		gbAdd(pfPwd, 1, 1, 3, 1);

		//이름
		JLabel bName = new JLabel("이름 :");
		tfName = new JTextField(20);
		gbAdd(bName,0,2,1,1);
		gbAdd(tfName,1,2,3,1);

		//전화
		JLabel bTel = new JLabel("전화 :");
		JPanel pTel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		tfTel1 = new JTextField(6);    
		tfTel2 = new JTextField(6);    
		tfTel3 = new JTextField(6);
		pTel.add(tfTel1);
		pTel.add(new JLabel(" - "));
		pTel.add(tfTel2);
		pTel.add(new JLabel(" - "));
		pTel.add(tfTel3);
		gbAdd(bTel, 0, 3, 1,1);
		gbAdd(pTel, 1, 3, 3,1);

		//주소
		JLabel bAddr = new JLabel("주소: ");
		tfAddr = new JTextField(20);
		gbAdd(bAddr, 0,4,1,1);
		gbAdd(tfAddr, 1, 4, 3,1);

		//생일
		JLabel bBirth= new JLabel("생일: ");
		tfYear = new JTextField(6);
		tfMonth = new JTextField(6);
		tfDate = new JTextField(6);
		JPanel pBirth = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pBirth.add(tfYear);
		pBirth.add(new JLabel("/"));
		pBirth.add(tfMonth);
		pBirth.add(new JLabel("/"));
		pBirth.add(tfDate);
		gbAdd(bBirth, 0,5,1,1);
		gbAdd(pBirth, 1, 5, 3,1);

		//직업       
		JLabel bJob = new JLabel("직업 : ");
		String[] arrJob = {"---", "학생", "직장인", "주부"};
		cbJob = new JComboBox(arrJob);
		JPanel pJob = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pJob.add(cbJob);       
		gbAdd(bJob, 0,6,1,1);
		gbAdd(pJob,1,6,3,1);

		//성별
		JLabel bGender = new JLabel("성별 : ");
		JPanel pGender = new JPanel(new FlowLayout(FlowLayout.LEFT));
		rbMan = new JRadioButton("남",true);
		rbWoman = new JRadioButton("여",true);
		ButtonGroup group = new ButtonGroup();
		group.add(rbMan);
		group.add(rbWoman);
		pGender.add(rbMan);
		pGender.add(rbWoman);      
		gbAdd(bGender, 0,7,1,1);
		gbAdd(pGender,1,7,3,1);

		//이메일
		JLabel bEmail = new JLabel("이메일 : ");
		tfEmail = new JTextField(20);
		gbAdd(bEmail, 0,8,1,1);
		gbAdd(tfEmail,1,8,3,1);

		//자기소개
		JLabel bIntro = new JLabel("자기 소개: ");
		taIntro = new JTextArea(5, 20); //행 : 열
		taIntro.setLineWrap(true);
		JScrollPane pane = new JScrollPane(taIntro);
		gbAdd(bIntro,0,9,1,1);
		gbAdd(pane,1,9,3,1);

		//버튼
		JPanel pButton = new JPanel();
		btnInsert = new JButton("가입");
		btnCancel = new JButton("취소");     
		pButton.add(btnInsert);
		pButton.add(btnCancel);    
		gbAdd(pButton, 0, 10, 4, 1);


		setSize(350,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);


	}//생성자

	//그리드백레이아웃에 붙이는 메소드
	private void gbAdd(JComponent c, int x, int y, int w, int h){
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		//gb.setConstraints(c, gbc);
		gbc.insets = new Insets(2, 2, 2, 2);
		add(c, gbc);
	}//gbAdd

	public static void main(String[] args) {

		new Park();
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	//actionPerformed 
}//end
	

