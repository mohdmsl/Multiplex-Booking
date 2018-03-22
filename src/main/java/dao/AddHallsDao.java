package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Halls;


public class AddHallsDao {
	
	private static String insert_halls="insert into HALLS(HALLDESC,TOTALCAPACITY) values(?,?)";
	
	
	Connection conn;
	public AddHallsDao(Connection conn) {
		super();
		this.conn = conn;
	}
	public void insertHalls(Halls halls)
	{
		try {
			
			
			PreparedStatement stmt=this.conn.prepareStatement(insert_halls);
			stmt.setString(1,halls.getHallDesc());
			stmt.setInt(2, halls.getTotalCapacity());
			
			
			
			stmt.executeUpdate();
		
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
		
		
		
	

}

