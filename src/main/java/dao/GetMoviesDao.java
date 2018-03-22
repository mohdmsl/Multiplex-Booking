package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class GetMoviesDao {
	String query="select movieid from movies";
	String query1="select * from movies where moviename=?";
	Connection conn;
	
  public GetMoviesDao(Connection conn) {
		super();
		this.conn = conn;
	}
public List<String> getMovies()
	{
		List<String> list=new LinkedList<String>();
		try {
			
			PreparedStatement ps=this.conn.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				list.add(rs.getString(1));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
  public int getMovieId(String movie) {
	  int movieId=0;
	  try {
			
			PreparedStatement ps=this.conn.prepareStatement(query1);
			ps.setString(1, movie);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
			movieId=rs.getInt(1);}
			
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return movieId;
	}
	
  

}
