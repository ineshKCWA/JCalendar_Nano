package servletPkg;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classesPkg.Dbase;
import classesPkg.Event;

/**
 * Servlet implementation class MainCalendarServlet
 */
@WebServlet("/MainCalendarServlet")
public class MainCalendarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainCalendarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Dbase dbase=new Dbase();
		
		Timestamp startStamp = Timestamp.valueOf("2014-01-01 00:00:00.0");
		java.util.Date endDate=new java.util.Date();				//
		Timestamp endStamp = new Timestamp(endDate.getTime());
		
		ArrayList<Event> eventsCollection=new ArrayList<Event>();
		eventsCollection=dbase.getEvents(startStamp,endStamp ,2 );
		
		request.setAttribute("eventList", eventsCollection);
		request.getRequestDispatcher("mainCalendar.jsp").forward(request, response);
		//response.sendRedirect("mainCalendar.jsp");
	}

}
