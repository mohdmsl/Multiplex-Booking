package system;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AddHallCapacitiesDao;
import model.HallCapacities;
@WebServlet("/addhallcapacities")
public class AddHallCapacities extends HttpServlet{


	/**
	 * 
	 */
	private static final long serialVersionUID = 6909164542446539980L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection conn=(Connection)getServletContext().getAttribute("dbconnection");
		AddHallCapacitiesDao ad=new AddHallCapacitiesDao(conn);
		ad.insertHallCapacitites(new HallCapacities(Integer.parseInt(req.getParameter("id")), req.getParameter("seattype"), Integer.parseInt(req.getParameter("seatcount")), Integer.parseInt(req.getParameter("fare"))));
	}
	

}
