package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.HallCapacities;

public class AddHallCapacitiesDao {
	String insert="insert into hallcapacities values(?,?,?,?)";
	Connection conn;
	
	public AddHallCapacitiesDao(Connection conn) {
	
		this.conn = conn;
	}

	public void insertHallCapacitites(HallCapacities capacitites){
		try {
			
			PreparedStatement ps=this.conn.prepareStatement(insert);
			ps.setInt(1,capacitites.getHallId() );
			ps.setString(2, capacitites.getSeatTypeDesc());
			ps.setInt(3, capacitites.getSeatCount());
			ps.setInt(4, capacitites.getSeatFare());
			ps.executeUpdate();
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	


}
