package system;

import java.io.IOException;
import java.sql.Connection;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BookingIdDao;
import dao.BookingsDao;
import dao.GetMoviesDao;
import dao.GetShowsDao;
import model.Bookings;
import model.Users;

@WebServlet("/addbooking")
public class AddBookings extends HttpServlet {
	private static final long serialVersionUID = 3921771026633583751L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//get Connection
		Connection conn=(Connection)getServletContext().getAttribute("dbconnection"); 
		
		BookingIdDao bId=new BookingIdDao(conn);
		int bookingId=bId.getBookingId();
		String movie=req.getParameter("movies");
		SimpleDateFormat format=new SimpleDateFormat("MM/dd/yyyy");
		String date=req.getParameter("showdate");
		Date showDate=null;
		Date bookedDate=new Date();
		
		try {
			 showDate=format.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int noOfSeats=Integer.parseInt(req.getParameter("noofseats"));
		String seatType=req.getParameter("seattype");
		HttpSession session=req.getSession();
		Users user=(Users)session.getAttribute("user");
		int userId=user.getUserId();
		int movieId=new GetMoviesDao(conn).getMovieId(movie);
		String show=req.getParameter("shows");
		int slotNo=0;
		switch(show) {
		case "Morning Show":
			slotNo=1;
			break;
		case "Matinee":
			slotNo=2;
			break;
		case "Evening Show":
			slotNo=3;
		case "Night Show":
			slotNo=4;
			break;
			
		}
		int showId=new GetShowsDao(conn).getShowId(movieId, slotNo);
		
		new BookingsDao(conn).insertBookings(new Bookings(bookingId, showId, userId, bookedDate, showDate, seatType, noOfSeats));
		
	}
	

}
