package system;


import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.GetMoviesDao;
@WebServlet("/getmovies")
public class getMovies extends HttpServlet{
	private static final long serialVersionUID = 5128655847998499282L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection conn=(Connection)getServletContext().getAttribute("dbconnection");
		GetMoviesDao gm=new GetMoviesDao(conn);
	List<String> movies=gm.getMovies();
	resp.getWriter().write(new Gson().toJson(movies));
	
	}
	

}
