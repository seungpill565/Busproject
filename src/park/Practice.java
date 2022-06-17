package park;

import javax.swing.JFrame;

import park.scrollpane.PayInfoScrollpane;

public class Practice extends JFrame{

//    public static void main(String args[]){
//    	// 플로우레이아웃 연습
//          JFrame f = new JFrame("FlowLayoutTest");
//          f.setBounds(100,100,200,500);
//          //왼쪽 정렬의 FlowLayout생성
//          f.setLayout(new FlowLayout(FlowLayout.LEFT));
//
//          f.add(new JButton("첫번째"));
//          f.add(new JButton("두번째"));
//          f.add(new JButton("세번째"));
//          f.add(new JButton("네번째"));
//          f.add(new JButton("다섯번째"));
//          f.setVisible(true);
//}

	public Practice() {
		
		add(new PayInfoScrollpane());
		setBounds(100, 100, 500, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Practice();
	}
}
