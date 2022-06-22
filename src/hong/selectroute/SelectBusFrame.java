package hong.selectroute;

import java.awt.Color;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;

import an.OjdbcConnection;

public class SelectBusFrame extends JFrame {
	
	final private static int MAX_SEAT = 21;

	private ArrayList <Integer> canReserve = new ArrayList();
	private ArrayList<Integer> busID = new ArrayList();
	private ArrayList<String> busTime = new ArrayList();
	private ArrayList<SelectBusButton> reserveBtns = new ArrayList();
	SelectBusButton busBtn;
	
	public SelectBusFrame() {
		
		super("버스 선택");
		
		setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		add(new ColumnNameLabel("버스 번호"));
		add(new ColumnNameLabel("출발 시간"));
		add(new ColumnNameLabel("남은 좌석"));
		add(new ColumnNameLabel("예약하기"));
		
		
		setBounds(300, 100, 440, 550);
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new SelectBusFrame();
	}
	
	// 버스 시간, 버스 id를 불러오는 메서드
	public void showBusInfo(int routeID, int month, int day) {
		
		String date = String.format("22/%02d/%02d" , month, day);
		
		String sql = "SELECT bi_id, bi_time FROM bus_info WHERE rt_id=? AND bi_day=?";

		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		){	
			pstmt.setInt(1, routeID);
			pstmt.setString(2, date);
			ResultSet rs = pstmt.executeQuery();
			
			
			while (rs.next()) {
				busID.add(rs.getInt("bi_id"));
				busTime.add(rs.getString("bi_time"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 예약할 수 있는 좌석 수를 불러오는 메서드
	public void getCanReserve() {
		
		String sql = "SELECT bs_is_reserved FROM bus_seat WHERE bi_id=?";
		
		for(int bi_id : busID) {
			int cnt = 0;
			try (
					Connection conn = OjdbcConnection.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql);
			){	
				pstmt.setInt(1, bi_id);
				ResultSet rs = pstmt.executeQuery();
				
				
				while (rs.next()) {
					if(rs.getInt("bs_is_reserved") == 0) {
						++cnt;
					}
				}
				this.canReserve.add(cnt);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}		
		}
	}
	
	
	// 각 정보를 프레임에 add하는 메서드
	public void addInfo() {
		int size = busID.size();
		System.out.println(busID);
		
		for (int i = 0; i < size; ++i) {
			System.out.println("추가됐음");
			add(new BusInfoLabel(busID.get(i).toString()));
			add(new BusInfoLabel(busTime.get(i)));
			add(new BusInfoLabel(canReserve.get(i) + " / " + MAX_SEAT));
			
			if(canReserve.get(i) == 0) {
				add(new BusInfoLabel("매진"));
			} else {
				busBtn = new SelectBusButton();
				busBtn.setName(busID.get(i).toString());
				add(busBtn);
				reserveBtns.add(busBtn);
			}
		}
	}
	
	public ArrayList<SelectBusButton> getAllBtns() {
		return reserveBtns;
	}
	
}




