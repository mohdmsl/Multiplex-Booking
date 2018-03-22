package system;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RegistrationDao;

@WebServlet("/registration")
public class UserRegistration extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RegistrationDao rd=new RegistrationDao();
		rd.insertUSers(req.getParameter("username"), req.getParameter("mobileno"), req.getParameter("email"), req.getParameter("pwd"));
	}
	
	
}
