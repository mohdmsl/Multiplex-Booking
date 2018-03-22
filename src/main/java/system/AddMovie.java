package system;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AddMoviesDao;
@WebServlet("/movie")
public class AddMovie extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		
		Connection conn=(Connection)getServletContext().getAttribute("dbconnection");
		AddMoviesDao am=new AddMoviesDao(conn);
		am.insertMovies(req.getParameter("movie"),req.getParameter("lang"));
		
		
	}
	
	

}
