package crms;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Booking;
import dao.BookingDAO;
/**
 * Servlet implementation class AdminPermit
 */
@WebServlet("/AdminPermit")
public class AdminPermit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminPermit() {
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
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		String id,cr,type;
		int week,day,time;
		id = request.getParameter("userid");
		cr = request.getParameter("crid");
		type = request.getParameter("bookingtype");
		week = Integer.parseInt(request.getParameter("weekno"));
		day = Integer.parseInt(request.getParameter("dayno"));
		time = Integer.parseInt(request.getParameter("timeno"));
		Booking t = new Booking(id,cr,week,day,time,type);
		System.out.println(t.toJSONString());
		boolean r = BookingDAO.Permit(t);
		BookingDAO.ClearIlleagal(t);
		if(r==true) {
			pw.print("�ɹ�ȷ��");
		}else {
			pw.print("error!");
		}
	}
	
}
