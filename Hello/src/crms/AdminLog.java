package crms;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.AdminDAO;

/**
 * Servlet implementation class AdminLog
 */
@WebServlet("/AdminLog")
public class AdminLog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLog() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get the admin log's id& pw ,to check the correctness;
		// if the user is an admin, we will send him/her to <manage.jsp>
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		boolean res = AdminDAO.AdminLogin(uid, upw);
		if(res==true) {
			response.sendRedirect("manage.jsp");
		}else {
			response.sendRedirect("admin_login.jsp");
		}
		return;
	}

}
