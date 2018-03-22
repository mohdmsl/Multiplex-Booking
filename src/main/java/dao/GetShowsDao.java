package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class GetShowsDao{
	
	String query="select slotno from shows where movieid=?";
	String query3="select * from shows where movieid=? and slotno=?";
	Connection conn;
	
	
  public GetShowsDao(Connection conn) {
		super();
		this.conn = conn;
	}
public List<String> getShows(String movie)
	{
		List<String> list=new LinkedList<String>();
		try {
			
			
			PreparedStatement ps1=this.conn.prepareStatement(query);
			
			int movieId=new GetMoviesDao(conn).getMovieId(movie);
			
			ps1.setInt(1, movieId);
			ResultSet rs1=ps1.executeQuery();
			while(rs1.next())
			{
				list.add(rs1.getString(1));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
  public int getShowId(int movieId,int slotNo) {
	  int showId=0;
	  try {
		
			PreparedStatement ps=this.conn.prepareStatement(query3);
			ps.setInt(1, movieId);
			ps.setInt(2, slotNo);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
			movieId=rs.getInt(1);
			}
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return showId;
	}
	  
  

}
