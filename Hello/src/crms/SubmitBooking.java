package crms;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import bean.Booking;
import dao.UserDAO;
/**
 * Servlet implementation class SubmitBooking
 */
@WebServlet("/SubmitBooking")
public class SubmitBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitBooking() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int week,day,time;
		String cr =request.getParameter("cr_id");
		week = Integer.parseInt(request.getParameter("week_no"));
		day = Integer.parseInt(request.getParameter("day_no"));
		time = Integer.parseInt(request.getParameter("time_no"));
		String r = request.getParameter("reason");
		System.out.println(week);
		System.out.println(day);
		System.out.println(time);
		System.out.println(cr);
		HttpSession sess = request.getSession();
		PrintWriter out = response.getWriter();
		if(sess.getAttribute("userid")==null) {
			out.print("You should log in first!");
		}else {
			String id = (String) sess.getAttribute("userid");
			//id = "2015000001";
			Booking t = new Booking(id,cr,week,day,time,r);
			boolean a = UserDAO.SubmitUserBooking(t);
			if(a) {
				out.print("success");
			}else {
				out.print("sth wrong!");
			}
		}
	}

}
