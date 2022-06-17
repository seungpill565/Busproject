package lee.mpcomponents;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


//패널의 패널 넣어야 됨
public class MPprofilePanel_2 extends JPanel {
	
	JButton MPbackBtn = new JButton("뒤로가기");
	JButton MPcompleteBtn = new JButton("수정완료");
	
	JPanel MPlabelPanel = new JPanel();//여기에 그백레 쓸 거
	
	//그백레!!!!!!!!!!!!!!!!
	GridBagLayout gbl = new GridBagLayout();
	GridBagConstraints gblc = new GridBagConstraints();

	JLabel MPviewLb1 = new JLabel("   이름:"); //왜 얘만 튀어나와 있음?▲
	JLabel MPviewLb2 = new JLabel("연락처:");
	JLabel MPviewLb3 = new JLabel("새 비밀번호:");
	
	
	JTextField MPnameTf = new JTextField(25);
	JTextField MPphoneTf = new JTextField(25);
	JTextField MPnewpwTf = new JTextField(25);
	
	
	public MPprofilePanel_2() {
		setLayout(null);

		
		//나중에 글씨체 바꿀 때 
//		MPviewLb1.setFont(new Font("궁서체", Font.PLAIN, 20));
//		MPviewLb2.setFont(new Font("궁서체", Font.PLAIN, 20));
//		MPviewLb3.setFont(new Font("궁서체", Font.PLAIN, 20));
	
		
		
		//인풋패널 설정
		MPlabelPanel.setLayout(new GridLayout());
		MPlabelPanel.setBounds(85, 90, 350, 170);
		MPlabelPanel.setBackground(Color.pink);
		MPlabelPanel.setLayout(gbl);
		
		
		
		//그백레 설정 + 컴포넌트 넣기 
		gblc.weightx = 1.0;
		gblc.weighty = 1.0;
			
		gbInsert(MPviewLb1, 0, 0, 1, 1);
		gbInsert(MPnameTf, 1, 0, 3, 1);
		gbInsert(MPviewLb2, 0, 1, 1, 1);
		gbInsert(MPphoneTf, 1, 1, 3, 1);
		gbInsert(MPviewLb3, 0, 2, 1, 1);
		gbInsert(MPnewpwTf, 1, 2, 3, 1);
		
	
		
		//수정완료버튼 설정
		MPcompleteBtn.setBounds(280, 300, 90, 38);
		MPcompleteBtn.setBorderPainted(false);
		
		//뒤로가기 버튼 설정
		MPbackBtn.setBounds(150, 300, 90, 38 );
		MPbackBtn.setBorderPainted(false);
		
		
		
		add(MPcompleteBtn);
		add(MPbackBtn);
		add(MPlabelPanel);
	}
	
	
	
	public void gbInsert(Component c, int gridx, int gridy, int gridwidth, int gridheight) {
		gblc.fill = gblc.BOTH;//전체를 채우라는거래 
		gblc.gridx = gridx;
		gblc.gridy = gridy;
		gblc.gridwidth = gridwidth;
		gblc.gridheight = gridheight;
		gbl.setConstraints(c,  gblc);
		gblc.insets = new Insets(15, 10, 10, 10);
		MPlabelPanel.add(c);
	}
	
	
}






