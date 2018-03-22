package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Halls;

public class ViewHAllDao {
	Connection conn;
	public ViewHAllDao(Connection conn) {
		super();
		this.conn = conn;
	}
	String get_halls="Select * from HALLS";
	public ArrayList<Halls> getHalls()
	{
		ArrayList<Halls> al=new ArrayList<Halls>();
	
		
		try {
			
			Statement stmt=this.conn.createStatement();
			ResultSet rs=stmt.executeQuery(get_halls);
			while(rs.next())
			{
				Halls h=new Halls(rs.getString(0),rs.getInt(1));
				al.add(h);
				
			}
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return al;
	}

}
