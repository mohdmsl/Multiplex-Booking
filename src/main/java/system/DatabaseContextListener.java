package system;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import dao.Database;

public class DatabaseContextListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		// TODO Auto-generated method stub
		ServletContext sc=event.getServletContext();
		String URL=sc.getInitParameter("Url");
		String DRIVER=sc.getInitParameter("Driver");
		String USER=sc.getInitParameter("User");
		String PASS=sc.getInitParameter("Pass");
		
		Database db=new Database(URL, DRIVER, USER, PASS);
		Connection conn=null;
		try {
			conn=db.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sc.setAttribute("dbconnection", conn);
		
		
	}
	

}
