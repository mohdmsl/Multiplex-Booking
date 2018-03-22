package system;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AddHallsDao;
import model.Halls;

@WebServlet("/hall")
public class AdminHallAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn=(Connection)getServletContext().getAttribute("dbconnection");
		String desc=request.getParameter("hal");
		int cap=Integer.parseInt(request.getParameter("capacity"));
		PrintWriter pw=response.getWriter();
		if(cap>200)
		{
			
			RequestDispatcher rs=request.getRequestDispatcher("halls.html");
			pw.print("<h2>"+"capacity greater than 200 not allowed"+"</h2>");
			rs.forward(request, response);
			
		}
		else
		{
			
		AddHallsDao ad=new AddHallsDao(conn);
		ad.insertHalls(new Halls(desc, cap));
		pw.println("<html><body>halls detail added</body></html>");
		}
		
	}

}
