package system;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AddShowsDao;

@WebServlet("/addshows")
public class AddShows extends HttpServlet {
	private static final long serialVersionUID = 6596371612854958747L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection conn=(Connection)getServletContext().getAttribute("dbconnection");
		int hallId=Integer.parseInt(req.getParameter("halls"));
		int movie=Integer.parseInt(req.getParameter("movies"));
		String lang=req.getParameter("language");
		String shows[]=req.getParameterValues("show");
		String fromdate=(req.getParameter("fromdate"));
		String  toDate=(req.getParameter("todate"));
		AddShowsDao ad=new AddShowsDao(conn);
		ad.insertShows(hallId,movie,lang,shows,fromdate,toDate);
		
	}
	

}
