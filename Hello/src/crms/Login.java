package crms;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.UserDAO;
import javax.servlet.http.HttpSession;
/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.sendRedirect("/Login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		String uid = new String(request.getParameter("uid")) ;
		String upw = new String(request.getParameter("password"));
		String pw = UserDAO.getPasswd(uid);
		if(pw==null) {
			response.sendRedirect("reg.jsp");
		}
		else if(!pw.equals(upw)){
			System.out.println(pw+","+upw);
			response.sendRedirect("Login.jsp");
		}
		else {
			HttpSession session = request.getSession();
			session.setAttribute("userid", uid);
			request.getRequestDispatcher("usermain.jsp").forward(request, response);
		}
	}

}
