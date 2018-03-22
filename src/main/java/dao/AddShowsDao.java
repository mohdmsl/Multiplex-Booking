package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddShowsDao {
	String insert="insert into shows(hallid,movieid,slotno,fromdate,todate,language) values(?,?,?,?,?,?)";
	Connection conn;
	
	public AddShowsDao(Connection conn) {
		super();
		this.conn = conn;
	}
	public void insertShows(int hallId,int movieId, String lang, String [] shows,String fromDate,String toDate )
	{
		
		try {
			
			PreparedStatement ps=conn.prepareStatement(insert);
			for(String x:shows)
			{
			ps.setInt(1, hallId);
			ps.setInt(2, movieId);
			ps.setString(6, lang);
			ps.setInt(3, Integer.parseInt(x));
			SimpleDateFormat format=new SimpleDateFormat("MM/dd/yyyy");
			
			
				Date d1=format.parse(fromDate);
				Date d2=format.parse(toDate);
				java.sql.Date date1=new java.sql.Date(d1.getTime());
				java.sql.Date date2=new java.sql.Date(d2.getTime());
				ps.setDate(4, date1);
				ps.setDate(5, date2);
				ps.executeUpdate();
				
				
			}
			
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(ParseException p) {
			
		}
		
		
		
	}
	public int getSlotNo(String movie) {
		String query="select movieid from movies where moviename=?";
		int slotNo=0;
	
		try {
			
			PreparedStatement ps=this.conn.prepareStatement(query);
			
			ps.setString(1, movie);
			ResultSet rs=ps.executeQuery();
			rs.getInt(1);
			
		
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
		return slotNo;
	}

	}


