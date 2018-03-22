package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Bookings;


public class BookingsDao {
	
	private static String insert_booking="insert into BOOKINGS(SHOWID,USERID,BOOKEDDATE,SHOWDATE,SEATTYPEDESC,NOOFSEATS) values(?,?,?,?,?,?)";
	private static String get_booking="select * from bookings where USERID=?";
	Connection conn;
	public BookingsDao(Connection conn)
	{
	this.conn=conn;	
	}

	public void insertBookings(Bookings booking)
	{
		
		try {
			
		
			
			PreparedStatement stmt=this.conn.prepareStatement(insert_booking);
			Date bookedDate=new Date(booking.getBookingDate().getTime());
			Date showDate=new Date(booking.getShowDate().getTime());
			stmt.setInt(1, booking.getShowId());
			stmt.setInt(2,booking.getUserId());
			stmt.setDate(3, bookedDate);
			stmt.setDate(4,showDate );
			stmt.setString(5, booking.getSeatTypeDesc());
			stmt.setInt(6, booking.getNoOfSeat());
			
			
			stmt.executeUpdate();
			
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Bookings getBookings(int userId)
	{
		Bookings booking=null;
		try {
			
			PreparedStatement stmt=this.conn.prepareStatement(get_booking);
			stmt.setInt(1,userId );
			ResultSet rs=stmt.executeQuery();
			
				booking=new Bookings(rs.getInt("BOOKINGID"),rs.getInt("SHOWID"),rs.getInt("USERID"),rs.getDate("BOOKEDDATE"),rs.getDate("SHOWDATE"),rs.getString("SEATTYPEDESC"),rs.getInt("NOOFSEATS"));
			
			
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return booking;
		
	}

}

