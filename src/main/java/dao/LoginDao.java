package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Users;


public class LoginDao {
	Connection conn;
	
	public LoginDao(Connection conn) {
		super();
		this.conn = conn;
	}



	private static String get_user="select * from USERS where EMAILID=? and PASSWORD=?";
	
	
	
	public Users checkUserExistence(String email,String password)
	{
		
	
		ResultSet rs=null;
		Users user=null;
		try {
		
			PreparedStatement stmt=this.conn.prepareStatement(get_user);
			stmt.setString(1,email);
			stmt.setString(2,password);
			
			rs=stmt.executeQuery();
			
			
			if(rs.next())
			{
				user=new Users(rs.getInt("USERID"),rs.getString("USERNAME"),rs.getString("USERTYPE"),rs.getString("MOBILENO"),rs.getString("EMAILID"),rs.getString("PASSWORD"));

				
			}
			
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return user;
		
	}
	


}
