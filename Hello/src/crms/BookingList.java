package crms;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.BookingDAO;
import bean.Booking;
/**
 * Servlet implementation class BookingList
 */
@WebServlet("/BookingList")
public class BookingList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingList() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Booking> list =  BookingDAO.getWaitingQueue();
		String res = "{\"num\":"+ String.valueOf(list.size());
		if(list.size()==0) {
			res += "}";
		}else {
			res+=",\"booking\":[";
			for(int i=0;i<list.size();i++) {
				res+=list.get(i).toJSONString();
				if(i<(list.size()-1)) res+=",";
			}
			res+="]}";
		}
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pwr = response.getWriter();
		pwr.print(res);
		System.out.println(res);
		return ;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
