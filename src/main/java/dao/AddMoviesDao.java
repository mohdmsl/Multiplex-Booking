package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddMoviesDao {
	private static String insert_movie="insert into movies(moviename,movilanguage) values(?,?)";
	Connection conn;
	
	public AddMoviesDao(Connection conn) {
		super();
		this.conn = conn;
	}

	public void insertMovies(String movie,String lang)
	{
		try {
			
			PreparedStatement ps=this.conn.prepareStatement(insert_movie);
			ps.setString(2, movie);
			ps.setString(3, lang);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
