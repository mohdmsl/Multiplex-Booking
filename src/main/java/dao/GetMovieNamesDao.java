package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class GetMovieNamesDao {
	String query="select moviename from movies";
	Connection conn;
	
	
  public GetMovieNamesDao(Connection conn) {
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
			
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}

}
