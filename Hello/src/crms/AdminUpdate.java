package crms;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.Booking;
import dao.AdminDAO;
import dao.BookingDAO;
/**
 * Servlet implementation class AdminUpdate
 */
@WebServlet("/AdminUpdate")
public class AdminUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	private Booking GenerateBooking(HttpServletRequest request) {
		String id,cr,type;
		int week,day,time;
		id = request.getParameter("userid");
		cr = request.getParameter("crid");
		type = request.getParameter("method");
		week = Integer.parseInt(request.getParameter("weekno"));
		day = Integer.parseInt(request.getParameter("dayno"));
		time = Integer.parseInt(request.getParameter("timeno"));
		Booking t = new Booking(id,cr,week,day,time,type);
		return t;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//JSON ����2�� key��method��now_state,��ֵ String
		// array = ["����","�п�","����"];
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		String method = request.getParameter("method");
		String state = request.getParameter("now_state");
		
		Booking t = this.GenerateBooking(request);
		boolean rs = false;
		if (method.equals("����")) {
			// ���û����п� -> ����
			//pw.print("�ɹ��������ģ�");
			rs = AdminDAO.DeleteSchedule(t);
			pw.print(!rs);
		}
		else if(state.equals("����")){
			//���б���п�
			rs = BookingDAO.Permit(t);
			pw.print(rs);
		}else {
			// ���ñ��пΣ���ʱ��ǰ���ж��²�ȥʵ��
			rs = AdminDAO.UpdateSchedule(t);
			pw.print(rs);
		}
		
	}

}