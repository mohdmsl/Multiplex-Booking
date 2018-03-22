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

import dao.GetHAllIdDao;
@WebServlet("/gethallid")
public class GetHallId extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection conn=(Connection)getServletContext().getAttribute("dbconnection");
		GetHAllIdDao gh=new GetHAllIdDao(conn);
		List<Integer > hallId=gh.getHallId();
		resp.getWriter().write(new Gson().toJson(hallId));
		
	}
	
	

}
