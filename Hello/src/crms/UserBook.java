package crms;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import dao.UserDAO;
import bean.Booking;

/**
 * Servlet implementation class UserBook
 */
@WebServlet("/UserBook")
public class UserBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession sess = request.getSession();

		if(sess.getAttribute("userid")==null) {
			System.out.println("this is wrong��");
			out.print("{\"num\":0}");
		}else {
			System.out.println("this is not wrong!");
			//String uid = "2015000001";//use Session to Get This;
			String uid = (String)sess.getAttribute("userid");
			ArrayList<Booking> list = UserDAO.GetUserBooking(uid);
			System.out.println(this.toJSONString(list));
			out.print(this.toJSONString(list));
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	private String toJSONString(ArrayList<Booking> list) {
		String js;
		if(list.isEmpty()) {
			js="{\"num\":0}";
		}else {
			js = "{\"num\":" +String.valueOf(list.size())
				+ ", \"booking\":" + "[";
			for(int i=0;i<list.size();i++) {
				js += list.get(i).toJSONString();
				if(i<list.size()-1) js+=",";
			}
			js +="]}";
		}
		return js;
		
	}
}
