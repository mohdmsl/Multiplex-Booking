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

import dao.GetShowsDao;
@WebServlet("/getshows")
public class GetShows extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection conn=(Connection)getServletContext().getAttribute("dbconnection");
		String movie=req.getParameter("movie");
		GetShowsDao gs=new GetShowsDao(conn);
		List<String> shows=gs.getShows(movie);
		resp.getWriter().write(new Gson().toJson(shows));
	}
	

}
