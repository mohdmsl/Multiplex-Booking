package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class GetHAllIdDao {
	Connection conn;
	
	public GetHAllIdDao(Connection conn) {
		super();
		this.conn = conn;
	}
	String select_hallId= "select HALLID from HALLS";
	public List<Integer> getHallId() {
		List<Integer> hallId=null;
		
		try {
			
			PreparedStatement ps=conn.prepareStatement(select_hallId);
			ResultSet rs=ps.executeQuery();
			hallId=new LinkedList<Integer>();
			while(rs.next())
			{
				hallId.add(rs.getInt(1));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return hallId;
	}
}
