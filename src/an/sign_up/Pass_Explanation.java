package an.sign_up;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Pass_Explanation extends JPanel{
	JLabel label = new Pass_Explanation_Label("비밀번호는 영문+특수문자+숫자 8자로 구성되어야 합니다");
	public Pass_Explanation() {
		new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		add(label);
	}
}
