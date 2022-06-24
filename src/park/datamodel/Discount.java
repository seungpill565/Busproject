package park.datamodel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Discount { // 이 테이블에 있는 행은 무조건 세개 / 어른, 청소년, 어린이

	//private Integer dc_id;
	private int dc_id;
	private String dc_group;
	//private Integer dc_discountrate;
	private int dc_discountrate;
	
	public Discount(ResultSet rs) throws SQLException{
		dc_id = rs.getInt("dc_id");
		dc_group = rs.getString("dc_group");
		dc_discountrate = rs.getInt("dc_discountrate");
	}
	
//	public Discount(Integer dc_id, String dc_group, Integer dc_discountrate) {
//	
//		this.dc_id = dc_id;
//		this.dc_group = dc_group;
//		this.dc_discountrate = dc_discountrate;
//	}

	public int getDc_id() {
		return dc_id;
	}

	public void setDc_id(int dc_id) {
		this.dc_id = dc_id;
	}

	public String getDc_group() {
		return dc_group;
	}

	public void setDc_group(String dc_group) {
		this.dc_group = dc_group;
	}

	public int getDc_discountrate() {
		return dc_discountrate;
	}

	public void setDc_discountrate(int dc_discountrate) {
		this.dc_discountrate = dc_discountrate;
	}
	

	
	
	

}
