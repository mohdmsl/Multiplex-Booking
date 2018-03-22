package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class RegistrationDao {
private static String set_user="insert into USERS(USERNAME,USERTYPE,MOBILENO,EMAILID,PASSWORD) values(?,?,?,?,?)";
	
	Connection conn;
	
	public void insertUSers(String userName,String mobileNo,String emailId,String password)
	{
		try {
			
			PreparedStatement ps=conn.prepareStatement(set_user);
			ps.setString(1, userName);
			ps.setString(2, "user");
			ps.setString(3, mobileNo);
			ps.setString(4, emailId);
			ps.setString(5, password);
			
			ps.executeUpdate();
			
			
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
