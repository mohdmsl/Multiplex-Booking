package system;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginDao;
import model.Users;

@WebServlet("/login")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn=(Connection)getServletContext().getAttribute("dbconnection");
		String email=request.getParameter("email");
		String pass=request.getParameter("pwd");
		LoginDao ld=new LoginDao(conn);
		Users user=ld.checkUserExistence(email,pass);
		RequestDispatcher rd=null;
		if(user!=null)
		{
			HttpSession session=request.getSession();
			session.setAttribute("user", user);
			
			if(user.getUserType().equals("admin")) {
				rd=request.getRequestDispatcher("admin.html");
				
			}
			else {
				rd=request.getRequestDispatcher("index.html");
				
			}
			rd.forward(request, response);
		}
		else {
			rd=request.getRequestDispatcher("login.html");
			rd.forward(request, response);
		}
			
			
		
		
	}

}
