package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookingIdDao {
	Connection conn;
	String query="select bookingid from bookings order by bookingid Desc LIMIT 1";
	
	public BookingIdDao(Connection conn) {
		super();
		this.conn = conn;
	}

	public int getBookingId() {
		int BookingId=0;
		try {
			
			PreparedStatement ps=this.conn.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
				while(rs.next()) {
				BookingId=rs.getInt(1);}
				
			
				
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return BookingId+1;
		
	}

	
}
