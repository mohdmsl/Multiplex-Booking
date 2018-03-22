package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	private String URL;
	private String DRIVER;
	private String USER;
	private String PASS;
	
	

	public Database(String URL, String DRIVER, String USER, String PASS) {
		super();
		this.URL = URL;
		this.DRIVER = DRIVER;
		this.USER = USER;
		this.PASS = PASS;
	}

	public Connection getConnection() throws ClassNotFoundException,SQLException
	{
		Class.forName(this.DRIVER);
		return DriverManager.getConnection(this.URL,this.USER,this.PASS);
		
	}
}
